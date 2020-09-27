package hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccount;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.BankAccount;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class UpdateBankAccountCurrentBalancePreparedStatementWriter implements PreparedStatementWriter<BankAccount> {

	@Override
	public void write(PreparedStatement preparedStatement, BankAccount entity) throws SQLException {
		preparedStatement.setLong(1, entity.getCurrentBalance());
		preparedStatement.setString(2, entity.getBankAccountNumber());
	}

}
