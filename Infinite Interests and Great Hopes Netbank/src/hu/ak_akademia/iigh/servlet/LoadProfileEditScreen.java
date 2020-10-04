package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.iigh.db.dao.UserDao;
import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.user.GetUserByLoginNameAndPasswordPreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.user.FullUserResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.user.GetUserByLoginNameAndPasswordSqlBuilder;

public class LoadProfileEditScreen extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedInUser = (User) request.getSession()
				.getAttribute("loggedInUser");
		UserDao userDao = new UserDao(new GetUserByLoginNameAndPasswordSqlBuilder(), new GetUserByLoginNameAndPasswordPreparedStatementWriter(), new FullUserResultSetReader());
		List<User> users = userDao.retrieve(loggedInUser);
		loggedInUser = users.get(0);
		request.setAttribute("loggedInUser", loggedInUser);
		if (request.getParameter("saveSuccessful") != null) {
			request.setAttribute("saveSuccessful", true);
		}
		request.getRequestDispatcher("editProfile.jsp")
				.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}