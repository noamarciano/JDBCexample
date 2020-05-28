package com.johnbryce.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
	private static Connection connection;
	private static final String url = "jdbc:mysql://localhost:3306/123?createDatabaseIfNotExist=TRUE&useTimezone=TRUE&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "1234";

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public static void createTableUsers() throws SQLException {

		// Connection connection = null;

		try {
			// STEP 2
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "CREATE TABLE `123`.`users` " + "(`id` INT PRIMARY KEY NOT NULL, "
					+ "`last` VARCHAR(45) NOT NULL," + "`first` VARCHAR(45) NOT NULL)";

			// STEP 3
			PreparedStatement statment = connection.prepareStatement(sql);
			statment.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// STEP 5
			ConnectionPool.getInstance().returnConnection(connection);
			connection = null;
		}

	}

}