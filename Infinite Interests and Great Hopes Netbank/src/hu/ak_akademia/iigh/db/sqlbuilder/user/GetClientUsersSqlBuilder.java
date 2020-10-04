package hu.ak_akademia.iigh.db.sqlbuilder.user;

import hu.ak_akademia.iigh.Role;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class GetClientUsersSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM users WHERE role_id = " + Role.USER.getRoleId();
	}

}