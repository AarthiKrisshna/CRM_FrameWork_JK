package com.comcast.crm.objectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.webdriverutility.WebdriverUtility;

public class CreateNewOrganizationPage 
{

	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
   @FindBy(name = "accountname")
   private WebElement Orgname;

public WebElement getOrgname() {
	return Orgname;
}

public WebElement getIndustrydropdown() {
	return industrydropdown;
}

public WebElement getTypedropdown() {
	return typedropdown;
}

public WebElement getPhoneNumber() {
	return phoneNumber;
}
@FindBy(name = "industry")
private WebElement industrydropdown;
@FindBy(name ="accounttype")
private WebElement typedropdown;
@FindBy(id = "phone")
private WebElement phoneNumber;
@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement savebutton;

public WebElement getSavebutton() {
	return savebutton;
}

public void createOrg(String orgname)
{
	Orgname.sendKeys(orgname);
	savebutton.click();
}
public void createOrg(String orgname,String indus,String type,WebdriverUtility wu) throws EncryptedDocumentException, IOException {
	Orgname.sendKeys(orgname);
	wu.selectDropdownByValue(industrydropdown,indus);
	wu.selectDropdownByValue(typedropdown, type);
	savebutton.click();
}
public void createOrgWithPhone(String orgname,String num) {
	Orgname.sendKeys(orgname);
	phoneNumber.sendKeys(num);
	savebutton.click();
}

   

}
