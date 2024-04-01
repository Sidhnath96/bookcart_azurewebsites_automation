package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiguration {
	
	Properties pro;
	
	public ReadConfiguration() 
	{
		File path = new File(".\\configuration\\config.properties");
		FileInputStream file;
		pro = new Properties();
		try {
			file = new FileInputStream(path);
			pro.load(file);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public  String getUrl()
	{
		String baseurl=pro.getProperty("baseURL");
		return baseurl;
	}
	
	public  String getUserName()
	{
		String  username=pro.getProperty("UserName");
		return username;
	}
	
	public  String getPassword()
	{
		String  passwowrd=pro.getProperty("Password");
		return passwowrd;
	}
	
	
	public  String getFname()
	{
		String  fname=pro.getProperty("FirstName");
		return fname;
	}
	
	public  String getLname()
	{
		String  lname=pro.getProperty("LastName");
		return lname;
	}
	
	public  String getLoginPageTitle()
	{
		String  loginpagetitle=pro.getProperty("loginPageTitle");
		return loginpagetitle;
	}
	
	
}
