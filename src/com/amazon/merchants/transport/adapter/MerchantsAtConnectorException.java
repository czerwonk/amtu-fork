/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.adapter;

import com.amazon.merchants.MerchantsException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class MerchantsAtConnectorException extends MerchantsException
{
	/**
	 * 
	 */
	public MerchantsAtConnectorException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public MerchantsAtConnectorException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public MerchantsAtConnectorException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public MerchantsAtConnectorException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
