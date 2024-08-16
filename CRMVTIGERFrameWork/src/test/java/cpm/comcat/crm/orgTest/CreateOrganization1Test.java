package cpm.comcat.crm.orgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseUtility.SampleBaseClass;

import com.comcast.crm.ListenerUtility.ListenerImplementationClass;

import com.comcast.crm.objectRepository.CreateNewOrganizationPage;
import com.comcast.crm.objectRepository.HomePage;

import com.comcast.crm.objectRepository.OrganizationInformationPage;
import com.comcast.crm.objectRepository.OrganizationPage;
import com.comcast.crm.webdriverutility.utilityClassObject;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImplementationClass.class)
public class CreateOrganization1Test extends SampleBaseClass
{
	@Test(groups = "smokeTest")
	public void  createOrganizationTest() throws EncryptedDocumentException, IOException
	{	
		int nn=ju.getRandomNumber(1000);
		
	    utilityClassObject.getTest().log(Status.INFO,"navigate to organization link");
	    
	    HomePage hm=new HomePage(driver);
	    hm.getOrganizationLink().click();
	    OrganizationPage og=new OrganizationPage(driver);
	    utilityClassObject.getTest().log(Status.INFO,"navigate to create organization page");
	    og.getCreatecontactImg().click();
	    CreateNewOrganizationPage cnog=new CreateNewOrganizationPage(driver);
	    String orgname = elib.getDataFromExcel("Org",1,2)+nn;
	   // String orgname = elib.getDataFromExcel("Org",1,2);
	    cnog.createOrg(orgname);
	    utilityClassObject.getTest().log(Status.PASS,orgname+"navigate to organization link");
	    OrganizationInformationPage ciog=new OrganizationInformationPage(driver);
	    String heading=ciog.getOrgInfoheader().getText();
	    Assert.assertEquals(heading.contains(orgname),true,"org name not verified in heading org info");
	    String Orgname=ciog.getOrgname().getText();
	    Assert.assertEquals(Orgname, orgname, "org name not verified in org info");
	}
	
	@Test(groups = "RegressionTest")
	public void createOrganizationWithIndustryType() throws EncryptedDocumentException, IOException {
      
		int nn=ju.getRandomNumber(1000);
		 utilityClassObject.getTest().log(Status.INFO,"navigate to organization link");
		String orgname = elib.getDataFromExcel("Org",1,2)+nn;
	    HomePage hm=new HomePage(driver);
	    hm.getOrganizationLink().click();
	    OrganizationPage og=new OrganizationPage(driver);
	    utilityClassObject.getTest().log(Status.INFO,"navigate to create organization page");
	    og.getCreatecontactImg().click();
	    CreateNewOrganizationPage cnog=new CreateNewOrganizationPage(driver);
	    cnog.createOrg(orgname, elib.getDataFromExcel("Org",4,4),elib.getDataFromExcel("Org",4,5), web);
	    OrganizationInformationPage ciog=new OrganizationInformationPage(driver);
	    String heading=ciog.getOrgInfoheader().getText();
	    Assert.assertEquals(heading.contains(orgname),true,"org info page header verified");
	    String Orgname=ciog.getOrgname().getText();
	    Assert.assertEquals(Orgname, orgname, "org name not verified in info");
	    String industrytype = ciog.getIndustype().getText();
		Assert.assertEquals(industrytype, elib.getDataFromExcel("Org",4, 4),"industry not verified");
		String type=ciog.getType().getText();
		Assert.assertEquals(type,elib.getDataFromExcel("Org",4,5),"type not verified");
	 
	}
	
	@Test(groups = "RegressionTest")
	public void createOrganizationWithPhonenumber() throws EncryptedDocumentException, IOException
	{
		
	
	int nn=ju.getRandomNumber(1000);
	String orgname = elib.getDataFromExcel("Org",1,2)+nn;
    HomePage hm=new HomePage(driver);
    hm.getOrganizationLink().click();
    OrganizationPage og=new OrganizationPage(driver);
    og.getCreatecontactImg().click();
    CreateNewOrganizationPage cnog=new CreateNewOrganizationPage(driver);
    cnog.createOrgWithPhone(orgname,elib.getDataFromExcel("Org",7,4));
    OrganizationInformationPage ciog=new OrganizationInformationPage(driver);
    String heading=ciog.getOrgInfoheader().getText();
    Assert.assertEquals(heading.contains(orgname), true);
    String Orgname=ciog.getOrgname().getText();
    Assert.assertEquals(Orgname, orgname);
    String phone=ciog.getPhone().getText();
    Assert.assertEquals(phone,elib.getDataFromExcel("Org",7,4) );
	
	}

}
