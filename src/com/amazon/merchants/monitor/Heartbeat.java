package com.amazon.merchants.monitor;

import java.io.IOException;
import java.net.*;
import java.util.Properties;

import org.apache.commons.lang.Validate;
import org.apache.commons.logging.*;

public class Heartbeat implements Runnable
{
	public static final String LOCAL_PORT_PROPERTY = "heartbeat.local.port";
	public static final String REMOTE_PORT_PROPERTY = "heartbeat.remote.port";
	public static final String REMOTE_ADDRESS_PROPERTY =
		"heartbeat.remote.address";

	// These are package-local so that the monitor can see them.
	// They are final so that the monitor can depend on their values,
	//  even if it happens to be running on another host.
	static final String ALIVE_STRING = "alive";
	static final int FREQUENCY_IN_MILLIS = 60000;

	private static final Log log = LogFactory.getLog(Heartbeat.class);

	private int port;
	private boolean keepBeating;
	private DatagramSocket localSocket;
	private SocketAddress listenerAddress;

	public Heartbeat(int localPort, SocketAddress listenerAddress)
		throws IOException
	{
		Validate.isTrue(
			localPort > 1023 && localPort < 65536,
			"Port must be in allowable range [1024,65535]");
		Validate.notNull(listenerAddress, "Listener Address cannot be null");

		this.port = localPort;
		this.listenerAddress = listenerAddress;
	}

	public Heartbeat(Properties props)
	{
		String portStr = props.getProperty(LOCAL_PORT_PROPERTY);
		String remPortStr = props.getProperty(REMOTE_PORT_PROPERTY);
		String remAddrStr = props.getProperty(REMOTE_ADDRESS_PROPERTY);
		Validate.notEmpty(portStr, "Must supply " + LOCAL_PORT_PROPERTY);
		Validate.notEmpty(remPortStr, "Must supply " + REMOTE_PORT_PROPERTY);
		Validate.notEmpty(remAddrStr, "Must supply " + REMOTE_ADDRESS_PROPERTY);

		this.port = Integer.parseInt(portStr);
		this.listenerAddress =
			new InetSocketAddress(remAddrStr, Integer.parseInt(remPortStr));
	}

	public void stopBeating()
	{
		synchronized (this)
		{
			keepBeating = false;
		}
	}

	public void run()
	{
		try
		{
			startBeating();
		} catch (IOException e)
		{
			log.fatal("Heartbeat Exiting.", e);
		}
	}

	private void startBeating() throws IOException
	{
		synchronized (this)
		{
			keepBeating = true;
		}
		beat(FREQUENCY_IN_MILLIS);
	}

	private void beat(int frequencyInMillis) throws IOException
	{
		while (keepBeating)
		{
			beatOnce();
			try
			{
				Thread.sleep(frequencyInMillis);
			} catch (InterruptedException ignored)
			{}
		}
	}

	private void beatOnce() throws IOException
	{
		socket().send(
			new DatagramPacket(
				ALIVE_STRING.getBytes(),
				ALIVE_STRING.getBytes().length,
				listenerAddress));
		log.debug("Heartbeat sent");
	}

	private DatagramSocket socket() throws SocketException
	{
		if (localSocket == null)
		{
			localSocket = new DatagramSocket(this.port);
			log.debug("Heartbeat connected to " + this.port);
		}
		return localSocket;
	}
}
