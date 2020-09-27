package hu.ak_akademia.iigh.db.dao;

import hu.ak_akademia.iigh.db.entity.BankAccountStatus;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class BankAccountStatusDao extends AbstractDatabaseDao<BankAccountStatus> {

	public BankAccountStatusDao(SqlBuilder sqlBuilder, PreparedStatementWriter<BankAccountStatus> preparedStatementWriter, ResultSetReader<BankAccountStatus> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}
