/*
 * Created on Apr 13, 2004
 *
 */
package com.amazon.merchants.transport.adapter;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class DocumentNoLongerAvailableException extends MerchantsAtConnectorException
{
	/**
	 * 
	 */
	public DocumentNoLongerAvailableException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public DocumentNoLongerAvailableException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public DocumentNoLongerAvailableException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public DocumentNoLongerAvailableException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
