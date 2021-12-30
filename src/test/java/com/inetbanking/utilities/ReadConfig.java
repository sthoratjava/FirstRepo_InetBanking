package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties Prop;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties"); 
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			Prop = new Properties();
			Prop.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url = Prop.getProperty("baseUrl");
		return url;
		
	}
	public String getUserName()
	{
		String username = Prop.getProperty("Uname");
		return username;
		
	}
	public String getPassword()
	{
		String password = Prop.getProperty("Password");
		return password;
		
	}
	public String getChrome()
	{
		String chromepath = Prop.getProperty("chromepath");
		return chromepath;
		
	}public String getIE()
	{
		String iepath = Prop.getProperty("iepath");
		return iepath;
		
	}public String getEdge()
	{
		String edgepath = Prop.getProperty("edgepath");
		return edgepath;
		
	}	 

}
