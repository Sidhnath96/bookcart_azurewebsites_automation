package com.testCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


import com.github.javafaker.Faker;
import com.utilities.Helper;
import com.utilities.ReadConfiguration;
import com.utilities.WaitHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver driver;
	public static Logger logger;
	
	ReadConfiguration readconfig = new ReadConfiguration();
    WaitHelper waitfor = new WaitHelper(driver);
	Faker faker = new Faker();
	Helper helper = new Helper(driver);
	
	String url = readconfig.getUrl();
	String username = readconfig.getUserName();
	String password = readconfig.getPassword();
	String firstname = readconfig.getFname();
	String lastname = readconfig.getLname();
	String loginpagetitle = readconfig.getLoginPageTitle();
	
	

	
	@BeforeMethod
	public void setUpBrowser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // Maximize the browser window
		options.addArguments("--disable-extensions"); // Disable browser extensions
		options.addArguments("--disable-notifications"); // help to desable browser notifications
		options.addArguments("clear-data"); // Clear cookies and cache
		options.addArguments("disable-application-cache"); // disable application cache (optional)
		
//		options.addArguments("--headless"); // !!!should be enabled for Jenkins
//		options.addArguments("--disable-dev-shm-usage"); // !!!should be enabled for Jenkins
//		options.addArguments("--window-size=1920,1080"); // !!!should be enabled for Jenkins
//		
		driver = new ChromeDriver(options);

		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.get(url);
		
		logger = Logger.getLogger("TechVerito_Assignment");
		PropertyConfigurator.configure("log4j.properties");
		
		
		
	}
	
	@AfterMethod
	public void closeBrowser() 	{

		
		if (driver != null) {
            driver.quit();
        }
		
	}

}
