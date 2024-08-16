package com.comcast.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationLookupPage
{
	public OrganizationLookupPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}

	@FindBy(name = "search_text")
	private WebElement searchtextfield;
	@FindBy(name = "search")
	private WebElement searchbtn;
    public WebElement getSearchtextfield() {
		return searchtextfield;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public void selectOrg(String Orgname,WebDriver driver)
    {
    	searchtextfield.sendKeys(Orgname);
    	searchbtn.click();
    	driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
    }
	
}
