package com.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pom.LogInPage;
import com.pom.RegistrationPage;

public class TC_002_RegistrationTest extends BaseClass {

	LogInPage lp ;
	RegistrationPage registpage;
	
	
	@Test(priority= 1)
	public void testRegistrationPageWithValideData()
	{
		 lp = new LogInPage(driver);
		 registpage = new RegistrationPage(driver);
		 
		 lp.clickheaderLoginbtn();
		 logger.info("clicked on login button");
		 
		 helper.clickByjavaScript(driver, registpage.mainregistrationlink);
		 logger.info("clicked on register button");
		 
		 registpage.setFname(firstname);
		 logger.info("entered first name");
		 
		 registpage.setLname(lastname);
		 logger.info("entered last name");
		 
		 registpage.setUserName(faker.name().username());
		 logger.info("entered user name");
		 
		 registpage.setPassword(password);
		 logger.info("entered valid password");
		 
		 registpage.setConfPassword(password);
		 logger.info("confiremed the valid password");
		 //registpage.clickMaleRadiobtn();
		 
		 helper.scrolldownMethod(driver, 0, 50);
		 helper.clickByjavaScript(driver, registpage.registrationbtn);
		 logger.info("clicked to register the user ");
		 
		 
		 Assert.assertEquals( readconfig.getLoginPageTitle(),driver.getTitle());
		 logger.info("user registered successsfully");
	}
	
	@Test(priority=2)
	public void testRegistrationWithInvalidData() throws InterruptedException
	{
		lp = new LogInPage(driver);
		registpage = new RegistrationPage(driver);
		
		 lp.clickheaderLoginbtn();
		 logger.info("clicked on login button");
		 
		 helper.clickByjavaScript(driver, registpage.mainregistrationlink);
		 logger.info("clicked on register button");
		 
		 registpage.setFname(faker.name().firstName());
		 logger.info("entered first name");
		 
		 registpage.setLname(faker.name().lastName());
		 logger.info("entered last name");
		 
		 registpage.setUserName(faker.name().username());
		 logger.info("entered user name");
		 
		 registpage.setPassword(faker.internet().password().repeat(2));
		 logger.info("entered Invalid password");
		 
		 registpage.setConfPassword(faker.internet().password());
		 logger.info("entered Invalid confirme password");
		 //registpage.clickMaleRadiobtn();

		 helper.scrolldownMethod(driver, 0, 50);
		 helper.clickByjavaScript(driver, registpage.registrationbtn);
		 logger.info("clicked to register the user ");
		 
		 //check for the error msg is present or not
		 WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@ng-reflect-ng-switch, 'error')]"));
		 SoftAssert sfassert = null;
		 if(errorMessage.isDisplayed())
		 {
			 sfassert = new SoftAssert();
			sfassert.assertTrue(false);
			 logger.info("user failed to register please enter valide user name and password");
		 }
		 
		 sfassert.assertAll();
		
	}
	
}
