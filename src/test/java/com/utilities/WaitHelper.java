package com.utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	WebDriver ldriver;
	public WaitHelper(WebDriver driver)
	{
		this.ldriver=driver;
	}
	
	 // Method for explicit wait until element is visible
	 public void waitForVisibilityOfElement(WebElement element) {
	        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
	         wait.until(ExpectedConditions.visibilityOf(element));
	    }

   // Method for explicit wait until element is clickable
   public void waitForElementToBeClickable(WebElement element) {
       WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.elementToBeClickable(element));
   }

  

   public void scrolldownMethod(WebDriver driver,int xPixels, int yPixels) {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(arguments[0], arguments[1])", xPixels, yPixels);
   }
	
	public void clickByjavaScript(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].click();", element);
	}

	
}



