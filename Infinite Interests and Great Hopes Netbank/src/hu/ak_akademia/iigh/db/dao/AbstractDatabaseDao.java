package hu.ak_akademia.iigh.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hu.ak_akademia.iigh.IIGHRuntimeException;
import hu.ak_akademia.iigh.db.preparedstatementwriter.PreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.ResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.SqlBuilder;

public abstract class AbstractDatabaseDao<E> implements DatabaseDao<E> {

	private SqlBuilder sqlBuilder;
	private PreparedStatementWriter<E> preparedStatementWriter;
	private ResultSetReader<E> resultSetReader;

	public AbstractDatabaseDao(SqlBuilder sqlBuilder, PreparedStatementWriter<E> preparedStatementWriter, ResultSetReader<E> resultSetReader) {
		this.sqlBuilder = sqlBuilder;
		this.preparedStatementWriter = preparedStatementWriter;
		this.resultSetReader = resultSetReader;
	}

	@Override
	public void create(E entity) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iigh", "iigh", "admin");
				PreparedStatement preparedStatement = connection.prepareStatement(sqlBuilder.build())) {
			preparedStatementWriter.write(preparedStatement, entity);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new IIGHRuntimeException("Error during record insertion into database.", e);
		}
	}

	@Override
	public List<E> retrieve(E entity) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iigh", "iigh", "admin");
				PreparedStatement preparedStatement = connection.prepareStatement(sqlBuilder.build())) {
			preparedStatementWriter.write(preparedStatement, entity);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSetReader.read(resultSet);
		} catch (SQLException e) {
			throw new IIGHRuntimeException("Error during query from database.", e);
		}
	}

	@Override
	public void update(E entity) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iigh", "iigh", "admin");
				PreparedStatement preparedStatement = connection.prepareStatement(sqlBuilder.build())) {
			preparedStatementWriter.write(preparedStatement, entity);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new IIGHRuntimeException("Error during record update in database.", e);
		}
	}

}
