package com.amazon.merchants.transport.timer;

import javax.management.*;

import org.apache.commons.logging.*;

import com.amazon.merchants.transport.*;

public class DispatchRunner implements NotificationListener
{
	private static final Log log = LogFactory.getLog(DispatchRunner.class);
	
	public void handleNotification(Notification arg0, Object arg1)
	{
		log.debug("Running Dispatcher");
		TransportClient.instance().run(TransportOperationEnum.DISPATCH_ALL);		
	}
}
