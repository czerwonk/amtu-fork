package com.amazon.merchants.util.file;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.Validate;

public class FileUtil
{
	public static String getStringFromFile(String fileName) throws IOException
	{
		Validate.notEmpty(fileName);
		return getStringFromFile(new File(fileName));
	}

	public static String getStringFromFile(File inputFile) throws IOException
	{
		Validate.notNull(inputFile);
		Validate.isTrue(inputFile.exists());

		return IO.toString(new FileInputStream(inputFile));
	}
	
	public static String [] getStringArrayFromFile(File inputFile) throws IOException
	{
		ArrayList list = new ArrayList();
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		while(true) 
		{
			String line = br.readLine();
			if (line==null)
				break;
			list.add(line);
		}
		br.close();
		
		return (String[])list.toArray(new String[0]);
	}

	public static boolean areFilesDifferent(File file1, File file2) throws IOException
	{
		Validate.isTrue(file1.exists());
		Validate.isTrue(file2.exists());

		byte[] file1Data = IO.toByteArray(new FileInputStream(file1));
		byte[] file2Data = IO.toByteArray(new FileInputStream(file2));

		return !Arrays.equals(file1Data, file2Data);
	}

	public static File createTempDirectory() throws IOException
	{
		File tempDirectory = File.createTempFile("FileUtilTempDirectory", ".tmp");
		tempDirectory.delete();
		if (!tempDirectory.mkdirs())
		{
			throw new IOException(
				"Failed to create temporary directory [" + tempDirectory.getAbsolutePath() + "]");
		}
		return tempDirectory;
	}

	public static void deleteTempDirectory(File tempDirectory)
	{
		if (tempDirectory != null && tempDirectory.isDirectory())
		{
			File[] files = tempDirectory.listFiles();
			if (files != null)
			{
				for (int curFileIdx = 0; curFileIdx < files.length; curFileIdx++)
				{
					if (files[curFileIdx].isDirectory())
					{
						FileUtil.deleteTempDirectory(files[curFileIdx]);
					}
					files[curFileIdx].delete();
				}
			}
			tempDirectory.delete();
		}
	}

	public static String getExtension(String fileOrUrl)
	{
		Validate.notEmpty(fileOrUrl);
		String extension = "";
		try
		{
			extension = getFileExtension(new URL(fileOrUrl).getPath());
		} catch (MalformedURLException e)
		{
			// Not a URL, so try parsing it as a file
			extension = getFileExtension(fileOrUrl);
		}
		return extension;
	}

	public static void writeStringToFile(String stringToWrite, String filename) throws IOException
	{
		OutputStream os = new FileOutputStream(filename);
		os.write(stringToWrite.getBytes());
		os.close();
	}

	private static String getFileExtension(String file)
	{
		String extension = "";
		String fileName = new File(file).getName();
		int idxOfDot = fileName.lastIndexOf('.');
		if (idxOfDot != -1)
		{
			extension = fileName.substring(idxOfDot + 1);
		}
		return extension;
	}
	
	public static String getSeparator()
	{
		return System.getProperty("file.separator");
	}
	
}
