package com.amazon.merchants.xml;

import java.util.*;

import org.xml.sax.*;

public class XMLErrorHandler implements ErrorHandler
{
	protected List errorList = new ArrayList();

	public void error(SAXParseException exception) throws SAXException
	{
		errorList.add(exception);
	}

	public void fatalError(SAXParseException exception) throws SAXException
	{
		errorList.add(exception);
	}

	public void warning(SAXParseException exception) throws SAXException
	{
		errorList.add(exception);
	}

	public boolean hasErrors()
	{
		return errorList.size() != 0;
	}

	public List errors()
	{
		return Collections.unmodifiableList(errorList);
	}

	void addError(Exception exception)
	{
		errorList.add(exception);
	}
}
