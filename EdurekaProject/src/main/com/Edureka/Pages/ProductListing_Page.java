package com.Edureka.Pages;

import com.Edureka.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class ProductListing_Page extends BaseClass {
	private static WebElement element;
	
	 	@FindBy(xpath="//*[@id='course-box-106']/div/span/div[1]/a[2]/i")
	    WebElement WISHLIST_ICON;
	 	
	 	@FindBy(xpath="//*[@id='course-box-106']/div/span/div[3]/div[1]/h3/a")
	 	WebElement SELECTED_COURSE;
	 	
	 	 @FindBy(xpath="//*[@id='header-II']/section/nav/div[1]/ul[2]/li[1]/a/span")
	     WebElement MYPROFILE;
	     
	     @FindBy(xpath="//*[@href='https://www.edureka.co/search/favourite']")
	     WebElement WISHLIST;
	    
	    
    public ProductListing_Page(WebDriver driver){
    	super(driver);
    	PageFactory.initElements(driver, this);
    	} 
    
    public WebElement wishlistIcon() throws Exception
    {
    	try {
			element = WISHLIST_ICON;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Wishlist icon field is not found on the ProductListing page");
			e.printStackTrace();
		}
    	return element;
    }
    
    public void addCourseToWishlist() throws Exception
    {
    	try {
			WISHLIST_ICON.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Wishlist icon field is not found on the ProductListing page");
			e.printStackTrace();
		}
    }
    
    public void clickOnMyProfile() throws Exception
    {
    	try {
			MYPROFILE.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Myprofile is not found on the ProductListing page");
			e.printStackTrace();
		}
    }
    
    public void clickOnMyWishlist() throws Exception
    {
    	try {
			WISHLIST.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Wishlist field is not found on the ProductListing page");
			e.printStackTrace();
		}
    }

	public void clickOnSelectedCourse() throws Exception {
		
       	try{
       		SELECTED_COURSE.click();
       		Log.info("Selenium course is found");
       	}catch (Exception e){
       		Log.error("Selenium course is not found");
       		
       		throw(e);
       		}
       	
        }
	
	
	
	}
	 