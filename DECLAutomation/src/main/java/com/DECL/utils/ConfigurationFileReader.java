package com.DECL.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationFileReader {

	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\DECL\\config\\Configuration.properties";

	public ConfigurationFileReader(){
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try{
				properties.load(reader);
				reader.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		} 
	}
	
	public String getApplicationUrl() {
		 String applicationURL = properties.getProperty("applicationURL");
		 if(applicationURL != null) return applicationURL;
		 else throw new RuntimeException("Application URL is not specified in the Configuration.properties file.");
	}
	
	public String getApplicationOrg() {
		 String applicationEnvironment = properties.getProperty("applicationOrg");
		 if(applicationEnvironment != null) return applicationEnvironment;
		 else throw new RuntimeException("Application Environment is not specified in the Configuration.properties file.");
	}
	
	public String getBrowserName() {
		 String browserName = properties.getProperty("browser");
		 if(browserName != null) return browserName;
		 else throw new RuntimeException("Browser Name is not specified in the Configuration.properties file.");
	}
}