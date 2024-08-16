package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage 
{
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgname;
    @FindBy(xpath = "//span[@class='dvHeaderText']")
    private WebElement orgInfoheader;
    public WebElement getOrgname() {
		return orgname;
	}
	public WebElement getOrgInfoheader() {
		return orgInfoheader;
	}
    @FindBy(xpath = "//span[@id='dtlview_Industry']/font")
    private WebElement industype;
    @FindBy(xpath = "//span[@id='dtlview_Type']/font")
    private WebElement type;
    @FindBy(id = "dtlview_Phone")
    private WebElement phone;
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getIndustype() {
		return industype;
	}
	public WebElement getType() {
		return type;
	}
}
