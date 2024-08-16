package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaingsPage 
{

	public CreateCampaingsPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
@FindBy(name = "campaignname")
private WebElement campaingname;
public WebElement getCampaingname() {
	return campaingname;
}
public WebElement getClosedate() {
	return closedate;
}
public WebElement getSavebutton() {
	return savebutton;
}
@FindBy(name = "closingdate")
private WebElement closedate;
@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement savebutton;

public void createCampaings(String campname,String enddate)
{
	campaingname.sendKeys(campname);
	closedate.sendKeys(enddate);
	savebutton.click();
}
}
