package com.virtual.queue.scheduler;



import java.util.Date;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class QueueTriggerFactory {

private QueueTriggerFactory(){};

public static Trigger getTrigger(int interval){
	
	
	return TriggerBuilder.newTrigger()

			.withSchedule(SimpleScheduleBuilder.simpleSchedule()

			.withIntervalInSeconds(interval)

			.repeatForever())

			.build();
	
	
}
public static Trigger getTrigger(int interval,Date startTime,Date endTime){
	
	
	return TriggerBuilder.newTrigger()

			.withSchedule(SimpleScheduleBuilder.simpleSchedule()

			.withIntervalInSeconds(interval)

			.repeatForever())

			.build();
	
	
}

}
