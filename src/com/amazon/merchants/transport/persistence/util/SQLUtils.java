/*
 * Created on Apr 30, 2004
 *
 */
package com.amazon.merchants.transport.persistence.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazon.merchants.util.ConfigResource;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class SQLUtils
{
	private static final SQLUtils _instance = new SQLUtils();
	private Properties sqlStrings=new Properties();
	private static final Log log = LogFactory.getLog(SQLUtils.class);
	public static final String IN_ARRAY_PLACEHOLDER="{LIST}";
	
	private SQLUtils()
	{
		try
		{
			sqlStrings.load(new ConfigResource("sqlCommands.properties").inputStream());
		}
		catch (IOException iox)
		{
			log.error("Could not load database query strings due to "+iox.getMessage());
			log.debug(ExceptionUtils.getFullStackTrace(iox));
		}
	}
	
	public static final SQLUtils instance()
	{
		return _instance;
	}
	
	public String getSqlString(SQLQueryEnum sqlQueryType)
	{
		return sqlStrings.getProperty(sqlQueryType.getName());
	}
	
	public String getInArray(Object [] array, String sqlString)
	{
		if (array != null && array.length > 0 && sqlString.indexOf(IN_ARRAY_PLACEHOLDER)>0)
		{
			StringBuffer result = new StringBuffer(sqlString.substring(0,sqlString.indexOf(IN_ARRAY_PLACEHOLDER)));
			
			for (int i=0;i<array.length;i++)
			{
				result.append("'");
				result.append(array[i].toString());
				result.append("'");
				result.append(",");
			}
			result.deleteCharAt(result.length()-1);
			result.append(sqlString.substring(sqlString.indexOf(IN_ARRAY_PLACEHOLDER)+IN_ARRAY_PLACEHOLDER.length()));
			sqlString = result.toString();
		}
		return sqlString;
	}
}
