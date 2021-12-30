package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.SetUserName(Uname);
		logger.info("User name is provided");
		lp.SetPassword(Password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(4000);
		
		  // click link
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");   // warning message 
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			//lp.clickLogout();
			//Thread.sleep(3000);
			//driver.switchTo().alert().accept();//close logout alert
			//driver.switchTo().defaultContent();
		}	
		
		AddCustomerPage addcust=new AddCustomerPage(driver);		
		addcust.clickAddNewCustomer(); 
		addcust.clickAddNewCustomer(); 
		
/*		if(isAlertPresent()==true)	
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
		}
*/				
		logger.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(2000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(2000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}		
	}	
}