/*
 * Created on Apr 27, 2004
 *
 */
package com.amazon.merchants.transport.persistence;

import java.sql.*;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.*;

import com.amazon.merchants.dao.*;
import com.amazon.merchants.transport.model.*;
import com.amazon.merchants.transport.persistence.util.*;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class MerchantFeedDAO extends DAO
{

	public MerchantFeedDAO(){}
	
	/**
	 * For transactional support
	 */
	public MerchantFeedDAO(DAOConnection con)
	{
		super(con);
	}
	
	private static final Log log = LogFactory.getLog(MerchantFeedDAO.class);
	public Object get(DAOKey id) throws DAOException
	{
		String key = ((MerchantFeedPrimaryKey)id).getId();
		String sql = SQLUtils.instance().getSqlString(SQLQueryEnum.FEED_GETBYID);
		return doGet(key,sql);
	}

	public MerchantFeed getFeedByBatchReference(BatchReferenceIdentifier ref) throws DAOException
	{
		Long key = new Long(ref.getId());
		String sql = SQLUtils.instance().getSqlString(SQLQueryEnum.FEED_GETBYBATCHREF);
		return doGet(key,sql);
	}
	
	private MerchantFeed doGet(Object key,String sql) throws DAOException
	{
		DAOConnection con = getDAOConnection();
		MerchantFeed mf = null;
		if (con!=null)
		{
			try
			{
				if(sql!=null && !sql.equals(""))
				{
					PreparedStatement ps = con.getConnection().prepareStatement(sql);
					if (key instanceof Long)
					{
						ps.setLong(1,((Long)key).longValue());
					}
					else
					{
						ps.setString(1,(String)key);
					}
					
					ResultSet rs = ps.executeQuery();
					if (rs!=null && rs.next()!=false)
					{
						mf = parseResultSet(rs);
					}
				}
				else
				{
					log.debug("SQL String not found");
				}				
			}
			catch(SQLException sqlex)
			{
				try
				{
					con.getConnection().rollback();
				}
				catch(SQLException sqlex2){log.debug(ExceptionUtils.getFullStackTrace(sqlex2));}
				throw new DAOException("Could not retrieve feed details from database.",sqlex);
			}
			finally
			{
				if (isTransactionOwner())
				{
					con.closeConnection();
				}
			}
			
		}		
		return mf;		
	}

	public void delete(DAOKey id) throws DAOException
	{
		DAOConnection con = getDAOConnection();
		if (con!=null)
		{
			try
			{
				String sql = SQLUtils.instance().getSqlString(SQLQueryEnum.FEED_DELETE);
				if(sql!=null && !sql.equals(""))
				{
					PreparedStatement ps = con.getConnection().prepareStatement(sql);
					ps.setString(1,((MerchantFeedPrimaryKey)id).getId());
					ps.execute();
					if (isTransactionOwner())
					{
						con.getConnection().commit();
					}
				}
				else
				{
					log.debug("SQL String not found");
				}
			}
			catch(SQLException sqlex)
			{
				try
				{
					con.getConnection().rollback();
				}
				catch(SQLException sqlex2){log.debug(ExceptionUtils.getFullStackTrace(sqlex2));}
				throw new DAOException("Could not save feed to database.",sqlex);
			}
			finally
			{
				if (isTransactionOwner())
				{
					con.closeConnection();
				}
			}
		}
	}
	
	/*
	 * @see com.amazon.merchants.dao.DAO#create(java.lang.Object)
	 */
	public void create(Object theObject) throws DAOException
	{
		persist((MerchantFeed)theObject,true);
	}

	/*
	 * Destructive overwrite of what is currently stored in the database
	 */
	public void update(Object theObject) throws DAOException
	{
		persist((MerchantFeed)theObject,false);
	}

	private MerchantFeed parseResultSet(ResultSet rs) throws SQLException
	{
		MerchantFeed mf = new MerchantFeed();
		int i=0;
		mf.setFeedId(rs.getString(++i));
		mf.setDocumentName(rs.getString(++i));
		mf.setDocumentType(DocumentTypeEnum.getEnum(rs.getString(++i)));
		mf.setFlatFile(rs.getBoolean(++i));
		mf.setCreationDate(rs.getTimestamp(++i)==null?null:new java.util.Date(rs.getTimestamp(i).getTime()));
		mf.setTimeSubmitted(rs.getTimestamp(++i)==null?null:new java.util.Date(rs.getTimestamp(i).getTime()));
		mf.setFailureReason(rs.getString(++i));
		mf.setEnvironment(rs.getString(++i));
		mf.setBatchReference(new BatchReferenceIdentifier(rs.getLong(++i)));
		mf.setStatus(FeedStatusEnum.getEnum(rs.getString(++i)));
		return mf;
	}

	private void persist(MerchantFeed feed, boolean create) throws DAOException
	{
		Validate.notNull(feed);
		DAOConnection con = getDAOConnection();
		if (con!=null)
		{
			try
			{
				String sql = SQLUtils.instance().getSqlString(create?SQLQueryEnum.FEED_INSERT:SQLQueryEnum.FEED_UPDATE);
				if(sql!=null && !sql.equals(""))
				{
					PreparedStatement ps = con.getConnection().prepareStatement(sql);
					int i=create?1:0;
					ps.setString(++i,feed.getDocumentName());
					ps.setString(++i,feed.getDocumentType().getName());
					ps.setBoolean(++i,feed.isFlatFile());
					ps.setTimestamp(++i,new Timestamp(feed.getCreationDate().getTime()));
					ps.setTimestamp(++i,new Timestamp(feed.getTimeSubmitted().getTime()));
					ps.setString(++i,feed.getFailureReason());
					ps.setString(++i,feed.getEnvironment());
					ps.setString(create?1:++i,feed.getFeedId());
					ps.execute();
		
					// A feed failed before submission will not have a batch reference, so give it a fake one
					if (feed.getBatchReference()==null)
					{
						feed.setBatchReference(new BatchReferenceIdentifier(feed.getFeedId().hashCode()));
					}

					ProcessingReport partialReport = new ProcessingReport(feed.getStatus(),feed.getBatchReference());
					partialReport.setFeedId(feed.getFeedId());
					partialReport.setEnvironment(feed.getEnvironment());
					ProcessingReportDAO prDao = new ProcessingReportDAO(con);
					if(create)
					{
						prDao.create(partialReport);
					}
					else
					{
						prDao.update(partialReport);
					}
					
					if (isTransactionOwner())
					{
						con.getConnection().commit();
					}
				}
				else
				{
					log.debug("SQL String not found");
				}
			}
			catch(SQLException sqlex)
			{
				try
				{
					con.getConnection().rollback();
				}
				catch(SQLException sqlex2){log.debug(ExceptionUtils.getFullStackTrace(sqlex2));}
				throw new DAOException("Could not save feed to database.",sqlex);
			}
			finally
			{
				if (isTransactionOwner())
				{
					con.closeConnection();
				}
			}
		}
	}
}
