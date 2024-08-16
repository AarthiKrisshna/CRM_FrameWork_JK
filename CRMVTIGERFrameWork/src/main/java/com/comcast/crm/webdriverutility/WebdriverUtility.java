package com.comcast.crm.webdriverutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility 
{
	public WebDriverWait driverWait(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait;
	}
	public Actions action(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	public Select select(WebElement element)
	{
		Select select=new Select(element);
		return select;
	}
	public void preConditions(WebDriver driver)
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void minimizeAndQuitTheBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
		driver.quit();
	}
	public void waitForElement(WebDriver driver,WebElement element)
	{
		
		driverWait(driver).until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForelementToCLick(WebDriver driver,WebElement element)
	{
		
		driverWait(driver).until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForalertIsPresent(WebDriver driver)
	{
		
		driverWait(driver).until(ExpectedConditions.alertIsPresent());
	}
	
   public void switchToNewTab(WebDriver driver,String partialurl)
   {
	   Set<String> wid = driver.getWindowHandles();
	   Iterator<String> it=wid.iterator();
	   while(it.hasNext())
	   {
		   String windowid=it.next();
		  String currenturl= driver.switchTo().window(windowid).getCurrentUrl();
		  if(currenturl.contains(partialurl))
		  {
			  break;
		  }
	   }
	   }
   public void switchToTabBasedOnTitle(WebDriver driver,String partialTitle)
   {
	   Set<String> wid = driver.getWindowHandles();
	   Iterator<String> it=wid.iterator();
	   while(it.hasNext())
	   {
		   String windowid=it.next();
		  String title= driver.switchTo().window(windowid).getTitle();
		  if(title.contains(partialTitle))
		  {
			  break;
		  }
	   }
	   }
   public void switchToFrame(WebDriver driver,int index)
   {
	   driver.switchTo().frame(index);
   }
   public void switchToFrame(WebDriver driver,String nameOrId)
   {
	   driver.switchTo().frame(nameOrId);
   }
   public void switchToFrame(WebDriver driver,WebElement element)
   {
	   driver.switchTo().frame(element);
   }
   public void switchToAlertANdAccept(WebDriver driver)
   {
	   driver.switchTo().alert().accept();
   }
   public void switchToAlertANDismmis(WebDriver driver)
   {
	   driver.switchTo().alert().dismiss();
   }
   public void switchToParentFrame(WebDriver driver)
   {
	   driver.switchTo().parentFrame();
   }
   public void switchToDefaultMainPage(WebDriver driver)
   {
	   driver.switchTo().defaultContent();
   }
   public void selectDropdownByVisibleText(WebElement element,String visibletext)
   {
	
	   select(element).selectByVisibleText(visibletext);
   }
   public void selectDropdownByValue(WebElement element,String Value)
   {
	   
	   select(element).selectByValue(Value);
   }
   public void selectDropdownByIndex(WebElement element,int index)
   {
	   select(element).selectByIndex(index);
   }
   public void mouseOverActions(WebDriver driver,WebElement element)
   {
	  
	   action(driver).moveToElement(element).perform();
   }
   public void doubleClick(WebDriver driver,WebElement element)
   {
	  
	   action(driver).doubleClick(element).perform();
   }
   public void dragAndDrop(WebDriver driver,WebElement sourceelement,WebElement destelement)
   {
	  
	   action(driver).dragAndDrop(sourceelement,destelement).perform();
   }
   public void rightClick(WebDriver driver,WebElement element)
   {
	  
	   action(driver).contextClick(element).perform();
   }
   public void sendKeysIntoElement(WebDriver driver,WebElement element,String data)
   {
	   action(driver).sendKeys(element,data).perform();
   }
   public void scrollDownToElement(WebDriver driver,WebElement element)
   {
	   action(driver).scrollToElement(element).perform(); 
   }
  public void webElementScreenshot(WebElement element,String name) throws IOException
  {
	  JavaUtility ju=new JavaUtility();
      File ts =element.getScreenshotAs(OutputType.FILE);
      File perms=new File("./bugs/"+name+" "+ju.getLocalDateAndTime()+".png");
      FileUtils.copyFile(ts, perms);
  }
  public void webPageScreenshot(WebDriver driver,String pagename) throws IOException
  {
	  JavaUtility ju=new JavaUtility();
	  TakesScreenshot tss=(TakesScreenshot) driver;
	   File ts=tss.getScreenshotAs(OutputType.FILE);
	   File perms=new File("./pageshot/"+pagename+" "+ju.getLocalDateAndTime()+".png");
	   FileUtils.copyFile(ts, perms);
  }
  public void javaScriptScrollDown(WebDriver driver,int scrollamount)
  {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,"+scrollamount+");");
  }
  public void javaScriptScrollUntilElementVisible(WebDriver driver,WebElement element)
  {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	 int y= element.getLocation().getY();
	 js.executeScript("window.scrollBy(0,"+y+");",element);
  }
  public void robotClass(WebDriver driver) throws AWTException
  {
	  Robot rob=new Robot();
  }
  
 
   
}
