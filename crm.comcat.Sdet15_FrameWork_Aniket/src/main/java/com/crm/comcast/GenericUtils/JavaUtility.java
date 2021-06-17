package com.crm.comcast.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	
		public int getRandomNumber()
		{
			Random random = new Random();
			int ran= random.nextInt(1000);
			return ran;
		}
		/**
		 * this method is used to current Date from system
		 * @return
		 */
		public String currentDate()
		{
			Date dt= new Date();
			String todaydate=dt.toString();
			return todaydate;
			
		}
		public  String Currentday(String todaydate)
		{
			currentDate();
			String arr[]= todaydate.split(" ");
			String day=arr[0];
			return day ;
		}
		public  String CurrentMonth(String todaydate)
		{
			currentDate();
			String arr[]= todaydate.split(" ");
			String month=arr[1];
			return month ;
		}
		public  String CurrentDate(String todaydate)
		{
			currentDate();
			String arr[]= todaydate.split(" ");
			String date=arr[2];
			return date ;
		}
		public String CurretYear(String todaydate)
		{
			currentDate();
			String arr[]= todaydate.split(" ");
			return arr[5];
			
		}
	
}
