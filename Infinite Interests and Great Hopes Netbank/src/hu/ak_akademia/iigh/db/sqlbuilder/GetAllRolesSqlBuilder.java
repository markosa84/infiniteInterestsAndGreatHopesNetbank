package hu.ak_akademia.iigh.db.sqlbuilder;

public class GetAllRolesSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM roles";
	}

}