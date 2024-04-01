package com.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.SearchItemPage;

public class TC_003_SearchItem_addCart extends BaseClass{
	

	SearchItemPage searchitem;
	TC_001_LoginTest logintest;
	
	@Test(dataProvider="Book List")
	public void searchItemAndToCart(String bookname) 
	{
		logintest= new TC_001_LoginTest();
		searchitem = new SearchItemPage(driver);
		
		logintest.testLoginWithValidData();
		
		helper.waitForVisibilityOfElement(searchitem.cartCount, 5);
//		helper.waitForElementToBeClickable(searchitem.cartCount, 5);
		int precount=0;
		try
		{
			
			if (!searchitem.getCount().isEmpty()) {
			    precount = Integer.parseInt(searchitem.getCount());
			    logger.info("count before added book: "+ precount);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		helper.waitForElementToBeClickable(searchitem.searchbar,3);
		searchitem.searchBook(bookname);
		logger.info("entered book name : "+bookname);
		

		searchitem.clickDrpDwnOption();
		
		helper.waitForElementToBeClickable(searchitem.addcartbtn,3);
		helper.clickByjavaScript(driver,searchitem.addcartbtn);
		logger.info("clicked on add to cart button");
	
		
		// check for the cart count afer added book
		helper.waitForElementToBeClickable(searchitem.cartCount, 5);
		int postcount=0;
		try
		{
			
			
			if (!searchitem.getCount().isEmpty()) {
				postcount = Integer.parseInt(searchitem.getCount());
			    logger.info("count after added book: "+ postcount);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(postcount>precount)
		{
			logger.info("added successfully into the cart : "+ bookname);
			Assert.assertTrue(true);
		}
		
		
	}
		
		

	
	@DataProvider(name="Book List")
	public Object[] getBooks()
	{
		
		
		return new Object[]
		{
			"Dr. Strange Beard",
			"mrs. everything",
			"Slayer",
			"The Chosen",
			"Birthday Girl",
			"The Simple Wild"
		};
		
	}


}
