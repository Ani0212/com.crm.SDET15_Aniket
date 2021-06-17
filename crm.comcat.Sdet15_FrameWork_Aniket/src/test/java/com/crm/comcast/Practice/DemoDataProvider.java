package com.crm.comcast.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider {
	
	@DataProvider
	public Object[][] provideData()
	{
		//declare a 2 dimensional object array 
		Object[][] data = new Object[2][3];
		
		//add values into the data provider
		data[0][0]="redmi";
		data[0][1]=12000;
		data[0][2]=2.3;
		
		data[1][0]="samsung";
		data[1][1]=10000;
		data[1][2]=3.1;
		
		return data;
}
	//call the data provider in the test script
	@Test(dataProvider = "provideData")
	public void readData(String phone, int price, double version)
	{
		System.out.println("phone is "+phone +"\n price is "+price+"\n version is "+version);
	}
}
