/*
 * Created on Apr 21, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher;

import com.amazon.merchants.transport.TransportConstants;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public interface DispatcherConstants
{
	public static final String [] ACCEPTED_FILE_TYPES 
					= new String[]{
						TransportConstants.FLAT_FILE_SUFFIX,
						TransportConstants.XML_FILE_SUFFIX};
	
						
}