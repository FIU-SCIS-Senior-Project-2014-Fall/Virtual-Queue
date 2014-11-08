package com.virtual.queue.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.beans.Role;
import com.virtual.queue.beans.VenueInfo;
import com.virtual.queue.exception.NotificationException;

@Repository
public class RideDaoImp extends BaseDao implements RideDao {
	@Autowired
	VenueDao vDao;

	private final static String GET_RIDE_INFO = "SELECT r.ride_name, r.ride_duraction, n.notification_time,n.notification_wait "
			+ " FROM VirtualQueueDB.Ride r, VirtualQueueDB.Notification n WHERE r.notification_id = n.notification_id AND n.notification_id = ?";
	
	// TODO:take this from property file or DB option.
	private final static long VENUE_ID = 1;

	private static final String GET_RIDE_INFO_BY_USERID = "SELECT r.ride_name, r.ride_duraction FROM  VirtualQueueDB.UserQueue q, Ride r where q.user_id =? and r.myqueue_id=queue_id ";

	@Override
	public List<RideInfo> pullRideInfo() throws NotificationException {

		List<RideInfo> info = new ArrayList<RideInfo>();
		/*
		 * final RideInfo info1 = new RideInfo(); info1.setrName("NameONE");
		 * info1.setStartTime(10L); info1.setInterval(100); //
		 * info1.setEndTime(1700); info.add(info1);
		 * 
		 * 
		 * final RideInfo info2 = new RideInfo(); info2.setrName("NameTWO");
		 * info2.setStartTime(300L); info2.setInterval(5);
		 * info2.setEndTime(1800); info.add(info2);
		 * 
		 * final RideInfo info3 = new RideInfo(); info3.setrName("NameTHREE");
		 * info3.setStartTime(200); info3.setEndTime(2000);
		 * info3.setInterval(3);
		 * 
		 * info.add(info3);
		 */
		System.out.println("pull ride info");
		 VenueDao vDao=new VenueDaoImp();
		List<VenueInfo> venueList = vDao.getVenueInfo(VENUE_ID);
		if (venueList.isEmpty())
			throw new NotificationException("Empty venue information");

		VenueInfo vInfo = venueList.get(0);

		long startTime = vInfo.getStartTime();
		long endTime = vInfo.getStartTime();

		try {

			PreparedStatement statement = getConnection().prepareStatement(
					GET_RIDE_INFO);
			statement.setInt(1, 1);

			ResultSet result = statement.executeQuery();
			RideInfo info2 = null;
			while (result.next()) {

				info2 = new RideInfo();
				info2.setrName(result.getString("ride_name"));
				info2.setStartTime(startTime);
				info2.setInterval(result.getInt("ride_duraction"));
				info2.setEndTime(endTime);
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

		}

		return info;

	}

	@Override
	public List<RideInfo> getRideByUser(Long userId) throws NotificationException {
		List<RideInfo> infoLst = new ArrayList<RideInfo>();
        //TODO:replace by logger.
		System.out.println("pull ride info");
		
		VenueDao vDao=new VenueDaoImp();
		List<VenueInfo> venueList = vDao.getVenueInfo(VENUE_ID);
	
		if (venueList.isEmpty())
			throw new NotificationException("Empty venue information");

		VenueInfo vInfo = venueList.get(0);

		long startTime = vInfo.getStartTime();
		long endTime = vInfo.getStartTime();
		RideInfo info2 = null;
		try {

			PreparedStatement statement = getConnection().prepareStatement(
					GET_RIDE_INFO_BY_USERID);
			statement.setLong(1, userId);

			ResultSet result = statement.executeQuery();
			
		    while (result.next()) {

				info2 = new RideInfo();
				info2.setrName(result.getString("ride_name"));
				info2.setStartTime(startTime);
				info2.setInterval(result.getInt("ride_duraction"));
				info2.setEndTime(endTime);
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

		}

		return infoLst;
	
	 
	
	
	}

	@Override
	public RideInfo getRideById(long rideId) throws NotificationException {
		
		 
	 
		System.out.println("pull ride info");
		 VenueDao vDao=new VenueDaoImp();
		List<VenueInfo> venueList = vDao.getVenueInfo(VENUE_ID);
		if (venueList.isEmpty())
			throw new NotificationException("Empty venue information");

		VenueInfo vInfo = venueList.get(0);

		long startTime = vInfo.getStartTime();
		long endTime = vInfo.getStartTime();
		RideInfo info2 = null;
		try {

			PreparedStatement statement = getConnection().prepareStatement(
					GET_RIDE_INFO);
			statement.setInt(1, 1);

			ResultSet result = statement.executeQuery();
			
			if (result.next()) {

				info2 = new RideInfo();
				info2.setrName(result.getString("ride_name"));
				info2.setStartTime(startTime);
				info2.setInterval(result.getInt("ride_duraction"));
				info2.setEndTime(endTime);
				 
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

		return info2;
	
	
	
	}

}
