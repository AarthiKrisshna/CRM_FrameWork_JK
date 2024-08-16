package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	public String getDataFromPropertiesFile(String key) throws IOException
	{
 		FileInputStream file=new FileInputStream("./configAppData/CreateOrg.properties");
		Properties pobj=new Properties();
		pobj.load(file);
		String value=pobj.getProperty(key);
	    return	value;
		
	}

}
