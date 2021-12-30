package com.inetbanking.utilities;


//this is a listener class used to generate extent reports 
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{

	//public ExtentHTMLReporter  htmlReporter;
	public ExtentSparkReporter htmlReporter;
	public ExtentTest  logger;
	public ExtentReports extent;
	
	
	public void onStart(ITestContext testContext)
	{
		Date date = new Date();  
		String timestamp = new SimpleDateFormat("yyyy.MM.DD.HH.mm.ss").format( date);
		String repName = "Test-Report-"+timestamp+".html";
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName );
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "snehal");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Title of the report
		htmlReporter.config().setReportName("Functional Test Automation Report");// name of the report
		htmlReporter.config().setTheme(Theme.DARK); // theme
		
	}

	public void OnTestSuccess(ITestResult tr)
	{
		logger.getExtent().createTest(tr.getName());// create a new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void OnTestFailure(ITestResult tr)
	{
		logger.getExtent().createTest(tr.getName());// create a new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	
		String ScreenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
		File f = new File(ScreenshotPath);
		if(f.exists())
		{
			logger.fail("ScreenShot is below:" + logger.addScreenCaptureFromPath(ScreenshotPath));			
		}			
	}
	
	public void OnTestSkipped(ITestResult tr)
	{
		logger.getExtent().createTest(tr.getName());// create a new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void OnFinish(ITestContext testContext)
	{
		extent.flush();
	}
}

