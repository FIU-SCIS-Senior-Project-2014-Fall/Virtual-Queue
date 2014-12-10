package com.virtual.queue.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.virtual.queue.beans.Coordinate;
import com.virtual.queue.beans.Ride;
import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.beans.VenueInfo;
import com.virtual.queue.exception.NotificationException;

@Repository
@Transactional
public class RideDaoImp extends BaseDao implements RideDao {
	@Autowired
	VenueDao vDao;

	private final static String GET_RIDE_INFO = "SELECT r.ride_name, r.ride_duraction, n.notification_time,n.notification_wait , r.ride_capacity ,r.ride_id , r.latitude, r.longitude "
			+ " FROM VirtualQueueDB.Ride r, VirtualQueueDB.Notification n WHERE r.notification_id = n.notification_id AND n.notification_id = ?";

	// TODO:take this from property file or DB option.
	private final static long VENUE_ID = 1;

	private static final String GET_RIDE_INFO_BY_USERID = "SELECT r.ride_name, r.ride_duraction ,r.ride_id, r.ride_capacity ,r.latitude, r.longitude FROM  VirtualQueueDB.UserQueue q, Ride r where q.user_id =? and r.myqueue_id=queue_id order by q.registered_time asc ";

	private static final String ADD_USER_TO_RIDE = "INSERT INTO VirtualQueueDB.USerQueue (queue_id,user_id,registered_time)VALUES ((Select myqueue_id From Ride where ride_id=? ),?,NOW());";

	private static final String GET_RIDE_ALL = "SELECT r.ride_name, r.ride_duraction ,r.ride_id, r.ride_capacity ,r.latitude, r.longitude FROM  Ride r  ";

	private static final String GET_RIDE_INFO_BY_ID = "SELECT r.ride_name, r.ride_duraction, n.notification_time,n.notification_wait , r.ride_capacity ,r.ride_id , r.latitude, r.longitude "
			+ " FROM VirtualQueueDB.Ride r, VirtualQueueDB.Notification n WHERE r.notification_id = n.notification_id AND n.notification_id = ? AND r.ride_id= ?";

	@Override
	public List<RideInfo> pullRideInfo() throws NotificationException {

		List<RideInfo> info = new ArrayList<RideInfo>();

		System.out.println("pull ride info");
		VenueDao vDao = new VenueDaoImp();
		List<VenueInfo> venueList = vDao.getVenueInfo(VENUE_ID);
		if (venueList.isEmpty())
			throw new NotificationException("Empty venue information");

		VenueInfo vInfo = venueList.get(0);

		long startTime = vInfo.getStartTime();
		long endTime = vInfo.getStartTime();

		Connection con = getConnection();

		try {

			PreparedStatement statement = con.prepareStatement(GET_RIDE_INFO);
			statement.setInt(1, 1);

			ResultSet result = statement.executeQuery();
			RideInfo info2 = null;
			while (result.next()) {

				info2 = new RideInfo();
				info2.setrName(result.getString("ride_name"));
				info2.setStartTime(startTime);
				info2.setInterval(result.getInt("ride_duraction"));
				info2.setEndTime(endTime);
				info2.setRideId(result.getLong("ride_id"));
				info.add(info2);
			}

			result.close();
			statement.close();

		} catch (SQLException e) {
			// TODO need to add log4j output
			e.printStackTrace();

		} catch (Exception ex) {

			// TODO need to add log4j output
			ex.printStackTrace();

		} finally{
			try {
				if(con!=null && !con.isClosed()){
					con.close();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		return info;

	}

	@Override
	public List<RideInfo> getRideByUser(Long userId)
			throws NotificationException {
		List<RideInfo> infoLst = new ArrayList<RideInfo>();
		// TODO:replace by logger.
		System.out.println("pull ride info");

		VenueDao vDao = new VenueDaoImp();
		List<VenueInfo> venueList = vDao.getVenueInfo(VENUE_ID);

		if (venueList.isEmpty())
			throw new NotificationException("Empty venue information");

		VenueInfo vInfo = venueList.get(0);

		long startTime = vInfo.getStartTime();
		long endTime = vInfo.getStartTime();
		RideInfo info2 = null;
		Connection con = getConnection();

		try {

			PreparedStatement statement = con
					.prepareStatement(GET_RIDE_INFO_BY_USERID);
			statement.setLong(1, userId);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				info2 = new RideInfo();
				info2.setrName(result.getString("ride_name"));
				info2.setStartTime(startTime);
				info2.setInterval(result.getInt("ride_duraction"));
				info2.setEndTime(endTime);
				info2.setCapacity(result.getInt("ride_capacity"));
				info2.setRideId(result.getLong("ride_id"));
				BigDecimal lat = result.getBigDecimal("latitude");
				BigDecimal lon = result.getBigDecimal("longitude");
				info2.setCoordinate(new Coordinate(lat, lon));

				infoLst.add(info2);
			}

			result.close();
			statement.close();

		} catch (SQLException e) {
			// TODO need to add log4j output
			e.printStackTrace();

		} catch (Exception ex) {

			// TODO need to add log4j output
			ex.printStackTrace();

		} finally{
			try {
				if(con!=null && !con.isClosed()){
					con.close();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		return infoLst;

	}

	@Override
	public RideInfo getRideById(long rideId) throws NotificationException {

		System.out.println("pull ride info");
		VenueDao vDao = new VenueDaoImp();
		List<VenueInfo> venueList = vDao.getVenueInfo(VENUE_ID);
		if (venueList.isEmpty())
			throw new NotificationException("Empty venue information");

		VenueInfo vInfo = venueList.get(0);

		long startTime = vInfo.getStartTime();
		long endTime = vInfo.getStartTime();
		RideInfo info2 = null;
		Connection con = getConnection();

		try {

			PreparedStatement statement = con.prepareStatement(GET_RIDE_INFO_BY_ID);
			statement.setInt(1, 1);
			statement.setLong(2, rideId);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				info2 = new RideInfo();
				info2.setrName(result.getString("ride_name"));
				info2.setStartTime(startTime);
				info2.setInterval(result.getInt("ride_duraction"));
				info2.setEndTime(endTime);
				info2.setCapacity(result.getInt("ride_capacity"));
				info2.setRideId(result.getLong("ride_id"));

				info2.setCoordinate(new Coordinate(result
						.getBigDecimal("latitude"), result
						.getBigDecimal("longitude")));

			}

			result.close();
			statement.close();

		} catch (SQLException e) {
			// TODO need to add log4j output
			e.printStackTrace();

		} catch (Exception ex) {

			// TODO need to add log4j output
			ex.printStackTrace();

		} finally {
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return info2;

	}

	@Override
	public boolean addUserRideById(Long rideId, Long userId) {
		PreparedStatement updateemp = null;
		Connection con = getConnection();
		try {

			updateemp = con.prepareStatement(ADD_USER_TO_RIDE);
			updateemp.setLong(1, rideId);
			updateemp.setLong(2, userId);
			updateemp.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		} finally {

			if (updateemp != null) {
				try {
					updateemp.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}

			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return true;

	}

	@Override
	public List<RideInfo> getAll() {

		List<RideInfo> infoLst = new ArrayList<RideInfo>();
		RideInfo info2 = null;

		Connection con = getConnection();
		try {

			PreparedStatement statement = getConnection().prepareStatement(
					GET_RIDE_ALL);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				info2 = new RideInfo();
				info2.setrName(result.getString("ride_name"));
				info2.setInterval(result.getInt("ride_duraction"));
				info2.setCapacity(result.getInt("ride_capacity"));
				info2.setRideId(result.getLong("ride_id"));
				BigDecimal lat = result.getBigDecimal("latitude");
				BigDecimal lon = result.getBigDecimal("longitude");
				info2.setCoordinate(new Coordinate(lat, lon));
				infoLst.add(info2);
			}

			result.close();
			statement.close();

		} catch (SQLException e) {
			// TODO need to add log4j output
			e.printStackTrace();

		} catch (Exception ex) {

			// TODO need to add log4j output
			ex.printStackTrace();

		} finally {
			if (con != null) {

				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return infoLst;

	}

}
