/*
 * Created on Apr 13, 2004
 *
 */
package com.amazon.merchants.transport.adapter.util;

import java.lang.reflect.Constructor;
import java.text.MessageFormat;

import org.apache.axis.AxisFault;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazon.merchants.transport.adapter.MerchantsAtConnectorException;
import com.amazon.merchants.transport.adapter.UnrecognizedMerchantException;
import com.amazon.merchants.transport.model.AmazonSoapReturnCodeEnum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description: This class deals with MerchantsAtAdapterExceptions as needed
 * 
 * @author hynoskij
 *
 */
public final class ErrorMapper
{
	private static final ErrorMapper _instance = new ErrorMapper();
	private static Log log = LogFactory.getLog(ErrorMapper.class);	
	
	private ErrorMapper(){}
	
	public static ErrorMapper instance()
	{
		return _instance;
	}
	
	/**
	 * This method takes action on errors returned from the connector and 
	 * takes action upon them. If they are severe enough, it will also throw
	 * a wrapped MerchantsAtConnectorException with a more meaningful exception
	 * type and explanation.
	 * 
	 * @param exception
	 * @throws MerchantsAtConnectorException
	 */
	public void handleException(Exception exception) throws MerchantsAtConnectorException
	{
		if (exception instanceof AxisFault)
		{
			handleAxisFault((AxisFault)exception);
		}
		else if (exception instanceof MerchantsAtConnectorException)
		{
			throw (MerchantsAtConnectorException)exception;
		}
		else
		{
			throw new MerchantsAtConnectorException("An unknown severe error has occurred",exception);
		}
	}
	
	/*
	 * Wrap up soap faults in a meaningful exception type.
	 * If we don't recognise it, just pass it back in the text.
	 */
	private void handleAxisFault(AxisFault fault) throws MerchantsAtConnectorException
	{
		String source = fault.getFaultCode().getLocalPart();

		if (source.equalsIgnoreCase("http"))
		{
			// Handle all known http errors, else come back and use the default
			handleHttpError(fault);
		}
		generateException(fault.getFaultString().trim(),fault);
	}
	
	public void handleSoapCode(String soapCode) throws MerchantsAtConnectorException
	{
		generateException(soapCode,null);	
	}
	
	private void generateException(String soapCode, Throwable exception) throws MerchantsAtConnectorException
	{
		AmazonSoapReturnCodeEnum soapFaultType = AmazonSoapReturnCodeEnum.getEnum(soapCode);

		if (soapFaultType.equals(AmazonSoapReturnCodeEnum.OTHER)||exception==null)
		{
			String [] parameters = new String [] {soapCode};
			String message = MessageFormat.format(ErrorMessageMappings.instance().getString(soapFaultType.getName()),parameters);
			throw new MerchantsAtConnectorException(message,exception);
		}
		else
		{		
			MerchantsAtConnectorException mAtException = getMappedException(soapFaultType,exception);
			throw mAtException;
		}
	}
	
	public void handleHttpError(AxisFault fault) throws MerchantsAtConnectorException
	{
		if (fault.getFaultReason().indexOf("401")!= -1)
		{
			throw new UnrecognizedMerchantException(MessageFormat.format(ErrorMessageMappings.instance().getString(AmazonSoapReturnCodeEnum.UNRECOGNIZED_MERCHANT.getName()),new String[0]),fault);
		}
	}
	
	private MerchantsAtConnectorException getMappedException(AmazonSoapReturnCodeEnum soapFaultType,Throwable root)	
	{
		MerchantsAtConnectorException exception=null;
		try
		{
			String exceptionMessage = ErrorMessageMappings.instance().getString(soapFaultType.getName());
			String exceptionClassName = ErrorExceptionMappings.instance().getString(soapFaultType.getName());
			Class exceptionClass = Class.forName(exceptionClassName);
			Constructor exceptionCtor = exceptionClass.getConstructor(new Class[] {String.class, Throwable.class});
			exception = (MerchantsAtConnectorException) exceptionCtor.newInstance(new Object[]{exceptionMessage,root});
		}
		catch (Exception ex)
		{
			// If we fall through to here, then just send the subclass as something weird has happened
			if (log.isDebugEnabled())
			{
				log.debug("A reflection error has occurred - throwing default exception",ex);
			}
			exception = new MerchantsAtConnectorException("An unknown error has occurred of type: "+soapFaultType.getName(),root);
		}

		return exception;
	}
}
