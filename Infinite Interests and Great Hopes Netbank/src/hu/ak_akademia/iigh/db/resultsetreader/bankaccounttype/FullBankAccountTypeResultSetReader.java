package hu.ak_akademia.iigh.db.resultsetreader.bankaccounttype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.iigh.db.entity.BankAccountType;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;

public class FullBankAccountTypeResultSetReader implements ResultSetReader<BankAccountType> {

	@Override
	public List<BankAccountType> read(ResultSet resultSet) throws SQLException {
		List<BankAccountType> results = new ArrayList<>();
		while (resultSet.next()) {
			long id = resultSet.getLong("bank_account_type_id");
			String name = resultSet.getString("type_name");
			BankAccountType bankAccountType = new BankAccountType(id, name);
			results.add(bankAccountType);
		}
		return results;
	}

}
