/*
 * Created on May 9, 2004
 *
 */
package com.amazon.merchants.transport.preferences;

import com.amazon.merchants.MerchantsException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class PreferencesException extends MerchantsException
{
	/**
	 * 
	 */
	public PreferencesException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public PreferencesException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public PreferencesException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public PreferencesException(String exceptionText, Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
