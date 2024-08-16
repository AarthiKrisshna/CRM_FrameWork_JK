package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaingsPAge 
{

    public CampaingsPAge(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createcampaingsLink;

	public WebElement getCreatecampaingsLink() {
		return createcampaingsLink;
	}
	

}
