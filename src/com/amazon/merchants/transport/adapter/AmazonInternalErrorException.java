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
public class AmazonInternalErrorException extends MerchantsAtConnectorException
{
	/**
	 * 
	 */
	public AmazonInternalErrorException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public AmazonInternalErrorException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public AmazonInternalErrorException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public AmazonInternalErrorException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
