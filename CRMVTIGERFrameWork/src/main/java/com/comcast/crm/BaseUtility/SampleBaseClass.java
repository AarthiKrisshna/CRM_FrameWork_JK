package com.comcast.crm.BaseUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.DatabaseUtility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectRepository.HomePage;
import com.comcast.crm.objectRepository.LoginPage;
import com.comcast.crm.webdriverutility.JavaUtility;
import com.comcast.crm.webdriverutility.WebdriverUtility;
import com.comcast.crm.webdriverutility.utilityClassObject;




public class SampleBaseClass 
{
	public DatabaseUtility dlib=new DatabaseUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebdriverUtility web=new WebdriverUtility();
	public JavaUtility ju=new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(groups = {"smokeTest","RegressionTest"})
	public void configBS() throws SQLException {
		System.out.println("===============connect to db,report config======================");
		dlib.getDataBaseConnection();
		
	}

	//@Parameters("browser")
	@BeforeClass(groups = {"smokeTest","RegressionTest"})
	public void confidBC() throws IOException {
		System.out.println("=============launch the browser=============");
		String Browser=System.getProperty("browser",flib.getDataFromPropertiesFile("browser"));
		//String Browser=browser;
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver(); 
		}
		else if(Browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		sdriver=driver;
		utilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups = {"smokeTest","RegressionTest"})
	public void  configBM() throws IOException 
	{
		System.out.println("======login to the application=====");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApplication(System.getProperty("url",flib.getDataFromPropertiesFile("url")), System.getProperty("un",flib.getDataFromPropertiesFile("un")),System.getProperty("pwd",flib.getDataFromPropertiesFile("pwd")));
	
	}

	@AfterMethod(groups = {"smokeTest","RegressionTest"})
	public void configAM()
	{
		System.out.println("=====logout of the application=====");
		HomePage hm=new HomePage(driver);
		hm.logout();
	}
	
	@AfterClass(groups = {"smokeTest","RegressionTest"})
	public void configAc() {
		System.out.println("===============close the browser=============");
		web.minimizeAndQuitTheBrowser(driver);
	}
	
	
	@AfterSuite(groups = {"smokeTest","RegressionTest"})
	public void configAC() throws SQLException {
		System.out.println("===================close db,and report back======================");
		dlib.closeDBConnection();
		
	}
	
	
	





}
