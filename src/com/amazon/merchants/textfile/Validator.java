package com.amazon.merchants.textfile;

import java.io.*;

import com.amazon.merchants.util.Resource;

/**
 * Right now, this only validates listing files.  I'm not familiar enough
 * with the other text-file feeds to determine valid criteria for
 * evaluating them.
 */
public class Validator
{
	private static final String TEMPLATE_PREFIX = "TemplateType";

	public boolean isValid(File file) throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		return isValid(reader);
	}

	public boolean isValid(Resource resource) throws IOException
	{
		BufferedReader reader =
			new BufferedReader(new InputStreamReader(resource.inputStream()));
		return isValid(reader);
	}

	protected boolean isValid(BufferedReader reader) throws IOException
	{
		String templateLine = reader.readLine();

		boolean isValid = checkTemplateLine(templateLine);
		if (isValid)
		{
			String headerLine = reader.readLine();
			int nTabsInHeader = countTabs(headerLine);

			isValid = verifyTabsInContentLines(reader, nTabsInHeader);
		}
		reader.close();
		return isValid;
	}

	private boolean verifyTabsInContentLines(
		BufferedReader reader,
		int nTabsInHeader)
		throws IOException
	{
		String curLine;
		while ((curLine = reader.readLine()) != null)
		{
			if (countTabs(curLine) != nTabsInHeader)
			{
				return false;
			}
		}
		return true;
	}

	private int countTabs(String headerLine)
	{
		int nTabs = 0;
		int curIdx = -1;
		while ((curIdx = headerLine.indexOf('\t', curIdx+1)) != -1)
		{
			nTabs++;
		}
		return nTabs;
	}

	private boolean checkTemplateLine(String templateLine)
	{
		if (!templateLine.startsWith(TEMPLATE_PREFIX))
		{
			return false;
		}
		return true;
	}
}
