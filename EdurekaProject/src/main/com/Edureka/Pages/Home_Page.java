package com.Edureka.Pages;

import com.Edureka.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Home_Page extends BaseClass{
    private static WebElement element = null;
    
    @FindBy(xpath="//*[@id='course-box-106']/div/span/div[3]/div[1]/h3/a")
    WebElement SEARCHCOURSE;   
   
    
    @FindBy(xpath=".//*[@id='homeSearchBar']")
    WebElement SEARCHBAR;
   
	public Home_Page(WebDriver driver){
	    	super(driver);
	    	PageFactory.initElements(driver, this);
	}    


	public WebElement SearchBar() throws Exception{
	    try{ 
	    	 element =SEARCHBAR;
	         
	    }catch (Exception e){
	   		Log.error("Search Button is not found");
	   		throw(e);
	   		}
	   	return element;
	}

	public WebElement SearchedCourse() throws Exception{
	    try{ 
	    	 element = SEARCHCOURSE;
	        
	    }catch (Exception e){
	   		Log.error("Selenium course is not found");
	   		throw(e);
	   		}
	   	return element;
	}
	
	


}

