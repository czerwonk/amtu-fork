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
public class InvalidTokenException extends MerchantsAtConnectorException
{
	/**
	 * 
	 */
	public InvalidTokenException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public InvalidTokenException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public InvalidTokenException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public InvalidTokenException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
