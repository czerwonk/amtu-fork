/*
 * Created on Apr 27, 2004
 *
 */
package com.amazon.merchants.dao;

import com.amazon.merchants.MerchantsException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class DAOException extends MerchantsException
{
	/**
	 * 
	 */
	public DAOException()
	{
		super();
	}
	/**
	 * @param exceptionText
	 */
	public DAOException(String exceptionText)
	{
		super(exceptionText);
	}
	/**
	 * @param rootException
	 */
	public DAOException(Throwable rootException)
	{
		super(rootException);
	}
	/**
	 * @param exceptionText
	 * @param rootException
	 */
	public DAOException(String exceptionText, Throwable rootException)
	{
		super(exceptionText, rootException);
	}
}
