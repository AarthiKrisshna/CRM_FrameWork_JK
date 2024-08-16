package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactInfoheaderElement;
	@FindBy(id= "dtlview_Last Name")
	private WebElement lastname;
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement Orgname;
	
    @FindBy(id = "dtlview_Support End Date")
    private WebElement supprtenddate;
    public WebElement getSupprtenddate() {
		return supprtenddate;
	}
	public WebElement getSupprtstartdate() {
		return supprtstartdate;
	}
	@FindBy(id = "dtlview_Support Start Date")
    private WebElement supprtstartdate;
	public WebElement getContactInfoheaderElement() {
		return contactInfoheaderElement;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getOrgname() {
		return Orgname;
	}
	
	

}
