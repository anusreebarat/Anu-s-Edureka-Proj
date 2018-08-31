package com.Edureka.Actions;


import com.Edureka.Pages.BaseClass;
import com.Edureka.Pages.CheckOut_Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOut_Action extends BaseClass {
	
	public CheckOut_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}	
	
	 public static void Execute() throws Exception{ 
     	
     	// Clicking on the Continue button on the Check Out page
	
     	CheckOut_Page checkOutPage = new CheckOut_Page(driver);
     	WebDriverWait waitElement = new WebDriverWait(driver,30);
	    waitElement.until(ExpectedConditions.visibilityOf(checkOutPage.paypalLogo()));     	
     	checkOutPage.selectCountry("India");
     	Thread.sleep(2000);
     	checkOutPage.enterCardNo("123456789");
     	checkOutPage.enterExpireDate("12/12/19");
     	checkOutPage.enterCVV("123");
    	Thread.sleep(2000);
    	
	 }

}
