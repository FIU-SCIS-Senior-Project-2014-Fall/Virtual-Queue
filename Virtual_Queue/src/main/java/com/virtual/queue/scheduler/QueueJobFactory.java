package com.virtual.queue.scheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;

public class QueueJobFactory {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JobDetail getJob(Class clazz,String jobName) {
	
		return JobBuilder.newJob(clazz)

		.withIdentity(jobName)

		.build();
		
		 
	}
}
