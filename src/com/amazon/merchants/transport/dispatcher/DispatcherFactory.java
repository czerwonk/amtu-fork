/*
 * Created on Apr 19, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher;

import com.amazon.merchants.transport.dispatcher.impl.DispatcherServiceImpl;
import com.amazon.merchants.transport.dispatcher.impl.FileContentIdentifier;
import com.amazon.merchants.transport.dispatcher.impl.PreprocessorImpl;
import com.amazon.merchants.transport.dispatcher.impl.RecognizerImpl;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class DispatcherFactory
{
	private static final DispatcherFactory _instance = new DispatcherFactory();
	private DispatcherFactory(){}

	public static DispatcherFactory instance()
	{
		return _instance;
	}
	
	public Recognizer getRecognizer()
	{
		return RecognizerImpl.instance();
	}

	public FileIdentifier getFileIdentifier()
	{
		return FileContentIdentifier.instance();
	}

	public Preprocessor getPreprocessor()
	{
		return PreprocessorImpl.instance();
	}

	public DispatcherService getDispatcherService()
	{
		return DispatcherServiceImpl.instance();
	}
}
