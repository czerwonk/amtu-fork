/*
 * Created on Apr 13, 2004
 *
 */
package com.amazon.merchants.transport.adapter.util;

import java.util.ListResourceBundle;

import com.amazon.merchants.transport.model.AmazonSoapReturnCodeEnum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class ErrorMessageMappings extends ListResourceBundle
{
	private static final ErrorMessageMappings _instance = new ErrorMessageMappings();
	/*
	 * @see java.util.ListResourceBundle#getContents()
	 */
	protected Object[][] getContents()
	{
		return contents;
	}
	
	public static ErrorMessageMappings instance()
	{
		return _instance;
	}
	
	static final Object[][] contents = 
	{
	  // Soap Faults
		  {AmazonSoapReturnCodeEnum.DOCUMENT_NOT_ACCESSIBLE.getName(), "Document is either not available or inaccessible to this user."},
		  {AmazonSoapReturnCodeEnum.INVALID_TOKEN.getName(), "Merchant identifier token is not recognized or is blocked from posting to Amazon."},
		  {AmazonSoapReturnCodeEnum.UNRECOGNIZED_MERCHANT.getName(), "The credentials and/or identifier token supplied are incorrect or not authorized to access the server specified."},
		  {AmazonSoapReturnCodeEnum.MISSING_DATA.getName(), "The document to be posted is either missing/blank or the soap message contains invalid data."},
		  {AmazonSoapReturnCodeEnum.INVALID_MESSAGE_TYPE.getName(), "Invalid message type specified."},
		  {AmazonSoapReturnCodeEnum.INTERNAL_ERROR.getName(), "An internal error has occurred on the Amazon server."},
		  {AmazonSoapReturnCodeEnum.DOCUMENT_NO_LONGER_AVAILABLE.getName(), "The document requested is too old and has been removed from the server."},
		  {AmazonSoapReturnCodeEnum.INVALID_REFERENCE_IDENTIFIER.getName(), "The reference identifier queried is invalid or does not exist on the Amazon server."},
		  {AmazonSoapReturnCodeEnum.OTHER.getName(),"The Amazon server has reported an error. The text of this error is: {0}."}
	};	  
}
