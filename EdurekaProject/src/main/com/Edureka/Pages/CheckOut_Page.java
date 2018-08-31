package com.Edureka.Pages;

import com.Edureka.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOut_Page extends BaseClass{
		private static WebElement element;
		
	@FindBy(id="countrySelector")
	WebElement COUNTRY;
	
	@FindBy(id="cc")
	WebElement CARDNO;
	
	@FindBy(id="expiry_value")
	WebElement EXPDATE;
		
	@FindBy(id="cvv")
	WebElement CVV;
	
	@FindBy(xpath="//*[@id='paypalLogo']")
	WebElement PAYPAL_LOGO;
		
     public CheckOut_Page(WebDriver driver)
     {
    	 super(driver);
    	 PageFactory.initElements(driver, this);
    	 
     }
     
     public WebElement paypalLogo() throws Exception{    	 
        	try{
        		return PAYPAL_LOGO;
        	}catch (Exception e){
        		Log.error("Paypal logo on Check Out page is not found");
        		throw(e);
        		
        		}
        	
         }
	 
     public WebElement selectCountry(String countryname) throws Exception{    	 
       	try{
	       		Select country = new Select(COUNTRY);
	       		country.selectByVisibleText(countryname);
       		}catch (Exception e){
	       		Log.error("Country on Check Out page is not found");
	       		throw(e);
	       		
       		}
       	return element;
        }
     
	 public void enterCardNo(String cardno) throws Exception{
    	try{
    		CARDNO.sendKeys(cardno);
       		
       	}catch (Exception e){
       		Log.error("Cardno field on Check Out page is not found");
       		throw(e);
       		
       		}
        }
	 
	 public void enterExpireDate(String date) throws Exception{
    	try{
    		EXPDATE.sendKeys(date);
       		
       	}catch (Exception e){
       		Log.error("Expire date field on Check Out page is not found");
       		throw(e);
       		
       		}
        }
	 
	 public void enterCVV(String cvv) throws Exception{
    	try{
    		CVV.sendKeys(cvv);
       		}catch (Exception e){
       		Log.error("CVV field on Check Out page is not found");
       		throw(e);
       		
       		}
        }
}
