/*
 * Created on Apr 22, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazon.merchants.transport.dispatcher.*;
import com.amazon.merchants.transport.logging.AuditLogger;
import com.amazon.merchants.transport.model.*;
import com.amazon.merchants.transport.util.TransportDirectoryUtil;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class RecognizerImpl implements Recognizer
{
	private static final Recognizer _instance = new RecognizerImpl();
	private static final Log log = LogFactory.getLog(Recognizer.class);
	
	public static Recognizer instance()
	{
		return _instance;
	}
	
	public MerchantFeed [] recognizeFiles(File[] files)
	{
		TreeSet sortedList = new TreeSet();

		for (int i=0;i<files.length;i++)
		{
			try
			{
				MerchantFeed doc = createMerchantFeed(files[i]);
				if (doc != null)
				{
					sortedList.add(doc);
				}
			}
			catch (UnrecognizedDocumentException udx)
			{
				AuditLogger.instance().logInfoMessage("Could not recognize file "+files[i].getName()+" - ignoring.");
				log.debug(ExceptionUtils.getFullStackTrace(udx));
			}
		}

		return (MerchantFeed []) sortedList.toArray(new MerchantFeed[0]);
	}
	
	private MerchantFeed createMerchantFeed(File file) throws UnrecognizedDocumentException
	{
		MerchantFeed feed = null;
		File root = file.getParentFile().getParentFile();

		// Seek the filetype
		try
		{
			DocumentTypeEnum type = DispatcherFactory.instance().getFileIdentifier().getFileType(file);
			// Move file to working temp folder
			File temp = new File(root.getAbsolutePath()+File.separator+TransportDirectoryUtil.TEMP);
			file = TransportDirectoryUtil.moveFile(file,temp);
			// Create Merchant Feed		
			feed = new MerchantFeed(file,type);
		}
		catch (InvalidDocumentException idx)
		{
			File failed = new File(root.getAbsolutePath()+File.separator+TransportDirectoryUtil.FAILED);
			file = TransportDirectoryUtil.moveFile(file,failed);
			throw new UnrecognizedDocumentException("Document type not known",idx);		
		}
		catch (FileNotFoundException fnf)
		{
			throw new UnrecognizedDocumentException("File inaccessible or has been deleted",fnf);		
		}
		return feed;
	}
}
