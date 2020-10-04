package hu.ak_akademia.iigh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.iigh.db.dao.UserDao;
import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.user.ApproveUserPreparedStatementWriter;
import hu.ak_akademia.iigh.db.sqlbuilder.user.ApproveUserSqlBuilder;

public class ApproveUsers extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao(new ApproveUserSqlBuilder(), new ApproveUserPreparedStatementWriter());
		request.getParameterMap()
				.keySet()
				.stream()
				.filter(key -> key.startsWith("selectedUser_"))
				.map(key -> key.replaceFirst("selectedUser_", ""))
				.forEach(loginName -> userDao.update(User.builder()
						.withLoginName(loginName)
						.build()));
		boolean isAtLeastOneCheckboxSelected = request.getParameterMap()
				.keySet()
				.stream()
				.anyMatch(key -> key.startsWith("selectedUser_"));
		response.sendRedirect("loadApproveUsers" + (isAtLeastOneCheckboxSelected ? "approveSuccessful" : ""));
	}

}