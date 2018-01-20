package com.naroyo.db.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class TestRepository {

	private Connection connection = this.getConnection();

	private Connection getConnection() {
		final DataSource dataSource = new MysqlDataSource();
		Connection connection = null;
		try {
			connection = dataSource.getConnection("user", "password");
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public Test getTextValue() throws SQLException {
		final PreparedStatement statement = this.connection.prepareStatement("select * from database.test");
		final ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		final Test test = new Test();
		test.setId(resultSet.getInt("id"));
		test.setText(resultSet.getString("text"));
		return test;
	}

	public void insertInto(final String text) throws SQLException {
		final PreparedStatement statement = this.connection
				.prepareStatement("insert into database.test (text) values (?)");
		statement.setString(1, text);
		statement.execute();
	}
}
