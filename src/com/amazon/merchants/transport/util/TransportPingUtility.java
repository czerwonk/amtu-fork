/*
 * Created on May 21, 2004
 *
 */
package com.amazon.merchants.transport.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.axis.AxisFault;

import com.amazon.merchants.transport.adapter.InvalidTokenException;
import com.amazon.merchants.transport.adapter.MerchantsAtConnector;
import com.amazon.merchants.transport.adapter.MerchantsAtConnectorException;
import com.amazon.merchants.transport.adapter.MerchantsAtConnectorFactory;
import com.amazon.merchants.transport.adapter.UnrecognizedMerchantException;
import com.amazon.merchants.transport.model.MerchantAccount;
import com.amazon.merchants.transport.model.ReportTypeEnum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class TransportPingUtility
{
	public static final String SUCCESS="Ping was successful";	
	public static final String NETWORK_FAILURE="Could not validate credentials or contact amazon server due to network failure.";
	public static final String CREDENTIAL_FAILURE="Username and password or merchant token entered are not valid on the amazon.com soap server.";
	public static final String TOKEN_FAILURE="The merchant token entered is invalid, does not match the expected value or has been blocked on the amazon.com server.";
	public static final String OTHER_FAILURE="An unknown error has occurred while trying to validate credentials.";
	
	public static String pingServer(MerchantAccount account)
	{
		try
		{
			MerchantsAtConnector connector = MerchantsAtConnectorFactory.instance().getMerchantsAtConnector(account);
			connector.getAllPendingDocumentIds(ReportTypeEnum.ORDER_REPORT,false);
		}
		catch(MerchantsAtConnectorException mex)
		{
			if (mex instanceof UnrecognizedMerchantException)
			{
				return CREDENTIAL_FAILURE;
			}
			else if (mex instanceof InvalidTokenException)
			{
				return TOKEN_FAILURE;
			}
			else if (mex.getRootCauseException() instanceof AxisFault)
			{
				AxisFault af = (AxisFault) mex.getRootCauseException();
				if (af.detail instanceof IOException)
				{
					return NETWORK_FAILURE;
				}
			}
			else
			{
				return OTHER_FAILURE+": "+mex.getMessage();
			}
		}
		return SUCCESS;
	}
	
	public static void main(String [] args) throws Exception
	{
		Properties jUnitProps = new Properties();
		jUnitProps.load(TransportPingUtility.class.getResourceAsStream("/junit-config.properties"));
			
		MerchantAccount creds = new MerchantAccount(
				jUnitProps.getProperty("junit.test.merchantUsername"),
				jUnitProps.getProperty("junit.test.merchantPassword"),
				jUnitProps.getProperty("junit.test.merchantToken"),
				jUnitProps.getProperty("junit.test.merchantName"),
				jUnitProps.getProperty("junit.test.merchantURL"),
				jUnitProps.getProperty("junit.test.environmentName"));
		System.out.println(pingServer(creds));
	}
}
