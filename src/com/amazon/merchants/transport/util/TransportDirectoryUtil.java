/*
 * Created on May 9, 2004
 *
 */
package com.amazon.merchants.transport.util;

import java.io.File;

import org.apache.commons.lang.Validate;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class TransportDirectoryUtil
{
	public static final String OUTGOING = "outgoing";
	public static final String REPORTS = "reports";
	public static final String PROCESSING_REPORTS = "processingreports";
	public static final String SENT = "sent";
	public static final String FAILED = "failed";	
	public static final String TEMP = "temp";
	public static final String LOGS = "logs";
	
	private static final String [] directories = {
										OUTGOING,
										REPORTS,
										PROCESSING_REPORTS,
										SENT,
										TEMP,
										FAILED};
										
	public static int getNumberDirectories()
	{
		return directories.length;
	}
	
	public static void createDirectoryStructure(String rootPath, String environment)
	{
		for (int i=0; i<directories.length;i++)
		{
			String directory = rootPath+File.separator+environment+File.separator+directories[i];
			File toCreate = new File(directory);
			toCreate.mkdirs();
		}
		String directory = rootPath+File.separator+LOGS;
		File toCreate = new File(directory);
		toCreate.mkdirs();
	}
	
	public static File getDirectory(String root, String environment, String directory)
	{
		String directoryPath = new StringBuffer(root).
									append(File.separator).
									append(environment).
									append(File.separator).
									append(directory).toString();
		return new File(directoryPath);
	}	

	public static File getDirectory(String root, String environment)
	{
		String directoryPath = new StringBuffer(root).
									append(File.separator).
									append(environment).
									append(File.separator).
									toString();
		return new File(directoryPath);
	}	

	
	public static File moveFile(File fromFile, File toDir)
	{
		return moveFile(fromFile,toDir,null);
	}

	public static File moveFile(File fromFile, File toDir, String suffix)
	{
		Validate.notNull(fromFile);
		Validate.notNull(toDir);
		String path = new StringBuffer(toDir.getAbsolutePath())
							.append(File.separator)
							.append(fromFile.getName())
							.append(suffix==null?"":"."+
							suffix).toString();
		File fullPath = new File(path);
		fromFile.renameTo(fullPath);
		return fullPath;
	}
}