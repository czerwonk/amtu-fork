/*
 * Created on Apr 27, 2004
 *
 */
package com.amazon.merchants.transport.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.amazon.merchants.dao.DAOException;
import com.amazon.merchants.util.ConfigResource;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
// TODO Use a pool instead - not important for v1.0 as threading is minimal
public class TransportDAOConnection extends com.amazon.merchants.dao.DAOConnection
{
	public TransportDAOConnection() throws DAOException {init();}

	protected void init() throws DAOException
	{
		String dbClass=null;
		
		try 
		{
			Properties dbProps = new Properties();
			dbProps.load(new ConfigResource("db.properties").inputStream());
			dbClass = dbProps.getProperty("db.driver");			
			Class.forName(dbClass);
			String jdbcString = dbProps.getProperty("db.connection");
			String username = dbProps.getProperty("db.username");
			String password = dbProps.getProperty("db.password");
			connection = DriverManager.getConnection(jdbcString,username,password);
		} 
		catch (ClassNotFoundException ex) 
		{
			throw new DAOException("No database driver found for type "+dbClass,ex);
		}
		catch (IOException ex) 
		{
			throw new DAOException("Could not load database properties.",ex);
		}
		catch (SQLException sqlex)
		{
			throw new DAOException("Could not connect to database.",sqlex);
		}
	}
	
	public Connection getConnection()
	{
		return connection;
	}
}
