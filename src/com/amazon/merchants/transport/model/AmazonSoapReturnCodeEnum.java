/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.enum.Enum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class AmazonSoapReturnCodeEnum extends Enum implements Serializable
{
	public static final AmazonSoapReturnCodeEnum DOCUMENT_NOT_ACCESSIBLE = new AmazonSoapReturnCodeEnum("_ACCESS_TO_DOCUMENT_DENIED_");
	public static final AmazonSoapReturnCodeEnum INVALID_TOKEN = new AmazonSoapReturnCodeEnum("_INVALID_API_");
	public static final AmazonSoapReturnCodeEnum UNRECOGNIZED_MERCHANT = new AmazonSoapReturnCodeEnum("_UNRECOGNIZED_MERCHANT_");
	public static final AmazonSoapReturnCodeEnum MISSING_DATA = new AmazonSoapReturnCodeEnum("_MISSING_OR_INVALID_DATA_");
	public static final AmazonSoapReturnCodeEnum INVALID_MESSAGE_TYPE = new AmazonSoapReturnCodeEnum("_INVALID_MESSAGE_TYPE_");
	public static final AmazonSoapReturnCodeEnum INTERNAL_ERROR = new AmazonSoapReturnCodeEnum("_INTERNAL_ERROR_");
	public static final AmazonSoapReturnCodeEnum DOCUMENT_NO_LONGER_AVAILABLE = new AmazonSoapReturnCodeEnum("_DOCUMENT_NO_LONGER_AVAILABLE_");
	public static final AmazonSoapReturnCodeEnum INVALID_REFERENCE_IDENTIFIER = new AmazonSoapReturnCodeEnum("_INVALID_DOCUMENT_TRANSACTION_IDENTIFIER_");
	public static final AmazonSoapReturnCodeEnum SUCCESSFUL = new AmazonSoapReturnCodeEnum("_SUCCESSFUL_");
	public static final AmazonSoapReturnCodeEnum OTHER = new AmazonSoapReturnCodeEnum("Unknown Error");
	
	/**
	 * Enum made private - users should not create their own
	 */
	private AmazonSoapReturnCodeEnum(String arg0)
	{
		super(arg0);
	}
	
	public static AmazonSoapReturnCodeEnum getEnum(String code) {
	  AmazonSoapReturnCodeEnum enum = (AmazonSoapReturnCodeEnum) getEnum(AmazonSoapReturnCodeEnum.class, code); 
	  return enum==null?OTHER:enum;
	}
 
	public static Map getEnumMap() {
	  return getEnumMap(AmazonSoapReturnCodeEnum.class);
	}
 
	public static List getEnumList() {
	  return getEnumList(AmazonSoapReturnCodeEnum.class);
	}
 
	public static Iterator iterator() {
	  return iterator(AmazonSoapReturnCodeEnum.class);
	}
}
