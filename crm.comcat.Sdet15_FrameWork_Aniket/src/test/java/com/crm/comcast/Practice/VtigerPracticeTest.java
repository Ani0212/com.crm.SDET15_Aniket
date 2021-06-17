package com.crm.comcast.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.JavaUtility;
import com.crm.comcast.GenericUtils.xmlFileUtility;

public class VtigerPracticeTest 
{
	@Test
	public void createOrganization() throws Throwable
	{
		WebDriver driver;
		xmlFileUtility xlib= new xmlFileUtility();
		JavaUtility jlib= new JavaUtility();
		int random = jlib.getRandomNumber();
		String URL = xlib.readDataFromXmlFile("url");

		String UserName= xlib.readDataFromXmlFile("username");

		String PASSWORD = xlib.readDataFromXmlFile("password");

		String BROWSER= xlib.readDataFromXmlFile("browser");

		//launch browser
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("FIREFOX"))
		{
			driver = new  FirefoxDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		//navigate to the url
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		
		// login to the application
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// navigate on organization 
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		// click on + symbol to organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		// Enter mandatory fields and create organization
		 driver.findElement(By.name("accountname")).sendKeys("skillRary_"+random);

		 driver.findElement(By.xpath("//input[@title='save [Alt+s]']")).click();

		//validate

		String successMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		Assert.assertTrue(successMsg.contains("skillRary"));
		System.out.println(successMsg);
		
	}

}
