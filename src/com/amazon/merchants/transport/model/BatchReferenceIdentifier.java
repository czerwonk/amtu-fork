/*
 * Created on Apr 13, 2004
 *
 */
package com.amazon.merchants.transport.model;

import java.io.Serializable;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class BatchReferenceIdentifier implements Serializable
{
	long id;
	/**
	 * 
	 */
	public BatchReferenceIdentifier(){}
	
	public BatchReferenceIdentifier(long id)
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

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object arg0)
	{
		return (id==((BatchReferenceIdentifier)arg0).getId());
	}

	public String toString()
	{
		return Long.toString(id);
	}
}
