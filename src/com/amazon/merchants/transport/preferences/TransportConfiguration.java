/*
 * Created on May 9, 2004
 *
 */
package com.amazon.merchants.transport.preferences;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.amazon.merchants.transport.model.MerchantAccount;

/**
 * Copyright 2004 Amazon.com
 *
 * Description:
 *
 * @author hynoskij
 *
 */
public class TransportConfiguration
{
	// Transport Preferences
	private HashMap accounts=new HashMap();
	private String rootFolder;
	private int processingReportIntervalMinutes;
	private int settlementReportIntervalMinutes;
	private int orderReportIntervalMinutes;
	private int dispatchIntervalMinutes;
	private int procReportTimeoutMinutes;
	private int procReportPostTimeoutIntervalMinutes;
	private boolean flatFile;
	private String serverLocations;

	// Monitor Preferences
	private int monitorSendPort;
	private int monitorReceivePort;
	private String monitorReceiveHost;
	private String monitorSMTPServer;
	private String monitorNotifyEmail;
	private String accessKey;
	private String secretAccessKey;


	public void addAccount(MerchantAccount account)
	{
		accounts.put(account.getEnvironmentName(),account);
	}

	public void removeAccount(MerchantAccount account)
	{
		accounts.remove(account.getEnvironmentName());
	}

	public MerchantAccount getAccount(String environmentName)
	{
		return (MerchantAccount)accounts.get(environmentName);
	}

	public Collection getAccounts()
	{
		return accounts.values();
	}

	public Iterator getAccountsIterator()
	{
		return accounts.values().iterator();
	}

	/**
	 * @return
	 */
	public int getDispatchIntervalMinutes()
	{
		return dispatchIntervalMinutes;
	}

	/**
	 * @return
	 */
	public boolean isFlatFile()
	{
		return flatFile;
	}

	/**
	 * @return
	 */
	public int getOrderReportIntervalMinutes()
	{
		return orderReportIntervalMinutes;
	}

	/**
	 * @return
	 */
	public int getProcessingReportIntervalMinutes()
	{
		return processingReportIntervalMinutes;
	}

	/**
	 * @return
	 */
	public int getSettlementReportIntervalMinutes()
	{
		return settlementReportIntervalMinutes;
	}

	/**
	 * @param i
	 */
	public void setDispatchIntervalMinutes(int i)
	{
		dispatchIntervalMinutes = i;
	}

	/**
	 * @param b
	 */
	public void setFlatFile(boolean b)
	{
		flatFile = b;
	}

	/**
	 * @param i
	 */
	public void setOrderReportIntervalMinutes(int i)
	{
		orderReportIntervalMinutes = i;
	}

	/**
	 * @param i
	 */
	public void setProcessingReportIntervalMinutes(int i)
	{
		processingReportIntervalMinutes = i;
	}

	/**
	 * @param i
	 */
	public void setSettlementReportIntervalMinutes(int i)
	{
		settlementReportIntervalMinutes = i;
	}
	/**
	 * @return
	 */
	public int getProcReportPostTimeoutIntervalMinutes()
	{
		return procReportPostTimeoutIntervalMinutes;
	}

	/**
	 * @return
	 */
	public int getProcReportTimeoutMinutes()
	{
		return procReportTimeoutMinutes;
	}

	/**
	 * @return
	 */
	public String getRootFolder()
	{
		return rootFolder;
	}

	/**
	 * @param i
	 */
	public void setProcReportPostTimeoutIntervalMinutes(int i)
	{
		procReportPostTimeoutIntervalMinutes = i;
	}

	/**
	 * @param i
	 */
	public void setProcReportTimeoutMinutes(int i)
	{
		procReportTimeoutMinutes = i;
	}

	/**
	 * @param string
	 */
	public void setRootFolder(String string)
	{
		rootFolder = string;
	}

	/**
	 * @return
	 */
	public String getMonitorNotifyEmail()
	{
		return monitorNotifyEmail;
	}

	/**
	 * @return
	 */
	public String getMonitorReceiveHost()
	{
		return monitorReceiveHost;
	}

	/**
	 * @return
	 */
	public int getMonitorReceivePort()
	{
		return monitorReceivePort;
	}

	/**
	 * @return
	 */
	public int getMonitorSendPort()
	{
		return monitorSendPort;
	}

	/**
	 * @return
	 */
	public String getMonitorSMTPServer()
	{
		return monitorSMTPServer;
	}

	/**
	 * @param string
	 */
	public void setMonitorNotifyEmail(String string)
	{
		monitorNotifyEmail = string;
	}

	/**
	 * @param string
	 */
	public void setMonitorReceiveHost(String string)
	{
		monitorReceiveHost = string;
	}

	/**
	 * @param i
	 */
	public void setMonitorReceivePort(int i)
	{
		monitorReceivePort = i;
	}

	/**
	 * @param i
	 */
	public void setMonitorSendPort(int i)
	{
		monitorSendPort = i;
	}

	/**
	 * @param string
	 */
	public void setMonitorSMTPServer(String string)
	{
		monitorSMTPServer = string;
	}

	/**
	 * @return:
	 * @ pcn
	 */
	public String getaccessKey()
	{
		return accessKey;
	}
	public void setaccessKey (String accessKey)
	{
	    this.accessKey = accessKey;
	}
	public String getsecretAccessKey()
	{
		return secretAccessKey;
	}
	public void setsecretAccessKey (String accessKey)
	{
	    this.secretAccessKey = secretAccessKey;
	}

	public void setServerLocations(String serverLocations)
	{
		this.serverLocations = serverLocations;
	}

	public String getServerLocations()
	{
		return this.serverLocations;
	}

}
