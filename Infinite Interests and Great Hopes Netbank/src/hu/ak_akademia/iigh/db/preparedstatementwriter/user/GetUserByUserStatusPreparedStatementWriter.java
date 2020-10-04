package hu.ak_akademia.iigh.db.preparedstatementwriter.user;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class GetUserByUserStatusPreparedStatementWriter implements PreparedStatementWriter<User> {

	private final long userStatusId;

	public GetUserByUserStatusPreparedStatementWriter(long userStatusId) {
		this.userStatusId = userStatusId;
	}

	@Override
	public void write(PreparedStatement preparedStatement, User entity) throws SQLException {
		preparedStatement.setLong(1, userStatusId);
	}

}