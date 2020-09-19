package hu.ak_akademia.iigh.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.BankAccount;

public class GetBankAccountsForUserPreparedStatementWriter implements PreparedStatementWriter<BankAccount> {

	@Override
	public void write(PreparedStatement preparedStatement, BankAccount bankAccount) throws SQLException {
		preparedStatement.setString(1, bankAccount.getLoginName());
	}

}