/*
 * Created on May 8, 2004
 *
 */
package com.amazon.merchants.transport.preferences;

import org.apache.commons.lang.enum.Enum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class TransportPreferenceEnum extends Enum
{
	private String defaultValue;

	// Folder Preferences
	public static final TransportPreferenceEnum TRANSPORT_ROOT_FOLDER=new TransportPreferenceEnum("transport.rootFolder",null);

	public static final TransportPreferenceEnum PROCESSING_REPORT_INTERVAL_MINUTES=new TransportPreferenceEnum("transport.processingReportIntervalMinutes","15");
	public static final TransportPreferenceEnum SETTLEMENT_REPORT_INTERVAL_MINUTES=new TransportPreferenceEnum("transport.settlementReportIntervalMinutes","180");
	public static final TransportPreferenceEnum ORDER_REPORT_INTERVAL_MINUTES=new TransportPreferenceEnum("transport.orderReportIntervalMinutes","30");
	public static final TransportPreferenceEnum DISPATCH_INTERVAL_MINUTES=new TransportPreferenceEnum("transport.dispatchIntervalMinutes","30");
	public static final TransportPreferenceEnum IS_FLATFILE=new TransportPreferenceEnum("transport.flatFile","true");

	// Retriever Specific Preferences
	public static final TransportPreferenceEnum RETRIEVER_REPORT_TIMEOUT=new TransportPreferenceEnum("retriever.timeout","60");
	public static final TransportPreferenceEnum RETRIEVER_POST_TIMEOUT_POLL_INTERVAL=new TransportPreferenceEnum("retriever.postTimeoutPoll","60");
		
	// Monitor Specific Preferences
	public static final TransportPreferenceEnum MONITOR_SEND_PORT=new TransportPreferenceEnum("transport.monitor.send.port", "13131");
	public static final TransportPreferenceEnum MONITOR_RECEIVE_PORT=new TransportPreferenceEnum("transport.monitor.receive.port", "13132");
	public static final TransportPreferenceEnum MONITOR_RECEIVE_HOST=new TransportPreferenceEnum("transport.monitor.receive.host", "localhost");
	public static final TransportPreferenceEnum MONITOR_SMTP_SERVER=new TransportPreferenceEnum("transport.monitor.smtp.server", "localhost");
	public static final TransportPreferenceEnum MONITOR_NOTIFY_EMAIL=new TransportPreferenceEnum("transport.monitor.notify.email", "name@address.com");

	// URL default preference keys
	public static final TransportPreferenceEnum MIP_DEFAULT_URL=new TransportPreferenceEnum("mip.user.url", "");
	public static final TransportPreferenceEnum PRODUCTION_DEFAULT_URL=new TransportPreferenceEnum("production.user.url", "");

	/**
	 * @param arg0
	 */
	public TransportPreferenceEnum(String arg0, String defaultValue)
	{
		super(arg0);
		this.defaultValue = defaultValue;
	}

	public static TransportPreferenceEnum getEnum(String code) {
	  TransportPreferenceEnum enum = (TransportPreferenceEnum) getEnum(TransportPreferenceEnum.class, code); 
	  return enum;
	}


	/**
	 * @return
	 */
	String getDefaultValue()
	{
		return defaultValue;
	}

	/**
	 * @param string
	 */
	void setDefaultValue(String string)
	{
		defaultValue = string;
	}

}
