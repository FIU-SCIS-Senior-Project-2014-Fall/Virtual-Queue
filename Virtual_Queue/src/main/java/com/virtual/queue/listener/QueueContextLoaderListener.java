package com.virtual.queue.listener;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.scheduler.QueueJob;
import com.virtual.queue.scheduler.QueueJobFactory;
import com.virtual.queue.scheduler.QueueTriggerFactory;
import com.virtual.queue.service.RideService;
import com.virtual.queue.service.RideServiceImp;


 

public class QueueContextLoaderListener extends org.springframework.web.context.ContextLoaderListener
{
	final static Logger logger = Logger.getLogger(QueueContextLoaderListener.class);
//@Autowired
//RideService rideService;

	public QueueContextLoaderListener() {
		 
	/*	
		logger.info("Starting application...");
		System.out.println("Application started.........s");
		// schedule the job
		// SchedulerFactory schFactory = new StdSchedulerFactory();
		try {
			Scheduler sch = new StdSchedulerFactory().getScheduler();

			sch.start();

			// RideService service = new RideServiceImp();
			
			
			RideService service = new RideServiceImp();
			List<RideInfo> list= service.pullRideInfo();

			// JobDetail job = null;
			// Trigger trigger = null;
           
           for (RideInfo info11 : list) {

				// job = QueueJobFactory.getJob(QueueJob.class,
				// info.getrName());
				// trigger = QueueTriggerFactory.getTrigger(info.getInterval());

				sch.scheduleJob(
						QueueJobFactory.getJob(QueueJob.class, info11.getrName()),
						QueueTriggerFactory.getTrigger(info11.getInterval()));

			}

		} catch (SchedulerException e) {

			e.printStackTrace();
			logger.error(e.getMessage());

		}
 */
	}
}