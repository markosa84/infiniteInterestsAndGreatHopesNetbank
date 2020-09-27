package hu.ak_akademia.iigh.db.preparedstatementwriter.transaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.Transaction;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateTransactionPreparedStatementWriter implements PreparedStatementWriter<Transaction> {

	@Override
	public void write(PreparedStatement preparedStatement, Transaction entity) throws SQLException {
		preparedStatement.setString(1, entity.getFromBankAccountNumber());
		preparedStatement.setString(2, entity.getToBankAccountNumber());
		preparedStatement.setString(3, entity.getBeneficiaryName());
		preparedStatement.setLong(4, entity.getAmount());
		preparedStatement.setString(5, entity.getTransactionComment());
	}

}
