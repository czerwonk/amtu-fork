package com.amazon.merchants.transport.timer;

import javax.management.*;

import com.amazon.merchants.jmx.MBeanServerManager;
import com.amazon.merchants.timer.*;
import com.amazon.merchants.transport.preferences.*;

public class TransportNotificationRegistry
{
	private static final int MIN_TO_MILLI_CONVERT = 60000;
	private static final String DISPATCH_TYPE = "dispatch.feeds";
	private static final String ORDER_TYPE = "order.reports";
	private static final String PROCESSING_REPORT_TYPE = "processing.reports";
	private static final String SETTLEMENT_TYPE = "settlement.reports";

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
			ReflectionException
	{
		TimerService.instance(MBeanServerManager.server()).start();
		NotificationRegistry.initialize(
			MBeanServerManager.server(),
			TimerService.instance().timerName());
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
		NotificationRegistry.register(
			"com.amazon.merchants.transport.timer.OrderRunner",
			ORDER_TYPE,
			orderFreq);
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
		NotificationRegistry.register(
			"com.amazon.merchants.transport.timer.DispatchRunner",
			DISPATCH_TYPE,
			dispatchFreq);
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
		NotificationRegistry.register(
			"com.amazon.merchants.transport.timer.SettlementRunner",
			SETTLEMENT_TYPE,
			settlementFreq);
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
		NotificationRegistry.register(
			"com.amazon.merchants.transport.timer.ProcessingReportRunner",
			PROCESSING_REPORT_TYPE,
			processingReportFreq);
	}
}
