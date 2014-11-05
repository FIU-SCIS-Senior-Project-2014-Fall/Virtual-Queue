package com.virtual.queue.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtual.queue.beans.QueueInfo;

public class QueueDaoImp extends BaseDao implements QueueDao {
	private static final String GET_QUEUE_INFO = "Select * from test";

	public QueueDaoImp() {

	}

	public List<QueueInfo> getNotificationInfo() {

		// pull data from DB DAO
		List<QueueInfo> info = new ArrayList<QueueInfo>(3);
		final QueueInfo info1 = new QueueInfo();
		info1.setName("Name1");
		info1.setMaxValue(300);
		info1.setPhoneNumber("7867602409");
		info1.setEmail("ysosasupport@gmail.com");
		info.add(info1);
		final QueueInfo info2 = new QueueInfo();
		info2.setName("Name2");
		info2.setMaxValue(400);
		info2.setPhoneNumber("7867602419");
		info2.setEmail("roninjord@yahoo.com");

		info.add(info2);
		final QueueInfo info3 = new QueueInfo();
		info2.setName("Name3");
		info2.setMaxValue(600);
		info3.setPhoneNumber("7867602409");
		info3.setEmail("samuraijord@hotmail.com");
		info.add(info3);

		return info;
	}

	@Override
	public List<QueueInfo> pullInfo(Integer rideId) {

		List<QueueInfo> infoList = new ArrayList<QueueInfo>();
		try {

			PreparedStatement statement = getConnection().prepareStatement(
					GET_QUEUE_INFO);

			// TODO:set ride id from job scheduler.
			statement.setInt(1, rideId);
			// statement.setString(2, password);
			// statement.setString(3, code);

			ResultSet result = statement.executeQuery();
			QueueInfo info = null;
			while (result.next()) {

				info = new QueueInfo();

				info.setEmail(result.getString("user_name"));
				info.setName(result.getString("first_name") + ", "
						+ result.getString("last_name"));
				info.setPhoneNumber(result.getString("phone_number"));
				info.setEmail(result.getString("email"));
				infoList.add(info);
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

	@Override
	public List<QueueInfo> pullAllInfo() {
		List<QueueInfo> infoList = new ArrayList<QueueInfo>();
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					GET_QUEUE_INFO);

			// TODO:set ride id from job scheduler.
			// statement.setInt(1, rideId);
			// statement.setString(2, password);
			// statement.setString(3, code);

			ResultSet result = statement.executeQuery();
			QueueInfo info = null;
			while (result.next()) {

				info = new QueueInfo();

				info.setEmail(result.getString("user_name"));
				info.setName(result.getString("first_name") + ", "
						+ result.getString("last_name"));
				info.setPhoneNumber(result.getString("phone_number"));
				info.setEmail(result.getString("email"));
				infoList.add(info);
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
