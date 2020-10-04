package hu.ak_akademia.iigh.db.sqlbuilder.user;

import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class UpdateUserSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "UPDATE users SET password_hash = ?, postal_address = ?, phone = ?, email = ?, newsletter = ? WHERE login_name = ?";
	}

}