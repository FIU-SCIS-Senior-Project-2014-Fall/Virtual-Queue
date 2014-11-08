package com.virtual.queue.scheduler;

import java.util.List;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.virtual.queue.beans.RideInfo;

public class QueueScheduler {
	
	public QueueScheduler(){}
	
	
	public boolean scheduleRideJobs(String command,List<RideInfo> rideList ){
		
		
		// schedule the job
				// SchedulerFactory schFactory = new StdSchedulerFactory();
				try {
					Scheduler sch = new StdSchedulerFactory().getScheduler();

					if ("start".equalsIgnoreCase(command) && !sch.isStarted()) {

						sch.start();

					} else {

						if (sch.isStarted()) {
							// wait until all jobs ended before shutting down
							sch.shutdown(true);

						}

					}

					//List<RideInfo> list = rideService.pullRideInfo();

					JobDetail job = null;
					Trigger trigger = null;

					for (RideInfo info11 : rideList) {

						job = QueueJobFactory.getJob(QueueJob.class, info11.getrName());
						trigger = QueueTriggerFactory.getTrigger(info11.getInterval());

						sch.scheduleJob(job, trigger);

					}

				} catch (Exception e) {

					e.printStackTrace();
				 
					//TODO:need to handle custom errors and return them to caller.
					return false;	 
				}

		return true;
	}
	
	public boolean removeUserFromQueue(List<RideInfo> ride,String command,int delay){
		

				try {
					Scheduler sch = new StdSchedulerFactory().getScheduler();

					if ("start".equalsIgnoreCase(command) && !sch.isStarted()) {

						sch.start();

					} else {

						if (sch.isStarted()) {
							// wait until all jobs ended before shutting down
							sch.shutdown(true);

						}

					}
					
					JobDetail job = null;
					Trigger trigger = null;
					int interval=0;
					for (RideInfo info : ride) {
						
						interval =info.getInterval()+delay;
						
						job = QueueJobFactory.getJob(RemoveRideJob.class, info.getrName());
						
						trigger = QueueTriggerFactory.getTrigger(interval);

						sch.scheduleJob(job, trigger);

					}

				} catch (Exception e) {

					e.printStackTrace();
				 
					//TODO:need to handle custom errors and return them to caller.
					return false;	 
				}

		return true;
		
		 
		
	}

}
