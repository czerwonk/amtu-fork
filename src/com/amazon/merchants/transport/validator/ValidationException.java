/*
 * Created on Apr 28, 2004
 *
 */
package com.amazon.merchants.transport.validator;

import com.amazon.merchants.MerchantsException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class ValidationException extends MerchantsException
{
	private int lineNumber;
	private int columnNumber;
	
	/**
	 * 
	 */
	public ValidationException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public ValidationException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public ValidationException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public ValidationException(String exceptionText, Throwable rootException)
	{
		super(exceptionText, rootException);
	}
	
	public ValidationException(String message, int lineNumber, int columnNumber)
	{
		this(message);
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
	}

	public ValidationException(String message, int lineNumber, int columnNumber, Throwable rootException)
	{
		this(message,rootException);
		this.lineNumber = lineNumber;
		this.columnNumber = columnNumber;
	}	
}
