/*
 * Created on Apr 22, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class InvalidDocumentException extends DispatcherServiceException
{
	/**
	 * 
	 */
	public InvalidDocumentException()
	{
		super();
	}

	/**
	 * @param exceptionText
	 */
	public InvalidDocumentException(String exceptionText)
	{
		super(exceptionText);
	}

	/**
	 * @param rootException
	 */
	public InvalidDocumentException(Throwable rootException)
	{
		super(rootException);
	}

	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public InvalidDocumentException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}

}
