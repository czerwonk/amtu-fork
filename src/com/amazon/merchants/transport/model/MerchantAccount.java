/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.transport.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class MerchantAccount implements Serializable
{
	private String username;
	private String password;
	private String token;
	private String merchantName;
	private String merchantURL;
	private String environmentName;
	
	/**
	 * 
	 */
	public MerchantAccount()
	{
		super();
	}

	public MerchantAccount(String username, String password, String token, String merchantName, String merchantURL, String environmentName)
	{
		this.username = username;
		this.password = password;
		this.token = token;
		this.merchantName = merchantName;
		this.merchantURL = merchantURL;
		this.environmentName = environmentName;
	}

	/**
	 * @return
	 */
	public String getMerchantName()
	{
		return merchantName;
	}

	/**
	 * @return
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @return
	 */
	public String getToken()
	{
		return token;
	}

	/**
	 * @return
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param string
	 */
	public void setMerchantName(String string)
	{
		merchantName = string;
	}

	/**
	 * @param string
	 */
	public void setPassword(String string)
	{
		password = string;
	}

	/**
	 * @param string
	 */
	public void setToken(String string)
	{
		token = string;
	}

	/**
	 * @param string
	 */
	public void setUsername(String string)
	{
		username = string;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object arg0)
	{
		if (arg0 == null || !(arg0 instanceof MerchantAccount))
		{
			return false;
		}
		
		MerchantAccount rhs = (MerchantAccount) arg0;
		return new EqualsBuilder()
								.appendSuper(super.equals(arg0))
								.append(username,rhs.username)
								.append(password,rhs.password)
								.append(token,rhs.token)
								.append(merchantName,rhs.merchantName)
								.append(merchantURL,rhs.merchantURL)
								.isEquals();
	}
	

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(31, 53).
		  append(username).
		  append(password).
		  append(token).
		  append(merchantName).
		  append(merchantURL).
		  toHashCode();
	}
	/**
	 * @return
	 */
	public String getMerchantURL()
	{
		return merchantURL;
	}

	/**
	 * @param string
	 */
	public void setMerchantURL(String string)
	{
		merchantURL = string;
	}
	
	public String toString()
	{
		return new StringBuffer().
		append(username).
		append(password).
		append(token).
		append(merchantName).
		append(merchantURL).
		toString();
	}

	/**
	 * @return
	 */
	public String getEnvironmentName()
	{
		return environmentName;
	}

	/**
	 * @param string
	 */
	public void setEnvironmentName(String string)
	{
		environmentName = string;
	}

}
