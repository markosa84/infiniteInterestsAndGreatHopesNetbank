package hu.ak_akademia.iigh.db.sqlbuilder.role;

import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class GetAllRolesSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM roles";
	}

}