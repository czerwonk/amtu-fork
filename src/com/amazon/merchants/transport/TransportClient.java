/*
 * Created on May 8, 2004
 *
 */
package com.amazon.merchants.transport;

import java.io.File;

import javax.activation.FileDataSource;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.*;

import com.amazon.merchants.transport.dispatcher.*;
import com.amazon.merchants.transport.logging.AuditLogger;
import com.amazon.merchants.transport.model.*;
import com.amazon.merchants.transport.preferences.*;
import com.amazon.merchants.transport.retriever.*;
import com.amazon.merchants.transport.util.TransportDirectoryUtil;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class TransportClient
{
	private static final Log log = LogFactory.getLog(TransportClient.class);
	private static final TransportClient _instance = new TransportClient();
	public static final TransportClient instance(){return _instance;}
	
	public void run(TransportOperationEnum operation)
	{
		Validate.notNull(operation);
		UserAccountPreferences userPreferences = null;
		TransportPreferences transportPreferences = null;
		String [] environments = null;
		String rootDirectory=null;

		// Do not run if preferences have not been set
		try
		{
			reloadPreferences();
			userPreferences = UserAccountPreferences.instance();
			transportPreferences = TransportPreferences.instance();
			if (!transportPreferences.preferencesExist())
			{
				throw new PreferencesException("Preferences do not exist");
			}
			environments = userPreferences.getEnvironments();
			rootDirectory=transportPreferences.getPreference(TransportPreferenceEnum.TRANSPORT_ROOT_FOLDER);
		}				
		catch (PreferencesException pex)
		{
			AuditLogger.instance().logSeriousError("Client did not run. ",pex);
			return;
		}
		
		for (int i=0; i<environments.length; i++)
		{
			MerchantAccount account = userPreferences.getAccount(environments[i]);
			File envDir = TransportDirectoryUtil.getDirectory(rootDirectory,environments[i]);

			// If the directory does not yet exist, create the structure and return
			if (!envDir.exists()||envDir.list().length<TransportDirectoryUtil.getNumberDirectories())
			{
				TransportDirectoryUtil.createDirectoryStructure(rootDirectory,environments[i]);
				return;
			}

			if (operation.equals(TransportOperationEnum.DISPATCH_ALL))
			{
				DispatcherService dispatcher = DispatcherFactory.instance().getDispatcherService();
				try
				{
					// Send the feeds
					MerchantFeed [] feeds = 
						dispatcher.dispatch(
							TransportDirectoryUtil.getDirectory(
									rootDirectory,
									environments[i],
									TransportDirectoryUtil.OUTGOING),account);

					// Move processed files to relevant directory					
					for (int j=0;j<feeds.length;j++)
					{
						File failedDir = TransportDirectoryUtil.getDirectory(rootDirectory,environments[i],TransportDirectoryUtil.FAILED);
						File sentDir = TransportDirectoryUtil.getDirectory(rootDirectory,environments[i],TransportDirectoryUtil.SENT);
						FileDataSource ds = (FileDataSource)feeds[j].getDocument().getDataSource();

						if (FeedStatusEnum.FAILED.equals(feeds[j].getStatus()))
						{
							TransportDirectoryUtil.moveFile(ds.getFile(),failedDir);
						}
						else
						{
							TransportDirectoryUtil.moveFile(ds.getFile(),sentDir,Long.toString(feeds[j].getBatchReference().getId()));
						}
					}
				}
				catch(Exception ex)
				{
					// Don't let anything bring down the system, just log and go
					log.debug(ExceptionUtils.getFullStackTrace(ex));
					AuditLogger.instance().logSeriousError("Error occurred dispatching files: "+ex.getMessage());
				}
			}
			else
			{
				ReportTypeEnum reportType = ReportTypeEnum.getEnum(operation.getName());
				RetrieverService service = RetrieverFactory.instance().getRetrieverService();
				try
				{
					if (reportType.equals(ReportTypeEnum.PROCESSING_REPORT))
					{
						service.retrieveOutstandingProcessingReports(
											account,
											TransportDirectoryUtil.getDirectory(rootDirectory,environments[i],TransportDirectoryUtil.PROCESSING_REPORTS),
											transportPreferences.getPreferenceBoolean(TransportPreferenceEnum.IS_FLATFILE));
					}
					else
					{
						service.retrieveAllPendingReports(
											reportType,
											account,
											TransportDirectoryUtil.getDirectory(rootDirectory,environments[i],TransportDirectoryUtil.REPORTS),
											transportPreferences.getPreferenceBoolean(TransportPreferenceEnum.IS_FLATFILE));
					}
				}
				catch(Exception ex)
				{
					// Don't let anything bring down the system, just log and go
					log.debug(ExceptionUtils.getFullStackTrace(ex));
					AuditLogger.instance().logSeriousError("Error occurred retrieving files: "+ex.getMessage());
				}
			}
		}		
	}
	
	public void reloadPreferences()
	{
		UserAccountPreferences.instance().reload();
		TransportPreferences.instance().reload();
	}	
}