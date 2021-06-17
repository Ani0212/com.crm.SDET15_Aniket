package com.crm.comcast.GenericUtils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class xmlFileUtility 
{
	
		/**
		 * This method is used to read data from xml
		 * @author Aniket kumar
		 * @param node
		 * @return
		 * @throws DocumentException
		 */
		public String readDataFromXmlFile(String node) throws DocumentException
		{
			// Read the file from location
			//File inputfile = new File("./commonData.xml");
			
			File inputfile = new File(IPathConstants.XMLPATH);
			// Read the xml File from input
			SAXReader reader= new SAXReader();
			Document doc = reader.read(inputfile);
			
			// Navigate to a particular node  to get the value
			String value = doc.selectSingleNode("//commonData/"+ node).getText();
			return value;
			
		}
  }

