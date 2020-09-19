package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.iigh.db.dao.RoleDao;
import hu.ak_akademia.iigh.db.entity.Role;
import hu.ak_akademia.iigh.db.preparedstatementwriter.EmptyPreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.FullRolesResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.GetAllRolesSqlBuilder;

public class LoadRegistrationScreen extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoleDao roleDao = new RoleDao(new GetAllRolesSqlBuilder(), new EmptyPreparedStatementWriter<Role>(), new FullRolesResultSetReader());
		List<Role> roles = roleDao.retrieve(null);
		request.setAttribute("userRoles", roles);
		request.getRequestDispatcher("registration.jsp")
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}