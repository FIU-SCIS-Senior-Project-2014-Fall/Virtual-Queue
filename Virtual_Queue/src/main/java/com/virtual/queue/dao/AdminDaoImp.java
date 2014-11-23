package com.virtual.queue.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtual.queue.beans.Coordinate;
import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.beans.User;

@Repository
@Transactional
public class AdminDaoImp extends BaseDao implements AdminDao {
	
	private static final String GET_ALL_USERS = "SELECT u.user_id, u.first_name, u.last_name, u.user_name "
			+ " FROM VirtualQueueDB.VenueRegisteredUser u, VirtualQueueDB.UserRole ur, VirtualQueueDB.Role r  "
			+ " WHERE u.user_id = ur.user_id AND r.role_id = ur.role_id AND  r.role_type = 'USER' AND u.enabled= '1' ";
	
	
	@Override
	public LinkedList<User> getAllUsers() {
		
		LinkedList<User> infoList = new LinkedList<User>();
		User user = null;
		try {

			PreparedStatement statement = getConnection().prepareStatement(
					GET_ALL_USERS);

			
			ResultSet result = statement.executeQuery();
			

			while (result.next()) {

				user = new User();
				user.setUserid(result.getLong("user_id"));
				user.setFirstName(result.getString("first_name"));
				user.setLastName(result.getString("last_name"));
				user.setUserName(result.getString("user_name"));
				infoList.add(user);
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

		return infoList;
	}

}