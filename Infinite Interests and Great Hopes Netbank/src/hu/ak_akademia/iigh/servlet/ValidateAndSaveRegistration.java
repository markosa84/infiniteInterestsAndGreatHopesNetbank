package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.iigh.Role;
import hu.ak_akademia.iigh.UserStatus;
import hu.ak_akademia.iigh.db.dao.UserDao;
import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.user.CreateUserPreparedStatementWriter;
import hu.ak_akademia.iigh.db.sqlbuilder.user.CreateUserSqlBuilder;
import hu.ak_akademia.iigh.util.PasswordManager;

public class ValidateAndSaveRegistration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginName = request.getParameter("loginName");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String password = request.getParameter("password");
		String passwordConfirmation = request.getParameter("passwordConfirmation");
		String roleIdAsString = request.getParameter("roleId");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String dateOfBirthAsString = request.getParameter("dateOfBirth");
		String newsletterAsString = request.getParameter("newsletter");

		Map<String, String> validationErrors = new HashMap<>();
		if (loginName == null || loginName.trim()
				.length() < 5 || loginName.trim()
						.length() > 30
				|| loginName.trim()
						.contains(" ")) {
			validationErrors.put("loginNameValidationResult", "Wrong login name.");
		}

		// A login name egyedi kell, hogy legyen. Ezt ellenőrizni kell. Ha már létezik
		// ilyen, akkor hibaüzenettel ezt jelezni kell és a felhasználónak másikat kell
		// választania.

		// password és passwordConfirmation egyezését kell vizsgálni
		// password erősségét kell vizsgálni

		if (validationErrors.isEmpty()) {
			String passwordHash = new PasswordManager().encrypt(password);
			Role role = Role.getById(Long.parseLong(roleIdAsString));
			boolean newsletter = newsletterAsString != null;
			LocalDate dateOfBirth = LocalDate.parse(dateOfBirthAsString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDateTime now = LocalDateTime.now();
			User user = new User(loginName, passwordHash, firstName, lastName, role, address, phone, email, newsletter, dateOfBirth, now, null, UserStatus.PENDING);
			UserDao userDao = new UserDao(new CreateUserSqlBuilder(), new CreateUserPreparedStatementWriter());
			userDao.create(user);
			response.sendRedirect("login.jsp?registrationSuccessful=true");
		} else {
			request.setAttribute("validationErrors", validationErrors);
			request.getRequestDispatcher("loadRegistration")
					.forward(request, response);
		}
	}

}