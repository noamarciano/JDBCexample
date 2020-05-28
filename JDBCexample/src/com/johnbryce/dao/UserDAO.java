
package com.johnbryce.dao;

import java.sql.SQLException;
import java.util.List;

import com.johnbryce.beans.User;

public interface UserDAO {

	void insertUser(User user) throws SQLException;

	void updateUser(int id, User user) throws SQLException;

	void deleteUser(int id) throws SQLException;

	List<User> getAllUsers() throws SQLException;

}
