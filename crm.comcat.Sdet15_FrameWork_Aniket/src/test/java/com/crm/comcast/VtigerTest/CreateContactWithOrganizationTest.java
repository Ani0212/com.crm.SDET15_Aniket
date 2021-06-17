package com.crm.comcast.VtigerTest;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.comcast.GenericUtils.BaseClass;
@Listeners(com.crm.comcast.GenericUtils.ListnerImpl.class)
public class CreateContactWithOrganizationTest extends BaseClass
{
	static String mainId;
	@Test

	public void CreateContactWithOrganization() throws Throwable
	{

		String OrgName = eLib.getExcelData("sheet1", "TC_01", "OrgName")+jLib.getRandomNumber();
		String ContactLastName = eLib.getExcelData("sheet2", "Tc_01", "ContactName");



		// navigate to Contacts 
		 wLib.waitForPageToLoad(driver);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// click on Contact  + symbol
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// pass the value in last name
		driver.findElement(By.name("lastname")).sendKeys(ContactLastName);

		// click on Organization + symbol

		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();

		// switch to main window to child window
		/*mainId = driver.getWindowHandle();		
		Set<String> allId = driver.getWindowHandles();
		for(String childId : allId)
		{	
			if(!mainId.equals(childId))
			{
				driver.switchTo().window(childId);
			}
		}
		driver.findElement(By.xpath("//a[text()='Qsp']")).click();*/

		//switch to child window
		wLib.SwitchtoWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(OrgName)).click();


		// switch to main window
		wLib.SwitchtoWindow(driver, "Contacts");

		//click on Save

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//validate

		String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		Assert.assertTrue(successMsg.contains("Aniket"));
		System.out.println(successMsg);
	}
}
