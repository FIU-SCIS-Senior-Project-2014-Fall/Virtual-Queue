package com.virtual.queue.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.listener.QueueContextLoaderListener;
import com.virtual.queue.scheduler.QueueScheduler;
import com.virtual.queue.service.RideService;

@Controller
@RequestMapping("/notification")
public class NotificationController {
	@Autowired
	RideService rideService;
	final static Logger logger = Logger
			.getLogger(QueueContextLoaderListener.class);

	@RequestMapping(value = "/notify/{command}", method = RequestMethod.GET)
	@ResponseBody
	public Boolean notificationEngine(@PathVariable("command") String command) {

		// TODO need to check for credentials before sending this command,user
		// id needs to be added to the request

		logger.info("Starting application...");
		System.out.println("Application started.........");

		QueueScheduler qScheduler = new QueueScheduler();
		List<RideInfo> rides = rideService.pullRideInfo();

		return qScheduler.scheduleRideJobs(command, rides);

	}


}
