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
public class DocumentNotAccessibleException extends MerchantsAtConnectorException
{
	/**
	 * 
	 */
	public DocumentNotAccessibleException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public DocumentNotAccessibleException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public DocumentNotAccessibleException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public DocumentNotAccessibleException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
