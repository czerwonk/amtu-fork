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
public class MerchantFeedPrimaryKey extends DAOKey
{
	String id;
	
	public MerchantFeedPrimaryKey(String id)
	{
		this.id=id;
	}
	
	/**
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param l
	 */
	public void setId(String l)
	{
		id = l;
	}

}
