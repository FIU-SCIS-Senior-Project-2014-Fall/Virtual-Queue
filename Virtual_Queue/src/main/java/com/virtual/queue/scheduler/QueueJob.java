package com.virtual.queue.scheduler;


import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.virtual.queue.service.NotificationServiceImp;

public class QueueJob implements Job {
	private Logger log = Logger.getLogger(QueueJob.class);
  // @Autowired
 //  NotificationServiceImp notificationService;
	// NotificationService service;

	public void execute(JobExecutionContext jExeCtx)
			throws JobExecutionException {

		log.debug("TestJob run successfully...");
		System.out.println("Job ran....");
		ExecuteService();
	}

	
	private void ExecuteService() {

		try {
			 
			new NotificationServiceImp().notifyUser(); 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
