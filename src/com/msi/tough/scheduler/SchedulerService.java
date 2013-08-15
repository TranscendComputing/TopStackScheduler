package com.msi.tough.scheduler;

import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;

import com.msi.tough.core.Appctx;

/**
 * @author musharaf.ahmed
 * 
 */

public class SchedulerService {
	private static Logger logger = Appctx.getLogger(SchedulerService.class
			.getName());

	public static void main(final String[] args) throws Exception {

		final SchedulerService service = new SchedulerService();
		service.run();
	}

	public SchedulerService() {

	}

	public void run() throws Exception {

		// First we must get a reference to a scheduler
		final SchedulerFactory sf = new StdSchedulerFactory();
		final Scheduler sched = sf.getScheduler();

		logger.info("------- Initialization Complete -----------");
		logger.info("------- (Not Scheduling any Jobs - relying on XML definitions --");
		logger.info("------- Starting Scheduler ----------------");

		// start the schedule
		sched.start();
		logger.info("------- Started Scheduler -----------------");

		for (;;) {
			try {
				Thread.sleep(300L * 1000L);
			} catch (final Exception e) {
			}
		}

		// shut down the scheduler
		// logger.info("------- Shutting Down ---------------------");
		// sched.shutdown(true);
		// logger.info("------- Shutdown Complete -----------------");
		//
		// final SchedulerMetaData metaData = sched.getMetaData();
		// logger.info("Executed " + metaData.getNumberOfJobsExecuted() +
		// " jobs.");
	}

}
