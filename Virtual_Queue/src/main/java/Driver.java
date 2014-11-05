

import java.util.List; 

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import com.virtual.queue.beans.RideInfo;
import com.virtual.queue.scheduler.QueueJob;
import com.virtual.queue.scheduler.QueueJobFactory;
import com.virtual.queue.scheduler.QueueTriggerFactory;
import com.virtual.queue.service.RideService;
import com.virtual.queue.service.RideServiceImp;

public class Driver {

	public static void main(String[] args) {

		try {

			// schedule the job
			//SchedulerFactory schFactory = new StdSchedulerFactory();

			Scheduler sch = new StdSchedulerFactory().getScheduler();

			sch.start();

			//RideService service = new RideServiceImp();
			List<RideInfo> list = new RideServiceImp().pullRideInfo();

			// JobDetail job = null;
			// Trigger trigger = null;

			for (RideInfo info : list) {

				// job = QueueJobFactory.getJob(QueueJob.class,
				// info.getrName());
				// trigger = QueueTriggerFactory.getTrigger(info.getInterval());

				sch.scheduleJob(QueueJobFactory.getJob(QueueJob.class, info.getrName()),
						QueueTriggerFactory.getTrigger(info.getInterval()));

			}

		} catch (SchedulerException e) {

			e.printStackTrace();

		}

	}

}
