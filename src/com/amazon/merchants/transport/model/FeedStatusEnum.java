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
public class FeedStatusEnum extends Enum implements Serializable
{
	// Amazon Statuses
	public static final FeedStatusEnum DONE = new FeedStatusEnum("_DONE_");
	public static final FeedStatusEnum FATAL_ERROR = new FeedStatusEnum("_FAILED_DUE_TO_FATAL_ERRORS_");
	public static final FeedStatusEnum PENDING = new FeedStatusEnum("_PENDING_");
	public static final FeedStatusEnum IN_PROGRESS = new FeedStatusEnum("_IN_PROGRESS_");

	// Application Specific Statuses
	public static final FeedStatusEnum POSTED = new FeedStatusEnum("_POSTED_"); // Posted - no processing report yet
	public static final FeedStatusEnum FAILED = new FeedStatusEnum("_FAILED_"); // Failed
	
	/**
	 * Enum made private - users should not create their own
	 */
	private FeedStatusEnum(String arg0)
	{
		super(arg0);
	}
	
	public static FeedStatusEnum getEnum(String status) {
	  return (FeedStatusEnum) getEnum(FeedStatusEnum.class, status); 
	}
 
	public static Map getEnumMap() {
	  return getEnumMap(FeedStatusEnum.class);
	}
 
	public static List getEnumList() {
	  return getEnumList(FeedStatusEnum.class);
	}
 
	public static Iterator iterator() {
	  return iterator(FeedStatusEnum.class);
	}
}
