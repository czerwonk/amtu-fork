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
public class MissingOrInvalidDataException extends MerchantsAtConnectorException
{
	/**
	 * 
	 */
	public MissingOrInvalidDataException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public MissingOrInvalidDataException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public MissingOrInvalidDataException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public MissingOrInvalidDataException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
