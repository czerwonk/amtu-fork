/*
 * Created on May 6, 2004
 *
 */
package com.amazon.merchants.transport.retriever;

import com.amazon.merchants.MerchantsException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class RetrieverException extends MerchantsException
{
	/**
	 * 
	 */
	public RetrieverException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public RetrieverException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public RetrieverException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public RetrieverException(String exceptionText, Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
