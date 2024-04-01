package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;

	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="/html/body/app-root/div/app-login/div/mat-card/mat-card-header/div[2]/button/span[5]")
	public WebElement mainregistrationlink;
	
	//span[normalize-space()='Register']
	
	@FindBy(xpath="//input[@placeholder='First name']")
	public WebElement inputFname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	public WebElement inputLname;
	
	@FindBy(xpath="//input[@placeholder='User name']")
	public WebElement inputuserName;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	public WebElement inputpassword;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	public WebElement inputconfirmpassword;
	
	
	@FindBy(xpath="//*[@id=\"mat-radio-2-input\"]")
	public WebElement maleradiobtn;
	
	@FindBy(xpath="//*[@id=\"mat-radio-3-input\"]")
	public WebElement femaleradiobtn;
	
	@FindBy(xpath="//span[normalize-space()='Register']")
	public WebElement registrationbtn; 
	
	public void clickMainRegistrationLink()
	{
		mainregistrationlink.click();
	}
	
	public void setFname(String Fname)
	{
		inputFname.sendKeys(Fname);
	}
	
	public void setLname(String Lname)
	{
		inputLname.sendKeys(Lname);
	}
	
	public void setUserName(String UserName)
	{
		inputuserName.sendKeys(UserName);
	}
	
	public void setPassword(String pass)
	{
		inputpassword.sendKeys(pass);
	}
	
	public void setConfPassword(String ConfPass)
	{
		inputconfirmpassword.sendKeys(ConfPass);
	}
	
	public void clickMaleRadiobtn()
	{
		maleradiobtn.click();
	}
	
	public void clickFemaleRadiobtn()
	{
		femaleradiobtn.click();
	}
	
	public void clickRegibtn()
	{
		registrationbtn.click();
	}
}
