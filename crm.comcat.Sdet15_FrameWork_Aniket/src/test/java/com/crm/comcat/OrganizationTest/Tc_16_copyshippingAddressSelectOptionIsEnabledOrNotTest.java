package com.crm.comcat.OrganizationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.crm.comcast.GenericUtils.BaseClass;

public class Tc_16_copyshippingAddressSelectOptionIsEnabledOrNotTest extends BaseClass
{
	@Test
	public void copyShipingaddress() throws Throwable
	{
		String OrgName = eLib.getExcelData("sheet1", "TC_01", "OrgName")+jLib.getRandomNumber();
		String shipaddress = eLib.getExcelData("sheet1", "TC_01", "shipaddress");
		// navigate on organization 
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		// click on + symbol to organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();	
		// Enter mandatory fields and create organization
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		// pass some value in shipping address
		driver.findElement(By.name("ship_street")).sendKeys(shipaddress);
		// click on coping shipping address
		WebElement select = driver.findElement(By.xpath("(//td[@class='detailedViewHeader']/input)[1]"));
		select.click(); 	  
		/*click on logout		  
		WebElement signout = driver.findElement
				(By.xpath("//span[@class='userName']/../following-sibling::td//img"));
		Actions act= new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("// a[text()='Sign Out']")).click();*/
	}
}
