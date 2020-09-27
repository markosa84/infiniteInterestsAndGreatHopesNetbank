package hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccount;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.BankAccount;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class GetBankAccountByBankAccountNumberPreparedStatementWriter implements PreparedStatementWriter<BankAccount> {

	@Override
	public void write(PreparedStatement preparedStatement, BankAccount bankAccount) throws SQLException {
		preparedStatement.setString(1, bankAccount.getBankAccountNumber());
	}

}