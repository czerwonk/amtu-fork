/*
 * Created on Apr 22, 2004
 *
 */
package com.amazon.merchants.transport.dispatcher;

import java.io.File;

import com.amazon.merchants.transport.model.DocumentTypeEnum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public interface FileIdentifier
{
	DocumentTypeEnum getFileType(File file) throws InvalidDocumentException;
}
