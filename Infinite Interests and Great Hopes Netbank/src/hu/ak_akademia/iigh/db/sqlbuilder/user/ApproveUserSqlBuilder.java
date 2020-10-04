package hu.ak_akademia.iigh.db.sqlbuilder.user;

import hu.ak_akademia.iigh.UserStatus;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public class ApproveUserSqlBuilder implements SqlBuilder {

	@Override
	public String build() {
		return "UPDATE users SET user_status_id = " + UserStatus.ACTIVE.getUserStatusId() + " WHERE login_name = ?";
	}

}