package hu.ak_akademia.iigh.db.sqlbuilder.bankaccount;

import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class UpdateBankAccountCurrentBalanceSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "UPDATE bank_account SET current_balance = ? WHERE bank_account_number = ?";
	}

}
