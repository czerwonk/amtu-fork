/*
 * Created on Apr 27, 2004
 *
 */
package com.amazon.merchants.transport.persistence;

import java.sql.*;
import java.util.ArrayList;

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
public class ProcessingReportDAO extends DAO
{
	private static final Log log = LogFactory.getLog(ProcessingReportDAO.class);

	public ProcessingReportDAO(){}
	
	/**
	 * For transactional support
	 */
	public ProcessingReportDAO(DAOConnection con)
	{
		super(con);
	}
	
	public Object get(DAOKey id) throws DAOException
	{
		DAOConnection con = getDAOConnection();
		ProcessingReport pr = null;
		if (con!=null)
		{
			try
			{
				String sql = SQLUtils.instance().getSqlString(SQLQueryEnum.PROCESSING_REPORT_GETBYID);
				if(sql!=null && !sql.equals(""))
				{
					PreparedStatement ps = con.getConnection().prepareStatement(sql);
					ps.setLong(1,((ProcessingReportPrimaryKey)id).getId());
					
					ResultSet rs = ps.executeQuery();
					if (rs!=null && rs.next()!=false)
					{
						pr = parseResultSet(rs,con);
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
		return pr;
	}

	public void delete(DAOKey id) throws DAOException
	{
		DAOConnection con = getDAOConnection();
		if (con!=null)
		{
			try
			{
				String sql = SQLUtils.instance().getSqlString(SQLQueryEnum.PROCESSING_REPORT_DELETE);
				if(sql!=null && !sql.equals(""))
				{
					PreparedStatement ps = con.getConnection().prepareStatement(sql);
					ps.setLong(1,((ProcessingReportPrimaryKey)id).getId());
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
		persist((ProcessingReport)theObject,true);
	}

	/*
	 * Destructive overwrite of what is currently stored in the database
	 */
	public void update(Object theObject) throws DAOException
	{
		persist((ProcessingReport)theObject,false);
	}
	
	public ProcessingReport [] getByStatusListAndEnvironment(String [] statusList,String env) throws DAOException
	{
		ArrayList reports = new ArrayList();
		DAOConnection con = getDAOConnection();
		if (con!=null)
		{
			try
			{
				String sql = SQLUtils.instance().getSqlString(SQLQueryEnum.PROCESSING_REPORT_GETBYSTATUSLISTANDENVIRONMENT);
				if(sql!=null && !sql.equals(""))
				{
					sql = SQLUtils.instance().getInArray(statusList,sql);
										
					PreparedStatement ps = con.getConnection().prepareStatement(sql);
					ps.setString(1,env);
					
					ResultSet rs = ps.executeQuery();
					while (rs!=null && rs.next()!=false)
					{
						reports.add(parseResultSet(rs,con));
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
		return (ProcessingReport[])reports.toArray(new ProcessingReport[0]);
	}
	
	private ProcessingReport parseResultSet(ResultSet rs, DAOConnection con) throws SQLException, DAOException
	{
		ProcessingReport pr = new ProcessingReport();
		int i=0;
		pr.setBatchReference(new BatchReferenceIdentifier(rs.getLong(++i)));
		pr.setFeedId(rs.getString(++i));
		pr.setDocumentId(new DocumentIdentifier(rs.getString(++i)));
		pr.setStatus(FeedStatusEnum.getEnum(rs.getString(++i)));
		pr.setEnvironment(rs.getString(++i));
		pr.setLastPollAttempt(rs.getTimestamp(++i)==null?null:new java.util.Date(rs.getTimestamp(i).getTime()));
		pr.setTimeSubmitted(rs.getTimestamp(++i)==null?null:new java.util.Date(rs.getTimestamp(i).getTime()));		
		if (pr.getDocumentId()!=null)
		{
			pr.setReportDetails((MerchantReport)new MerchantReportDAO(con).get(new MerchantReportPrimaryKey(pr.getDocumentId().toString())));
		}
		return pr;
	}

	private void persist(ProcessingReport report, boolean create) throws DAOException
	{
		Validate.notNull(report);
		DAOConnection con = getDAOConnection();
		if (con!=null)
		{
			try
			{
				String sql = SQLUtils.instance().getSqlString(create?SQLQueryEnum.PROCESSING_REPORT_INSERT:SQLQueryEnum.PROCESSING_REPORT_UPDATE);
				if(sql!=null && !sql.equals(""))
				{
					PreparedStatement ps = con.getConnection().prepareStatement(sql);

					int i=create?1:0;
					// Don't want the feed id to be adjusted once batch is created
					if (create) ps.setString(++i,report.getFeedId());
				 	ps.setString(++i,report.getDocumentId()==null?null:report.getDocumentId().getId());
					ps.setString(++i,report.getStatus().getName());
					if (create) ps.setString(++i,report.getEnvironment());
					ps.setTimestamp(++i,report.getLastPollAttempt()==null?null:new Timestamp(report.getLastPollAttempt().getTime()));
					ps.setLong(create?1:++i,report.getBatchReference().getId());
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
				log.debug(ExceptionUtils.getFullStackTrace(sqlex));
				try
				{
					con.getConnection().rollback();
				}
				catch(SQLException sqlex2){log.debug(ExceptionUtils.getFullStackTrace(sqlex2));}
				throw new DAOException("Could not save processing report to database.",sqlex);
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
