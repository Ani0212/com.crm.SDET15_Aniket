package com.crm.comcast.VtigerTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.comcast.GenericUtils.ExcelUtility;
import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.WebDriverUtils;
import com.crm.comcast.GenericUtils.propertiesfileUtility;

@Listeners(com.crm.comcast.GenericUtils.ListnerImpl.class)
public class CreatemultipleOrganization 
{	
	WebDriver driver;
	propertiesfileUtility pLib = new propertiesfileUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtils wLib = new WebDriverUtils();
	ExcelUtility eLib = new ExcelUtility();

	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eLib.getExcelData("sheet3");
	}

	@Test(dataProvider = "getData")
	public void createMulipleOrg(String OrgName, String IndustryType) throws Throwable
	{

		String URL = pLib.readDatafromProperrtyFile("url");
		String USERNAME = pLib.readDatafromProperrtyFile("username");
		String PASSWORD = pLib.readDatafromProperrtyFile("password");
		String BROWSER = pLib.readDatafromProperrtyFile("browser");

		//launch browser
		if(BROWSER.equals("chrome")){
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")){
			driver = new FirefoxDriver();
		}else {
			driver = new InternetExplorerDriver();
		}

		//navigate to the url
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		wLib.maximiseWin(driver);

		//login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();

		//navigate to create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//enter mandatory fields and create organization
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		// Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//select industry drop-drown
		WebElement element = driver.findElement(By.name("industry"));
		wLib.Select(element,"industry");

		//validate
		String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(successMsg.contains(OrgName));
		System.out.println(successMsg);
	}
}	
