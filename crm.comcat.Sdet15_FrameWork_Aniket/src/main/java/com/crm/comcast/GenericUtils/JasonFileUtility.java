package com.crm.comcast.GenericUtils;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JasonFileUtility 
{
		/**
		 * This method read  the data from Jason file
		 * @author Aniket kumar
		 * @param key
		 * @return
		 * @throws Throwable
		 */
		public String readDataFromJson(String key) throws Throwable
		{
			//Read the data from Json
			//FileReader inputfile = new FileReader("./commonData.json");
			FileReader inputfile = new FileReader(IPathConstants.JSONPATH);
			
			// parse the json object into java data stream
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(inputfile);
			
			// type caste the object into hashmap and read the data in key format  value format
			HashMap jobj = (HashMap)obj;
			String value = jobj.get(key).toString();
			return value;
		}
	
}
