/*
 * Created on Apr 27, 2004
 *
 */
package com.amazon.merchants.transport.logging;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazon.merchants.MerchantsException;
import com.amazon.merchants.transport.model.BatchReferenceIdentifier;
import com.amazon.merchants.transport.model.FeedStatusEnum;
import com.amazon.merchants.transport.model.MerchantDocument;
import com.amazon.merchants.transport.model.MerchantFeed;
import com.amazon.merchants.transport.model.MerchantReport;
import com.amazon.merchants.transport.model.ProcessingReport;
import com.amazon.merchants.transport.model.ReportTypeEnum;
import com.amazon.merchants.transport.persistence.DAOWrapper;
import com.amazon.merchants.transport.persistence.PersistenceException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class AuditLogger
{
	private static final AuditLogger _instance = new AuditLogger();
	private static final Log log = LogFactory.getLog(AuditLogger.class);
	private AuditLogger(){}
	
	public static AuditLogger instance()
	{
		return _instance;
	}
	
	public void logStatusUpdate(MerchantFeed feed)
	{
		String message = getStatusUpdateMessage(feed.getStatus(),
												feed.getBatchReference(),
												feed);
		log.info(message);
	}

	public void logStatusUpdate(ProcessingReport report)
	{
		try
		{
			MerchantFeed feed = DAOWrapper.getFeed(report.getBatchReference());
			String message = getStatusUpdateMessage(report.getStatus(),
													report.getBatchReference(),
													feed);
			log.info(message);
		}
		catch (PersistenceException pex)
		{
			log.debug(ExceptionUtils.getFullStackTrace(pex));
		}
	}

	public void logReportDownload(MerchantReport report)
	{
		String message = ReportDownloadMessageMappings.instance().getString(report.getDocumentType().getName());
		ArrayList params = new ArrayList();
		
		params.add(report.getDocumentName());
		
		if (report.getDocumentType().equals(ReportTypeEnum.PROCESSING_REPORT))
		{
			params.add(((ProcessingReport)report).getBatchReference().toString());
		}
				
		log.info(MessageFormat.format(message,params.toArray(new String[0])));		
	}
	
	private String getStatusUpdateMessage(FeedStatusEnum status, BatchReferenceIdentifier batch, MerchantDocument doc)
	{
		String message = FeedStatusMessageMappings.instance().getString(status.getName());
		ArrayList params = new ArrayList();
		
		params.add(doc.getDocumentName());
		
		if (status.equals(FeedStatusEnum.FAILED))
		{
			params.add(((MerchantFeed)doc).getFailureReason());
		}
		else
		{
			params.add(Long.toString(batch.getId()));				
		}
		
		return MessageFormat.format(message,params.toArray(new String [0]));
	}

	public void logSeriousError(MerchantsException mex)
	{
		this.logSeriousError("A serious error has occurred.",mex);
	}

	public void logSeriousError(String message, MerchantsException mex)
	{
		log.error(message+" Message: "+mex.getMessage()+" Root cause: "+mex.getRootCauseMessage());
	}

	public void logSeriousError(String message)
	{
		log.error(message);
	}
	
	public void logInfoMessage(String infoMessage)
	{
		log.info(infoMessage);
	}	
}
