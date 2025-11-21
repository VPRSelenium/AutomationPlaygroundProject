package org.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	public String propertiesFile(String url) throws IOException {
		FileInputStream file = new FileInputStream(
				"D:\\Manoj\\AutomationPlaygroundProject\\src\\test\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(file);
		String URL = prop.getProperty(url);
		return URL;
	}
}
