/*
 * Created on Apr 17, 2004
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
public class MerchantReport extends MerchantDocument
{
	private DocumentIdentifier documentId;
	private Date downloadDate;
	private AmazonSoapReturnCodeEnum acknowledgementStatus;

	/**
	 * 
	 */
	public MerchantReport()
	{
		super();
	}

	/**
	 * @return
	 */
	public DocumentIdentifier getDocumentId()
	{
		return documentId;
	}

	/**
	 * @return
	 */
	public Date getDownloadDate()
	{
		return downloadDate;
	}

	/**
	 * @param identifier
	 */
	public void setDocumentId(DocumentIdentifier identifier)
	{
		documentId = identifier;
	}

	/**
	 * @param date
	 */
	public void setDownloadDate(Date date)
	{
		downloadDate = date;
	}

	/**
	 * @return
	 */
	public AmazonSoapReturnCodeEnum getAcknowledgementStatus()
	{
		return acknowledgementStatus;
	}

	/**
	 * @param enum
	 */
	public void setAcknowledgementStatus(AmazonSoapReturnCodeEnum enum)
	{
		acknowledgementStatus = enum;
	}

}
