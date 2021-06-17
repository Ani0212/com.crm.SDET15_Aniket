package com.crm.comcast.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MMTFutureDateHAndle 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.MMT.com/");
		
		// to click outside on screen
		Actions act= new Actions(driver);
		act.moveByOffset(10,10).perform();
		
		WebElement src= driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement dest= driver.findElement(By.xpath("//input[@id='toCity']"));
		
		src.sendKeys("Mumbai");
		driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
		Thread.sleep(2000);
		
		dest.sendKeys("Chennai");
		driver.findElement(By.xpath("//div[contains(text(),'MAA')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(2000);
		
		for(; ;)
		{
			try 
			{
				driver.findElement(By.xpath("//div[@aria-label='Sat Oct 02 2021']")).click();
				break;	
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
	}

}
