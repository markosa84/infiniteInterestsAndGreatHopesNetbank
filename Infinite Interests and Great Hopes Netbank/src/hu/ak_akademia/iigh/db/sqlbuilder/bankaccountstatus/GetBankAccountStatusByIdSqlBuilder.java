package hu.ak_akademia.iigh.db.sqlbuilder.bankaccountstatus;

import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class GetBankAccountStatusByIdSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM bank_account_status WHERE bank_account_status_id = ?";
	}

}
