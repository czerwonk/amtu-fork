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
			ReflectionException,
            AttributeNotFoundException
	{
		System.setProperty("transport.appversion", "_amtu1.0.8_");

		if (!TransportPreferences.instance().preferencesExist())
		{
			System.out.println("Preferences not set, please run Configuration Utility before running this application!");
			return;
		}
		Properties log4jProps = new Properties();
		log4jProps.load(new ConfigResource("log4j.properties").inputStream());

		//Different log files based on monitor mode or not...
		if(args[0].equalsIgnoreCase("monitor"))
			setupLogPaths(log4jProps,"moni_");
		else
			setupLogPaths(log4jProps,"amtu_");

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

	private static void setupLogPaths(Properties log4jProps, String logNamePrefix)
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
		String defDebug = logDirectory + logNamePrefix + "def_debug.log";
		String defAudit = logDirectory + logNamePrefix + "def_audit.log";
		String defError = logDirectory + logNamePrefix + "def_error.log";
	    String curLog;

		//Only be explicit about the pathing if there is no pathing already specified
		//in the existing properties file
		curLog = log4jProps.getProperty("log4j.appender.debugLog.File");
		if(curLog.length() > 0)
		{
			if(curLog.indexOf(File.separator) < 0)
				curLog = logDirectory + logNamePrefix + curLog;
		}
		else
			curLog = defDebug;
		log4jProps.put("log4j.appender.debugLog.File",curLog);

		curLog = log4jProps.getProperty("log4j.appender.auditLog.File");
		if(curLog.length() > 0)
		{
			if(curLog.indexOf(File.separator) < 0)
				curLog =  logDirectory + logNamePrefix + curLog;
		}
		else
			curLog = defAudit;
		log4jProps.put("log4j.appender.auditLog.File",curLog);

		curLog = log4jProps.getProperty("log4j.appender.errorLog.File");
		if(curLog.length() > 0)
		{
			if(curLog.indexOf(File.separator) < 0)
				curLog =  logDirectory + logNamePrefix + curLog;
		}
		else
			curLog = defError;
		log4jProps.put("log4j.appender.errorLog.File",curLog);
	}
}
