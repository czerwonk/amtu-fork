/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.model;

import java.io.*;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.lang.Validate;

import com.amazon.merchants.util.file.IO;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public abstract class MerchantDocument
{
	transient DataHandler document;
	String savedFileName;
	MerchantDocumentEnum documentType;
	boolean flatFile;
	String environment;
	
	/**
	 * 
	 */
	public MerchantDocument()
	{
		super();
	}

	/**
	 * @return
	 */
	public DataHandler getDocument()
	{
		return document;
	}

	/**
	 * @param handler
	 */
	public void setDocument(DataHandler handler)
	{
		document = handler;
	}
	
	/**
	 * Saves the stored document to a file.
	 * Note: When this is run, this object will now refer to the created
	 * file as a data source.
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void saveToFile(File path) throws IOException
	{
		Validate.notNull(path);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));
		if (document != null)
		{
			InputStream is = this.document.getInputStream();
			IO.copyStream(is,bos);

			// Point this document to the local copy so the memory resident
			// copy can be garbage collected
			document = new DataHandler(new FileDataSource(path));
			savedFileName = path.getAbsolutePath();
		}
		else
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(bos));
			pw.println("Document not found or an error has occurred.");
			pw.flush();
			pw.close();
		}
	}
	
	/**
	 * @return
	 */
	public MerchantDocumentEnum getDocumentType()
	{
		return documentType;
	}

	/**
	 * @param enum
	 */
	public void setDocumentType(MerchantDocumentEnum enum)
	{
		this.documentType = enum;
	}
	/**
	 * @return
	 */
	public boolean isFlatFile()
	{
		return flatFile;
	}

	/**
	 * @param b
	 */
	public void setFlatFile(boolean b)
	{
		flatFile = b;
	}
	
	public String getDocumentName()
	{
		return (document==null||document.getDataSource()==null)?savedFileName:document.getDataSource().getName();
	}
	
	/*
	 * Does not update the pointer. Only to be used for data storage purposes.
	 * Will 
	 */
	public void setDocumentName(String name)
	{
		this.savedFileName = name; 
	}
	/**
	 * @return
	 */
	public String getEnvironment()
	{
		return environment;
	}

	/**
	 * @param string
	 */
	public void setEnvironment(String string)
	{
		environment = string;
	}
}
