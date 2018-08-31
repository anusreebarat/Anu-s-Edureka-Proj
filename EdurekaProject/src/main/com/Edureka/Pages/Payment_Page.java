package com.Edureka.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Edureka.utility.Log;

public class Payment_Page extends BaseClass {
	
	@FindBy(xpath="//*[@id='paypal-button']/div/div/iframe")
	WebElement PAYMENTFRAME;
	
	@FindBy(xpath="/html/body/div[1]/div[1]")
	WebElement PAYPALBTN;

	public Payment_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void SwitchToFrame() throws Exception
	{
		try {
			driver.switchTo().frame(PAYMENTFRAME);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Frame is not found in Payment Page");
			e.printStackTrace();
		}
	}
	
	public void ClickOnPayPal() throws Exception
	{
		try {
			PAYPALBTN.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Paypall button is not found in Payment Page");
			e.printStackTrace();
		}
	}

}
