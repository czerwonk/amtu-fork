/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher;

import com.amazon.merchants.MerchantsException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class DispatcherServiceException extends MerchantsException
{
	/**
	 * 
	 */
	public DispatcherServiceException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public DispatcherServiceException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public DispatcherServiceException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public DispatcherServiceException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
