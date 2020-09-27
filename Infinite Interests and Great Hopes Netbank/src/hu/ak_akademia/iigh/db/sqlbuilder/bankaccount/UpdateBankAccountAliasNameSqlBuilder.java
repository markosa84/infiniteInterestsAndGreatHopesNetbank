package hu.ak_akademia.iigh.db.sqlbuilder.bankaccount;

import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class UpdateBankAccountAliasNameSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "UPDATE bank_account SET alias_name = ? WHERE bank_account_number = ?";
	}

}
