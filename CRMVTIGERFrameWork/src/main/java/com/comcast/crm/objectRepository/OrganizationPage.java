package com.comcast.crm.objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.webdriverutility.WebdriverUtility;

public class OrganizationPage
{
	WebDriver driver;

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
	}
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createcontactImg;

	public WebElement getCreatecontactImg() {
		return createcontactImg;
	}
	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[*]/a")
	private List<WebElement> orglist;

	public List<WebElement> getOrglist() {
		return orglist;
	}
	public void clickOrgLink(String orgname)
	{
		for(WebElement li:orglist)
		{
			if(li.getText().equals(orgname))
			{
				li.click();
				System.out.println("clicked");
				break;
			}
		}
	}
	
	@FindAll({@FindBy(id = "bas_searchfield"),@FindBy(name = "search_field")})
	private WebElement indropdown;
	@FindAll({@FindBy(name = "search_text"),@FindBy(xpath = "//input[@class='txtBox']")})
	private WebElement searchfield;

	public WebElement getIndropdown() {
		return indropdown;
	}
	public WebElement getSearchfield() {
		return searchfield;
	}
	@FindAll({@FindBy(xpath = "(//input[@value=' Search Now '])[1]"),@FindBy(name = "submit")})
	private WebElement searchbtn;
	
	
	
public WebElement getSearchbtn() {
		return searchbtn;
	}
public void deleteOrgLink(String orgname,WebdriverUtility wd,WebDriver driver) {
	searchfield.sendKeys(orgname);
	wd.selectDropdownByVisibleText(indropdown, "Organization Name");
	searchbtn.click();
	driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
	
 
}
}
