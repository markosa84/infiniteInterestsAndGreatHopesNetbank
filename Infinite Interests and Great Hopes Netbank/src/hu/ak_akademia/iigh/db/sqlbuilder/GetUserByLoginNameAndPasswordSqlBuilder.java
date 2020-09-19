package hu.ak_akademia.iigh.db.sqlbuilder;

public class GetUserByLoginNameAndPasswordSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "SELECT * FROM users WHERE login_name = ? AND password_hash = ?";
	}

}