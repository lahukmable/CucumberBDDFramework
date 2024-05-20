package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties properties;

	String path = "config.properties";

	//Constructed

	public ReadConfig() {

		try {

			properties = new Properties();

			// to open config.prperties file in input mode and load the file		 

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);
		}
		catch(Exception e)
		{

			e.printStackTrace();
		}


	}

	public String getBrowser() {

		String value = properties.getProperty("browser");

		if (value!=null)
			return value;

		else
			throw new RuntimeException("URL not specified in config file");
	}

}
