package com.virtual.queue.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.beans.VenueInfo;
import com.virtual.queue.dao.VenueDao;

@Repository
public class VenueDaoImp extends BaseDao implements VenueDao {
	
	private final static String GET_VENUE_INFO="SELECT r.ride_name, r.ride_duraction, n.notification_time,n.notification_wait"+
			"FROM VirtualQueueDB.Ride r, VirtualQueueDB.Notification n WHERE r.notification_id = n.notification_id AND n.notification_id = ?";
	
	
	@Override
	public List<VenueInfo> getVenueInfo() {
		 
		List<VenueInfo> list= new ArrayList<VenueInfo>();
			try {

				PreparedStatement statement = getConnection().prepareStatement(
						GET_VENUE_INFO);
				statement.setInt(1, 1); 
				
				ResultSet result = statement.executeQuery();
				VenueInfo info2=null;
				while (result.next()) {
					
					info2= new VenueInfo();
					info2.setVenueName(result.getString("venue_name"));
					info2.setStartTime(result.getDate("start_time"));
					info2.setStartTime(result.getDate("end_time")); 
					list.add(info2); 
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
			 
	return list;
	
	}

}
