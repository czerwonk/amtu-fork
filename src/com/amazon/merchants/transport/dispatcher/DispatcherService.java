/*
 * Created on Apr 18, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher;

import java.io.File;

import com.amazon.merchants.transport.model.MerchantAccount;
import com.amazon.merchants.transport.model.MerchantFeed;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public interface DispatcherService
{
	MerchantFeed [] dispatch(File fileOrDirectory,MerchantAccount account) throws DispatcherServiceException;
}
