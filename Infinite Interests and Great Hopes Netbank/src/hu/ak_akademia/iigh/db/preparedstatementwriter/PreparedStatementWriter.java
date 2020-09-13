package hu.ak_akademia.iigh.db.preparedstatementwriter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementWriter<E> {

	void write(PreparedStatement preparedStatement, E entity) throws SQLException;

}
