/*
 * Created on Feb 19, 2004
 *
 */
package com.amazon.merchants;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description: Allows for an exception to wrap other exceptions
 * 
 * @author hynoskij
 *
 */
public class ChainedException extends Exception
{
	private Throwable chain;
	/**
	 * 
	 */
	public ChainedException()
	{
		super();
	}
	/**
	 * @param arg0
	 */
	public ChainedException(String arg0)
	{
		super(arg0);
	}
	/**
	 * @param arg0
	 */
	public ChainedException(Throwable arg0)
	{
		super(arg0);
		this.chain = arg0;
	}
	/**
	 * @param arg0
	 * @param arg1
	 */
	public ChainedException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
		this.chain=arg1;
	}
	
	
	
	/*
	 * @see java.lang.Throwable#printStackTrace()
	 */
	public void printStackTrace()
	{
		super.printStackTrace();
		if (chain != null)
		{
			chain.printStackTrace();
		}
	}

	/*
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	public void printStackTrace(PrintStream arg0)
	{
		super.printStackTrace(arg0);
		if (chain != null)
		{
			chain.printStackTrace(arg0);
		}
	}

	/*
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	public void printStackTrace(PrintWriter arg0)
	{
		super.printStackTrace(arg0);
		if (chain != null)
		{
			chain.printStackTrace(arg0);
		}
	}
	
	public String getMessage()
	{
		return super.getMessage();
	}
	
	/*
	 * Chain traversing function - gets to the bottom of an exception chain
	 */
	public String getRootCauseMessage()
	{

		if (chain == null || !(chain instanceof ChainedException))
		{
			return this.getMessage();
		}
		else if (!(chain instanceof ChainedException))
		{
			return chain.getMessage();
		}
		else
		{
			return ((ChainedException)chain).getRootCauseMessage();
		}
	}
	
	/*
	 * Chain traversing function - gets to the bottom of an exception chain
	 */
	public Throwable getRootCauseException()
	{
		if (chain == null)
		{
			return this;
		}
		else if (!(chain instanceof ChainedException))
		{
			return chain;
		}
		else
		{
			return ((ChainedException)chain).getRootCauseException();
		}
	}
}
