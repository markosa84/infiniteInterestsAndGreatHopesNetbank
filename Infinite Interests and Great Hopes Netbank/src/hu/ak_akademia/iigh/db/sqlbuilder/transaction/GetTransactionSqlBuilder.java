package hu.ak_akademia.iigh.db.sqlbuilder.transaction;

import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class GetTransactionSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM transaction WHERE from_bank_account_number = ? OR to_bank_account_number = ?";
	}

}
