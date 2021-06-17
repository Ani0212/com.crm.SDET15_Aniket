package com.crm.comcast.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleDBExecuteQuery
{
	@Test
	public void databaseExecuteQuery() throws Throwable
	{
		//step 1 Register to Database
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);	
		// Step 2  get connection with database provide database name
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root","root");
		
		//step 3 issue create statement
		Statement stat=conn.createStatement();
		
		// Step 4 Execute any query provide provide table name
		ResultSet result= stat.executeQuery("select * from employee;");
		while(result.next())
		{
			System.out.println(result.getString(1)+ "\t" + result.getString(2)+ "\t" + result.getString(3));
		}
		// step 5 close the database
		conn.close();
	}

}
