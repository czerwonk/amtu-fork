/*
 * Created on Apr 27, 2004
 *
 */
package com.amazon.merchants.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public abstract class DAOConnection
{
	protected Connection connection = null;

	public DAOConnection() throws DAOException
	{
		init();
	}

	/**
	 * This must be overridden in the implementation 
	 * to set up the database connection
	 */
	protected abstract void init() throws DAOException;

	public Connection getConnection()
	{
		return connection;
	}
	
	public void closeConnection() throws DAOException
	{
		try
		{
			connection.close();
		}
		catch(SQLException sqlex)
		{
			throw new DAOException("Could not close connection.",sqlex);
		}
	}
}
