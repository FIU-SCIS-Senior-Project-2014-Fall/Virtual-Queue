package com.virtual.queue.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.virtual.queue.beans.User;

@Repository
@Transactional
public class UserDaoImp extends BaseDao implements UserDao {

	private static String ALL_USERS = "select * from user limit 30";

	@Override
	public User getUser(String username, String passwd) {
		return User.getDemoUser();
	}

	@Override
	public String getCurrentlyAuthenticatedUserName() {

		return User.getDemoUser().getUserName();
	}

	@Override
	public User getUserByToken(String token) {
		return User.getDemoUser();
	}

	@Override
	public String storeToken(Long userId) {
		return User.getDemoUser().getToken();
	}

	@Override
	public List<User> getAll() {
		/*
		 * List<User> list = new ArrayList<User>(4);
		 * 
		 * for (int i= 0; i<4; i++){ list.add(User.getDemoUser()); } return
		 * list;
		 */

		List<User> users = new ArrayList<User>();
		try {
             
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery(ALL_USERS);
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getLong("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setToken(rs.getString("token_id"));
				user.setUserName(rs.getString("user_name"));
				users.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return users;

	}

	@Override
	public void addUser(User user) {
		System.out.println("User was suscefully added!");

	}

	@Override
	public void updateUser(User user) {
		System.out.println("User was suscefully updated!");

	}

	@Override
	public void deleteUserById(Long id) {
		System.out.println("User was suscefully deleted!");

	}

	@Override
	public User getUserByUserName(String userName) {

		return User.getDemoUser();
	}

}
