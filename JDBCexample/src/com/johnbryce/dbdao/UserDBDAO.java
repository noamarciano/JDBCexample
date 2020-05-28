package com.johnbryce.dbdao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.johnbryce.beans.User;
import com.johnbryce.dao.UserDAO;
import com.johnbryce.utils.ConnectionPool;

public class UserDBDAO implements UserDAO {

	@Override
	public void insertUser(User user) throws SQLException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			String sql = "INSERT INTO `123`.`users` (id,last,first) VALUES (?,?,?)";

			// STEP 3
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, user.getId());
			statement.setString(2, user.getLast());
			statement.setString(3, user.getFirst());

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

	}

	@Override
	public void updateUser(int id, User user) throws SQLException {
		Connection connection = null;

		try {
			// STEP 2
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "UPDATE `123`.`users` SET first=?, last=? WHERE id=?";

			// STEP 3
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getFirst());
			statement.setString(2, user.getLast());
			statement.setInt(3, id);

			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

	}

	@Override
	public void deleteUser(int id) throws SQLException {
		Connection connection = null;
		try {

			// STEP 2
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "DELETE FROM `123`.`users` WHERE id=?";

			// STEP 3
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

	}

	@Override
	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		Connection connection = null;

		try {
			// STEP 2
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "SELECT * FROM `123`.`users`";
			// STEP 3
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			// STEP 4
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String last = resultSet.getString(2);
				String first = resultSet.getString(3);
				users.add(new User(id, last, first));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

		return users;
	}

}
