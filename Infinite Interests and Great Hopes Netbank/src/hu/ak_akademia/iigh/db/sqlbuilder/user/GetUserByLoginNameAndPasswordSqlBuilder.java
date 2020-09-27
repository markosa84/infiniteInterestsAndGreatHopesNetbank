package hu.ak_akademia.iigh.db.sqlbuilder.user;

import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class GetUserByLoginNameAndPasswordSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM users WHERE login_name = ? AND password_hash = ?";
	}

}