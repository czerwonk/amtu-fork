/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.adapter;

import java.util.HashMap;
import java.util.Iterator;

import com.amazon.merchants.transport.adapter.impl.MerchantsAtConnectorMGSImpl;
import com.amazon.merchants.transport.adapter.impl.MerchantsAtConnectorAWSImpl;
import com.amazon.merchants.transport.model.MerchantAccount;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class MerchantsAtConnectorFactory
{
	// Cache an instance of this per set of credentials
	private HashMap instances=new HashMap();
	private static final MerchantsAtConnectorFactory _instance = new MerchantsAtConnectorFactory();
	private MerchantsAtConnectorFactory(){};

	public static MerchantsAtConnectorFactory instance()
	{
		return _instance;
	}
	
	public synchronized MerchantsAtConnector getMerchantsAtConnector(MerchantAccount credentials) throws MerchantsAtConnectorException
	{
		// Using the string of merchant account as using the object did not work despite hash equality
		MerchantsAtConnector connector = (MerchantsAtConnector)instances.get(credentials.toString());
		
		if (connector==null)
		{
			connector = new MerchantsAtConnectorMGSImpl(credentials);
			// add logic to determine which to add to hash map  ~swm
            //connector = new MerchantsAtConnectorAWSIm pl(credentials);
			instances.put(credentials.toString(),connector);
		}
		return connector;
	}
	
	public void resetCache()
	{
		// Extra careful destruction of the hashmap
		for (Iterator i = instances.keySet().iterator();i.hasNext();instances.remove(i.next()));
		instances = new HashMap();
	}
}
