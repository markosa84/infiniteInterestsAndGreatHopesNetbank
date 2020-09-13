package hu.ak_akademia.iigh.db.dao;

import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class UserDao extends AbstractDatabaseDao<User> {

	public UserDao(SqlBuilder sqlBuilder, PreparedStatementWriter<User> preparedStatementWriter) {
		super(sqlBuilder, preparedStatementWriter, null);
	}

	public UserDao(SqlBuilder sqlBuilder, PreparedStatementWriter<User> preparedStatementWriter, ResultSetReader<User> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}
