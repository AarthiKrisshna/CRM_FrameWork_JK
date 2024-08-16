package com.comcast.crm.objectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.webdriverutility.JavaUtility;

public class CreateContactPage 
{
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
@FindBy(name = "lastname")
private WebElement lastname;
public WebElement getLastname() {
	return lastname;
}
public WebElement getSupportenddate() {
	return supportenddate;
}
public WebElement getStartdate() {
	return startdate;
}
public WebElement getOrglookup() {
	return orglookup;
}
public WebElement getSavebutton() {
	return savebutton;
}
@FindBy(name = "support_end_date")
private WebElement supportenddate;
@FindBy(name = "support_start_date")
private WebElement startdate;
@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
private WebElement orglookup;
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebutton;
 public void createContact(ExcelUtility ex,int ram) throws EncryptedDocumentException, IOException
 {
	 lastname.sendKeys(ex.getDataFromExcel("contact", 1, 2)+ram);
	 savebutton.click();
 }
 public void createContactWithSupportDate(ExcelUtility ex,int ram,JavaUtility ju) throws EncryptedDocumentException, IOException
 {
	 lastname.sendKeys(ex.getDataFromExcel("contact", 1, 2)+ram);
	 startdate.clear();
	 startdate.sendKeys(ju.getDateFromSystem());
	 supportenddate.clear();
	 supportenddate.sendKeys(ju.getEndDate(30));
	 savebutton.click();
 }
 public void createContactWithOrg(ExcelUtility ex,int ram) throws EncryptedDocumentException, IOException
 {
	 lastname.sendKeys(ex.getDataFromExcel("contact", 1, 2)+ram);
 }


}

