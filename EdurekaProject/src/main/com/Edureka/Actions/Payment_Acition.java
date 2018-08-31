package com.Edureka.Actions;

import com.Edureka.Pages.BaseClass;
import com.Edureka.Pages.Payment_Page;
import com.Edureka.utility.Log;

import org.openqa.selenium.WebDriver;

public class Payment_Acition extends BaseClass{
	
	Payment_Page paymentPage;

	public Payment_Acition(WebDriver driver) {
		super(driver);
		
	}
	
	public void Enrollment() {
		paymentPage = new Payment_Page(driver);
		try {
			paymentPage.SwitchToFrame();
			paymentPage.ClickOnPayPal();
			Log.info("Enroll by using Paypall");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
