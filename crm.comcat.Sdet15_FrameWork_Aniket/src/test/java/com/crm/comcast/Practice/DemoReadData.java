package com.crm.comcast.Practice;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtils.DataBaseUtility;
import com.crm.comcast.GenericUtils.JasonFileUtility;
import com.crm.comcast.GenericUtils.propertiesfileUtility;
import com.crm.comcast.GenericUtils.xmlFileUtility;

public class DemoReadData 
{
	@Test
	public void demoReadFileFromAllTheFile() throws Throwable
	{
		propertiesfileUtility plib = new propertiesfileUtility();
		
		JasonFileUtility jlib= new JasonFileUtility();
		
		xmlFileUtility xmlLib= new xmlFileUtility();
		
		DataBaseUtility dblib= new DataBaseUtility();
		
		String URL = xmlLib.readDataFromXmlFile("url");
		System.out.println(URL);
		String USERNAME = plib.readDatafromProperrtyFile("username");
		System.out.println(USERNAME);
		String PASWORD = jlib.readDataFromJson("password");
		System.out.println(PASWORD);
		/*
		//connect to DB
		dblib.connectionToDB();
		String value = dblib.executeQueryAndGetData("select * from employee", 1, "Aniket");
		System.out.println(value);
		//close to DB
		dblib.CloseDB();
		*/
		
		dblib.readDatafromDataBase("select * from employee", 1, "Aniket");
		
	}
}
