package hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccounttype;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.BankAccountType;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class GetBankAccountTypeByIdPreparedStatementWriter implements PreparedStatementWriter<BankAccountType> {

	@Override
	public void write(PreparedStatement preparedStatement, BankAccountType entity) throws SQLException {
		preparedStatement.setLong(1, entity.getId());
	}

}
