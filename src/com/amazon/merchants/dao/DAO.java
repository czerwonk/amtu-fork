/*
 * Created on Apr 27, 2004
 *
 */
package com.amazon.merchants.dao;

import java.sql.SQLException;

import com.amazon.merchants.transport.persistence.TransportDAOConnectionFactory;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public abstract class DAO
{
	private DAOConnection daoConnection;
	protected boolean transactionOwner;

	public DAO(){}
	
	public DAO(DAOConnection con)
	{
		this.daoConnection = con;
	}
	
	public abstract Object get(DAOKey id) throws DAOException;
	public abstract void create(Object theObject) throws DAOException;
	public abstract void update(Object theObject) throws DAOException;
	public abstract void delete(DAOKey id) throws DAOException;

	protected DAOConnection getDAOConnection() throws DAOException
	{
		try
		{
			if(daoConnection==null || daoConnection.getConnection()==null || daoConnection.getConnection().isClosed())
			{
				daoConnection = TransportDAOConnectionFactory.instance().getDAOConnection();
				transactionOwner = true;
			}
		}
		catch (SQLException sqlex)
		{
			throw new DAOException("Could not retrieve connection",sqlex);
		}
		
		return daoConnection;
	}
	/**
	 * @return
	 */
	public boolean isTransactionOwner()
	{
		return transactionOwner;
	}

	/**
	 * @param b
	 */
	public void setTransactionOwner(boolean b)
	{
		transactionOwner = b;
	}

}
