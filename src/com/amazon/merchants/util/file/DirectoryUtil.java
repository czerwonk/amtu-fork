/*
 * Created on Apr 20, 2004
 *
 */
package com.amazon.merchants.util.file;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang.Validate;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class DirectoryUtil
{
	public static File [] getAllFilesWithSuffixes(File directory,String [] suffixes)
	{
		Validate.notNull(directory);
		Validate.isTrue(directory.isDirectory());
		
		return directory.listFiles((FileFilter)new SuffixFileFilter(suffixes));		
	}
}
