package hu.ak_akademia.iigh.db.dao;

import hu.ak_akademia.iigh.db.entity.BankAccount;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class BankAccountDao extends AbstractDatabaseDao<BankAccount> {

	public BankAccountDao(SqlBuilder sqlBuilder, PreparedStatementWriter<BankAccount> preparedStatementWriter) {
		super(sqlBuilder, preparedStatementWriter, null);
	}

	public BankAccountDao(SqlBuilder sqlBuilder, PreparedStatementWriter<BankAccount> preparedStatementWriter, ResultSetReader<BankAccount> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}
