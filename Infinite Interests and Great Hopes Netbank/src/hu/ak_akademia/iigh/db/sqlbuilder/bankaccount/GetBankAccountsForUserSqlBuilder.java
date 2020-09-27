package hu.ak_akademia.iigh.db.sqlbuilder.bankaccount;

import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class GetBankAccountsForUserSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM bank_account WHERE login_name = ?";
	}

}