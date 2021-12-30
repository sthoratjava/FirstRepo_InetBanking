package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test; 

import com.inetbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass

{
	@Test
	public void LoginTest() throws IOException
	{
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.SetUserName(Uname);
		logger.info("entered Username");
		
		lp.SetPassword(Password);	
		logger.info("Entered Password ");
		
		lp.clickSubmit();
		logger.info("Clicked submit");
		
		if(driver.getTitle().equals(" Guru99 Bank Home Page "))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver,"LoginTest" );
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}
}
