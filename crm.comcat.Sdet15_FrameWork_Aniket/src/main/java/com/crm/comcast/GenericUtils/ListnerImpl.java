package com.crm.comcast.GenericUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImpl implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		//@Test
		 test=extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//@AfterMethod
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//@AfterMethod
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
	try {
		String sysDate=new JavaUtility().currentDate();
		String path = new WebDriverUtils().takeScreenShot(BaseClass.staticDriver, 
				result.getMethod().getMethodName()+"_"+sysDate);
		test.addScreenCaptureFromPath(path);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//@AfterMethod
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	@Override
	public void onStart(ITestContext context) {
		//On start act like Before Suite
		String sysDate=new JavaUtility().currentDate();
		
		ExtentSparkReporter htmlReporter=
				new ExtentSparkReporter(IPathConstants.EXTENT_REPORT+sysDate+".html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Vtiger V5");
		htmlReporter.config().setReportName("Regression");
		
		 extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		propertiesfileUtility pLib = new propertiesfileUtility();
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Platform", "Windows 10");
		try {
			extent.setSystemInfo("App Url", pLib.readDatafromProperrtyFile("url"));
			extent.setSystemInfo("Browser Type", pLib.readDatafromProperrtyFile("browser"));
			extent.setSystemInfo("Reporter Name", "Nithesh");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//After suite
		extent.flush();
	}

}
