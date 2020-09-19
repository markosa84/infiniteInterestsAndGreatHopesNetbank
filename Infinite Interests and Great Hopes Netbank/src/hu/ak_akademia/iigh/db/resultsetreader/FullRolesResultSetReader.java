package hu.ak_akademia.iigh.db.resultsetreader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.ak_akademia.iigh.db.entity.Role;

public class FullRolesResultSetReader implements ResultSetReader<Role> {

	@Override
	public List<Role> read(ResultSet resultSet) throws SQLException {
		List<Role> roles = new ArrayList<>();
		while (resultSet.next()) {
			long id = resultSet.getLong("role_id");
			String name = resultSet.getString("role_name");
			String displayName = resultSet.getString("role_display_name");
			Role role = new Role(id, name, displayName);
			roles.add(role);
		}
		return roles;
	}

}