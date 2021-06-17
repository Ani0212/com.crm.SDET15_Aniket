package com.crm.comcast.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class propertiesfileUtility
{
		/**
		 * This method is used to  read the data from properties file
		 * @author Aniket kumar
		 * @param key
		 * @return
		 * @throws Throwable
		 */
		public String readDatafromProperrtyFile(String key) throws Throwable
		{
			//FileInputStream file= new FileInputStream("./commonData.properties");
			FileInputStream file = new FileInputStream(IPathConstants.PROPERTYFILEPATH);
			Properties plib= new Properties();
			plib.load(file);
			String value=plib.getProperty(key);
			System.out.println(value);
			return value;
		}

}
