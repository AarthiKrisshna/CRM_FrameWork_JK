package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	public WebElement getContactsLink() {
		return contactsLink;
	}
	@FindBy(linkText = "More")
	private WebElement moreOption;
	
	public WebElement getMoreOption() {
		return moreOption;
	}
	
	@FindBy(xpath = "(//td[@class='small']/img)[1]")
    private WebElement accounticon;
	
	public WebElement getAccounticon() {
		return accounticon;
	}
	@FindBy(linkText ="Campaigns")
	private WebElement campaingslink;
	
	public WebElement getCampaingslink() {
		return campaingslink;
	}
    @FindBy(linkText = "Sign Out")
    private WebElement signoutlink;
    
	public WebElement getSignoutlink() {
		return signoutlink;
	}
	public WebDriver getDriver() {
		return driver;
	}

	 @FindBy(linkText = "Leads")
	 private WebElement leadslink;
	 

		public WebElement getLeadslink() {
			return leadslink;
		}
		
		 public void navigateToCampaingsPage(WebDriver driver)
		 {
			 Actions act=new Actions(driver);
			 act.moveToElement(moreOption).perform();
			 campaingslink.click();
			 
		 }
	public void logout() {
		accounticon.click();
		signoutlink.click();
	}
		
}
