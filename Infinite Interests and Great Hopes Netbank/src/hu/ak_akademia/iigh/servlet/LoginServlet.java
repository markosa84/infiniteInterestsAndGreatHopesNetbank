package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.ak_akademia.iigh.IIGHRuntimeException;
import hu.ak_akademia.iigh.UserStatus;
import hu.ak_akademia.iigh.db.dao.UserDao;
import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.user.GetUserByLoginNameAndPasswordPreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.user.FullUserResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.user.GetUserByLoginNameAndPasswordSqlBuilder;
import hu.ak_akademia.iigh.util.PasswordManager;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");

		// validáció

		String passwordHash = new PasswordManager().encrypt(password);
		User user = new User(loginName, passwordHash);
		UserDao userDao = new UserDao(new GetUserByLoginNameAndPasswordSqlBuilder(), new GetUserByLoginNameAndPasswordPreparedStatementWriter(), new FullUserResultSetReader());
		List<User> users = userDao.retrieve(user);
		if (users.isEmpty()) {
			// nincs ilyen felhasználónév / jelszó páros
			request.setAttribute("invalidLoginNameOrPassword", true);
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			User userToLogIn = users.get(0);
			if (UserStatus.ACTIVE.equals(userToLogIn.getUserStatus())) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedInUser", userToLogIn);
				String redirectTo;
				switch (userToLogIn.getRole()) {
				case ADMIN:
					redirectTo = "adminHome.jsp";
					break;
				case USER:
					redirectTo = "userHome.jsp";
					break;
				default:
					throw new IIGHRuntimeException("Illegal role detected: " + userToLogIn.getRole());
				}
				response.sendRedirect(redirectTo);
			} else {
				request.setAttribute("invalidLoginNameOrPassword", true);
				request.getRequestDispatcher("login.jsp")
						.forward(request, response);
			}
		}
	}

}
