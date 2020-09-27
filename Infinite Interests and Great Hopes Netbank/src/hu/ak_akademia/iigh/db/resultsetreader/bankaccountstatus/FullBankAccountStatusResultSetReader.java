package hu.ak_akademia.iigh.db.resultsetreader.bankaccountstatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.iigh.db.entity.BankAccountStatus;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;

public class FullBankAccountStatusResultSetReader implements ResultSetReader<BankAccountStatus> {

	@Override
	public List<BankAccountStatus> read(ResultSet resultSet) throws SQLException {
		List<BankAccountStatus> results = new ArrayList<>();
		while (resultSet.next()) {
			long id = resultSet.getLong("bank_account_status_id");
			String name = resultSet.getString("status_name");
			String displayName = resultSet.getString("status_display_name");
			BankAccountStatus bankAccountStatus = new BankAccountStatus(id, name, displayName);
			results.add(bankAccountStatus);
		}
		return results;
	}

}
