/*
 * Created on Apr 9, 2004
 *
 */
package com.amazon.merchants.util.file;

import java.io.*;

import org.apache.commons.lang.Validate;


/**
 * Based on org.strange.core.utilities.File.IO
 */
public class IO
{
	public static int BUFFER_SIZE = 4 * 1024;

	public static void copyStream(InputStream input, OutputStream output) throws IOException
	{
		copyStream(input, output, true);
	}

	public static void copyStream(InputStream input, OutputStream output, boolean closeStreams)
		throws IOException
	{
		Validate.notNull(input, "InputStream cannot be null");
		Validate.notNull(output, "OutputStream cannot be null");

		try
		{
			byte[] buffer = new byte[BUFFER_SIZE];
			int numBytesRead;

			while ((numBytesRead = input.read(buffer)) != -1)
			{
				output.write(buffer, 0, numBytesRead);
			}
		} finally
		{
			if (closeStreams)
			{
				closeStream(input);
				closeStream(output);
			}
		}
	}

	public static byte[] toByteArray(InputStream input) throws IOException
	{
		return toByteArray(input, true);
	}

	public static byte[] toByteArray(InputStream input, boolean closeStream) throws IOException
	{
		return copyToByteArray(input, closeStream).toByteArray();
	}

	public static String toString(InputStream input) throws IOException
	{
		return copyToByteArray(input, true).toString();
	}

	public static void closeStream(InputStream input)
	{
		try
		{
			if (input != null)
			{
				input.close();
			}
		} catch (IOException ignored)
		{
		}
	}

	public static void closeStream(OutputStream output)
	{
		try
		{
			if (output != null)
			{
				output.close();
			}
		} catch (IOException ignored)
		{
		}
	}

	private static ByteArrayOutputStream copyToByteArray(
		InputStream input,
		boolean closeInputStream)
		throws IOException
	{
		Validate.notNull(input, "InputStream cannot be null");

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		try
		{
			copyStream(input, buffer, closeInputStream);
		} finally
		{
			closeStream(buffer);
		}

		return buffer;
	}
}
