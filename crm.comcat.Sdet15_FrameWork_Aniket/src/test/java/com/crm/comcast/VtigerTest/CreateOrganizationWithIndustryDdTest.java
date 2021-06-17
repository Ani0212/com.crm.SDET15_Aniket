package com.crm.comcast.VtigerTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class CreateOrganizationWithIndustryDdTest extends BaseClass
{
	@Test
	public void createOrganizationWithIndustryDD() throws Throwable
	{
		
		HomePage hp= PageFactory.initElements(driver, HomePage.class);
		CreateOrganisationPage creOrgPg= PageFactory.initElements(driver, CreateOrganisationPage.class);
		OrganisationPage orgPg= PageFactory.initElements(driver, OrganisationPage.class);
		OrganisationInformationPage orginfo= PageFactory.initElements(driver, OrganisationInformationPage.class);

		// fetch the data
		String OrgName = eLib.getExcelData("sheet1", 1,2)+jLib.getRandomNumber();
		String IndustryType = eLib.getExcelData("sheet1",3,3);
		// navigate on organization 
		hp.getOrganisationLink();
		hp.clickOnOrganisationLink();
		// click on + symbol to organization
		//orgPg.getCreateOrgImage();
		orgPg.createOrg();
		// Enter mandatory fields create organization and select Education from Industry Drop-down
		creOrgPg.createOrganisationWithIndustry(OrgName,IndustryType);
		
		/*click  on Industry drop-down and Select Education
		WebElement element = driver.findElement(By.name("industry"));
		Select s = new Select(Indutryslst);
		s.selectByVisibleText("Education");
		wLib.Select(element,IndustryType );*/
		
		/*save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		//validate
		//String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String successMsg = orginfo.getOrganisationText();
		Assert.assertTrue(successMsg.contains(OrgName));
		System.out.println(successMsg);

	}
}
