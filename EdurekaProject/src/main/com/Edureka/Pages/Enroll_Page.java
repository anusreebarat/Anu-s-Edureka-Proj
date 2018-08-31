package com.Edureka.Pages;

import com.Edureka.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Enroll_Page extends BaseClass {
	
	@FindBy(xpath="//*[@id='batches']/div/div[2]/div[2]/a/button")//*[@id="batches"]/div/div[2]/div[2]/a/button
	WebElement ENROLL;
	
	public Enroll_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement enrollBtn() throws Exception
	{
		return ENROLL;
	}

	public void ClickOnEnrollButton() throws Exception{		
		try{ 
			 ENROLL.click();
	         
	   }catch (Exception e){
	  		Log.error("Enroll button is not found");
	  		throw(e);
	  		}
	  	
	}	
}
