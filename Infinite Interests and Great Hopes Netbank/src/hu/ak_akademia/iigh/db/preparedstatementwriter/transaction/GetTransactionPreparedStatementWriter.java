package hu.ak_akademia.iigh.db.preparedstatementwriter.transaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.Transaction;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class GetTransactionPreparedStatementWriter implements PreparedStatementWriter<Transaction> {

	private final String bankAccountNumber;

	public GetTransactionPreparedStatementWriter(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	@Override
	public void write(PreparedStatement preparedStatement, Transaction entity) throws SQLException {
		preparedStatement.setString(1, bankAccountNumber);
		preparedStatement.setString(2, bankAccountNumber);
	}

}
