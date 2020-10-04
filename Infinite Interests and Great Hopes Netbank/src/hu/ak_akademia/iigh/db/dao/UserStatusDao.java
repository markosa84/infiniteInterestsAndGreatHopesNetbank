package hu.ak_akademia.iigh.db.dao;

import hu.ak_akademia.iigh.db.entity.UserStatus;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class UserStatusDao extends AbstractDatabaseDao<UserStatus> {

	public UserStatusDao(SqlBuilder sqlBuilder, PreparedStatementWriter<UserStatus> preparedStatementWriter, ResultSetReader<UserStatus> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}