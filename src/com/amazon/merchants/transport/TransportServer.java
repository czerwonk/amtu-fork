package com.amazon.merchants.transport;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.management.*;

import com.amazon.merchants.monitor.Heartbeat;
import com.amazon.merchants.transport.preferences.*;
import com.amazon.merchants.transport.timer.TransportNotificationRegistry;

public class TransportServer
{
	private TransportNotificationRegistry registry;
	private Heartbeat heartbeat;

	public void start()
		throws
			InstanceNotFoundException,
			MalformedObjectNameException,
			InstanceAlreadyExistsException,
			MBeanRegistrationException,
			NotCompliantMBeanException,
			MBeanException,
			ReflectionException,
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException,
			IOException
	{
		// Initialize MBeanServer, TimerService, and register
		//  timers for all feeds and reports.
		registry = new TransportNotificationRegistry();
		registry.register();

		// Initialize Monitor Heartbeat service.
		heartbeat = new Heartbeat(heartbeatPort(), monitorAddress());
		new Thread(heartbeat).start();
	}

	public void stop()
		throws
			InstanceNotFoundException,
			ListenerNotFoundException,
			MBeanException,
			ReflectionException
	{
		new TransportNotificationRegistry().unregister();
		heartbeat.stopBeating();
	}

	private int heartbeatPort()
	{
		return TransportPreferences.instance().getPreferenceInt(
			TransportPreferenceEnum.MONITOR_SEND_PORT);
	}

	private InetSocketAddress monitorAddress()
	{
		return new InetSocketAddress(monitorHost(), monitorPort());
	}

	private String monitorHost()
	{
		return TransportPreferences.instance().getPreference(
			TransportPreferenceEnum.MONITOR_RECEIVE_HOST);
	}

	private int monitorPort()
	{
		return TransportPreferences.instance().getPreferenceInt(
			TransportPreferenceEnum.MONITOR_RECEIVE_PORT);
	}
}
