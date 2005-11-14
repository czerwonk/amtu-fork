package com.amazon.merchants.transport.preferences;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import com.amazon.merchants.transport.model.MerchantAccount;
import com.amazon.merchants.transport.util.TransportPingUtility;
import com.amazon.merchants.util.ConfigResource;
import com.amazon.merchants.util.interaction.InputTypeEnum;
import com.amazon.merchants.util.interaction.TextMenuUtil;


public class Configure
{
    // for now, this is to get this to compile.  In the addormodifyaccount method,
    // this flag probably shouldn't be used.  the existing prefs should be referenced, most likely
    private static boolean isWS=false;

    public static void main(String[] args)
	{
		Configure configure = new Configure();
		boolean isAdvanced=false;
		TransportPreferences preferences = TransportPreferences.instance();
		System.out.println("Invoking Configure Utility");
		if (args.length > 0 && args[0]!=null)
		{
			if ("-advanced".equals(args[0].trim()))
			{
				isAdvanced=true;
			}
			else if ("-uninstall".equals(args[0].trim()))
			{
				System.out.println("Removing all items from preferences registry.");
				deinstall();
				System.out.println("Registry items removed.");
				return;
			}
			else if ("-ws".equals(args[0].trim())) // specifically for WS naik @10/25
			{
			    System.out.println("Configuring for WS.");
			    isWS=true;
			}
		}
	
		System.out.println("Amazon Merchant Transport Tool Configuration Utility v0.1"+(isAdvanced?" Advanced Mode":""));
		System.out.println("----------------------------------------------------"+(isAdvanced?"--------------":""));
		System.out.println();
		System.out.println("Values in square brackets [] are defaults. To select these, just press Enter.");
		System.out.println();
		
		if (preferences.preferencesExist())
		{
			configure.updateConfiguration(preferences,isAdvanced);
		}
		else
		{
			configure.initialConfiguration(preferences,isAdvanced);
		}
		System.out.println();
		System.out.println("Exiting Application");
	}
	
	public void initialConfiguration(TransportPreferences preferences, boolean isAdvanced)
	{
		System.out.println("Initial Configuration and Setup");
		Properties defaultPreferences = new Properties();
		try
		{
			defaultPreferences.load(new ConfigResource("defaultPreferences.properties").inputStream());
			Enumeration e = defaultPreferences.keys();
			while(e.hasMoreElements())
			{
				String key = (String)e.nextElement();
				preferences.putPreference(TransportPreferenceEnum.getEnum(key),defaultPreferences.getProperty(key));
			}
			
			TransportConfiguration config = preferences.getConfig();
			
			setGlobals(config);
			
			if (isAdvanced)
			{
				while(TextMenuUtil.promptYesNo("Would you like to add a new account?",false))
				{
					addOrModifyAccount(config,TextMenuUtil.promptAndValidate("Enter a unique name for environment","production",InputTypeEnum.STRING),isAdvanced);
				}
			}
			
			else
			{
				addStandardAccounts(config);
			}

			System.out.print("Updating configuration...");
			preferences.store(config);
			preferences.reload();
			System.out.println(" done!");
			System.out.println();
			System.out.println("To alter this configuration, please use the Configuration Utility in the directory you installed this application.");
		}
		catch (IOException iox)
		{
			System.out.println("Could not open default preferences file due to "+iox.getMessage());
		}	
	}

	public void updateConfiguration(TransportPreferences preferences, boolean isAdvanced)
	{
		TransportConfiguration config = preferences.getConfig();
		int choice=99;
		
		do
		{	
			ArrayList options = new ArrayList();
			options.add("Exit configuration utility");
			options.add("View/Modify application preferences");
			options.add("View/Modify a configuration account");
			options.add("Remove a configuration account");
			options.add("Add a configuration account");
			options.add("Add Amazon Web Servcies Information");
			
			switch(choice=TextMenuUtil.promptChoice("What would you like to do?",0,((String []) options.toArray(new String[0]))))
			{
				case 1:
					setGlobals(config);
					break;
				case 2:
					modifyAccount(config,isAdvanced);
					break;
				case 3:
					removeAccount();
					break;
				case 4:
					if (isAdvanced)
					{
						addOrModifyAccount(config,TextMenuUtil.promptAndValidate("Enter a unique name for environment","production",InputTypeEnum.STRING),isAdvanced);
					}
					else
					{
						addStandardAccounts(config);
					}
					break;
			}
			System.out.print("Updating configuration...");
			preferences.store(config);
			preferences.reload();
			System.out.println(" done!");

		} while (choice > 0);
	}
	
	private void setGlobals(TransportConfiguration config)
	{
		// Transport Root Folder
		File workingDir = new File(System.getProperty("user.dir"));
		// Default directory is two levels up from current.
		workingDir = workingDir.getParentFile().getParentFile();
		String defaultDir = workingDir.getAbsolutePath()+File.separator+"DocumentTransport";
		System.out.println("Press Enter key to accept default or supply a base directory where reports will be stored and files will be dispatched.");
		config.setRootFolder(TextMenuUtil.promptAndCreateDirectory("Enter directory",config.getRootFolder()==null?defaultDir:config.getRootFolder()));
		// Is Flatfile
		int retVal = TextMenuUtil.promptChoice("Choose what format you would prefer to receive your reports in",config.isFlatFile()?1:0,new String[]{"xml","text file"});
		config.setFlatFile((retVal==1));
		// Monitor Notify Email Address
		config.setMonitorNotifyEmail(TextMenuUtil.promptAndValidate("Enter an email address that will be used for application status notifications",config.getMonitorNotifyEmail()==null?"":config.getMonitorNotifyEmail(),InputTypeEnum.EMAIL));
		// Monitor Notify SMTP Server
		config.setMonitorSMTPServer(TextMenuUtil.promptAndValidate("Enter the address of your smtp mail server (ask your mail administrator if you do not know what this is)",config.getMonitorSMTPServer()==null?"mail":config.getMonitorSMTPServer(),InputTypeEnum.DOMAIN));		
	}
	
	private void addOrModifyAccount(TransportConfiguration config, String environmentName, boolean isAdvanced)
	{
		boolean done;
		do
		{
			done=true;
			System.out.println("Editing account for "+environmentName);
			// Check for predefined URL values for this
			MerchantAccount account = UserAccountPreferences.instance().getAccount(environmentName);
			account.setEnvironmentName(environmentName);
			// Merchant Full Name
			account.setMerchantName(TextMenuUtil.promptAndValidate("Enter merchant legal name",account.getMerchantName()==null?"":account.getMerchantName(),InputTypeEnum.STRING));
			// Merchant User Name
			account.setUsername(TextMenuUtil.promptAndValidate("Enter your Amazon.com username for this account",account.getUsername()==null?"":account.getUsername(),InputTypeEnum.EMAIL));
			// Merchant Password
			String password = TextMenuUtil.promptAndValidate("Enter your Amazon.com password for this account","********",InputTypeEnum.STRING);
			if (isWS) {
			    account.setAccessKey(TextMenuUtil.promptAndValidate("Enter your Amazon Developer Access key",account.getAccessKey()==null?"":account.getAccessKey(),InputTypeEnum.STRING));
			    account.setSecretAccessKey(TextMenuUtil.promptAndValidate("Enter your Amazon Developer Secret Access key",account.getSecretAccessKey()==null?"":account.getSecretAccessKey(),InputTypeEnum.STRING));
			}
			if (!"********".equals(password))
			{
				account.setPassword(password);
			}
			// Merchant Token
			account.setToken(TextMenuUtil.promptAndValidate("Enter your Amazon.com token (e.g. Q_M_MYNAME_1023) for this account",account.getToken()==null?"":account.getToken(),InputTypeEnum.STRING));
			if (isAdvanced || account.getMerchantURL()==null)
			{
				int choice = TextMenuUtil.promptChoice("Select the url you wish to use",1,new String[]{"MIP","Production","Other URL"});
				switch(choice)
				{
					case 0:
						account.setMerchantURL(UserAccountPreferences.instance().getPreference("mip",UserAccountPreferenceEnum.MERCHANT_URL));
						break;
					case 1:
						account.setMerchantURL(UserAccountPreferences.instance().getPreference("production",UserAccountPreferenceEnum.MERCHANT_URL));
						break;
					case 2:
						account.setMerchantURL(TextMenuUtil.promptAndValidate("Enter the URL address for the amazon soap server you wish to use","",InputTypeEnum.URL));
						break;
				}
			}
			System.out.println("Please standby while your account details are verified...");
			String status = TransportPingUtility.pingServer(account);
			System.out.println(status);
			if (status != TransportPingUtility.SUCCESS)
			{
				done = TextMenuUtil.promptYesNo("Would you like to save account configuration and continue anyway?",false);
			}
			config.addAccount(account);
			
		} while (!done);
	}
	
	private void removeAccount()
	{
		try
		{
			String [] envs = UserAccountPreferences.instance().getEnvironments();
			String [] options = new String[envs.length+1];
			System.arraycopy(envs,0,options,0,envs.length);
			options[options.length-1]="Do not remove any accounts";
			int choice = TextMenuUtil.promptChoice("Which account would you like to remove?",options.length-1,options);
			if (choice != options.length-1)
			{
				UserAccountPreferences.instance().removeAccount(options[choice]);
				System.out.println("Note this will only result in the account being removed. The directory will remain, but will no longer be monitored.");
			}
		}
		catch(PreferencesException pex)
		{
			System.out.println("No accounts found");
		}
	}
	
	private void modifyAccount(TransportConfiguration config, boolean isAdvanced)
	{
		try
		{
			String [] envs = UserAccountPreferences.instance().getEnvironments();
			String [] options = new String[envs.length+1];
			System.arraycopy(envs,0,options,0,envs.length);
			options[options.length-1]="Do not modify any accounts";
			int choice = TextMenuUtil.promptChoice("Which account would you like to modify?",options.length-1,options);
			if (choice != options.length-1)
			{
				addOrModifyAccount(config,options[choice],isAdvanced);
			}
		}
		catch(PreferencesException pex)
		{
			System.out.println("No accounts found");
		}
	}
	
	private static void deinstall()
	{
		try
		{
			String [] envs = UserAccountPreferences.instance().getEnvironments();
			for (int i=0;i<envs.length;i++)
			{
				UserAccountPreferences.instance().removeAccount(envs[i]);
			}
		}
		catch(PreferencesException pex)
		{
			System.out.println("No accounts found to remove");
		}
		TransportPreferences.instance().removeAll();
	}
	
	private void addStandardAccounts(TransportConfiguration config)
	{
		boolean hasMIP=false;
		boolean hasProd=false;
		
		try
		{
			String [] envs = UserAccountPreferences.instance().getEnvironments();
			if (envs!=null)
			{
				for (int i=0;i<envs.length;i++)
				{
					if ("mip".equals(envs[i]))
					{
						hasMIP = true;
					}
					else if ("production".equals(envs[i]))
					{
						hasProd=true;
					}
				}
			}
		}
		catch (PreferencesException pex){}
		
		if (hasMIP && hasProd)
		{
			System.out.println("You already have both MIP and Production accounts. Either edit existing accounts or remove one to be able to add.");
			return;
		}
	
		boolean done=false;

		while (!done)
		{
			System.out.println("Adding account details");
			if (!hasMIP && TextMenuUtil.promptYesNo("Do you require a MIP (Merchant Integration Platform) account for testing?",false))
			{
				hasMIP = true;
				addOrModifyAccount(config,"mip",false);
			}
					
			if (!hasProd && TextMenuUtil.promptYesNo("Do you require a Production account at this time?",false))
			{
				hasProd = true;
				addOrModifyAccount(config,"production",false);
			}
			// If they didnt add any accounts, make sure this is right.
			done = hasMIP||hasProd?true:TextMenuUtil.promptYesNo("You have not entered any account details which means the tool will not run. Are you sure this is what you want to do?",false);
		}		
	}
}
