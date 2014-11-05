package com.virtual.queue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtual.queue.beans.NotificationInfo;
import com.virtual.queue.beans.QueueInfo;
import com.virtual.queue.dao.QueueDao;
import com.virtual.queue.dao.QueueDaoImp;
import com.virtual.queue.handler.EmailNotificationHandlerImp;
import com.virtual.queue.handler.NotificationHandler;
@Service
public class NotificationServiceImp implements NotificationService {
	public static String NOTIFICATION_MSG = "Your ride is due in :";

	
	@Autowired
	QueueDao queueDao;
	// QueueInfo info;

	public NotificationServiceImp() {
		System.out.println("Service created");
		System.out.println("pull data from DB");

		// info= new QueueInfo();
		// info.setName("Name1");
		// info.setMaxValue(200);

	}

	@Override
	public List<QueueInfo> pullNotInfo(Integer rideId) {

		return queueDao.pullInfo(rideId);
	}

	@Override
	public void notifyUser(Integer rideId) throws Exception {

		List<QueueInfo> list = this.pullNotInfo(1);
		
		
		NotificationHandler handler = new EmailNotificationHandlerImp();

		if (list.isEmpty())
			throw new Exception("Empty user list");

		NotificationInfo Notinfo=null;
		
		for (QueueInfo info : list) {

			Notinfo = new NotificationInfo();
			Notinfo.setEmail(info.getEmail());
			Notinfo.setName(info.getName());
			Notinfo.setMessage(NOTIFICATION_MSG);

			handler.notifiyUser(Notinfo);
			
			System.out.println("Send sms message to user phone number :"
					+ info.getPhoneNumber());
		}

		System.out.println("finished sending  sms message to user list");

	}

	@Override
	public void notifyAllUsers() throws Exception {

		List<QueueInfo> list = this.pullAllNotInfo();
		
		
		NotificationHandler handler = new EmailNotificationHandlerImp();

		if (list.isEmpty())
			throw new Exception("Empty user list");

		NotificationInfo Notinfo=null;
		
		for (QueueInfo info : list) {

			Notinfo = new NotificationInfo();
			Notinfo.setEmail(info.getEmail());
			Notinfo.setName(info.getName());
			Notinfo.setMessage(NOTIFICATION_MSG);

			handler.notifiyUser(Notinfo);
			
			System.out.println("Send sms message to user phone number :"
					+ info.getPhoneNumber());
		}

		System.out.println("finished sending  sms message to user list");
		
	}

	@Override
	public List<QueueInfo> pullAllNotInfo() {
		// TODO Auto-generated method stub
		return queueDao.pullAllInfo();
	}

}
