/*
 * Created on Feb 19, 2004
 *
 */
package com.amazon.merchants;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description: 
 * Clean base for all Amazon Merchants application exceptions.
 * Inherits from chained exception, so exceptions can be easily
 * linked together to allow for root cause passing.
 * 
 * @author hynoskij
 *
 */
public class MerchantsException extends ChainedException
{
	
	/**
	 * Default exception, no message
	 *
	 */
	public MerchantsException()
	{
		super();
	}

	/**
	 * Sets message text for this exception
	 * @param exceptionText
	 */
	public MerchantsException(String exceptionText)
	{
		super(exceptionText);
	}

	/**
	 * Wraps another exception in this one and adds it to the chain
	 * @param rootException
	 */
	public MerchantsException(Throwable rootException)
	{
		super(rootException);
	}

	/**
	 * Sets the text of this exception and adds the root cause to the
	 * chain
	 * 
	 * @param exceptionText
	 * @param rootException
	 */
	public MerchantsException(String exceptionText, Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
