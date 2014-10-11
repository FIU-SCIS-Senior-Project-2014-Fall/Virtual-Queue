package com.virtual.queue.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.virtual.queue.beans.Role;
import com.virtual.queue.beans.User;

@Repository
public class LoginDaoImp extends BaseDao implements LoginDao {

	private static String GET_USER_SESSION = "SELECT u.user_name, u.user_password, u.user_id, rs.role_type, rs.role_desc, rs.enable "
			+ "FROM VirtualQueue.User u, VirtualQueue.Barcode b, VirtualQueue.UserRole r, VirtualQueue.Roles rs "
			+ " WHERE  u.barcode_id = b.barcode_id AND u.user_id = r.user_id AND r.role_id = rs.role_id"
			+ " AND u.user_name = ? AND u.user_password = ? AND  b.barcode_number= ?";

	@Override
	public boolean signOut(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long validLogin(String user, String password, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signIn(String userName, String password, String code) {

		User user = new User();
		try {

			PreparedStatement statement = getConnection().prepareStatement(
					GET_USER_SESSION);
			statement.setString(1, userName);
			statement.setString(2, password);
			statement.setString(3, code);

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				user.setUserName(result.getString("user_name"));
				user.setUserid(result.getLong("user_id"));
				user.setPassword(result.getString("user_password"));
				Role role = new Role();
				role.setRole_type(result.getString("role_type"));
				role.setRole_desc(result.getString("role_desc"));
				user.set_userRole(role);
			
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

}
