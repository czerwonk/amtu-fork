/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class ReportTypeEnum extends MerchantDocumentEnum implements Serializable
{
	public static final ReportTypeEnum ORDER_REPORT = new ReportTypeEnum("ORDER","_GET_ORDERS_DATA_","_GET_FLAT_FILE_ORDERS_DATA_");
	public static final ReportTypeEnum SETTLEMENT_REPORT = new ReportTypeEnum("SETTLEMENT","_GET_PAYMENT_SETTLEMENT_DATA_","_GET_FLAT_FILE_PAYMENT_SETTLEMENT_DATA_");
	public static final ReportTypeEnum PROCESSING_REPORT = new ReportTypeEnum("PROCESSING");

	/**
	 * Enum made private - users should not create their own
	 */
	private ReportTypeEnum(String name)
	{
		super(name);
	}
	
	private ReportTypeEnum(String name, String xmlCode, String flatFileCode)
	{
		super(name);
		this.xmlCode = xmlCode;
		this.flatFileCode = flatFileCode;
	}

	private ReportTypeEnum(String name, String xmlCode)
	{
		this(name,xmlCode,null);
	}

	public static ReportTypeEnum getEnum(String reportType) {
	  return (ReportTypeEnum) getEnum(ReportTypeEnum.class, reportType);
	}
 
	public static Map getEnumMap() {
	  return getEnumMap(ReportTypeEnum.class);
	}
 
	public static List getEnumList() {
	  return getEnumList(ReportTypeEnum.class);
	}
 
	public static Iterator iterator() {
	  return iterator(ReportTypeEnum.class);
	}
}
