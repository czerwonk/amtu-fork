/*
 * Created on May 19, 2004
 *
 */
package com.amazon.merchants.util.interaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang.Validate;


/**
 * Copyright 2004 Amazon.com
 * 
 * Description: This utility should use enums to make it more robust.
 * 
 * @author hynoskij
 *
 */
public class InputValidator
{
	public static void validate(String input, InputTypeEnum type) throws InvalidDataException
	{
		Validate.notNull(input);
		Validate.notNull(type);
		
		if (!input.matches(type.getPattern()))
		{
			throw new InvalidDataException(type.getMessage());
		}
		
		if (type.isExistCheck())
		{
			validateExistence(input,type);
		}
	}

	private static void validateExistence(String input, InputTypeEnum type) throws InvalidDataException
	{
		Validate.notNull(input);
		Validate.notNull(type);
		
		if (type.equals(InputTypeEnum.FILE) || type.equals(InputTypeEnum.DIRECTORY))
		{
			File file = new File(input);
			if (!file.exists())
			{
				throw new InvalidDataException(type.getMessage(), new FileNotFoundException(type.getMessage()));
			}
			
			if (type.equals(InputTypeEnum.DIRECTORY) && !file.isDirectory())
			{
				throw new InvalidDataException("Value is not a directory, and no directory can be created.");
			}
		}
		else if(type.equals(InputTypeEnum.DOMAIN))
		{
			InetSocketAddress address = new InetSocketAddress(input,25);
			if (address.isUnresolved())
			{
				throw new InvalidDataException("Could not resolve domain name "+input+" to an address. The value may be invalid or there may be no domain name service available.");
			}
		}		
		else if(type.equals(InputTypeEnum.URL))
		{
			try
			{
				URL address = new URL(input);
				validateExistence(address.getHost(),InputTypeEnum.DOMAIN);
			}
			catch(MalformedURLException mex)
			{
				throw new InvalidDataException("Invalid url format. URL should be of the form http://my.domain.com:optional_port/path");
			}			
		}		
	}
	
	public static void main(String [] args) throws Exception
	{
		//validate("north19.com",InputTypeEnum.DOMAIN);
		//validate("",InputTypeEnum.STRING);
		//validate("http://www.north19.com",InputTypeEnum.URL);
		validate("ME@me-fish.co-m",InputTypeEnum.EMAIL);		
	}
}
