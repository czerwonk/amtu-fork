/*
 * Created on May 4, 2004
 *
 */
package com.amazon.merchants.transport.persistence;

import com.amazon.merchants.dao.DAO;
import com.amazon.merchants.dao.DAOConnection;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class TransportDAOFactory
{
	private static final TransportDAOFactory _instance = new TransportDAOFactory(); 
	public static final TransportDAOFactory instance(){return _instance;}
	private static final String MERCHANT_FEED = "MerchantFeed";
	private static final String MERCHANT_REPORT = "MerchantReport";
	private static final String PROCESSING_REPORT = "ProcessingReport";
	private static final String PRIMARY_KEY_SUFFIX = "PrimaryKey";
	

	public DAO getDao(Class clazz)
	{
		return getDao(clazz,null);
	}
	
	/**
	 * Returns a DAO given either the model class or primary key class
	 * 
	 * @param clazz
	 * @param con
	 * @return
	 */
	public DAO getDao(Class clazz, DAOConnection con)
	{
		boolean isTrx=false;
		
		if (con!=null)
		{ 
			isTrx=true;
		}
		
		if (clazz.getName().endsWith(MERCHANT_FEED)||clazz.getName().endsWith(MERCHANT_FEED+PRIMARY_KEY_SUFFIX))
		{
			return isTrx?new MerchantFeedDAO(con):new MerchantFeedDAO();
		}
		else if (clazz.getName().endsWith(MERCHANT_REPORT)||clazz.getName().endsWith(MERCHANT_REPORT+PRIMARY_KEY_SUFFIX))
		{
			return isTrx?new MerchantReportDAO(con):new MerchantReportDAO();
		}
		else if (clazz.getName().endsWith(PROCESSING_REPORT)||clazz.getName().endsWith(PROCESSING_REPORT+PRIMARY_KEY_SUFFIX))
		{
			return isTrx?new ProcessingReportDAO(con):new ProcessingReportDAO();
		}
		return null;
	}
}
