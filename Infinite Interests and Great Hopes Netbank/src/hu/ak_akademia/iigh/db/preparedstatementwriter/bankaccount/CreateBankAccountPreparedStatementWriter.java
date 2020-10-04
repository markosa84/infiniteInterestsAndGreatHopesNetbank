package hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccount;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.BankAccount;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class CreateBankAccountPreparedStatementWriter implements PreparedStatementWriter<BankAccount> {

	@Override
	public void write(PreparedStatement preparedStatement, BankAccount bankAccount) throws SQLException {
		preparedStatement.setString(1, bankAccount.getBankAccountNumber());
		preparedStatement.setString(2, bankAccount.getAliasName());
		preparedStatement.setString(3, bankAccount.getLoginName());
		preparedStatement.setLong(4, bankAccount.getCurrentBalance());
		preparedStatement.setString(5, bankAccount.getCurrencyType());
		preparedStatement.setLong(6, bankAccount.getBankAccountStatus()
				.getBankAccountStatusId());
		preparedStatement.setLong(7, bankAccount.getBankAccountType()
				.getBankAccountTypeId());
	}

}