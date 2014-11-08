package com.virtual.queue.scheduler;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.virtual.queue.service.NotificationServiceImp;

public class RemoveRideJob implements Job {
	private Logger log = Logger.getLogger(QueueJob.class);
	  // @Autowired
	 //  NotificationServiceImp notificationService;
		// NotificationService service;

		public void execute(JobExecutionContext jExeCtx)
				throws JobExecutionException {

			log.debug("TestJob run successfully...");
			System.out.println("Job ran....");
			
			//need to get ride id from job context.
			ExecuteService(1);
		}

		
		private void ExecuteService(int rideId) {

			try {
				 
				new NotificationServiceImp().notifyUser(rideId); 
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
