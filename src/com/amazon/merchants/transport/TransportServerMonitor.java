package com.amazon.merchants.transport;

import com.amazon.merchants.monitor.*;
import com.amazon.merchants.transport.preferences.*;

public class TransportServerMonitor
{
	private HeartbeatMonitor monitor;

	public void start()
	{
		// Initialize Monitor service. 
		monitor = new HeartbeatMonitor(monitorPort());
		MonitorAction mailAction =
			new SendMailMonitorAction(
				smtpServer(),
				emailAddress(),
				emailAddress());
		monitor.addObserver(mailAction);
		MonitorAction logAction = new MonitorAction("Transport Server");
		monitor.addObserver(logAction);

		new Thread(monitor).start();
	}

	public void stop()
	{
		monitor.stop();
	}

	private int monitorPort()
	{
		return TransportPreferences.instance().getPreferenceInt(
			TransportPreferenceEnum.MONITOR_RECEIVE_PORT);
	}

	private String smtpServer()
	{
		return TransportPreferences.instance().getPreference(
			TransportPreferenceEnum.MONITOR_SMTP_SERVER);
	}

	private String emailAddress()
	{
		return TransportPreferences.instance().getPreference(
			TransportPreferenceEnum.MONITOR_NOTIFY_EMAIL);
	}

}
