package com.msi.tough.scheduler.http;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;

import com.msi.tough.core.Appctx;
import com.msi.tough.core.HttpUtils;


public class HttpService implements Job {
	private static Logger logger = Appctx
			.getLogger(HttpService.class.getName());

	private String url;

    private String parameters;

    // The Quartz scheduler wants to set this ugly name, for some reason.
    private Object JobSchedulingDataLoaderPlugin_jobInitializer;

	@Override
	public void execute(final JobExecutionContext ctx)
			throws JobExecutionException {
	    String host = Appctx.getBean("internalServiceHost");
	    JobDataMap jobdata = ctx.getJobDetail().getJobDataMap();
	    String url = jobdata.getString("url");
	    if (host != null) {
	        url = url.replaceFirst("SRVHOST", host);
	    } else if (url.contains("SRVHOST")) {
	        logger.warn("SRVHOST replacement not found.");
	        // Context is probably still initializing, wait for next execution.
            logger.warn("HttpService deferred until next trigger.");
	        return;
	    }
	    String parameters = jobdata.getString("parameters");
	    String resp = new HttpUtils().sendGetRequest(url, parameters);
	    logger.info("Http Response : " + resp);
	    logger.info("Executing at: " + Calendar.getInstance().getTime()
	            + " triggered by: " + ctx.getTrigger().getKey());
	}

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the parameters
     */
    public String getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    /**
     * @return the jobSchedulingDataLoaderPlugin_jobInitializer
     */
    public Object getJobSchedulingDataLoaderPlugin_jobInitializer() {
        return JobSchedulingDataLoaderPlugin_jobInitializer;
    }

    /**
     * @param jobSchedulingDataLoaderPlugin_jobInitializer the jobSchedulingDataLoaderPlugin_jobInitializer to set
     */
    public void setJobSchedulingDataLoaderPlugin_jobInitializer(
            Object jobSchedulingDataLoaderPlugin_jobInitializer) {
        JobSchedulingDataLoaderPlugin_jobInitializer = jobSchedulingDataLoaderPlugin_jobInitializer;
    }
}
