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
public class InvalidReferenceIdentifierException extends MerchantsAtConnectorException
{
	/**
	 * 
	 */
	public InvalidReferenceIdentifierException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public InvalidReferenceIdentifierException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public InvalidReferenceIdentifierException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public InvalidReferenceIdentifierException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
