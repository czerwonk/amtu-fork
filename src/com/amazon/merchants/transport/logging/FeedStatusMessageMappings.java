/*
 * Created on Apr 13, 2004
 *
 */
package com.amazon.merchants.transport.logging;

import java.util.ListResourceBundle;

import com.amazon.merchants.transport.model.FeedStatusEnum;;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class FeedStatusMessageMappings extends ListResourceBundle
{
	private static final FeedStatusMessageMappings _instance = new FeedStatusMessageMappings();
	/*
	 * @see java.util.ListResourceBundle#getContents()
	 */
	protected Object[][] getContents()
	{
		return contents;
	}
	
	public static FeedStatusMessageMappings instance()
	{
		return _instance;
	}
	
	static final Object[][] contents = 
	{
	  // Feed Status
	  {FeedStatusEnum.DONE.getName(),"Feed file {0} processing completed. Batch reference {1}."},
	  {FeedStatusEnum.FATAL_ERROR.getName(),"Feed file {0} had a fatal error on Amazon. Please contact Amazon for more information and quote batch reference {1}."},
	  {FeedStatusEnum.PENDING.getName(),"Feed file {0} is pending on Amazon. Please contact Amazon for more information and quote batch reference {1}."},
	  {FeedStatusEnum.IN_PROGRESS.getName(),"Feed file {0} is currently processing on Amazon, batch reference is {1}."},
	  {FeedStatusEnum.POSTED.getName(),"Feed file {0} has been posted.  Reference id from Amazon is {1}."},
	  {FeedStatusEnum.FAILED.getName(),"Feed file {0} has failed to process for the following reason: {1}."}
	};	  
}


