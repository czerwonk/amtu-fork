/*
 * Created on Apr 24, 2004
 *
 */
package com.amazon.merchants.transport.model;

import org.apache.commons.lang.enum.Enum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class MerchantDocumentEnum extends Enum
{
	String xmlCode;
	String flatFileCode;
	
	public MerchantDocumentEnum(String arg0)
	{
		super(arg0);
	}
	
	public String getFlatFileCode()
	{
		return flatFileCode;
	}
	
	public String getXmlCode()
	{
		return xmlCode;
	}

}
