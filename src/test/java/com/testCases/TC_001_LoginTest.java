package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pom.LogInPage;

public class TC_001_LoginTest extends BaseClass{
	
	
	LogInPage lp;
		
	
	@Test(priority=1)
	public void testLoginWithValidData() 
	{
		
		lp=new LogInPage(driver);
	
		helper.waitForElementToBeClickable(lp.headerloginBtn, 5);
	
		lp.clickheaderLoginbtn();
		logger.info("user landed on log-in page");
		
		helper.waitForVisibilityOfElement(lp.usernameinputbox, 5);
		lp.setusername(username);
		logger.info("entered valide user name ");
		
		helper.waitForVisibilityOfElement(lp.passwordinputbox, 5);
		lp.setpassword(password);
		logger.info("entered valide password");
		
		helper.clickByjavaScript(driver, lp.loginbtn);
		
		
		Assert.assertEquals(readconfig.getLoginPageTitle(),driver.getTitle());
		logger.info("user loged in successfully");
	}
	
	
	@Test(priority=2)
	public void testLoginWithInvalidData() throws InterruptedException
	{
		// create random username and password using faker libraries
		lp=new LogInPage(driver);
		
		helper.waitForElementToBeClickable(lp.headerloginBtn, 5);
		helper.clickByjavaScript(driver, lp.headerloginBtn);
		logger.info("user landed on log-in page");
		

		helper.waitForVisibilityOfElement(lp.usernameinputbox, 5);
		lp.setusername(faker.name().username());
		
		helper.waitForVisibilityOfElement(lp.passwordinputbox, 5);
		lp.setpassword(faker.internet().password());
		
		logger.info("entered Invalid credentials");
	
		helper.clickByjavaScript(driver, lp.loginbtn);
		
		SoftAssert sfassert = new SoftAssert();
		
		sfassert.assertTrue(false);
		logger.info("Failed login to system");
		sfassert.assertAll();
	
	}
	
	
}
