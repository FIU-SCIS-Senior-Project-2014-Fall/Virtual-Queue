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

@Repository
public class RideDaoImp extends BaseDao implements RideDao {
	@Autowired
	VenueDao venueDao;
	
private final static String GET_RIDE_INFO="SELECT r.ride_name, r.ride_duraction, n.notification_time,n.notification_wait"+
"FROM VirtualQueueDB.Ride r, VirtualQueueDB.Notification n WHERE r.notification_id = n.notification_id AND n.notification_id = ?";
	@Override
	public List<RideInfo> pullRideInfo() {
		 
				List<RideInfo > info = new ArrayList<RideInfo>();
			/*	
				final RideInfo info1 = new RideInfo();
				info1.setrName("NameONE");
				info1.setStartTime(10L);
				info1.setInterval(100);
				//
				info1.setEndTime(1700);
				info.add(info1);
				
				 
				final RideInfo info2 = new RideInfo();
				info2.setrName("NameTWO");
				info2.setStartTime(300L);
				info2.setInterval(5);
				info2.setEndTime(1800);
				info.add(info2);
				
				final RideInfo info3 = new RideInfo();
				info3.setrName("NameTHREE");
				info3.setStartTime(200);
				info3.setEndTime(2000);
				info3.setInterval(3); 
				
				info.add(info3);
				*/
				System.out.println("pull ride info");
		        List<VenueInfo> venueList=venueDao.getVenueInfo();
				//TODO:check for empty list
		        VenueInfo vInfo= venueList.get(0);
				
				Date startTime= vInfo.getStartTime();
				Date endTime= vInfo.getStartTime();
				
				try {

					PreparedStatement statement = getConnection().prepareStatement(
							GET_RIDE_INFO);
					statement.setInt(1, 1); 
					
					ResultSet result = statement.executeQuery();
					RideInfo info2=null;
					while (result.next()) {
						
						info2= new RideInfo();
						info2.setrName(result.getString("ride_name"));
						info2.setStartTime(startTime);
						info2.setInterval(result.getInt("ride_duration"));
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

	

}
