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
public interface Preprocessor
{
	MerchantFeed [] process(MerchantFeed [] feed);
}
