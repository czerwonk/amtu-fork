/*
 * Created on May 3, 2004
 *
 */
package com.amazon.merchants.dao;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class NoRecordsFoundException extends DAOException
{
	/**
	 * 
	 */
	public NoRecordsFoundException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public NoRecordsFoundException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public NoRecordsFoundException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public NoRecordsFoundException(
		String exceptionText,
		Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
