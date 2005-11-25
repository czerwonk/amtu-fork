package com.amazon.merchants.transport.timer;

import java.io.IOException;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.NotificationListener;
import javax.management.ReflectionException;

import com.amazon.merchants.jmx.MBeanServerManager;
import com.amazon.merchants.remote.EmitterService;
import com.amazon.merchants.timer.NotificationFilter;
import com.amazon.merchants.timer.NotificationRegistry;
import com.amazon.merchants.timer.TimerService;
import com.amazon.merchants.transport.preferences.TransportPreferenceEnum;
import com.amazon.merchants.transport.preferences.TransportPreferences;

public class TransportNotificationRegistry
{
	private static final int MIN_TO_MILLI_CONVERT = 60000;
	private static final String DISPATCH_TYPE = "dispatch.feeds";
	private static final String ORDER_TYPE = "order.reports";
	private static final String PROCESSING_REPORT_TYPE = "processing.reports";
	private static final String SETTLEMENT_TYPE = "settlement.reports";

    private EmitterService emitterService;
    
	public void register()
		throws
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException,
			InstanceNotFoundException,
			MalformedObjectNameException,
			InstanceAlreadyExistsException,
			MBeanRegistrationException,
			NotCompliantMBeanException,
			MBeanException,
			ReflectionException,
            AttributeNotFoundException,
            IOException
	{
		TimerService.instance(MBeanServerManager.server()).start();
        emitterService = EmitterService.instance(MBeanServerManager.server());

        // the notification registery was designed specifically for the Timer
        // service. We'll have to use our own registration for the MBean that is
        // to listen for remote events and invoke the interactions with the server
        NotificationRegistry.initialize(
			MBeanServerManager.server(),
			TimerService.instance().timerName());
        
        // these four calls should register the operations with the Timer AND the remote listener.
		registerDispatch();
		registerOrders();
		registerProcessingReports();
		registerSettlement();
	}

	public void unregister()
		throws
			MBeanException,
			ReflectionException,
			InstanceNotFoundException,
			ListenerNotFoundException
	{
		TimerService.instance().stop();
		NotificationRegistry.unregister(DISPATCH_TYPE);
		NotificationRegistry.unregister(ORDER_TYPE);
		NotificationRegistry.unregister(PROCESSING_REPORT_TYPE);
		NotificationRegistry.unregister(SETTLEMENT_TYPE);
	}

	private void registerOrders()
		throws
			InstanceNotFoundException,
			MBeanException,
			ReflectionException,
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException
	{
		int orderFreq =
			TransportPreferences.instance().getPreferenceInt(
				TransportPreferenceEnum.ORDER_REPORT_INTERVAL_MINUTES)
				* MIN_TO_MILLI_CONVERT;
		String className ="com.amazon.merchants.transport.timer.OrderRunner"; 
        NotificationRegistry.register(className, ORDER_TYPE, orderFreq);

		NotificationListener listener = 
            new NotificationFilter((NotificationListener) Class.forName(className).newInstance(), ORDER_TYPE);
		MBeanServerManager.server().addNotificationListener(emitterService.objName(), listener, null, new Object());

    }

	private void registerDispatch()
		throws
			InstanceNotFoundException,
			MBeanException,
			ReflectionException,
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException
	{
		int dispatchFreq =
			TransportPreferences.instance().getPreferenceInt(
				TransportPreferenceEnum.DISPATCH_INTERVAL_MINUTES)
				* MIN_TO_MILLI_CONVERT;
		String className = "com.amazon.merchants.transport.timer.DispatchRunner";
        NotificationRegistry.register(className, DISPATCH_TYPE, dispatchFreq);

        NotificationListener listener = 
            new NotificationFilter((NotificationListener) Class.forName(className).newInstance(), DISPATCH_TYPE);
        MBeanServerManager.server().addNotificationListener(emitterService.objName(), listener, null, new Object());
	}

	private void registerSettlement()
		throws
			InstanceNotFoundException,
			MBeanException,
			ReflectionException,
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException
	{
		int settlementFreq =
			TransportPreferences.instance().getPreferenceInt(
				TransportPreferenceEnum.SETTLEMENT_REPORT_INTERVAL_MINUTES)
				* MIN_TO_MILLI_CONVERT;
		String className = "com.amazon.merchants.transport.timer.SettlementRunner"; 
        NotificationRegistry.register(className, SETTLEMENT_TYPE, settlementFreq);

        NotificationListener listener = 
            new NotificationFilter((NotificationListener) Class.forName(className).newInstance(), SETTLEMENT_TYPE);
        MBeanServerManager.server().addNotificationListener(emitterService.objName(), listener, null, new Object());
	}

	private void registerProcessingReports()
		throws
			InstanceNotFoundException,
			MBeanException,
			ReflectionException,
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException
	{
		int processingReportFreq =
			TransportPreferences.instance().getPreferenceInt(
				TransportPreferenceEnum.PROCESSING_REPORT_INTERVAL_MINUTES)
				* MIN_TO_MILLI_CONVERT;
		String className = "com.amazon.merchants.transport.timer.ProcessingReportRunner";

        NotificationRegistry.register(className, PROCESSING_REPORT_TYPE, processingReportFreq);

        NotificationListener listener = 
            new NotificationFilter((NotificationListener) Class.forName(className).newInstance(), PROCESSING_REPORT_TYPE);
        MBeanServerManager.server().addNotificationListener(emitterService.objName(), listener, null, new Object());
	}
}
