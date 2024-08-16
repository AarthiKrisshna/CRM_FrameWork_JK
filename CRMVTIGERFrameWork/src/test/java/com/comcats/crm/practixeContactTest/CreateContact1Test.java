package com.comcats.crm.practixeContactTest;



import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.BaseUtility.SampleBaseClass;

import com.comcast.crm.objectRepository.ContactInfoPage;
import com.comcast.crm.objectRepository.ContactsPage;
import com.comcast.crm.objectRepository.CreateContactPage;
import com.comcast.crm.objectRepository.CreateNewOrganizationPage;
import com.comcast.crm.objectRepository.HomePage;

import com.comcast.crm.objectRepository.OrganizationInformationPage;
import com.comcast.crm.objectRepository.OrganizationLookupPage;
import com.comcast.crm.objectRepository.OrganizationPage;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImplementationClass.class)
public class CreateContact1Test extends SampleBaseClass
{
	@Test(groups = "smokeTest")
	public void createContactTest() throws IOException {
     
		int nn=ju.getRandomNumber(1000);
		String lastname=elib.getDataFromExcel("contact",1,2)+nn;
		
		//navigate to contacts page
	    HomePage hm=new HomePage(driver);
	    hm.getContactsLink().click();
	    //create contact
	    ContactsPage cp=new ContactsPage(driver);
	    cp.getCreatecontact().click();
	    CreateContactPage ccp=new CreateContactPage(driver);
	    ccp.createContact(elib, nn);
	    //verify the contact created
	    ContactInfoPage cip=new ContactInfoPage(driver);
	    String header=cip.getContactInfoheaderElement().getText();
	    boolean status=header.contains(lastname);
	    Assert.assertEquals(status, true);
		String lastname1=cip.getLastname().getText();
		Assert.assertEquals(lastname1,lastname,"details are not valid");
		
}
	@Test(groups = "RegressionTest")
	public void createcontactWithSupportDateTest() throws IOException, InterruptedException {


	
		String lastname=elib.getDataFromExcel("contact", 1, 2);
		int nn=ju.getRandomNumber(1000);
	
	    HomePage hm=new HomePage(driver);
	    hm.getContactsLink().click();
	    ContactsPage cp=new ContactsPage(driver);
	    cp.getCreatecontact().click();
	    CreateContactPage ccp=new CreateContactPage(driver);
	    ccp.createContactWithSupportDate(elib, nn, ju);
	    ContactInfoPage cip=new ContactInfoPage(driver);
	    String header=cip.getContactInfoheaderElement().getText();
	    Assert.assertEquals(header.contains(lastname+nn), true);
			String lastname1=cip.getLastname().getText();
			Assert.assertEquals(lastname1, lastname+nn);
			String startdate=cip.getSupprtstartdate().getText();
		    Assert.assertEquals(startdate,ju.getDateFromSystem());
			String enddate=cip.getSupprtenddate().getText();
			Assert.assertEquals(enddate, ju.getEndDate(30));
			
	}
	@Test(groups = "RegressionTest")
	public void createContactWithOrganizationTest() throws EncryptedDocumentException, IOException {
		    
	    String lastname=elib.getDataFromExcel("contact",1,2);
	    String orgname=elib.getDataFromExcel("Org",1,2);
		int nn=ju.getRandomNumber(1000);
	    HomePage hm=new HomePage(driver);
	    hm.getOrganizationLink().click();
	    OrganizationPage og=new OrganizationPage(driver);
	    og.getCreatecontactImg().click();
	    CreateNewOrganizationPage cnog=new CreateNewOrganizationPage(driver);
	    cnog.createOrg(orgname+nn);
	    OrganizationInformationPage ciog=new OrganizationInformationPage(driver);
	    String heading=ciog.getOrgInfoheader().getText();
	    Assert.assertEquals(heading.contains(orgname+nn),true);;
	    String Orgname=ciog.getOrgname().getText();
	    Assert.assertEquals(Orgname, orgname+nn);
	    hm.getContactsLink().click();
	    ContactsPage cp=new ContactsPage(driver);
	    cp.getCreatecontact().click();
	    CreateContactPage ccp=new CreateContactPage(driver);
	    ccp.createContactWithOrg(elib, nn);
	    ccp.getOrglookup().click();
	   web.switchToNewTab(driver, "module=Accounts&action");
	   OrganizationLookupPage olp=new OrganizationLookupPage(driver);
	   olp.selectOrg(orgname+nn, driver);
	   web.switchToNewTab(driver, "module=Contacts&action");
	   ccp.getSavebutton().click();
	   ContactInfoPage cip=new ContactInfoPage(driver);
	   String heading1=cip.getContactInfoheaderElement().getText();
	   Assert.assertEquals(heading1.contains(lastname),true);
		String lastname1=cip.getLastname().getText();
		Assert.assertEquals(lastname1,lastname+nn,"last name not verified in contact info");
		String orglink=cip.getOrgname().getText();
		Assert.assertEquals(orglink, orgname+nn,"organization name not verifiedin contacts info");

	}

}
