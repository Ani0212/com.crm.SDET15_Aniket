package com.crm.comcast.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleDBExecuteUpdateQuery 
{

	@Test
	public void databaseExecuteUpdate() throws Throwable
	{
		//step 1 Register to Database
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		
		// Step 2  get connection with database provide database name
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root","root");
		
		//step 3 issue create statement
		Statement stat=conn.createStatement();
		
		// Step 4 Execute any query  provide table name
		int result= stat.executeUpdate("insert into employee values('Rajat',12345678,'Delhi');");
		if(result== 1)
		{
			System.out.println("Query successfully  - 1 row added");
		}
		else
		{
			System.out.println("Query failed");
		}
		// step 5 close the database
		conn.close();
	}
	/*
	@Test
	public void databaseExecuteUpdated() throws Throwable
	{
		Connection conn= null;
		try {
		//step 1 Register to Database
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		
		// Step 2  get connection with database provide database name
		Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root","root");
		
		//step 3 issue create statement
		Statement stat=con1.createStatement();
		
		// Step 4 Execute any query  provide table name
		int result= stat.executeUpdate("insert into employ values('Rajat',12345678,'Delhi');");
		if(result== 1)
		{
			System.out.println("Query successfully  - 1 row added");
		}
		else
		{
			System.out.println("Query failed");
		}
		}
		catch(Exception e) {
			
		}
		finally {
			// step 5 close the database
			conn.close();
		}
		
	}*/
}
