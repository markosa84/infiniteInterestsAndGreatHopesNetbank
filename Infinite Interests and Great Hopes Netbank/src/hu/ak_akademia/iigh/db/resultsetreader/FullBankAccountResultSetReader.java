package hu.ak_akademia.iigh.db.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.iigh.BankAccountStatus;
import hu.ak_akademia.iigh.BankAccountType;
import hu.ak_akademia.iigh.db.entity.BankAccount;

public class FullBankAccountResultSetReader implements ResultSetReader<BankAccount> {

	@Override
	public List<BankAccount> read(ResultSet resultSet) throws SQLException {
		List<BankAccount> bankAccounts = new ArrayList<>();
		while (resultSet.next()) {
			String bankAccountNumber = resultSet.getString("bank_account_number");
			String aliasName = resultSet.getString("alias_name");
			String loginName = resultSet.getString("login_name");
			long currentBalance = resultSet.getLong("current_balance");
			String currencyType = resultSet.getString("currency_type");
			long bankAccountStatusId = resultSet.getLong("bank_account_status_id");
			BankAccountStatus bankAccountStatus = BankAccountStatus.getById(bankAccountStatusId);
			long bankAccountTypeId = resultSet.getLong("bank_account_type_id");
			BankAccountType bankAccountType = BankAccountType.getById(bankAccountTypeId);
			BankAccount bankAccount = new BankAccount(bankAccountNumber, aliasName, loginName, currentBalance, currencyType, bankAccountStatus, bankAccountType);
			bankAccounts.add(bankAccount);
		}
		return bankAccounts;
	}

}