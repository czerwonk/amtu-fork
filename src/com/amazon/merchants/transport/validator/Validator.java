/*
 * Created on Apr 28, 2004
 *
 */
package com.amazon.merchants.transport.validator;

import com.amazon.merchants.transport.model.MerchantFeed;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public interface Validator
{
	public void validate(MerchantFeed feed) throws ValidationException;
}
