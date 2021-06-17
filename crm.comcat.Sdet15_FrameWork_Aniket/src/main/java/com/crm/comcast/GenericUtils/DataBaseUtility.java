package com.crm.comcast.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{
	Connection con= null;
		ResultSet result= null;
		/**
		 * this method is used to established connection with Database
		 */
		public void connectionToDB()
		{
			Driver driverRef;
			try
			{
				driverRef= new Driver();
				DriverManager.registerDriver(driverRef);
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root","root");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		/**
		 * This method is used to close the DB connection
		 * @throws Throwable 
		 */
		public void CloseDB() throws Throwable
		{
			con.close();
		}
			/**
		 * This method is used to verify the data in database
		 * @param query
		 * @param columnNAme
		 * @param expectedData
		 * @return
		 * @throws Throwable 
		 */	
		public String executeQueryAndGetData(String query,int columnName, String expectedData) throws Throwable
		{
			
			boolean flag = false;
			result=con.createStatement().executeQuery(query);
			while(result.next())
			{
				if(result.getString(columnName).equalsIgnoreCase(expectedData))
				{
					flag=true;
					break;
				}
			}
			if(flag)
			{
				System.out.println(expectedData+"data verified in Database");
			}
			else 
			{
				System.out.println(expectedData+"data not verified in Database");
				
			}
			return expectedData;
		}
		/**
		 * This method is used to read the data From Database
		 * @throws Throwable 
		 */
		public ResultSet readDatafromDataBase(String query,int columnName, String expectedData) throws Throwable
		{
			// Step 1:-connect to the Database
			   connectionToDB();
			   
			// Step2:- Read the data from DataBase
			   String value = executeQueryAndGetData(query,columnName,expectedData);
			// Step3:- print the value
			   System.out.println(value);
			//Step4 :-Close  the DB
			   con.close();
			 return result;
			
		}
}
