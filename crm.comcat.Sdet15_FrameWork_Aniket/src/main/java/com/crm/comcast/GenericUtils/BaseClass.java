package com.crm.comcast.GenericUtils;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public DataBaseUtility dLib = new DataBaseUtility();
	public WebDriverUtils wLib = new WebDriverUtils();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public JasonFileUtility jsLib = new JasonFileUtility();
	public xmlFileUtility xLib =  new xmlFileUtility();
	public propertiesfileUtility pLib = new propertiesfileUtility();
	public WebDriver driver;
	public static WebDriver staticDriver;
	
	@BeforeSuite(groups = {"SmokeTest","regressionTest"})
	public void makeDBConnection() throws Throwable
	{
		//dLib.connectToDB();
		System.out.println("========make database connection=====");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups = {"SmokeTest" ,"regressionTest"})
	public void launchBrowser() throws Throwable
	{
		String BROWSER = pLib.readDatafromProperrtyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new InternetExplorerDriver();
		}
		
	}
	
	
	@BeforeMethod(groups = {"SmokeTest" , "regressionTest"})
	public void loginTtoApp() throws Throwable
	{
		String URL = pLib.readDatafromProperrtyFile("url");
		String USERNAME = pLib.readDatafromProperrtyFile("username");
		String PASSWORD = pLib.readDatafromProperrtyFile("password");
		
		
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		wLib.maximiseWin(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	}
	
	
    @AfterMethod() //groups = {"SmokeTest","regressionTest"}
    public void logoutOfApp()
    {/*
    	//WebElement logoutImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    	WebElement logoutImg = driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td//img"));
    	wLib.Mouseover(driver, logoutImg);
        wLib.waitForPageToLoad(driver);
       wLib.waitForElementToBeVisible(driver, logoutImg);
       // driver.findElement(By.linkText("Sign Out")).click();
        driver.findElement(By.xpath("// a[text()='Sign Out']")).click();*/
    	WebElement signout = driver.findElement
				(By.xpath("//span[@class='userName']/../following-sibling::td//img"));
		Actions act= new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("// a[text()='Sign Out']")).click();     
    }
    
    @AfterClass()//groups = {"SmokeTest" , "regressionTest"}
    public void closeBrowser()
    {
    	driver.close();
    }
    
    @AfterSuite(groups = {"SmokeTest","regressionTest"})
    public void closeDB() throws Throwable
    {
    	//dLib.closeDB();
    	System.out.println("=====close the DB connection======");
    }

}
