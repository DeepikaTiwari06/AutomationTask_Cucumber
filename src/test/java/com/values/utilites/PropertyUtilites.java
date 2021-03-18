package com.values.utilites;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtilites {
	private Properties properties;
	
	 private final String propertyFilePath= "src/test/resources/Config/application.properties";

	 public PropertyUtilites()
	 {
	 BufferedReader reader;
	 try {
	 reader = new BufferedReader(new FileReader(propertyFilePath));
	 properties = new Properties();
	 try {
	 properties.load(reader);
	 reader.close();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
	 } 
	 }
	 
	 
	 public String getbrower(){
		 String browser = properties.getProperty("browser");
		 if(browser!= null) return browser;
		 else throw new RuntimeException("browser name specified in the config file."); 
		 }

	 
	 public String getdriverpath(){
		 String driverpath = properties.getProperty("driverpath");
		 if(driverpath!= null) return driverpath;
		 else throw new RuntimeException("driverpath name specified in the config file."); 
		 }

}
