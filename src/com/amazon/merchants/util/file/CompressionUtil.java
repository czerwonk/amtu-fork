/*
 * Created on Apr 22, 2004
 *
 */
package com.amazon.merchants.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.lang.Validate;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class CompressionUtil
{
	public void gzipFile(File inputFile, File compressedFile)
	{
		Validate.notNull(inputFile);
		Validate.notNull(compressedFile);
		Validate.isTrue(inputFile.canRead(),"Input file is not accessible.");

		try 
		{
			// Create the GZIP output stream
			GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(compressedFile));
    
			// Open the input file
			FileInputStream in = new FileInputStream(inputFile);
    
			// Transfer bytes from the input file to the GZIP output stream
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) 
			{
				out.write(buf, 0, len);
			}
			in.close();
    
			// Complete the GZIP file
			out.finish();
			out.close();
		} 
		catch (IOException e) 
		{
		}
		
	}
}
