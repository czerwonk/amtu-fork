package com.amazon.merchants.util;


public class ConfigResource extends Resource
{

	public ConfigResource(String resourceName)
	{
		super(resourceName);
	}

	protected String resourceSubDirectory()
	{
		return "conf";
	}

}
