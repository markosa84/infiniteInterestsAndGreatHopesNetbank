package hu.ak_akademia.iigh.db.dao;

import hu.ak_akademia.iigh.db.entity.Role;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class RoleDao extends AbstractDatabaseDao<Role> {

	public RoleDao(SqlBuilder sqlBuilder, PreparedStatementWriter<Role> preparedStatementWriter) {
		super(sqlBuilder, preparedStatementWriter, null);
	}

	public RoleDao(SqlBuilder sqlBuilder, PreparedStatementWriter<Role> preparedStatementWriter, ResultSetReader<Role> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}