/*
 * Created on Apr 13,"com.amazon.merchants.transport.adapter.2004
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
public class ErrorExceptionMappings extends ListResourceBundle
{
	private static final ErrorExceptionMappings _instance = new ErrorExceptionMappings();
	/*
	 * @see java.util.ListResourceBundle#getContents()
	 */
	protected Object[][] getContents()
	{
		return contents;
	}
	
	public static ErrorExceptionMappings instance()
	{
		return _instance;
	}
	
	static final Object[][] contents = 
	{
	  // Soap Faults
		  {AmazonSoapReturnCodeEnum.DOCUMENT_NOT_ACCESSIBLE.getName(),"com.amazon.merchants.transport.adapter.DocumentNotAccessibleException"},
		  {AmazonSoapReturnCodeEnum.INVALID_TOKEN.getName(),"com.amazon.merchants.transport.adapter.InvalidTokenException"},
		  {AmazonSoapReturnCodeEnum.UNRECOGNIZED_MERCHANT.getName(),"com.amazon.merchants.transport.adapter.UnrecognizedMerchantException"},
		  {AmazonSoapReturnCodeEnum.MISSING_DATA.getName(),"com.amazon.merchants.transport.adapter.MissingOrInvalidDataException"},
		  {AmazonSoapReturnCodeEnum.INVALID_MESSAGE_TYPE.getName(),"com.amazon.merchants.transport.adapter.InvalidMessageTypeException"},
		  {AmazonSoapReturnCodeEnum.INTERNAL_ERROR.getName(),"com.amazon.merchants.transport.adapter.AmazonInternalErrorException"},
		  {AmazonSoapReturnCodeEnum.DOCUMENT_NO_LONGER_AVAILABLE.getName(),"com.amazon.merchants.transport.adapter.DocumentNoLongerAvailableException"},
		  {AmazonSoapReturnCodeEnum.INVALID_REFERENCE_IDENTIFIER.getName(),"com.amazon.merchants.transport.adapter.InvalidReferenceIdentifierException"},
		  {AmazonSoapReturnCodeEnum.OTHER.getName(),"com.amazon.merchants.transport.adapter.MerchantsAtConnectorException"}
	};	  
}
