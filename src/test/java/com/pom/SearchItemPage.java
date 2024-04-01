package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItemPage {
	
	WebDriver driver;
	
	public SearchItemPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Search books or authors']")
	public WebElement searchbar;
	
	@FindBy(xpath="/html/body/app-root/div/app-home/div/div[2]/div/div/app-book-card/mat-card/mat-card-content/app-addtocart/button/span[1]")
	public WebElement addcartbtn;
	
	@FindBy(xpath="//span[@class='mdc-list-item__primary-text']")
	public WebElement autosuggestdrpdwn;
	
	@FindBy(xpath="//span[@id='mat-badge-content-0' and @class='mat-badge-content mat-badge-active']")
	public WebElement cartCount;
	
	public void searchBook(String bookname)
	{
//		searchbar.clear();
		searchbar.sendKeys(bookname);
	}
	
	public void clickDrpDwnOption()
	{
		autosuggestdrpdwn.click();
	}
	
	public String getCount()
	{
		String countText=cartCount.getText();
		return countText;
	}
}
