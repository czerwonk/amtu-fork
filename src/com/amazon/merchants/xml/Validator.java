package com.amazon.merchants.xml;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import org.xml.sax.*;

import com.amazon.merchants.util.Resource;

/**
 * The purpose of this class is to validate XML feeds to the greatest
 * extent possible.  It needs to consider the size of the feed, and the
 * presence or absence of XSDs.
 */
public class Validator
{
	private static final String JAXP_SCHEMA_LANGUAGE =
		"http://java.sun.com/xml/jaxp/properties/schemaLanguage";

	private static final String W3C_XML_SCHEMA =
		"http://www.w3.org/2001/XMLSchema";

	private static final String MISSING_SCHEMA_ERROR = "Cannot find the declaration of element";

	private DocumentBuilderFactory factoryUseSchema, factoryNoSchema;
	private XMLErrorHandler errorHandler;

	public List errors()
	{
		List errors;
		if (errorHandler != null)
		{
			errors = errorHandler.errors();
		} else
		{
			errors = new ArrayList();
		}
		return errors;
	}

	public boolean isValid(File file)
		throws ParserConfigurationException, FactoryConfigurationError, IOException
	{
		if (isValidUsingSchema(new FileInputStream(file)))
		{
			return true;
		} else
		{
			List errors = errors();
			errorHandler = null;
			if (isValidNoSchema(new FileInputStream(file)))
			{
				return isSchemaMissing(errors);
			}
		}
		return false;
	}

	public boolean isValid(Resource xmlResource)
		throws ParserConfigurationException, FactoryConfigurationError, IOException
	{
		if (isValidUsingSchema(xmlResource.inputStream()))
		{
			return true;
		} else
		{
			List errors = errors();
			errorHandler = null;
			if (isValidNoSchema(xmlResource.inputStream()))
			{
				return isSchemaMissing(errors);
			}
		}
		return false;
	}

	/**
	 * Examines errors to see if schema was missing,
	 * or if they are due to actual invalid XML.
	 */
	protected boolean isSchemaMissing(List errors)
	{
		if (errors != null)
		{
			Iterator errorItr = errors.iterator();
			while (errorItr.hasNext())
			{
				String errorMessage =
					((Exception) errorItr.next()).getMessage();
				if (errorMessage.indexOf(MISSING_SCHEMA_ERROR) != -1)
				{
					return true;
				}
			}
		}
		return false;
	}

	protected DocumentBuilderFactory factory(boolean useSchema)
	{
		if (useSchema)
		{
			return factoryUseSchema();
		}
		return factoryNoSchema();
	}

	protected DocumentBuilderFactory factoryUseSchema()
	{
		if (factoryUseSchema == null)
		{
			factoryUseSchema = DocumentBuilderFactory.newInstance();
			factoryUseSchema.setNamespaceAware(true);
			factoryUseSchema.setValidating(true);
			factoryUseSchema.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
		}
		return factoryUseSchema;
	}

	protected DocumentBuilderFactory factoryNoSchema()
	{
		if (factoryNoSchema == null)
		{
			factoryNoSchema = DocumentBuilderFactory.newInstance();
			factoryNoSchema.setNamespaceAware(true);
		}
		return factoryNoSchema;
	}

	protected boolean isValidUsingSchema(InputStream xmlInput)
		throws ParserConfigurationException, FactoryConfigurationError, IOException
	{
		DocumentBuilder builder = factory(true).newDocumentBuilder();
		builder.setErrorHandler(errorHandler());
		try
		{
			builder.parse(new InputSource(xmlInput));
		} catch (SAXException e)
		{
			errorHandler().addError(e);
		}
		return !errorHandler.hasErrors();
	}

	protected boolean isValidNoSchema(InputStream xmlInput)
		throws ParserConfigurationException, FactoryConfigurationError, IOException
	{
		DocumentBuilder builder = factory(false).newDocumentBuilder();
		builder.setErrorHandler(errorHandler());
		try
		{
			builder.parse(new InputSource(xmlInput));
		} catch (SAXException e)
		{
			errorHandler().addError(e);
		}
		return !errorHandler.hasErrors();
	}

	protected XMLErrorHandler errorHandler()
	{
		if (errorHandler == null)
		{
			errorHandler = new XMLErrorHandler();
		}
		return errorHandler;
	}

}