package hu.ak_akademia.iigh.db.sqlbuilder;

public class GetBankAccountsForUserSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM bank_account WHERE login_name = ?";
	}

}