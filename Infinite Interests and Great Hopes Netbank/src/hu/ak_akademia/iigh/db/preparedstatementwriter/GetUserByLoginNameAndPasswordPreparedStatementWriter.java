package hu.ak_akademia.iigh.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.User;

public class GetUserByLoginNameAndPasswordPreparedStatementWriter implements PreparedStatementWriter<User> {

	@Override
	public void write(PreparedStatement preparedStatement, User user) throws SQLException {
		preparedStatement.setString(1, user.getLoginName());
		preparedStatement.setString(2, user.getPasswordHash());
	}

}