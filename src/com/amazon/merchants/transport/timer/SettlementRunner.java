package com.amazon.merchants.transport.timer;

import javax.management.*;

import org.apache.commons.logging.*;

import com.amazon.merchants.transport.*;

public class SettlementRunner implements NotificationListener
{
	private static final Log log = LogFactory.getLog(SettlementRunner.class);

	public void handleNotification(Notification arg0, Object arg1)
	{
		log.debug("Fetching Settlement Reports");
		TransportClient.instance().run(TransportOperationEnum.GET_SETTLEMENTS);
	}

}
