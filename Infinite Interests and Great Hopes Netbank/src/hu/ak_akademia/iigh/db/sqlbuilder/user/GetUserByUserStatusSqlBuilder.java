package hu.ak_akademia.iigh.db.sqlbuilder.user;

import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class GetUserByUserStatusSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM users WHERE user_status_id = ?";
	}

}