package com.Edureka.Actions;

import com.Edureka.Pages.BaseClass;
import com.Edureka.Pages.Enroll_Page;
import com.Edureka.utility.Log;
import com.Edureka.utility.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Enroll_Action extends BaseClass{

	public Enroll_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ClickOnEnrollBtn() throws Exception
	{
		
		try {
			//Thread.sleep(2000);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
			Enroll_Page enrollPage = new Enroll_Page(driver);
			Utils.waitForElement(enrollPage.enrollBtn());
			enrollPage.ClickOnEnrollButton();
			Log.info("Try enrolling can be done from the wishlist page");
			Thread.sleep(2000);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
