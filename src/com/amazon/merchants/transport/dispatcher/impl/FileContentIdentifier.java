/*
 * Created on Apr 22, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.amazon.merchants.transport.TransportConstants;
import com.amazon.merchants.transport.dispatcher.FileIdentifier;
import com.amazon.merchants.transport.dispatcher.InvalidDocumentException;
import com.amazon.merchants.transport.model.DocumentTypeEnum;
import com.amazon.merchants.util.*;
import com.amazon.merchants.util.file.FileUtil;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class FileContentIdentifier implements FileIdentifier
{
	public static final FileContentIdentifier _instance =
		new FileContentIdentifier();
	public Properties lookup = new Properties();

	FileContentIdentifier()
	{
		try
		{
			lookup.load(
				new ConfigResource("contentIdentifierStrings.properties")
					.inputStream());
		} catch (IOException iox)
		{
			iox.printStackTrace();
		}
	}

	public static FileContentIdentifier instance()
	{
		return _instance;
	}

	/*
	 * @see com.amazon.merchants.transport.dispatcher.FileIdentifier#getFileType(java.io.File)
	 */
	public DocumentTypeEnum getFileType(File file)
		throws InvalidDocumentException
	{
		Validate.notNull(file);
		Validate.isTrue(
			file.canRead(),
			"Cannot access file " + file.getAbsolutePath());

		String header = getStartOfFile(file);

		DocumentTypeEnum type =
			getFileTypeFromString(
				header,
				FileUtil.getExtension(file.getName()));
		return type;
	}

	String getStartOfFile(File file)
	{
		String header = null;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(file));
			char[] buffer = new char[512];
			br.read(buffer);
			br.close();
			header = new String(buffer);
		} catch (IOException iox)
		{
			// This shouldn't be thrown as we already checked it.
			iox.printStackTrace();
		}
		return header;
	}

	DocumentTypeEnum getFileTypeFromString(String header, String fileType)
		throws InvalidDocumentException
	{
		String key = getTypeKey(header, fileType);
		DocumentTypeEnum enumType = null;

		if (key != null)
		{
			// Using a tokenizer in case we use a bigger prefix one day

			StringTokenizer st = new StringTokenizer(key, ".");
			st.nextToken(); // Skip the text part
			String type = st.nextToken();
			enumType = DocumentTypeEnum.getEnum(type);
		} else
		{
			throw new InvalidDocumentException("Document not recognized.");
		}

		return enumType;
	}

	String getTypeKey(String header, String fileType) throws InvalidDocumentException
	{
		String key = null;

		// First check for all the ones we do know about
		for (Enumeration e = lookup.keys(); e.hasMoreElements();)
		{
			key = (String) e.nextElement();
			if (key.startsWith(fileType))
			{
				String element = (String) lookup.getProperty(key);
				if (new Str(header).indexOfIgnoreCase(element) != -1)
				{
					return key;
				}
			}
		}

		// If nothing has been found and its a flatfile see if its 
		// a product file, as other TemplateTypes are already checked.
		if (fileType.equals(TransportConstants.FLAT_FILE_SUFFIX))
		{
			// Check if this is a SHOPZILLA feed
			if (isShopzillaFeed(header)) {
				return "txt.SHOPZILLA";
			}
			
			if (new Str(header).indexOfIgnoreCase("TemplateType=") == 0)
			{
				return "txt.PRODUCT";
			}
		}
		throw new InvalidDocumentException("Document cannot be recognized as a valid Amazon document");
	}
	
	private boolean isShopzillaFeed(final String header) {
		
		if (new Str(header).indexOfIgnoreCase("TemplateType=Shopzilla") == 0) {
			return true;
		}
		
		if (new Str(header).indexOfIgnoreCase("TemplateType=") == 0) {
			return false;
		}
		
		String[] shopzillaRequiredColumms = StringUtils.stripAll(
				StringUtils.split(lookup.getProperty("txt.SHOPZILLA"), ",")); 
			
		if (shopzillaRequiredColumms == null || shopzillaRequiredColumms.length == 0) 
			throw new IllegalArgumentException("Cannot find 'Shopzilla' in file 'contentIdentifierStrings.properties'");		
		
		for (int i = 0; i < shopzillaRequiredColumms.length; i++) {
			if (! StringUtils.contains(header, shopzillaRequiredColumms[i])) {
				return false;
			}
		}
		return true;	
	}
}
