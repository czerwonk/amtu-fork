/*
 * Created on Apr 27, 2004
 *
 */
package com.amazon.merchants.transport.persistence;

import com.amazon.merchants.dao.DAO;
import com.amazon.merchants.dao.DAOException;
import com.amazon.merchants.dao.DAOKey;
import com.amazon.merchants.transport.model.BatchReferenceIdentifier;
import com.amazon.merchants.transport.model.FeedStatusEnum;
import com.amazon.merchants.transport.model.MerchantDocument;
import com.amazon.merchants.transport.model.MerchantFeed;
import com.amazon.merchants.transport.model.ProcessingReport;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description: Utility method to wrap up dao calls for merchant documents
 * 
 * @author hynoskij
 *
 */
public class DAOWrapper
{	
	public static void create(MerchantDocument doc) throws PersistenceException
	{
		persist(doc,true);
	}

	public static void update(MerchantDocument doc) throws PersistenceException
	{
		persist(doc,false);
	}
	
	public static MerchantDocument getDocument(DAOKey key) throws PersistenceException
	{
		DAO dao = TransportDAOFactory.instance().getDao(key.getClass());		
		try
		{
			return (MerchantDocument)dao.get(key);
		}
		catch (DAOException dex)
		{
			throw new PersistenceException("Could not retrieve object from database",dex);
		}
	}

	public static MerchantFeed getFeed(BatchReferenceIdentifier ref) throws PersistenceException
	{		
		try
		{
			MerchantFeedDAO dao = new MerchantFeedDAO();
			return dao.getFeedByBatchReference(ref);
		}
		catch (DAOException dex)
		{
			throw new PersistenceException("Could not retrieve object from database",dex);
		}
	}

	private static void persist(MerchantDocument doc, boolean create) throws PersistenceException
	{
		DAO dao = TransportDAOFactory.instance().getDao(doc.getClass());
		try
		{
			if (create)	
			{
				dao.create(doc);
			} 
			else 
			{
				dao.update(doc);
			} 
		}
		catch (DAOException dex)
		{
			throw new PersistenceException("Could not persist object to database",dex);
		}
	}
	
	public static ProcessingReport [] getAllIncompleteProcessingReportsByEnvironment(String environment) throws PersistenceException
	{
		String [] statuses=new String[]{FeedStatusEnum.IN_PROGRESS.getName(),
										FeedStatusEnum.PENDING.getName(),
										FeedStatusEnum.POSTED.getName()};
		
		ProcessingReport [] results = null;
		
		try
		{
			results = new ProcessingReportDAO().getByStatusListAndEnvironment(statuses,environment);
		}
		catch(DAOException dex)
		{
			throw new PersistenceException("Could not retrieve processing report listing",dex);
		}

		return results;
	}
}
