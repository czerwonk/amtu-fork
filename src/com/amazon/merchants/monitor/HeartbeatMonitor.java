package com.amazon.merchants.monitor;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.commons.lang.Validate;
import org.apache.commons.logging.*;

public class HeartbeatMonitor extends Observable implements Runnable
{
	private DatagramSocket socket;
	private int port;
	private boolean isMonitoring;
	private boolean isAlive;

	private static final Log log = LogFactory.getLog(HeartbeatMonitor.class);
	// Allow it to miss four heartbeats (plus a one-second fudge-factor)
	//  before panicking.
	private static final int PANIC_TIMEOUT =
		Heartbeat.FREQUENCY_IN_MILLIS * 5 + 1000;
	private static final int MIN_PORT = 1023;
	
	public HeartbeatMonitor(int port)
	{
		Validate.isTrue(
			port > 1023 && port < 65536,
			"Port must be in allowable range [1024,65535]");
		this.port = port;
	}

	public void run()
	{
		synchronized (this)
		{
			isMonitoring = true;
		}
		byte[] buf = new byte[Heartbeat.ALIVE_STRING.getBytes().length + 1];
		try
		{
			while (isMonitoring)
			{
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket().setSoTimeout(PANIC_TIMEOUT);
				try
				{
					socket().receive(packet);
					log.debug("Monitor received heartbeat");
					toggleAndNotifyOnStateChange(!isAlive);
				} catch (SocketTimeoutException e)
				{
					log.debug("Monitor failed to receive packet");
					toggleAndNotifyOnStateChange(isAlive);
				}
			}
		} catch (IOException e)
		{
			log.fatal("Heartbeat Monitor Exiting.", e);
		}
	}

	public void stop()
	{
		synchronized (this)
		{
			isMonitoring = false;
		}
	}

	private void toggleAndNotifyOnStateChange(boolean stateChanged)
	{
		if (stateChanged)
		{
			log.debug("Monitor notifying observers");
			isAlive = !isAlive; // Toggle current value
			this.setChanged();
			notifyObservers(new Boolean(isAlive));
		}
	}

	private DatagramSocket socket() throws SocketException
	{
		if (socket == null)
		{
			socket = new DatagramSocket(this.port);
			log.debug("Monitor connected to " + this.port);
		}
		return socket;
	}
}
