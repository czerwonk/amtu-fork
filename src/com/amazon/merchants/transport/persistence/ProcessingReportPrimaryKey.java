/*
 * Created on May 3, 2004
 *
 */
package com.amazon.merchants.transport.persistence;

import com.amazon.merchants.dao.DAOKey;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class ProcessingReportPrimaryKey extends DAOKey
{
	long id;
	
	public ProcessingReportPrimaryKey(long id)
	{
		this.id=id;
	}
	
	/**
	 * @return
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param l
	 */
	public void setId(long l)
	{
		id = l;
	}

}
