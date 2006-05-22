/*
 * Created on May 19, 2004
 *
 */
package com.amazon.merchants.util.interaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 * Copyright 2004 Amazon.com
 * 
 * Description:
 * 
 * @author hynoskij
 *
 */
public class TextMenuUtil
{	
	private static HashSet bipolarValues=new HashSet(Arrays.asList(new String[]{"yes","y","no","n"}));
	
	public static String promptAndValidate(String prompt, String defaultValue,InputTypeEnum validationType)
	{
		Validate.notNull(prompt);
		Validate.notNull(validationType);
		String input=null;
		
		while (input==null)
		{
			displayPrompt(prompt,defaultValue);
			input = readLine();
			input = (input==null||"".equals(input))?defaultValue:input;
			try
			{
				InputValidator.validate(input,validationType);
			}
			catch(InvalidDataException idx)
			{
				System.out.println("Invalid Data Entered: "+idx.getMessage());
				System.out.println("Please re-enter value.");
				input=null;
			}
		}
				
		return input;
	}

	public static String promptAndCreateDirectory(String prompt, String defaultValue)
	{
		Validate.notNull(prompt);
		String input=null;
				
		while (input==null)
		{
			displayPrompt(prompt,defaultValue);			
			input = readLine();
			input = (input==null||"".equals(input))?defaultValue:input;
			try
			{
				InputValidator.validate(input,InputTypeEnum.DIRECTORY);
			}
			catch(InvalidDataException idx)
			{
				if (idx.getRootCauseException() instanceof FileNotFoundException)
				{
					if (TextMenuUtil.promptYesNo("Directory does not exist. Would you like directory to be created?",true))
					{
						File directory = new File(input);
						directory.mkdirs();
						return input;
					}
				}
				else
				{
					System.out.println("Invalid Data Entered: "+idx.getMessage());
				}
				System.out.println("Please re-enter value.");
				input=null;
			}
		}
				
		return input;
	}

	
	public static int promptChoice(String prompt,int defaultValue,String [] choices)
	{
		System.out.println(prompt);
		int choice=defaultValue;

		for (int i=0;i<choices.length;i++)
		{
			System.out.println("\t"+(i+1)+") "+choices[i]);
		}
		
		boolean done=false;
		while(!done)
		{
			displayPrompt("Enter choice",Integer.toString(defaultValue+1));
			String readVal = readLine();
			if (StringUtils.isNumeric(readVal) && !"".equals(readVal))
			{
				int value = Integer.parseInt(readVal);
				if (value <= 0 || value > choices.length)
				{
					System.out.println("Please only enter a value between 1 and "+choices.length);
				}
				else
				{
					choice=value;
					done=true;
				}
			}
			else
			{
				if ("".equals(readVal))
				{
					choice = defaultValue+1;
					done=true;
				}
				else
				{
					System.out.println("Please only enter a numeric value.");
				}
			}
		}
		
		return choice-1;
	}

	public static boolean promptYesNo(String prompt, boolean defaultValue)
	{
		boolean output=false;
		String input=null;
		while(input==null||!bipolarValues.contains(input.toLowerCase()))
		{
			displayPrompt(prompt,defaultValue?"Yes":"No");
			input = readLine();
			if (input != null)
			{
				if (input.equals(""))
				{
					input = "Y";
					output = defaultValue;
				}
				else
				{
					output = stringToBoolean(input);
				}
			}
		}
		return output;
	}
	
	public static void pause()
	{
		System.out.print("Press the enter key to continue...");
		readLine();
		System.out.println();
	}
	
	private static final boolean stringToBoolean(String input)
	{
		boolean val = Boolean.getBoolean(input);
		if (!val)
		{
			if (input.equalsIgnoreCase("yes")||input.equalsIgnoreCase("y"))
			{
				val=true;
			}
		}
		return val;
	}
	
	private static void displayPrompt(String prompt, String defaultValue)
	{
		StringBuffer buffer = new StringBuffer(prompt)
								.append(" [")
								.append(defaultValue==null?"":defaultValue)
								.append("]: ");
		System.out.print(buffer);
	}
		
	private static String readLine()
	{
		String input=null;
		try
		{
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			input = buf.readLine().trim();
		}
		catch(IOException iox)
		{
			// Ignore IO exceptions on standard in
		}
		
		return input;
	}
}
