/*
 * Created on Apr 12, 2004
 *
 */
package com.amazon.merchants.transport.model;

import java.io.Serializable;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class DocumentIdentifier implements Serializable
{
	private String id;
	private AmazonSoapReturnCodeEnum acknowledgementStatus;
	
	public DocumentIdentifier(){}
	public DocumentIdentifier(String id)
	{
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param string
	 */
	public void setId(String string)
	{
		id = string;
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
