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
public class InvalidMessageTypeException extends MerchantsAtConnectorException
{
	/**
	 * 
	 */
	public InvalidMessageTypeException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public InvalidMessageTypeException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public InvalidMessageTypeException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public InvalidMessageTypeException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
