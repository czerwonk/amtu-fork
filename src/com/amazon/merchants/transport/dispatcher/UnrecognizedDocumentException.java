/*
 * Created on Apr 26, 2004
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
public class UnrecognizedDocumentException extends DispatcherServiceException
{
	/**
	 * @param exceptionText
	 */
	public UnrecognizedDocumentException(String exceptionText)
	{
		super(exceptionText);
	}

	/**
	 * @param rootException
	 */
	public UnrecognizedDocumentException(Throwable rootException)
	{
		super(rootException);
	}

	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public UnrecognizedDocumentException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}

	/**
	 * 
	 */
	public UnrecognizedDocumentException()
	{
		super();
	}
}
