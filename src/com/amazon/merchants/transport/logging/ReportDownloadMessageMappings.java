/*
 * Created on Apr 13, 2004
 *
 */
package com.amazon.merchants.transport.logging;

import java.util.ListResourceBundle;

import com.amazon.merchants.transport.model.ReportTypeEnum;
;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class ReportDownloadMessageMappings extends ListResourceBundle
{
	private static final ReportDownloadMessageMappings _instance = new ReportDownloadMessageMappings();
	/*
	 * @see java.util.ListResourceBundle#getContents()
	 */
	protected Object[][] getContents()
	{
		return contents;
	}
	
	public static ReportDownloadMessageMappings instance()
	{
		return _instance;
	}
	
	static final Object[][] contents = 
	{
	  {ReportTypeEnum.ORDER_REPORT.getName(),"Order report downloaded and saved to file {0}"},
	  {ReportTypeEnum.SETTLEMENT_REPORT.getName(),"Settlement report downloaded and saved to file {0}"},
	  {ReportTypeEnum.PROCESSING_REPORT.getName(),"Processing report saved to file {0} for batch reference {1}."}
	};	  
}


