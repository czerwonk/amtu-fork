/*
 * Created on May 8, 2004
 *
 */
package com.amazon.merchants.transport.preferences;

import org.apache.commons.lang.enum.Enum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class UserAccountPreferenceEnum extends Enum
{
	public static final UserAccountPreferenceEnum ENVIRONMENT_NAME=new UserAccountPreferenceEnum("user.envname");
	public static final UserAccountPreferenceEnum USERNAME=new UserAccountPreferenceEnum("user.username");
	public static final UserAccountPreferenceEnum PASSWORD=new UserAccountPreferenceEnum("user.password");
	public static final UserAccountPreferenceEnum TOKEN=new UserAccountPreferenceEnum("user.token");
	public static final UserAccountPreferenceEnum MERCHANT_NAME=new UserAccountPreferenceEnum("user.name");
	public static final UserAccountPreferenceEnum MERCHANT_URL=new UserAccountPreferenceEnum("user.url");
	
	/**
	 * @param arg0
	 */
	public UserAccountPreferenceEnum(String arg0)
	{
		super(arg0);
	}
	
	public String getKey(String environment)
	{
		return environment+"."+getName();
	}	
}
