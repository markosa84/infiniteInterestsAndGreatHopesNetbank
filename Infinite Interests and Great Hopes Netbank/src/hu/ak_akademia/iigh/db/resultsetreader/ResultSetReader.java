package hu.ak_akademia.iigh.db.resultsetreader;

import java.sql.ResultSet;
import java.util.List;

public interface ResultSetReader<E> {

	List<E> read(ResultSet resultSet);

}
