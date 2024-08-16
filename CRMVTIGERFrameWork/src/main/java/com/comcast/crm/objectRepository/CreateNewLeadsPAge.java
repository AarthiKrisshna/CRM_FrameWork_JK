package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadsPAge
{

	public CreateNewLeadsPAge(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
@FindBy(name="lastname")
private WebElement lastname;
@FindBy(name="company")
private WebElement company;
public WebElement getLastname() {
	return lastname;
}
public WebElement getCompany() {
	return company;
}
public WebElement getSavebutton() {
	return savebutton;
}
@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement savebutton;
public void craeteLead(String lastname,String company)
{
	this.lastname.sendKeys(lastname);
	this.company.sendKeys(company);
	savebutton.click();
	
}
}
