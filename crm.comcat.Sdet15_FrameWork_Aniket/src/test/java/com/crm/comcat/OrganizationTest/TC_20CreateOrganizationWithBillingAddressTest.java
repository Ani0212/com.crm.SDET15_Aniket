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

public class TC_20CreateOrganizationWithBillingAddressTest extends BaseClass
{
	@Test
	public void createOrganization() throws Throwable
	{
		String orgname=eLib.getExcelData("sheet4", "TC_20", "OrgName")+jLib.getRandomNumber();
		wLib.waitForPageToLoad(driver);
		wLib.maximiseWin(driver);

		

		// navigate on organization 
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		// click on + symbol to organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Enter mandatory fields and create organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		// click n Billing  address text-box
		driver.findElement(By.name("bill_street")).click();

		//click on Save
		driver.findElement(By.xpath("//input[@title='save [Alt+s]']")).click();

		// validate
		String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(successMsg.contains("Amisha"))
		{
			System.out.println("Campaign Information Updated today");
		}
		else {
			System.out.println("Not Updated");
		}
		/*click on logout
		WebElement signout = driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td//img"));
		Actions act= new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("// a[text()='Sign Out']")).click();*/
	}	
}
