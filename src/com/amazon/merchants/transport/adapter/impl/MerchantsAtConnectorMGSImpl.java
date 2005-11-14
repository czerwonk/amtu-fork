/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.adapter.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.activation.DataHandler;
import javax.xml.soap.SOAPException;

import org.apache.axis.AxisFault;
import org.apache.axis.attachments.*;
import org.apache.axis.holders.OctetStreamHolder;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.*;

import com.amazon.merchants.transport.adapter.*;
import com.amazon.merchants.transport.model.*;
import com.amazon.merchants.transport.soapclient.*;
import com.amazon.merchants.transport.adapter.util.ErrorMapper;
import com.amazon.merchants.util.file.IO;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class MerchantsAtConnectorMGSImpl implements MerchantsAtConnector
{
	MerchantAccount credentials;
	MerchantInterface merchantInterface;
	Merchant merchant;
	
	private static Log log = LogFactory.getLog(MerchantsAtConnector.class);
	
	/**
	 * 
	 */
	public MerchantsAtConnectorMGSImpl(MerchantAccount credentials) throws MerchantsAtConnectorException
	{
		super();
		this.credentials = credentials;
		merchant = new Merchant();
		merchant.setMerchantIdentifier(credentials.getToken());
		merchant.setMerchantName(credentials.getMerchantName());
		try
		{
			URL merchAtURL = new URL(credentials.getMerchantURL());
			merchantInterface = new MerchantInterfaceMimeLocator().getMerchantInterface(merchAtURL);
			((MerchantInterfaceStub)merchantInterface).setUsername(credentials.getUsername());
			((MerchantInterfaceStub)merchantInterface).setPassword(credentials.getPassword());
		}
		catch (Exception ex)
		{
			if (log.isDebugEnabled())
			{
				log.debug(ExceptionUtils.getStackTrace(ex));
			}
			throw new MerchantsAtConnectorException("Could not create merchant connector service",ex);
		}
	}
	/*
	 * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#postDocument(com.amazon.merchants.transport.model.MerchantDocument)
	 */
	public BatchReferenceIdentifier postDocument(MerchantFeed document) throws MerchantsAtConnectorException
	{
		return postDocument(document,false);
	}
	/*
	 * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#postDocument(com.amazon.merchants.transport.model.MerchantDocument, boolean)
	 */
	public BatchReferenceIdentifier postDocument(MerchantFeed document, boolean isDeadEnd) throws MerchantsAtConnectorException
	{
		Validate.notNull(document);

		DocumentSubmissionResponse response = null;
		BatchReferenceIdentifier batchRef = null;
		String messageType=null;
		document.setTimeSubmitted(new java.util.Date());
		document.setEnvironment(credentials.getEnvironmentName());
		
		try
		{
			if (document.isFlatFile())
			{
				messageType = ((DocumentTypeEnum)document.getDocumentType()).getFlatFileCode();
			}
			else
			{
				messageType = ((DocumentTypeEnum)document.getDocumentType()).getXmlCode();
			}

			if (isDeadEnd)
			{
				response = merchantInterface.postDocumentInterfaceConformance(merchant,messageType,new OctetStream(IO.toByteArray(document.getDocument().getInputStream())));
			}
			else
			{
				response = merchantInterface.postDocument(merchant,messageType,new OctetStream(IO.toByteArray(document.getDocument().getInputStream())));
			}
			
			if (response.getDocumentTransactionID() > 0)
			{
				batchRef = new BatchReferenceIdentifier(response.getDocumentTransactionID());
				document.setBatchReference(batchRef);
			}
			else
			{
				throw new MerchantsAtConnectorException("Batch reference id returned is invalid");
			}
		}
		catch (AxisFault soex)
		{
			if (log.isDebugEnabled())
			{
				log.debug(ExceptionUtils.getStackTrace(soex));
			}
			ErrorMapper.instance().handleException(soex);
		}
		catch (Exception ix)
		{
			if (log.isDebugEnabled())
			{			
				log.debug(ExceptionUtils.getStackTrace(ix));
			}
			throw new MerchantsAtConnectorException("A serious error has occurred.",ix);
		}
		
		return batchRef;
	}
	/*
	 * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#getDocument(java.lang.String)
	 */
	public MerchantReport getDocument(DocumentIdentifier documentId) throws MerchantsAtConnectorException
	{
		Validate.notNull(documentId);
		
		MerchantReport theDocument = null;
		try
		{
			merchantInterface.getDocument(merchant,documentId.getId(),new OctetStreamHolder());
			Object [] attachments = ((MerchantInterfaceStub)merchantInterface).getAttachments();
			if (attachments.length > 0)
			{
				// Going to assume the server is behaving and returns just the one attachment
				AttachmentPart attachment = (AttachmentPart)attachments[0];
				DataHandler handler = attachment.getDataHandler();
				theDocument = new MerchantReport();
				theDocument.setDocument(handler);
				theDocument.setDocumentId(documentId);
				theDocument.setDownloadDate(new java.util.Date());
				theDocument.setEnvironment(credentials.getEnvironmentName());				
			}
		}
		catch (SOAPException soex)
		{
			if (log.isDebugEnabled())
			{
				log.debug(ExceptionUtils.getStackTrace(soex));
			}
			throw new MerchantsAtConnectorException("No attachment in incoming message for document id "+documentId.getId());
		}
		catch (AxisFault af)
		{
			if (log.isDebugEnabled())
			{
				log.debug(ExceptionUtils.getStackTrace(af));
			}
			ErrorMapper.instance().handleException(af);
		}
		catch (Exception ix)
		{
			if (log.isDebugEnabled())
			{			
				log.debug(ExceptionUtils.getStackTrace(ix));
			}
			throw new MerchantsAtConnectorException("A serious error has occurred while downloading  for document id "+documentId.getId(),ix);
		}

		return theDocument;
	}

	/*
	 * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#getAllPendingDocumentIds(org.apache.commons.lang.enum.Enum)
	 */
	public DocumentIdentifier [] getAllPendingDocumentIds(ReportTypeEnum messageType, boolean isFlatFile) throws MerchantsAtConnectorException
	{
		Validate.notNull(messageType);

		DocumentIdentifier [] docIds = new DocumentIdentifier[0];
		try
		{
			String messageTypeString=isFlatFile?messageType.getFlatFileCode():messageType.getXmlCode();
			ArrayOfMerchantDocumentInfo docInfo = merchantInterface.getAllPendingDocumentInfo(merchant,messageTypeString);
			MerchantDocumentInfo [] docInfoArray = docInfo.getMerchantDocumentInfo();
			if (docInfoArray != null)
			{
				docIds = new DocumentIdentifier[docInfoArray.length];
				for(int i=0; i<docInfoArray.length;i++)
				{
					docIds[i] = new DocumentIdentifier(docInfoArray[i].getDocumentID());
				}
			}
		}
		catch (AxisFault af)
		{
			if (log.isDebugEnabled())
			{
				log.debug(ExceptionUtils.getStackTrace(af));
			}
			ErrorMapper.instance().handleException(af);
		}
		catch(Exception ix)
		{
			if (log.isDebugEnabled())
			{			
				log.debug(ExceptionUtils.getStackTrace(ix));
			}
			throw new MerchantsAtConnectorException("A serious error has occurred.",ix);
		}
				
		return docIds;
	}
	
	/*
	 * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#getProcessingReport(java.lang.String, boolean)
	 */
	public ProcessingReport getProcessingReport(
		BatchReferenceIdentifier referenceId,
		boolean isFlatFile) throws MerchantsAtConnectorException
	{
		Validate.notNull(referenceId);

		DocumentProcessingInfo result = null;
		
		try
		{
			result = merchantInterface.getDocumentProcessingStatus(merchant,referenceId.getId());
		}
		catch (AxisFault soex)
		{
			if (log.isDebugEnabled())
			{			
				log.debug(ExceptionUtils.getStackTrace(soex));
			}
			ErrorMapper.instance().handleException(soex);
		}
		catch (Exception ix)
		{
			if (log.isDebugEnabled())
			{			
				log.debug(ExceptionUtils.getStackTrace(ix));
			}
			throw new MerchantsAtConnectorException("A serious error has occurred.",ix);
		}
		
		FeedStatusEnum status = null;

		if (result != null)
		{
			status = FeedStatusEnum.getEnum(result.getDocumentProcessingStatus());
		}
		
		if (!FeedStatusEnum.DONE.equals(status))
		{
			return new ProcessingReport(status, referenceId);
		}
		
		MerchantDocumentInfo procInfo = result.getProcessingReport();
				
		if (procInfo==null || procInfo.getDocumentID()==null || procInfo.getDocumentID().length()<=0)
		{
			throw new MerchantsAtConnectorException("Amazon did not provide a valid document id for this processing report");
		}
		
		MerchantReport md = this.getDocument(new DocumentIdentifier(procInfo.getDocumentID()));
		ProcessingReport processingReport = new ProcessingReport(md,status,referenceId);
		processingReport.setFlatFile(isFlatFile);
		processingReport.setEnvironment(credentials.getEnvironmentName());

		return processingReport;
	}

	/*
	 * @see com.amazon.merchants.transport.adapter.MerchantsAtConnector#acknowledgeDocumentDownload(com.amazon.merchants.transport.model.DocumentIdentifier[])
	 */
	public boolean acknowledgeDocumentDownload(MerchantReport[] reports)
		throws MerchantsAtConnectorException
	{
		Validate.notNull(reports);
		boolean success=true;
		
		try
		{
			// Using a hashmap as cannot guarantee amazon will return the array in order
			HashMap docsToAck = new HashMap();
			for(int i=0;i<reports.length;i++)
			{
				// Careful - sometimes there is no document
				if (reports[i].getDocumentId() != null)
				{
					docsToAck.put(reports[i].getDocumentId().getId(),reports[i]);
				}
			}
			
			if (docsToAck.size()>0)
			{
				ArrayOfstring strArray = new ArrayOfstring();
				strArray.setString((String[])docsToAck.keySet().toArray(new String[0]));
				ArrayOfDocumentDownloadAckStatus statusArray = merchantInterface.postDocumentDownloadAck(merchant,strArray);
				ArrayList failedDocuments = new ArrayList();
				for(int i=0;i<statusArray.getDocumentDownloadAckStatus().length;i++)
				{
					DocumentDownloadAckStatus status = statusArray.getDocumentDownloadAckStatus(i);
					String statusCode = status.getDocumentDownloadAckProcessingStatus();
					String docId = status.getDocumentID();
					MerchantReport report = (MerchantReport)docsToAck.get(docId);
					if (report != null)
					{
						report.setAcknowledgementStatus(AmazonSoapReturnCodeEnum.getEnum(statusCode));
					}
					
					if (!AmazonSoapReturnCodeEnum.getEnum(statusCode).equals(AmazonSoapReturnCodeEnum.SUCCESSFUL))
					{
						success=false;
					}
				}
			}
		}
		catch (AxisFault soex)
		{
			if (log.isDebugEnabled())
			{			
				log.debug(ExceptionUtils.getStackTrace(soex));
			}
			ErrorMapper.instance().handleException(soex);
		}
		catch (Exception ix)
		{
			if (log.isDebugEnabled())
			{			
				log.debug(ExceptionUtils.getStackTrace(ix));
			}
			throw new MerchantsAtConnectorException("A serious error has occurred.",ix);
		}
		return success;
	}
}