/*
 * Created on Apr 28, 2004
 *
 */
package com.amazon.merchants.transport.validator.impl;

import com.amazon.merchants.transport.model.MerchantFeed;
import com.amazon.merchants.transport.validator.ValidationException;
import com.amazon.merchants.transport.validator.Validator;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class FlatFileValidator implements Validator
{
	/**
	 * 
	 */
	public FlatFileValidator()
	{
		super();
	}
	/*
	 * @see com.amazon.merchants.transport.validator.Validator#validate(com.amazon.merchants.transport.model.MerchantFeed)
	 */
	public void validate(MerchantFeed feed) throws ValidationException
	{
	}
}
