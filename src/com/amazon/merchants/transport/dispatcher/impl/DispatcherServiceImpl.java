/*
 * Created on Apr 19, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher.impl;

import java.io.File;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.*;

import com.amazon.merchants.transport.adapter.*;
import com.amazon.merchants.transport.dispatcher.*;
import com.amazon.merchants.transport.logging.AuditLogger;
import com.amazon.merchants.transport.model.*;
import com.amazon.merchants.transport.persistence.DAOWrapper;
import com.amazon.merchants.transport.persistence.PersistenceException;
import com.amazon.merchants.transport.validator.*;
import com.amazon.merchants.util.file.DirectoryUtil;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class DispatcherServiceImpl implements DispatcherService
{
	private static final DispatcherService _instance = new DispatcherServiceImpl();
	private static final Log log = LogFactory.getLog(DispatcherService.class);

	public static DispatcherService instance()
	{
		return _instance;
	}

	/*
	 * @see com.amazon.merchants.transport.dispatcher.DispatcherService#dispatch(java.io.File, com.amazon.merchants.transport.model.MerchantAccount)
	 */
	public MerchantFeed [] dispatch(File fileOrDirectory, MerchantAccount account) throws DispatcherServiceException
	{
		Validate.notNull(fileOrDirectory);
		Validate.isTrue(fileOrDirectory.canRead(),"Cannot read file "+fileOrDirectory.getName());
		Validate.notNull(account);
		
		AuditLogger.instance().logInfoMessage("Dispatching outgoing files for environment "+account.getEnvironmentName());
		
		if (fileOrDirectory.isDirectory())
		{
			return dispatchDirectory(fileOrDirectory,account);
		}
		else
		{
			return dispatchFile(fileOrDirectory,account);
		}
	}

	private MerchantFeed [] dispatchFile(File file, MerchantAccount account)
	{
		return dispatchAll(new File[]{file},account);
	}

	private MerchantFeed [] dispatchDirectory(File directory, MerchantAccount account)
	{
		return dispatchAll(DirectoryUtil.getAllFilesWithSuffixes(directory,DispatcherConstants.ACCEPTED_FILE_TYPES),account);
	}

	private MerchantFeed [] dispatchAll(File [] files, MerchantAccount account)
	{
		MerchantFeed [] feeds = DispatcherFactory.instance().getRecognizer().recognizeFiles(files);
		feeds = DispatcherFactory.instance().getPreprocessor().process(feeds);

		try
		{

			MerchantsAtConnector connector = MerchantsAtConnectorFactory.instance().getMerchantsAtConnector(account);
			for (int i=0;i<feeds.length;i++)
			{
				try
				{
					Validator feedValidator = ValidatorFactory.instance().getValidator(feeds[i].getDocumentName());
					feedValidator.validate(feeds[i]);
					connector.postDocument(feeds[i]);
					feeds[i].setStatus(FeedStatusEnum.POSTED);
					AuditLogger.instance().logInfoMessage("Dispatched " + feeds[i].getDocumentName());
				}
				catch (ValidationException vex)
				{
					log.debug(ExceptionUtils.getFullStackTrace(vex));
					feeds[i].setStatus(FeedStatusEnum.FAILED);
					feeds[i].setFailureReason(vex.getMessage());
				}
				catch (MerchantsAtConnectorException max)
				{
					log.debug(ExceptionUtils.getFullStackTrace(max));
					AuditLogger.instance().logSeriousError("Could not post document "+feeds[i].getDocumentName(),max);
					feeds[i].setStatus(FeedStatusEnum.FAILED);
					feeds[i].setFailureReason(max.getMessage());
				}
				
				// Log to Audit File
				AuditLogger.instance().logStatusUpdate(feeds[i]);
				
				// Store in Database
				try
				{
					DAOWrapper.create(feeds[i]);
				}
				catch (PersistenceException pex)
				{
					log.debug(ExceptionUtils.getFullStackTrace(pex));
					AuditLogger.instance().logSeriousError(pex);
				}
			}
		}
		catch(MerchantsAtConnectorException max)
		{
			log.debug(ExceptionUtils.getFullStackTrace(max));
			AuditLogger.instance().logSeriousError(max);
		}
		return feeds;
	}
}