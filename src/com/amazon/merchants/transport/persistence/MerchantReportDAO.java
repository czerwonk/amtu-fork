/*
 * Created on Apr 27, 2004
 *
 */
package com.amazon.merchants.transport.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazon.merchants.dao.*;
import com.amazon.merchants.transport.model.AmazonSoapReturnCodeEnum;
import com.amazon.merchants.transport.model.DocumentIdentifier;
import com.amazon.merchants.transport.model.MerchantReport;
import com.amazon.merchants.transport.model.ReportTypeEnum;
import com.amazon.merchants.transport.persistence.util.SQLQueryEnum;
import com.amazon.merchants.transport.persistence.util.SQLUtils;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class MerchantReportDAO extends DAO
{
	
	private static final Log log = LogFactory.getLog(ProcessingReportDAO.class);

	public MerchantReportDAO(){}
	
	/**
	 * For transactional support
	 */
	public MerchantReportDAO(DAOConnection con)
	{
		super(con);
	}
	
	/*
	 * @see com.amazon.merchants.dao.DAO#get(com.amazon.merchants.dao.DAOKey)
	 */
	public Object get(DAOKey id) throws DAOException
	{
		String key = ((MerchantReportPrimaryKey)id).getId();
		String sql = SQLUtils.instance().getSqlString(SQLQueryEnum.REPORT_GETBYID);
		return doGet(key,sql);
	}
	/*
	 * @see com.amazon.merchants.dao.DAO#delete(com.amazon.merchants.dao.DAOKey)
	 */
	public void delete(DAOKey id) throws DAOException
	{
		DAOConnection con = getDAOConnection();
		if (con!=null)
		{
			try
			{
				String sql = SQLUtils.instance().getSqlString(SQLQueryEnum.REPORT_DELETE);
				if(sql!=null && !sql.equals(""))
				{
					PreparedStatement ps = con.getConnection().prepareStatement(sql);
					ps.setString(1,((MerchantReportPrimaryKey)id).getId());
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
				throw new DAOException("Could not delete report from database.",sqlex);
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
		persist((MerchantReport)theObject,true);
	}

	/*
	 * @see com.amazon.merchants.dao.DAO#update(java.lang.Object)
	 */
	public void update(Object theObject) throws DAOException
	{
		persist((MerchantReport)theObject,false);
	}

	private MerchantReport doGet(Object key,String sql) throws DAOException
	{
		DAOConnection con = getDAOConnection();
		MerchantReport mr = null;
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
						mr = parseResultSet(rs);
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
				throw new DAOException("Could not retrieve report details from database.",sqlex);
			}
			finally
			{
				if (isTransactionOwner())
				{
					con.closeConnection();
				}
			}
			
		}		
		return mr;		
	}

	private MerchantReport parseResultSet(ResultSet rs) throws SQLException
	{
		MerchantReport mr = new MerchantReport();
		int i=0;
		mr.setDocumentId(rs.getString(++i)==null?null:new DocumentIdentifier(rs.getString(i)));
		mr.setDocumentName(rs.getString(++i));
		mr.setDocumentType(ReportTypeEnum.getEnum(rs.getString(++i)));
		mr.setFlatFile(rs.getBoolean(++i));
		mr.setDownloadDate(rs.getTimestamp(++i)==null?null:new java.util.Date(rs.getTimestamp(i).getTime()));
		mr.setAcknowledgementStatus(AmazonSoapReturnCodeEnum.getEnum(rs.getString(++i)));
		mr.setEnvironment(rs.getString(++i));
		return mr;
	}

	private void persist(MerchantReport report, boolean create) throws DAOException
	{
		Validate.notNull(report);
		DAOConnection con = getDAOConnection();
		if (con!=null)
		{
			try
			{
				String sql = SQLUtils.instance().getSqlString(create?SQLQueryEnum.REPORT_INSERT:SQLQueryEnum.REPORT_UPDATE);
				if(sql!=null && !sql.equals(""))
				{
					PreparedStatement ps = con.getConnection().prepareStatement(sql);
					int i=create?1:0;
					ps.setString(++i,report.getDocumentName());
					ps.setString(++i,report.getDocumentType().getName());
					ps.setBoolean(++i,report.isFlatFile());
					ps.setTimestamp(++i,new Timestamp(report.getDownloadDate().getTime()));
					ps.setString(++i,report.getAcknowledgementStatus()==null?null:report.getAcknowledgementStatus().getName());
					ps.setString(++i,report.getEnvironment());
					ps.setString(create?1:++i,report.getDocumentId().getId());
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
				throw new DAOException("Could not save report to database.",sqlex);
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
