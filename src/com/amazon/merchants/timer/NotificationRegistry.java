package com.amazon.merchants.timer;

import java.util.*;

import javax.management.*;

import org.apache.commons.lang.Validate;

public class NotificationRegistry
{
	// Minimum "ping" is one second.
	private static final int MIN_PERIOD = 1000;

	private static MBeanServer mbeanServer;
	private static ObjectName timerObjName;

	private static Map listeners = new HashMap();

	public static void initialize(MBeanServer server, ObjectName timer)
	{
		mbeanServer = server;
		timerObjName = timer;
	}

	public static void register(Properties props)
		throws
			InstanceNotFoundException,
			NumberFormatException,
			MBeanException,
			ReflectionException,
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException
	{
		if (!isInitialized())
		{
			throw new IllegalArgumentException("NotificationRegistry is not initialized.  Cannot register.");
		}
		Validate.notNull(props);
		String classes = props.getProperty("notify.classes");
		String periods = props.getProperty("notify.periods");
		String types = props.getProperty("notify.notificationTypes");

		Validate.notEmpty(classes);
		Validate.notEmpty(periods);
		Validate.notEmpty(types);

		String[] classArray = split(classes);
		String[] periodArray = split(periods);
		String[] typeArray = split(types);
		if (classArray.length != periodArray.length)
		{
			throw new IllegalArgumentException("Classes and periods - numbers must match");
		}
		if (classArray.length != typeArray.length)
		{
			throw new IllegalArgumentException("Classes and types - numbers must match");
		}
		for (int i = 0; i < classArray.length; i++)
		{
			register(
				classArray[i],
				typeArray[i],
				Long.parseLong(periodArray[i]));
		}
	}

	public static void register(String className, String type, long period)
		throws
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException,
			InstanceNotFoundException,
			MBeanException,
			ReflectionException
	{
		if (!isInitialized())
		{
			throw new IllegalArgumentException("NotificationRegistry is not initialized.  Cannot register.");
		}
		Validate.notEmpty(className);
		Validate.notEmpty(type);
		Validate.isTrue(period > MIN_PERIOD);

		mbeanServer.invoke(
			timerObjName,
			"addNotification",
			new Object[] { type, "message", null, new Date(), new Long(period)},
			new String[] {
				"java.lang.String",
				"java.lang.String",
				"java.lang.Object",
				"java.util.Date",
				"long" });
		NotificationListener listener =
			new NotificationFilter(
				(NotificationListener) Class.forName(className).newInstance(),
				type);
		listeners.put(type, listener);
		mbeanServer.addNotificationListener(
			timerObjName,
			listener,
			null,
			new Object());
	}

	public static void unregister(String type)
		throws InstanceNotFoundException, ListenerNotFoundException
	{
		NotificationListener listener =
			(NotificationListener) listeners.get(type);
		if (listener != null)
		{
			mbeanServer.removeNotificationListener(timerObjName, listener);
		}
	}

	static void deInitialize()
	{
		// For testing
		mbeanServer = null;
		timerObjName = null;
	}

	private static boolean isInitialized()
	{
		return mbeanServer != null && timerObjName != null;
	}

	private static String[] split(String stringToSplit)
	{
		ArrayList list = new ArrayList();
		StringTokenizer tok = new StringTokenizer(stringToSplit);
		while (tok.hasMoreElements())
		{
			list.add(tok.nextToken());
		}
		return (String[]) list.toArray(new String[0]);
	}
}
