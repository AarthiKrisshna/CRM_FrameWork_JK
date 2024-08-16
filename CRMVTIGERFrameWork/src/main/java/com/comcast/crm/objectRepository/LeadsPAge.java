package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPAge 
{
	public LeadsPAge(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
@FindBy(xpath = "//img[@alt='Create Lead...']")
private WebElement createleads;

public WebElement getCreateleads() {
	return createleads;
}

}
