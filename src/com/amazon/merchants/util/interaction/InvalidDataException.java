/*
 * Created on May 19, 2004
 *
 */
package com.amazon.merchants.util.interaction;

import com.amazon.merchants.MerchantsException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class InvalidDataException extends MerchantsException
{
	/**
	 * 
	 */
	public InvalidDataException()
	{
		super();
	}
	/**
	 * @param message
	 */
	public InvalidDataException(String message)
	{
		super(message);
	}
	/**
	 * @param cause
	 */
	public InvalidDataException(Throwable cause)
	{
		super(cause);
	}
	/**
	 * @param message
	 * @param cause
	 */
	public InvalidDataException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
