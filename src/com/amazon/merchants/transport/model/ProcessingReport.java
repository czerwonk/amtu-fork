/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.model;

import java.util.Date;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class ProcessingReport extends MerchantReport implements Statusable
{
	private BatchReferenceIdentifier batchReference;
	private FeedStatusEnum status;
	private String feedId;
	private Date timeSubmitted;
	private Date lastPollAttempt;
	
	/**
	 * 
	 */
	public ProcessingReport()
	{
		super();
		this.setDocumentType(ReportTypeEnum.PROCESSING_REPORT);
	}

	public ProcessingReport(MerchantReport doc,FeedStatusEnum status,BatchReferenceIdentifier batchRef)
	{
		this(status,batchRef);
		setReportDetails(doc);
	}
	
	public ProcessingReport(FeedStatusEnum status, BatchReferenceIdentifier batchRef)
	{
		this();
		this.setStatus(status);
		this.setBatchReference(batchRef);
	}

	public void setReportDetails(MerchantReport doc)
	{
		if (doc!=null)
		{
			this.setDocumentId(doc.getDocumentId());
			this.setDocument(doc.getDocument());
			this.setDownloadDate(doc.getDownloadDate());
		}
	}

	/**
	 * @return
	 */
	public FeedStatusEnum getStatus()
	{
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(FeedStatusEnum status)
	{
		this.status = status;
	}

	/**
	 * @return
	 */
	public BatchReferenceIdentifier getBatchReference()
	{
		return batchReference;
	}

	/**
	 * @param identifier
	 */
	public void setBatchReference(BatchReferenceIdentifier identifier)
	{
		batchReference = identifier;
	}

	/**
	 * @return
	 */
	public String getFeedId()
	{
		return feedId;
	}

	/**
	 * @param string
	 */
	public void setFeedId(String string)
	{
		feedId = string;
	}

	/**
	 * @return
	 */
	public Date getLastPollAttempt()
	{
		return lastPollAttempt;
	}

	/**
	 * @param date
	 */
	public void setLastPollAttempt(Date date)
	{
		lastPollAttempt = date;
	}

	/**
	 * @return
	 */
	public Date getTimeSubmitted()
	{
		return timeSubmitted;
	}

	/**
	 * @param date
	 */
	public void setTimeSubmitted(Date date)
	{
		timeSubmitted = date;
	}

}
