/*
 * Created on Apr 26, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazon.merchants.transport.dispatcher.MerchantFeedProcessor;
import com.amazon.merchants.transport.dispatcher.Preprocessor;
import com.amazon.merchants.transport.model.MerchantFeed;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class PreprocessorImpl implements Preprocessor
{
	private static final Preprocessor _instance = new PreprocessorImpl();
	private static final Log log = LogFactory.getLog(Preprocessor.class);

	private ArrayList preprocessors = new ArrayList();
	
	public static final Preprocessor instance()
	{
		return _instance;
	}
	
	public MerchantFeed[] process(MerchantFeed[] feeds)
	{
		for (Iterator p=preprocessors.iterator();p.hasNext();)
		{
			MerchantFeedProcessor processor = (MerchantFeedProcessor)p;
			processor.init();
			for (int i=0;i<feeds.length;i++)
			{
				processor.process(feeds[i]);
			}

			if (processor.isBatching())
			{
				feeds = processor.finish();
			}
		}
		return feeds;
	}
	
	public void addPreprocessor(MerchantFeedProcessor processor)
	{
		preprocessors.add(processor);
	}
	
	public void clearPreprocessors()
	{
		preprocessors.clear();
	}
}
