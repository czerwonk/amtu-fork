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
public class UnrecognizedMerchantException extends MerchantsAtConnectorException
{
	/**
	 * 
	 */
	public UnrecognizedMerchantException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public UnrecognizedMerchantException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public UnrecognizedMerchantException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public UnrecognizedMerchantException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
