package hu.ak_akademia.iigh.db.resultsetreader.user;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.iigh.Role;
import hu.ak_akademia.iigh.UserStatus;
import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;

public class FullUserResultSetReader implements ResultSetReader<User> {

	@Override
	public List<User> read(ResultSet resultSet) throws SQLException {
		List<User> users = new ArrayList<>();
		while (resultSet.next()) {
			String loginName = resultSet.getString("login_name");
			String passwordHash = resultSet.getString("password_hash");
			String firstName = resultSet.getString("first_name");
			String lastName = resultSet.getString("last_name");
			Long roleId = resultSet.getLong("role_id");
			Role role = Role.getById(roleId);
			String postalAddress = resultSet.getString("postal_address");
			String phone = resultSet.getString("phone");
			String email = resultSet.getString("email");
			boolean newsletter = "Y".equals(resultSet.getString("newsletter"));
			Date dateOfBirthAsSqlDate = resultSet.getDate("date_of_birth");
			LocalDate dateOfBirth = null;
			if (dateOfBirthAsSqlDate != null) {
				dateOfBirth = dateOfBirthAsSqlDate.toLocalDate();
			}
			LocalDateTime registrationDate = resultSet.getTimestamp("registration_date")
					.toLocalDateTime();
			Timestamp lastLoginDateAsSqlTimestamp = resultSet.getTimestamp("last_login_date");
			LocalDateTime lastLoginDate = null;
			if (lastLoginDateAsSqlTimestamp != null) {
				lastLoginDate = lastLoginDateAsSqlTimestamp.toLocalDateTime();
			}
			Long userStatusId = resultSet.getLong("user_status_id");
			UserStatus userStatus = UserStatus.getById(userStatusId);
			User user = new User(loginName, passwordHash, firstName, lastName, role, postalAddress, phone, email, newsletter, dateOfBirth, registrationDate, lastLoginDate, userStatus);
			users.add(user);
		}
		return users;
	}

}