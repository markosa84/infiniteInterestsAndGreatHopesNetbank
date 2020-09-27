package hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccountstatus;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hu.ak_akademia.iigh.db.entity.BankAccountStatus;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;

public class GetBankAccountStatusByIdPreparedStatementWriter implements PreparedStatementWriter<BankAccountStatus> {

	@Override
	public void write(PreparedStatement preparedStatement, BankAccountStatus entity) throws SQLException {
		preparedStatement.setLong(1, entity.getId());
	}

}
