package com.crm.comcast.VtigerTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.objectRepository.CreateOrganisationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.OrganisationInformationPage;
import com.crm.comcast.objectRepository.OrganisationPage;
@Listeners(com.crm.comcast.GenericUtils.ListnerImpl.class)
public class CreateOrganizationTest extends BaseClass
{
	@Test(groups = "SmokeTest")
	public void createOrganization() throws Throwable
	{
		HomePage hp= PageFactory.initElements(driver, HomePage.class);
		OrganisationPage orgPg= PageFactory.initElements(driver, OrganisationPage.class);
		CreateOrganisationPage creOrgPg= PageFactory.initElements(driver, CreateOrganisationPage.class);
	 OrganisationInformationPage orginfo= PageFactory.initElements(driver, OrganisationInformationPage.class);
		// fetch data from excel
		String OrgName = eLib.getExcelData("sheet1", "TC_01", "OrgName")+jLib.getRandomNumber();
		
		wLib.waitForPageToLoad(driver);				
		wLib.maximiseWin(driver);
		// navigate on organization 
		hp.getOrganisationLink();
		hp.clickOnOrganisationLink();
		// click on + symbol to organization
		orgPg.createOrg();
		
		// Enter mandatory fields and create organization
		creOrgPg.createOrganisation(OrgName);
		//validate
		String successMsg = orginfo.getOrganisationText();
		Assert.assertTrue(successMsg.contains(OrgName));
		System.out.println(successMsg);
	}
	@Test
	public void createOrgWithType()
	{
		System.out.println("organization created");
	}
}
