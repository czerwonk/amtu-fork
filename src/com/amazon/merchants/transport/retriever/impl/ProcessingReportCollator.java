/*
 * Created on May 6, 2004
 *
 */
package com.amazon.merchants.transport.retriever.impl;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.*;

import com.amazon.merchants.transport.logging.AuditLogger;
import com.amazon.merchants.transport.model.*;
import com.amazon.merchants.transport.persistence.*;
import com.amazon.merchants.transport.preferences.TransportPreferenceEnum;
import com.amazon.merchants.transport.preferences.TransportPreferences;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description: Reads the database and works out which processing reports are
 * 				due for collection.
 * 
 * @author hynoskij
 *
 */
public class ProcessingReportCollator
{
	private int timeoutMinutes;
	private int postTimeoutPollIntervalMinutes;
	private boolean useProperties=false;
	private static final Log log = LogFactory.getLog(ProcessingReportCollator.class);
	
	ProcessingReportCollator()
	{
		super();
		
		if (TransportPreferences.instance().getPreference(TransportPreferenceEnum.RETRIEVER_POST_TIMEOUT_POLL_INTERVAL)!=null)
		{
				timeoutMinutes = TransportPreferences.instance().getPreferenceInt(TransportPreferenceEnum.RETRIEVER_POST_TIMEOUT_POLL_INTERVAL);
				postTimeoutPollIntervalMinutes = TransportPreferences.instance().getPreferenceInt(TransportPreferenceEnum.RETRIEVER_POST_TIMEOUT_POLL_INTERVAL);
				useProperties=true;
		}
		else
		{
			log.debug("Not using timeouts on processing report retrieval.");
		}
	}
	
	BatchReferenceIdentifier [] getAllPendingReports(String environment)
	{
		ArrayList batchRefs = new ArrayList();
		
		ProcessingReportDAO prDao = new ProcessingReportDAO();
		try
		{
			ProcessingReport [] reports = DAOWrapper.getAllIncompleteProcessingReportsByEnvironment(environment);
			for (int i=0; i<reports.length;i++)
			{
				// Only do this check if we're using timeouts on processing reports
				if (useProperties)
				{
					long nowMillis = new Date().getTime();
					
					// Check if the time elapsed since submission is too long
					if (nowMillis - reports[i].getTimeSubmitted().getTime()>(timeoutMinutes*1000*60))
					{
						// Its been waiting a while so we're polling less often - is it time?
						if (reports[i].getLastPollAttempt()!=null
						&&  (nowMillis - reports[i].getLastPollAttempt().getTime())<postTimeoutPollIntervalMinutes*1000*60)
						{
							// Too early to re-poll this one, move along
							continue;
						}
					}
					
				}
				// Adding to the list of pollees
				batchRefs.add(reports[i].getBatchReference());
			}
		}
		catch (PersistenceException pex)
		{
			log.debug(ExceptionUtils.getFullStackTrace(pex));
			AuditLogger.instance().logSeriousError("Could not retrieve list of outstanding processing reports from database.",pex);
		}
		return (BatchReferenceIdentifier [])batchRefs.toArray(new BatchReferenceIdentifier[0]);
	}
}
