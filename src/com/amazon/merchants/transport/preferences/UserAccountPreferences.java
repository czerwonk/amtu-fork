/*
 * Created on May 8, 2004
 *
 */
package com.amazon.merchants.transport.preferences;

import java.util.Collection;
import java.util.Iterator;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.amazon.merchants.transport.TransportClient;
import com.amazon.merchants.transport.logging.AuditLogger;
import com.amazon.merchants.transport.model.MerchantAccount;
import com.amazon.merchants.util.ReversibleCipher;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class UserAccountPreferences
{
	private static final UserAccountPreferences _instance = new UserAccountPreferences();
	private Preferences preferences;
	private Preferences environments;
	private static final Log log = LogFactory.getLog(UserAccountPreferences.class);
	private static final ReversibleCipher cipher = new ReversibleCipher();
	
	public static final UserAccountPreferences instance()
	{
		return _instance;
	}
	
	private UserAccountPreferences()
	{
		preferences = Preferences.systemNodeForPackage(UserAccountPreferences.class);
		environments = Preferences.systemNodeForPackage(TransportClient.class);
	}
	
	public MerchantAccount getAccount(String environmentName)
	{
		byte [] encodedPassword = preferences.getByteArray(UserAccountPreferenceEnum.PASSWORD.getKey(environmentName),null);
		String password = (encodedPassword==null?null:cipher.decode(encodedPassword));
		
		return new MerchantAccount(
			preferences.get(UserAccountPreferenceEnum.USERNAME.getKey(environmentName),""),
			password,
			preferences.get(UserAccountPreferenceEnum.TOKEN.getKey(environmentName),""),
			preferences.get(UserAccountPreferenceEnum.MERCHANT_NAME.getKey(environmentName),""),
			preferences.get(UserAccountPreferenceEnum.MERCHANT_URL.getKey(environmentName),""),
			preferences.get(UserAccountPreferenceEnum.ENVIRONMENT_NAME.getKey(environmentName),""));
	}

	public void putAccount(MerchantAccount account)
	{
		String environmentName = account.getEnvironmentName();
		environments.putBoolean(environmentName,true);
		preferences.put(UserAccountPreferenceEnum.USERNAME.getKey(environmentName), account.getUsername());
		String password = account.getPassword();
		byte [] encodedPassword = null;
		if (password != null && !"".equals(password))
		{
			encodedPassword = cipher.encode(password);
		}
		preferences.putByteArray(UserAccountPreferenceEnum.PASSWORD.getKey(environmentName),encodedPassword);
		preferences.put(UserAccountPreferenceEnum.TOKEN.getKey(environmentName),account.getToken());
		preferences.put(UserAccountPreferenceEnum.MERCHANT_NAME.getKey(environmentName),account.getMerchantName());
		preferences.put(UserAccountPreferenceEnum.MERCHANT_URL.getKey(environmentName),account.getMerchantURL());
		preferences.put(UserAccountPreferenceEnum.ENVIRONMENT_NAME.getKey(environmentName),account.getEnvironmentName());
	}
	
	public String getPreference(String environmentName,UserAccountPreferenceEnum type)
	{
		return preferences.get(type.getKey(environmentName),"");
	}
		
	public String [] getEnvironments() throws PreferencesException
	{
		try
		{
			if (environments.keys()!=null && environments.keys().length>0)
			{
				return environments.keys();
			}
			else
			{
				throw new PreferencesException("Preferences may not have been created - please run configuration application.");
			}
		}
		catch (BackingStoreException bex)
		{
			log.debug(ExceptionUtils.getFullStackTrace(bex));
			AuditLogger.instance().logSeriousError("Could not load environments - preferences may not be set.");
			throw new PreferencesException("Preferences may not have been created - please run configuration application.",bex);
		}
	}
	
	public void reload()
	{
		try
		{
			environments.sync();
			preferences.sync();
		}
		catch (BackingStoreException bex)
		{
			log.debug(ExceptionUtils.getFullStackTrace(bex));
			AuditLogger.instance().logSeriousError("Could not read preferences."); 
		}
	}
	
	public void removeAccount(String environmentName)
	{
		environments.remove(environmentName);
		preferences.remove(UserAccountPreferenceEnum.USERNAME.getKey(environmentName));
		preferences.remove(UserAccountPreferenceEnum.PASSWORD.getKey(environmentName));
		preferences.remove(UserAccountPreferenceEnum.TOKEN.getKey(environmentName));
		preferences.remove(UserAccountPreferenceEnum.MERCHANT_NAME.getKey(environmentName));
		if (!environmentName.equals("mip") && !environmentName.equals("production"))
		{
			preferences.remove(UserAccountPreferenceEnum.MERCHANT_URL.getKey(environmentName));
		}
		preferences.remove(UserAccountPreferenceEnum.ENVIRONMENT_NAME.getKey(environmentName));
	}
	
	public void storeAll(Collection accounts)
	{
		if (accounts!=null)
		{
			Iterator i = accounts.iterator();
			while(i.hasNext())
			{
				MerchantAccount account = (MerchantAccount)i.next();
				putAccount(account);
			}
		}
	}	
}