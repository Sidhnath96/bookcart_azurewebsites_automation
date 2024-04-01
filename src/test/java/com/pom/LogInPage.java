package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@ng-reflect-router-link='/login']")
	public WebElement headerloginBtn;

	@FindBy(xpath = "//button[@class='mdc-button mdc-button--raised mat-mdc-raised-button mat-primary mat-mdc-button-base']//span[@class='mat-mdc-button-touch-target']")
	public WebElement loginbtn;

	@FindBy(xpath = "//input[@ng-reflect-placeholder='Username']")
	public WebElement usernameinputbox;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement passwordinputbox;

	public void clickLoginbtn() {
		loginbtn.click();
	}

	public void clickheaderLoginbtn() {
		headerloginBtn.click();
	}

	public void setusername(String username) {
		
		usernameinputbox.sendKeys(username);
	}

	public void setpassword(String password) {
		
		passwordinputbox.sendKeys(password);
	}

}
