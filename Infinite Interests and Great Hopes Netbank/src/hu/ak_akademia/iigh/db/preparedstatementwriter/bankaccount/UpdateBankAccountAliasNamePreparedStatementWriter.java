package hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccount;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.BankAccount;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class UpdateBankAccountAliasNamePreparedStatementWriter implements PreparedStatementWriter<BankAccount> {

	@Override
	public void write(PreparedStatement preparedStatement, BankAccount entity) throws SQLException {
		preparedStatement.setString(1, entity.getAliasName());
		preparedStatement.setString(2, entity.getBankAccountNumber());
	}

}
