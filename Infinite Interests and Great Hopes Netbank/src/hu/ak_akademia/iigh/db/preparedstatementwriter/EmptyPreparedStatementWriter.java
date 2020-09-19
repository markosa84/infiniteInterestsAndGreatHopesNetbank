package hu.ak_akademia.iigh.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmptyPreparedStatementWriter<E> implements PreparedStatementWriter<E> {

	@Override
	public void write(PreparedStatement preparedStatement, E entity) throws SQLException {
	}

}
