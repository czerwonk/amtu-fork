/*
 * Created on May 4, 2004
 *
 */
package com.amazon.merchants.transport.persistence;

import com.amazon.merchants.MerchantsException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class PersistenceException extends MerchantsException
{
	/**
	 * 
	 */
	public PersistenceException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public PersistenceException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public PersistenceException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public PersistenceException(String exceptionText, Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
