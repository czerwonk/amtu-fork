/*
 * Created on May 9, 2004
 *
 */
package com.amazon.merchants.transport;

import org.apache.commons.lang.enum.Enum;

import com.amazon.merchants.transport.model.ReportTypeEnum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class TransportOperationEnum extends Enum
{
	public static final TransportOperationEnum DISPATCH_ALL=new TransportOperationEnum("DISPATCH_ALL");
	public static final TransportOperationEnum GET_SETTLEMENTS=new TransportOperationEnum(ReportTypeEnum.SETTLEMENT_REPORT.getName());
	public static final TransportOperationEnum GET_ORDERS=new TransportOperationEnum(ReportTypeEnum.ORDER_REPORT.getName());
	public static final TransportOperationEnum GET_PROCESSING_REPORTS=new TransportOperationEnum(ReportTypeEnum.PROCESSING_REPORT.getName());

	/**
	 * @param arg0
	 */
	public TransportOperationEnum(String arg0)
	{
		super(arg0);
	}
}
