package com.amazon.merchants.transport.timer;

import javax.management.*;

import org.apache.commons.logging.*;

import com.amazon.merchants.transport.*;

public class ProcessingReportRunner implements NotificationListener
{
	private static final Log log =
		LogFactory.getLog(ProcessingReportRunner.class);

	public void handleNotification(Notification arg0, Object arg1)
	{
		log.debug("Fetching Processing Reports");
		TransportClient.instance().run(
			TransportOperationEnum.GET_PROCESSING_REPORTS);
	}

}
