package com.amazon.merchants.transport;

import java.io.*;
import java.util.Properties;

import javax.management.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

import com.amazon.merchants.transport.preferences.*;
import com.amazon.merchants.transport.util.TransportDirectoryUtil;
import com.amazon.merchants.util.ConfigResource;

public class TransportMain
{

	public static void main(String[] args)
		throws
			MalformedObjectNameException,
			InstanceAlreadyExistsException,
			NotCompliantMBeanException,
			InstantiationException,
			IllegalAccessException,
			ClassNotFoundException,
			IOException,
			InstanceNotFoundException,
			ListenerNotFoundException,
			MBeanException,
			ReflectionException
	{
		System.setProperty("transport.appversion", "_amtu1.0.2_");

		if (!TransportPreferences.instance().preferencesExist())
		{
			System.out.println("Preferences not set, please run Configuration Utility before running this application!");
			return;
		}
		Properties log4jProps = new Properties();
		log4jProps.load(new ConfigResource("log4j.properties").inputStream());
		setupLogPaths(log4jProps);
		PropertyConfigurator.configure(log4jProps);

		if (args[0].equalsIgnoreCase("monitor"))
		{
			TransportServerMonitor monitor = new TransportServerMonitor();
			monitor.start();

			loopUntilDone();
			monitor.stop();
			LogManager.shutdown();
		} else
		{
			TransportServer transportServer = new TransportServer();
			transportServer.start();

			loopUntilDone();
			transportServer.stop();
			LogManager.shutdown();
		}
	}

	private static void loopUntilDone()
	{
		boolean loop = true;
		while (loop)
		{
			try
			{
				Thread.sleep(10000);
			} catch (InterruptedException e)
			{
				loop = false;
			}
		}
	}

	private static void setupLogPaths(Properties log4jProps)
	{
		// Override the existing setup
		String rootDirectory = TransportPreferences.instance().getPreference(TransportPreferenceEnum.TRANSPORT_ROOT_FOLDER);
		rootDirectory = rootDirectory+File.separator;
		String logDirectory = rootDirectory+File.separator+TransportDirectoryUtil.LOGS+File.separator;
		// Create log directory
		File logDir = new File(logDirectory);
		if (!logDir.exists())
		{
			logDir.mkdirs();
		}
		log4jProps.put("log4j.appender.debugLog.File",logDirectory+"debug.log");
		log4jProps.put("log4j.appender.auditLog.File",logDirectory+"audit.log");
		log4jProps.put("log4j.appender.errorLog.File",logDirectory+"error.log");
	}
}
