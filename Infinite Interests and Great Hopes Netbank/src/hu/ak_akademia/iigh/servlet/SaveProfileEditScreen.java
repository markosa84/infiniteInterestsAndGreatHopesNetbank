package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hu.ak_akademia.iigh.db.dao.UserDao;
import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.user.GetUserByLoginNameAndPasswordPreparedStatementWriter;
import hu.ak_akademia.iigh.db.preparedstatementwriter.user.UpdateUserPreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.user.FullUserResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.user.GetUserByLoginNameAndPasswordSqlBuilder;
import hu.ak_akademia.iigh.db.sqlbuilder.user.UpdateUserSqlBuilder;
import hu.ak_akademia.iigh.util.PasswordManager;
import hu.ak_akademia.iigh.util.StringUtil;

public class SaveProfileEditScreen extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newPassword = request.getParameter("newPassword");
		String newPasswordConfirmation = request.getParameter("newPasswordConfirmation");
		String oldPassword = request.getParameter("oldPassword");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String newsletterAsString = request.getParameter("newsletter");
		boolean newsletter = newsletterAsString != null;

		PasswordManager passwordManager = new PasswordManager();
		Map<String, String> validationErrors = new HashMap<>();
		// validálás
		if (!StringUtil.isBlank(newPassword) || !StringUtil.isBlank(newPasswordConfirmation) || !StringUtil.isBlank(oldPassword)) {
			if (newPassword != null && !newPassword.equals(newPasswordConfirmation)) {
				validationErrors.put("passwordDoesNotMatchWithConfirmation", "Az új jelszó nem egyezik meg a megerősítésével.");
			}
			if (StringUtil.isBlank(oldPassword)) {
				validationErrors.put("oldPasswordWrong", "A jelenlegi jelszó nem lehet üres.");
			} else {
				User loggedInUser = (User) request.getSession()
						.getAttribute("loggedInUser");
				UserDao userDao = new UserDao(new GetUserByLoginNameAndPasswordSqlBuilder(), new GetUserByLoginNameAndPasswordPreparedStatementWriter(), new FullUserResultSetReader());
				List<User> users = userDao.retrieve(loggedInUser);
				loggedInUser = users.get(0);
				String oldPasswordHash = passwordManager.encrypt(oldPassword);
				if (!loggedInUser.getPasswordHash()
						.equals(oldPasswordHash)) {
					validationErrors.put("oldPasswordWrong", "A jelenlegi jelszó nem helyes.");
				}
			}
		}

		// egyéb validációk címre, telefonszámra, e-mail címre

		if (validationErrors.isEmpty()) {
			User loggedInUser = (User) request.getSession()
					.getAttribute("loggedInUser");
			UserDao retrieveUserDao = new UserDao(new GetUserByLoginNameAndPasswordSqlBuilder(), new GetUserByLoginNameAndPasswordPreparedStatementWriter(), new FullUserResultSetReader());
			List<User> users = retrieveUserDao.retrieve(loggedInUser);
			loggedInUser = users.get(0);
			loggedInUser.setPasswordHash(newPassword == null ? loggedInUser.getPasswordHash() : passwordManager.encrypt(newPassword));
			loggedInUser.setPostalAddress(address);
			loggedInUser.setPhone(phone);
			loggedInUser.setEmail(email);
			loggedInUser.setNewsletter(newsletter);
			UserDao updateUserDao = new UserDao(new UpdateUserSqlBuilder(), new UpdateUserPreparedStatementWriter());
			updateUserDao.update(loggedInUser);
			HttpSession session = request.getSession();
			session.setAttribute("loggedInUser", loggedInUser);
			response.sendRedirect("loadUserDataForProfileEdit?saveSuccessful");
		} else {
			request.setAttribute("validationErrors", validationErrors);
			request.getRequestDispatcher("loadUserDataForProfileEdit")
					.forward(request, response);
		}

	}

}