/*
 * Created on May 6, 2004
 *
 */
package com.amazon.merchants.transport.retriever.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.*;

import com.amazon.merchants.MerchantsException;
import com.amazon.merchants.dao.DAOException;
import com.amazon.merchants.transport.TransportConstants;
import com.amazon.merchants.transport.adapter.*;
import com.amazon.merchants.transport.logging.AuditLogger;
import com.amazon.merchants.transport.model.*;
import com.amazon.merchants.transport.persistence.*;
import com.amazon.merchants.transport.retriever.*;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class RetrieverServiceImpl implements RetrieverService
{
	private static final RetrieverService _instance=new RetrieverServiceImpl();
	private ProcessingReportCollator reportCollator;

	private	RetrieverServiceImpl()
	{
		reportCollator = new ProcessingReportCollator();
	}

	public static final RetrieverService instance()
	{
		return _instance;
	}
	
	private static final Log log = LogFactory.getLog(RetrieverService.class);
	private Properties retrieverProperties;
	
	private void setRetrieverProperties(Properties properties)
	{
		retrieverProperties = properties;
	}
	
	public ProcessingReport getProcessingReport(
		BatchReferenceIdentifier batchReference,
		MerchantAccount account,
		boolean flatFile)
		throws RetrieverException
	{
		return (getProcessingReports(new BatchReferenceIdentifier[]{batchReference},account,flatFile))[0];
	}

	/*
	 * @see com.amazon.merchants.transport.retriever.RetrieverService#getDocument(com.amazon.merchants.transport.model.DocumentIdentifier, com.amazon.merchants.transport.model.MerchantAccount, boolean)
	 */
	public MerchantReport getDocument(
		DocumentIdentifier documentID,
		MerchantAccount account,
		boolean flatFile)
		throws RetrieverException
	{
		MerchantReport report = null;
		try
		{
			MerchantsAtConnector connector = MerchantsAtConnectorFactory.instance().getMerchantsAtConnector(account);
			report = connector.getDocument(documentID);
			report.setFlatFile(flatFile);
		}
		catch(MerchantsAtConnectorException mex)
		{
			log.debug(ExceptionUtils.getFullStackTrace(mex));
			AuditLogger.instance().logSeriousError("Document id "+documentID.getId()+" contained no data.");
			throw new RetrieverException("An error occurred retrieving document "+documentID.getId(),mex);					
		}

		return report;
	}

	/*
	 * @see com.amazon.merchants.transport.retriever.RetrieverService#getPendingReports(com.amazon.merchants.transport.model.ReportTypeEnum, com.amazon.merchants.transport.model.MerchantAccount, boolean)
	 */
	public MerchantReport[] getPendingReports(
		ReportTypeEnum reportType,
		MerchantAccount account,
		boolean flatFile)
		throws RetrieverException
	{
		ArrayList documents = new ArrayList();
		MerchantReport [] reportArray = new MerchantReport[0];
		try
		{
			MerchantsAtConnector connector = MerchantsAtConnectorFactory.instance().getMerchantsAtConnector(account);
			DocumentIdentifier [] docIds = connector.getAllPendingDocumentIds(reportType,flatFile);
			if (docIds!=null && docIds.length > 0)
			{
				for (int i=0;i<docIds.length;i++)
				{
					try
					{
						MerchantReport mr = connector.getDocument(docIds[i]);
						if (mr != null)
						{
							mr.setEnvironment(account.getEnvironmentName());
							mr.setDocumentType(reportType);
							documents.add(mr);
						}
						else
						{
							AuditLogger.instance().logSeriousError("Document id "+docIds[i].getId()+" contained no data.");
						}
					}
					catch (MerchantsAtConnectorException mex)
					{
						// Log and continue - give each document a chance
						log.debug(ExceptionUtils.getFullStackTrace(mex));
						AuditLogger.instance().logSeriousError("Document id "+docIds[i].getId()+" could not be downloaded.",mex);
					}
				}
				reportArray = (MerchantReport[])documents.toArray(new MerchantReport[0]);
				connector.acknowledgeDocumentDownload(reportArray);
			}
		}
		catch(MerchantsAtConnectorException mex)
		{
			log.debug(ExceptionUtils.getFullStackTrace(mex));
			AuditLogger.instance().logSeriousError(mex);
			throw new RetrieverException("An error occurred retrieving reports",mex);		
		}

		return reportArray;
	}

	/*
	 * @see com.amazon.merchants.transport.retriever.RetrieverService#getProcessingReports(com.amazon.merchants.transport.model.BatchReferenceIdentifier[], com.amazon.merchants.transport.model.MerchantAccount, boolean)
	 */
	public ProcessingReport[] getProcessingReports(
		BatchReferenceIdentifier[] batchReferences,
		MerchantAccount account,
		boolean flatFile)
		throws RetrieverException
	{
		ArrayList reports = new ArrayList();
		ProcessingReport [] reportArray = new ProcessingReport[0];

		try
		{
			MerchantsAtConnector connector = MerchantsAtConnectorFactory.instance().getMerchantsAtConnector(account);
			for (int i=0;i<batchReferences.length;i++)
			{
				try
				{
					ProcessingReport pr = connector.getProcessingReport(batchReferences[i],flatFile);
					if (pr != null)
					{
						pr.setLastPollAttempt(new Date());
						pr.setEnvironment(account.getEnvironmentName());
						reports.add(pr);
						DAOWrapper.update(pr);
						AuditLogger.instance().logStatusUpdate(pr);
					}
					else
					{
						AuditLogger.instance().logSeriousError("Processing report for batch id "+batchReferences[i].getId()+" contained no data.");
					}		
				}
				catch (MerchantsAtConnectorException mex)
				{
					// Log and continue - give each document a chance
					log.debug(ExceptionUtils.getFullStackTrace(mex));
					AuditLogger.instance().logSeriousError("Document id "+batchReferences[i].getId()+" could not be downloaded.",mex);
				}
				catch (PersistenceException pex)
				{
					log.debug(ExceptionUtils.getFullStackTrace(pex));
					AuditLogger.instance().logSeriousError("Batch reference "+batchReferences[i].getId()+" could not be updated in database.",pex);
				}
			}
			reportArray = (ProcessingReport[])reports.toArray(new ProcessingReport[0]);
			connector.acknowledgeDocumentDownload(reportArray);
		}
		catch (MerchantsAtConnectorException mex)
		{
			log.debug(ExceptionUtils.getFullStackTrace(mex));
			AuditLogger.instance().logSeriousError(mex);
			throw new RetrieverException("An error occurred retrieving processing reports",mex);				
		}

		return (ProcessingReport[])reports.toArray(new ProcessingReport[0]);
	}

	/*
	 * @see com.amazon.merchants.transport.retriever.RetrieverService#retrieveAllPendingReports(com.amazon.merchants.transport.model.ReportTypeEnum, com.amazon.merchants.transport.model.MerchantAccount, java.io.File, boolean)
	 */
	public void retrieveAllPendingReports(
		ReportTypeEnum reportType,
		MerchantAccount account,
		File incomingDirectory,
		boolean flatFile)
		throws RetrieverException
	{
		AuditLogger.instance().logInfoMessage("Retrieving Outstanding "+reportType.getName()+" reports for environment "+account.getEnvironmentName());
		MerchantReport [] reports = getPendingReports(reportType,account,flatFile);
		saveGenericReports(reports,incomingDirectory,flatFile);
		AuditLogger.instance().logInfoMessage("Retrieved "+reports.length+" "+ reportType.getName() +" reports.");
	}

	/*
	 * @see com.amazon.merchants.transport.retriever.RetrieverService#retrieveOutstandingProcessingReports(com.amazon.merchants.transport.model.MerchantAccount, java.io.File, boolean)
	 */
	public void retrieveOutstandingProcessingReports(
		MerchantAccount account,
		File incomingDirectory,
		boolean flatFile)
		throws RetrieverException
	{
		AuditLogger.instance().logInfoMessage("Retrieving Outstanding Processing Reports for environment "+account.getEnvironmentName());
		BatchReferenceIdentifier [] batches = reportCollator.getAllPendingReports(account.getEnvironmentName());
		ProcessingReport [] reports = getProcessingReports(batches,account,flatFile);
		saveGenericReports(reports,incomingDirectory,flatFile);
		AuditLogger.instance().logInfoMessage("Retrieved processing report or updated status for "+reports.length+" processing reports.");
	}

	private void saveGenericReports(MerchantReport [] reports, File incomingDirectory, boolean flatFile)
	{
		for (int i=0;i<reports.length;i++)
		{
			// Only save to file if a file exists to save
			if (reports[i].getDocument()!=null)
			{
				boolean isProcessingReport=false;
				String reportId="";
				if (reports[i] instanceof ProcessingReport)
				{
					// Name processing report by batch ref to make life easier
					isProcessingReport = true;
					reportId = Long.toString(((ProcessingReport)reports[i]).getBatchReference().getId());
				}
				else
				{
					reportId = reports[i].getDocumentId().getId();
				}
				
				String fileName = new StringBuffer().
								append(reports[i].getDocumentType().getName()).
								append(reportId).
								append(".").
								append(flatFile?TransportConstants.FLAT_FILE_SUFFIX
											   :TransportConstants.XML_FILE_SUFFIX).
								toString();
				
				File savePath = new File(incomingDirectory.getAbsolutePath()+File.separator+fileName);
				
				try
				{
					reports[i].saveToFile(savePath);
					reports[i].setDownloadDate(new Date());
					MerchantReportDAO dao = new MerchantReportDAO();
					dao.create(reports[i]);
					AuditLogger.instance().logReportDownload(reports[i]);
				}
				catch(DAOException dex)
				{
					log.debug(ExceptionUtils.getFullStackTrace(dex));
					AuditLogger.instance().logSeriousError("Could not store "+fileName+" to the database.",new MerchantsException(dex));
				}
				catch(IOException iox)
				{
					log.debug(ExceptionUtils.getFullStackTrace(iox));
					AuditLogger.instance().logSeriousError("Could not save "+fileName+" to disk.",new MerchantsException(iox));
				}
			}
		}
	}
}
