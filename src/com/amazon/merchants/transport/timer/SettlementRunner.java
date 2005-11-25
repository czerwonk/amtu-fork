package com.amazon.merchants.transport.timer;

import javax.management.*;

import org.apache.commons.logging.*;

import com.amazon.merchants.transport.*;

public class SettlementRunner implements NotificationListener
{
	private static final Log log = LogFactory.getLog(SettlementRunner.class);

    // because of how this class is instantiated on the fly as needed,
    // we have to synchronize on a static variable.  I think it's appropriate
    // to synchronize at this level since this whole process should be "atomic".
    // if we access the server for the same operation more than once, we could get
    // ourselves into a bad state.
    private static Object mutex = new Object();
    
	public void handleNotification(Notification arg0, Object arg1)
	{
	    synchronized(mutex) {
	        log.debug("Fetching Settlement Reports");
	        TransportClient.instance().run(TransportOperationEnum.GET_SETTLEMENTS);
        }
	}

}
