/*
 * Created on Apr 26, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher;

import com.amazon.merchants.transport.model.MerchantFeed;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public abstract class MerchantFeedProcessor
{
	boolean batching;
	
	public abstract void init();
	public abstract void process(MerchantFeed doc);
	public abstract MerchantFeed [] finish();

	/**
	 * @return
	 */
	public boolean isBatching()
	{
		return batching;
	}

	/**
	 * @param b
	 */
	void setBatching(boolean b)
	{
		batching = b;
	}

}
