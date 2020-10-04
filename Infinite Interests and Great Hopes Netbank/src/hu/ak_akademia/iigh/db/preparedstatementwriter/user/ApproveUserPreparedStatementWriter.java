package hu.ak_akademia.iigh.db.preparedstatementwriter.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class ApproveUserPreparedStatementWriter implements PreparedStatementWriter<User> {

	@Override
	public void write(PreparedStatement preparedStatement, User user) throws SQLException {
		preparedStatement.setString(1, user.getLoginName());
	}

}