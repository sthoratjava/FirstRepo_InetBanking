package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}	
	
 /* @FindBy -- if you use PageObject pattern then you adds this annotation to class members
 * and WebDriver automatically inject appropriate WebElements to it during
 * object initialization (when PageFactory.initElements() called). 
 */

	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement txtbtnLogin;

	@FindBy(name="btnReset")
	@CacheLookup
	WebElement txtbtnReset;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void SetUserName(String uname)
	{
		
		txtUserName.sendKeys(uname);
	}
	
	public void SetPassword(String pword)
	{
		
		txtPassword.sendKeys(pword);
	}
	
	public void clickSubmit()
	{
		
		txtbtnLogin.click();
	}
	public void clickLogout()
	{
	
		lnkLogout.click();
	}
	
}