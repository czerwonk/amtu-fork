/*
 * Created on Apr 19, 2004
 *
 */
package com.amazon.merchants.transport.retriever;

import com.amazon.merchants.transport.retriever.impl.RetrieverServiceImpl;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class RetrieverFactory
{
	private static final RetrieverFactory _instance = new RetrieverFactory();
	private RetrieverFactory(){}

	public static RetrieverFactory instance()
	{
		return _instance;
	}
	
	public RetrieverService getRetrieverService()
	{
		return RetrieverServiceImpl.instance();
	}
}
