package com.amazon.merchants.util;

import java.io.*;
import java.net.URL;

import org.apache.commons.logging.*;

import com.amazon.merchants.util.file.IO;

public abstract class Resource
{
	private static final Log log = LogFactory.getLog(Resource.class);

	private String resourceName;

	public Resource(String resourceName)
	{
		this.resourceName = resourceName;
	}

	public InputStream inputStream()
	{
		InputStream inputStream = null;
		String filePath = resourceFilePath();
		try
		{
			inputStream = new FileInputStream(filePath);
		} catch (IOException ignored)
		{}
		if (inputStream == null)
		{
			ClassLoader classLoader = this.getClass().getClassLoader();

			try
			{
				inputStream = classLoader.getResourceAsStream(filePath);
			} catch (Exception ignored)
			{
				log.error("Unable to load " + resourceFilePath());
			}
		}
		return inputStream;
	}

	public URL url()
	{
		URL url = null;
		try
		{
			File file = new File(resourceFilePath());
			if (file.exists())
			{
				url = file.toURL();
			}
		} catch (IOException ignored)
		{
			//ignored.printStackTrace();
		}
		if (url == null)
		{
			ClassLoader classLoader = this.getClass().getClassLoader();

			try
			{
				url = classLoader.getResource(resourceFilePath());
			} catch (Exception ignored)
			{
				log.error("Unable to load " + resourceFilePath());
			}
		}
		return url;
	}

	public String asString()
	{
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
		try
		{
			toStream(bStream);
		} catch (IOException e)
		{
			log.error("Unable to load " + resourceFilePath(), e);
		}
		return bStream.toString();
	}

	public byte[] asBytes()
	{
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
		try
		{
			toStream(bStream);
		} catch (IOException e)
		{
			log.error("Unable to load " + resourceFilePath(), e);
		}
		return bStream.toByteArray();
	}

	public void toStream(OutputStream oStream) throws IOException
	{
		IO.copyStream(inputStream(), oStream);
	}

	public void toFile(File file) throws IOException
	{
		toStream(new FileOutputStream(file));
	}

	protected abstract String resourceSubDirectory();

	protected String resourceDirectory()
	{
		return "resources/" + resourceSubDirectory();
	}

	protected String resourceFilePath()
	{
		return resourceDirectory() + "/" + resourceName();
	}

	protected String resourceName()
	{
		return this.resourceName;
	}

}
