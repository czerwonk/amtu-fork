/*
 * Created on May 8, 2004
 *
 */
package com.amazon.merchants.transport.model;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public interface Statusable
{
	FeedStatusEnum getStatus();
	void setStatus(FeedStatusEnum status);
}
