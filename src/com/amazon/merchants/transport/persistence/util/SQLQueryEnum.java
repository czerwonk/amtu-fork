/*
 * Created on Apr 30, 2004
 *
 */
package com.amazon.merchants.transport.persistence.util;

import org.apache.commons.lang.enum.Enum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description: Rigid constants for sql queries
 * 
 * @author hynoskij
 *
 */
public class SQLQueryEnum extends Enum
{
	public static final SQLQueryEnum FEED_INSERT = new SQLQueryEnum("FEED_INSERT");
	public static final SQLQueryEnum FEED_UPDATE = new SQLQueryEnum("FEED_UPDATE");
	public static final SQLQueryEnum FEED_DELETE = new SQLQueryEnum("FEED_DELETE");

	public static final SQLQueryEnum REPORT_INSERT = new SQLQueryEnum("REPORT_INSERT");
	public static final SQLQueryEnum REPORT_UPDATE = new SQLQueryEnum("REPORT_UPDATE");
	public static final SQLQueryEnum REPORT_DELETE = new SQLQueryEnum("REPORT_DELETE");
	
	public static final SQLQueryEnum PROCESSING_REPORT_INSERT = new SQLQueryEnum("PROCESSING_REPORT_INSERT");
	public static final SQLQueryEnum PROCESSING_REPORT_UPDATE = new SQLQueryEnum("PROCESSING_REPORT_UPDATE");
	public static final SQLQueryEnum PROCESSING_REPORT_DELETE = new SQLQueryEnum("PROCESSING_REPORT_DELETE");

	public static final SQLQueryEnum FEED_GETBYID = new SQLQueryEnum("FEED_GETBYID");
	public static final SQLQueryEnum FEED_GETBYBATCHREF = new SQLQueryEnum("FEED_GETBYBATCHREF");
	public static final SQLQueryEnum REPORT_GETBYID = new SQLQueryEnum("REPORT_GETBYID");
	public static final SQLQueryEnum PROCESSING_REPORT_GETBYID = new SQLQueryEnum("PROCESSING_REPORT_GETBYID");
	
	public static final SQLQueryEnum PROCESSING_REPORT_GETBYSTATUSLISTANDENVIRONMENT = new SQLQueryEnum("PROCESSING_REPORT_GETBYSTATUSLISTANDENVIRONMENT"); 
	
	private SQLQueryEnum(String arg0)
	{
		super(arg0);
	}	
}
