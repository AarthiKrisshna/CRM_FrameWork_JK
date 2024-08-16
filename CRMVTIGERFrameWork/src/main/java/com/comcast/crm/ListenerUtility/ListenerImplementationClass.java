package com.comcast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseUtility.SampleBaseClass;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.utilityClassObject;


public class ListenerImplementationClass implements ITestListener,ISuiteListener
{
	public static  ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		//ISuiteListener.super.onStart(suite);
		JavaUtility ju=new JavaUtility();
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport/report"+ju.getLocalDateAndTime()+".html");
		spark.config().setDocumentTitle("CRM Test suite Result");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		
		
		//add environment information and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","windows-10");
		report.setSystemInfo("browser","chrome-100");
		System.out.println("report configuration");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		//ISuiteListener.super.onFinish(suite);
		report.flush();
		System.out.println("report backup");
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	    test=report.createTest(result.getMethod().getMethodName());
	    utilityClassObject.setTest(test);
	    test.log(Status.INFO, result.getMethod().getMethodName()+">====Started<======");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
	
		test.log(Status.PASS, result.getMethod().getMethodName()+">====Ended<======");
	}

	@Override
	public void onTestFailure(ITestResult result){
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		String testname=result.getMethod().getMethodName();
		TakesScreenshot edriver=(TakesScreenshot)utilityClassObject.getDriver();
		String filepath=edriver.getScreenshotAs(OutputType.BASE64);
		JavaUtility ju=new JavaUtility();
		String timestamp=ju.getLocalDateAndTime();
		test.addScreenCaptureFromBase64String(filepath, testname+" "+timestamp);
		test.log(Status.FAIL, result.getMethod().getMethodName()+">====failed<======");
		test.log(Status.FAIL,result.getThrowable());
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
		test.log(Status.SKIP,result.getThrowable());
	}


	
 
}
