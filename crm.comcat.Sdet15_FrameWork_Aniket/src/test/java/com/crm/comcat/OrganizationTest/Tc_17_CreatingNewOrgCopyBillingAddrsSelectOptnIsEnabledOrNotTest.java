package com.crm.comcat.OrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.BaseClass;
import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.xmlFileUtility;


public class Tc_17_CreatingNewOrgCopyBillingAddrsSelectOptnIsEnabledOrNotTest extends BaseClass
{
	@Test
	public void createOrganization() throws Throwable
	{
		
		String OrgName = eLib.getExcelData("sheet4", "TC_17", "OrgName")+jLib.getRandomNumber();
		String Billadd = eLib.getExcelData("sheet4", "TC_17", "Billaddress")+jLib.getRandomNumber();
		wLib.waitForPageToLoad(driver);
		wLib.maximiseWin(driver);
		// navigate on organization 
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		// click on + symbol to organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// Enter mandatory fields and create organization
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		// pass some value in Billings address
		driver.findElement(By.name("bill_street")).sendKeys(Billadd);
		// click on coping Billing address
		WebElement select = driver.findElement(By.xpath("(//td[@class='detailedViewHeader']/input)[2]"));
		select.click();
		//click on logout  
		/*WebElement signout = driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td//img"));
		Actions act= new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("// a[text()='Sign Out']")).click();*/
	}
}
