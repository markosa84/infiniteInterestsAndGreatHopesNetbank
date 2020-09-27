package hu.ak_akademia.iigh.db.dao;

import hu.ak_akademia.iigh.db.entity.BankAccountType;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class BankAccountTypeDao extends AbstractDatabaseDao<BankAccountType> {

	public BankAccountTypeDao(SqlBuilder sqlBuilder, PreparedStatementWriter<BankAccountType> preparedStatementWriter, ResultSetReader<BankAccountType> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}
