package com.virtual.queue.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.virtual.queue.beans.User;
import com.virtual.queue.beans.UserQueueInfo;
import com.virtual.queue.exception.ResetPasswordException;

@Repository
@Transactional
public class UserDaoImp extends BaseDao implements UserDao {

	
	private static String ADD_USERS = "INSERT INTO VirtualQueueDB.VenueRegisteredUser (first_name,last_name,email,user_password, "
			+ "user_name,security_question, security_answer, phone_number, age, height, weight) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	private static String ALL_USERS = "select * from user limit 30";

	private static String GET_USER = "Select u.user_id , u.security_question , u.security_answer , u.user_password from VirtualQueueDB.VenueRegisteredUser u WHERE u.user_name = ? AND u.security_question = ? AND u.security_answer = ? ";
	private static String RESET_PASSWORD = "UPDATE VirtualQueueDB.VenueRegisteredUser SET user_password = ? WHERE user_id = ? ";
	private static String GET_USER_BY_ID = "Select * from User where user_id=?";
	private static final String DELETE_USER_FROM_QUEUE = "DELETE FROM VirtualQueueDB.UserQueue WHERE user_id= ? and queue_id=(Select myqueue_id From Ride where ride_id= ? )";
	
	
	@Override
	public User getUser(String username, String passwd) {

		// TODO:validate user input.
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
				user.setUserName(rs.getString("user_name"));
				user.setSecurityQuestion("security_question");
				user.setAge("age");
				user.setHeight("height");
				user.setWeight("weight");
				users.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return users;

	}

	@Override
	public void addUser(User user) {

		PreparedStatement updateemp = null;

		try {
			getConnection();
			updateemp = connection.prepareStatement(ADD_USERS);

			updateemp.setString(1, user.getFirstName());
			updateemp.setString(2, user.getLastName());
			updateemp.setString(3, user.getEmail());
			updateemp.setString(4, user.getPassword());
			updateemp.setString(5, user.getEmail());
			updateemp.setString(6, user.getSecurityQuestion());
			updateemp.setString(7, user.getSecurityAnswer());
			updateemp.setString(8, user.getPhoneNumber());
			updateemp.setString(9, user.getAge());
			updateemp.setString(10, user.getHeight());
			updateemp.setString(11, user.getWeight());
			updateemp.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			if (updateemp != null) {
				try {
					updateemp.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			closeConnection();

		}

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

	@Override
	public Boolean resetPassword(String userName, String securityAnswer,
			String securityQuestion, String newPassword) throws Exception {

		PreparedStatement updateemp = null;
		PreparedStatement resetting = null;
		String secQuestion = null;
		String secAnswer = null;
		String oldPassword = null;
		Long userId = 0L;

		try {

			getConnection();

			resetting = connection.prepareStatement(GET_USER);
			resetting.setString(1, userName);
			resetting.setString(2, securityQuestion);
			resetting.setString(3, securityAnswer);
			ResultSet rs = resetting.executeQuery();

			if (rs.next()) {

				userId = rs.getLong("user_id");
				secQuestion = rs.getString("security_question");
				secAnswer = rs.getString("security_answer");
				oldPassword = rs.getString("user_password");

			}
			// Close result set.
			if (rs != null && !rs.isClosed())
				rs.close();

			// validate for null and empty values
			if (secQuestion == null || "".equals(secQuestion)
					|| secAnswer == null || "".equals(secAnswer)
					|| oldPassword == null)
				return false;

			// check for valid information
			if (!securityQuestion.equalsIgnoreCase(secQuestion)
					|| !securityAnswer.equalsIgnoreCase(secAnswer)
					|| userId < 1)
				return false;

			// check for same password
			if (!"".equals(newPassword) && oldPassword.equals(newPassword))
				return false;

			updateemp = connection.prepareStatement(RESET_PASSWORD);
			updateemp.setLong(1, userId);
			updateemp.setString(2, newPassword);
			updateemp.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			// throw new ResetPasswordException(e.getMessage());

		} finally {

			if (resetting != null)
				resetting.close();
			if (updateemp != null)
				updateemp.close();

			closeConnection();
		}

		return true;

	}

	@Override
	public User authenticateUser(String userName, String securityQuestion,
			String securityAnwser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(long userId) {

		User user = new User();
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					GET_USER_BY_ID);

			statement.setLong(1, userId);

			ResultSet result = statement.executeQuery();

			if (result.next()) {

				// TODO:fill out user object
				user.setFirstName(result.getString("first_name"));

			}

			result.close();
			statement.close();
		} catch (SQLException e) {
			// TODO need to add log4j output
			e.printStackTrace();

		} catch (Exception ex) {

			// TODO need to add log4j output
			ex.printStackTrace();

		}

		return user;
	}

	@Override
	public boolean removeUserFromQueue(long userId,long rideId) {
		PreparedStatement updateemp = null;

		try {

			getConnection();

			updateemp = connection.prepareStatement(DELETE_USER_FROM_QUEUE);
			updateemp.setLong(1, userId);
			updateemp.setLong(2, rideId);
			updateemp.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			// throw new ResetPasswordException(e.getMessage());
          //TODO:needs to handle errors and return to caller with a message.
			return false;
		
		} finally {

			if (updateemp != null)
				try {
					updateemp.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			closeConnection();
		}

		return true;

	}

}
