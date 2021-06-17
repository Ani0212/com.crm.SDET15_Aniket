package com.crm.comcast.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.comcast.GenericUtils.propertiesfileUtility;

public class DynamicWebTable
{
	public void dynamicWebtable() throws Throwable
	{
		WebDriver driver;
		propertiesfileUtility  plib= new propertiesfileUtility();
		
		String URL = plib.readDatafromProperrtyFile("url");

		String UserName= plib.readDatafromProperrtyFile("username");

		String PASSWORD = plib.readDatafromProperrtyFile("password");

		String BROWSER= plib.readDatafromProperrtyFile("browser");

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
		/*
		//click on all check boxes
		List<WebElement> list = driver.findElements
				(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		for(int i =1; i<list.size();i++)
		{
			list.get(i).click();
		}
		// click on last check box
		
		list.get(list.size()-1).click();
		
		// click on 3rd row check box
		driver.findElements
		(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[1]/input")).click();
		*/
		// print all organization name  in console
		List<WebElement> list1 = driver.findElements
				(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		String expData="ch";
		int actDataCount=0;
		for(WebElement ls: list1)
		{
			String actData = ls.getText();
			if(expData.equalsIgnoreCase(actData))
			{
				break;
			}
			actDataCount++;
		}
		System.out.println(actDataCount);
		driver.findElement
		(By.xpath("//table[@class='lvt small']/tbody/tr["+(actDataCount+2)+"]/td[8]/a[.='del']")).click();
	}
}
