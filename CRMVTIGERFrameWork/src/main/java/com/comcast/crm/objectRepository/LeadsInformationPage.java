package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInformationPage 
{

	public LeadsInformationPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	@FindBy(linkText = "Convert Lead")
	private WebElement convertleadLinkl;
	@FindBy(xpath  = "//input[@id='select_potential']")
	private WebElement oppcheckbox;
	@FindBy(name = "closingdate")
	private WebElement closingdate;
	@FindBy(name="Save")
	private WebElement savebtn;
	public WebElement getConvertleadLinkl() {
		return convertleadLinkl;
	}
	public WebElement getOppcheckbox() {
		return oppcheckbox;
	}
	public WebElement getClosingdate() {
		return closingdate;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	

}
