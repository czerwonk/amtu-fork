/*
 * Created on Apr 8, 2004
 *
 */
package com.amazon.merchants.util.interaction;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.enum.Enum;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class InputTypeEnum extends Enum implements Serializable
{
	private String pattern;
	private boolean existCheck;
	private String message;
	 
	// Pattern Cases
	public static final InputTypeEnum INTEGER = new InputTypeEnum("Integer","(^-?\\d\\d*$)",false,"Not a valid integer. Must be a number with no decimal points.");
	public static final InputTypeEnum DECIMAL = new InputTypeEnum("Decimal","^[+-]?([0-9]*\\.?[0-9]+|[0-9]+\\.?[0-9]*)([eE][+-]?[0-9]+)?$",false,"Not a valid decimal. Must be a standard number with no alphabetic characters and only a single decimal point");
	public static final InputTypeEnum STRING = new InputTypeEnum("String",".+",false,"Must be a non-empty string");
	public static final InputTypeEnum EMAIL = new InputTypeEnum("Email","(^[a-zA-Z0-9]([a-zA-Z0-9_\\-\\.]*)@([a-zA-Z0-9_\\-]+)([.][a-zA-Z0-9]{3})$)|(^[a-zA-Z0-9]([a-zA-Z0-9_\\-\\.]*)@([a-zA-Z0-9_\\-\\.]*)(\\.[a-zA-Z0-9]{2})(\\.[a-zA-Z0-9]{2})*$)",false,"Invalid Email Address. Address should be of the form name@address.extension");

	// Special Cases
	public static final InputTypeEnum FILE = new InputTypeEnum("File",STRING.getPattern(),true,"File does not exist or is invalid.");
	public static final InputTypeEnum DIRECTORY = new InputTypeEnum("Directory",STRING.getPattern(),true,"Directory does not exist or is invalid.");
	public static final InputTypeEnum DOMAIN = new InputTypeEnum("Domain",STRING.getPattern(),true,"Domain is invalid or blank.");
	public static final InputTypeEnum URL = new InputTypeEnum("URL",STRING.getPattern(),true,"URL is invalid or blank.");
	
	/**
	 * Enum made private - users should not create their own
	 */
	private InputTypeEnum(String name, String pattern, boolean existCheck, String message)
	{
		super(name);
		this.pattern = pattern;
		this.existCheck = existCheck;
		this.message = message;
	}
	
	public static InputTypeEnum getEnum(String status) {
	  return (InputTypeEnum) getEnum(InputTypeEnum.class, status); 
	}
 
	public static Map getEnumMap() {
	  return getEnumMap(InputTypeEnum.class);
	}
 
	public static List getEnumList() {
	  return getEnumList(InputTypeEnum.class);
	}
 
	public static Iterator iterator() {
	  return iterator(InputTypeEnum.class);
	}
	/**
	 * @return
	 */
	public boolean isExistCheck()
	{
		return existCheck;
	}

	/**
	 * @return
	 */
	public String getMessage()
	{
		return message;
	}

	/**
	 * @return
	 */
	public String getPattern()
	{
		return pattern;
	}

}
