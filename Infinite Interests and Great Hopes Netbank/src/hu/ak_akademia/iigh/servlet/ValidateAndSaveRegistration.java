package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.iigh.IIGHRuntimeException;
import hu.ak_akademia.iigh.Role;
import hu.ak_akademia.iigh.UserStatus;
import hu.ak_akademia.iigh.db.dao.UserDao;
import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.CreateUserPreparedStatementWriter;
import hu.ak_akademia.iigh.db.sqlbuilder.CreateUserSqlBuilder;

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

		// password és passwordConfirmation egyezését kell vizsgálni
		// password erősségét kell vizsgálni

		if (validationErrors.isEmpty()) {
			String passwordHash = encrypt(password);
			Role role = Role.getById(Long.parseLong(roleIdAsString));
			boolean newsletter = newsletterAsString != null;
			LocalDate dateOfBirth = LocalDate.parse(dateOfBirthAsString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			LocalDateTime now = LocalDateTime.now();
			User user = new User(loginName, passwordHash, firstName, lastName, role, address, phone, email, newsletter, dateOfBirth, now, null, UserStatus.PENDING);
			UserDao userDao = new UserDao(new CreateUserSqlBuilder(), new CreateUserPreparedStatementWriter());
			userDao.create(user);
			response.sendRedirect("login.jsp");
		} else {
			request.setAttribute("validationErrors", validationErrors);
			request.getRequestDispatcher("loadRegistration")
					.forward(request, response);
		}
	}

	private String encrypt(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			return bytesToHex(encodedhash);
		} catch (NoSuchAlgorithmException e) {
			throw new IIGHRuntimeException("Unable to encrypt password.");
		}
	}

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (byte element : hash) {
			String hex = Integer.toHexString(0xff & element);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

}