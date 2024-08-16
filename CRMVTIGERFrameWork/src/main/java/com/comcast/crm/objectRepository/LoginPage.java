package com.comcast.crm.objectRepository;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.webdriverutility.WebdriverUtility;

/**
 * 
 * @author AarthiKrishnamoorthy
 * 
 * contains Login page elements & business lib like login()
 * 
 */
public class LoginPage  extends WebdriverUtility
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(name = "user_name")
	private WebElement username;
	
	public WebElement getUsername() {
		return username;
	}
	@FindBy(name="user_password")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}
	@FindBy(id="submitButton")
	private WebElement login;
	public WebElement getLogin() {
		return login;
	}

/**
 * login to application based on username,password,url
 * @param url
 * @param usernamev
 * @param passwordv
 */


public void loginToApplication(String url,String usernamev,String passwordv)
{
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(url);
	username.sendKeys(usernamev);
	password.sendKeys(passwordv);
	login.click();
}
}
