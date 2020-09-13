package hu.ak_akademia.iigh.db.dao;

import hu.ak_akademia.iigh.db.entity.Transaction;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class TransactionDao extends AbstractDatabaseDao<Transaction> {

	public TransactionDao(SqlBuilder sqlBuilder, PreparedStatementWriter<Transaction> preparedStatementWriter) {
		super(sqlBuilder, preparedStatementWriter, null);
	}

	public TransactionDao(SqlBuilder sqlBuilder, PreparedStatementWriter<Transaction> preparedStatementWriter, ResultSetReader<Transaction> resultSetReader) {
		super(sqlBuilder, preparedStatementWriter, resultSetReader);
	}

}
