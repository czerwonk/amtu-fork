/*
 * Created on Apr 28, 2004
 *
 */
package com.amazon.merchants.transport.validator;

import java.util.HashMap;

import org.apache.commons.lang.Validate;

import com.amazon.merchants.transport.model.MerchantFeed;
import com.amazon.merchants.util.file.FileUtil;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class ValidatorFactory
{
	private static final ValidatorFactory _instance = new ValidatorFactory();
	private HashMap validators = new HashMap();

	private ValidatorFactory(){}
	public static ValidatorFactory instance()
	{
		return _instance;
	}
	
	public void addValidator(String fileSuffix,Validator validator)
	{
		validators.put(fileSuffix.toLowerCase(),validator);
	}
	
	/*
	 * Tries to get a validator for the file. 
	 * 
	 */
	public Validator getValidator(String filename)
	{
		Validate.notNull(filename);
		String fileSuffix = FileUtil.getExtension(filename.toLowerCase());
		Validator vReturn = (Validator) validators.get(fileSuffix);
		return vReturn==null?new DefaultValidator():vReturn;
	}

	/**
	 * This is a do-nothing validator if nothing else is returned
	 */	
	private class DefaultValidator implements Validator
	{
		public void validate(MerchantFeed feed) throws ValidationException {}
	}	
}
