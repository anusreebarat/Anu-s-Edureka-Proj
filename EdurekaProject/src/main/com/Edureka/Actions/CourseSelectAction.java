package com.Edureka.Actions;

import com.Edureka.Pages.BaseClass;
import com.Edureka.Pages.ProductListing_Page;
import com.Edureka.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CourseSelectAction extends BaseClass{
	
	public CourseSelectAction(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void Execute() throws Exception{
		 
		ProductListing_Page productListingPage = new ProductListing_Page(driver);
		// This is to select the product from the list
		WebElement usernameField = productListingPage.wishlistIcon();
		
		String Search = usernameField.getAttribute("class");
		
		if(Search.equals("icon-Wishlist")){
			usernameField.click();
	    }
		Log.info("Add the searched course to wishlist.");
		Thread.sleep(2000);
		productListingPage.clickOnMyProfile();
		productListingPage.clickOnMyWishlist();
		Log.info("Check that searched course is added in the users wishlist");
		Thread.sleep(2000);
		productListingPage.clickOnSelectedCourse();
		}
}
