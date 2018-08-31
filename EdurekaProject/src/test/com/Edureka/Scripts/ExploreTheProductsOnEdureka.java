package com.Edureka.Scripts;

import com.Edureka.Actions.CheckOut_Action;
import com.Edureka.Actions.CourseSelectAction;
import com.Edureka.Actions.Enroll_Action;
import com.Edureka.Actions.Payment_Acition;
import com.Edureka.Actions.SignIn_Action;
import com.Edureka.Pages.BaseClass;
import com.Edureka.Pages.Home_Page;
import com.Edureka.utility.Constant;
import com.Edureka.utility.ExcelUtils;
import com.Edureka.utility.Log;
import com.Edureka.utility.Utils;

import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ExploreTheProductsOnEdureka{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  //  before method is your prerequisites of your main Test Case	
  @BeforeMethod
  public void beforeMethod() throws Exception {
	    // Configuring Log4j logs, please see the following posts to learn about Log4j Logging
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// Getting the Test Case name, as it will going to use in so many places
	  	// The main use is to get the TestCase row from the Test Data Excel sheet
	  	sTestCaseName = this.toString();
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// Setting up the Test Data Excel file using Constants variables
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// Initializing the Base Class for Selenium driver
		new BaseClass(driver);  
        }
  
  // This is the starting of the Main Test Case
  @Test
  public void main() throws Exception {
	  try{
		 
		SignIn_Action.Execute(iTestCaseRow);
		Home_Page homePage = new Home_Page(driver);
		homePage.SearchBar().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Course));
		homePage.SearchBar().sendKeys(Keys.ENTER);
		Log.info("Searching for the course");
		Utils.waitForElement(homePage.SearchedCourse());
		Thread.sleep(2000);
		CourseSelectAction.Execute();			
		
		Enroll_Action enrollAction = new Enroll_Action(driver);
		Thread.sleep(2000);
		enrollAction.ClickOnEnrollBtn();
	
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
		
		
		Payment_Acition enrollment = new Payment_Acition(driver);
		enrollment.Enrollment();
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			Thread.sleep(2000);
		}		
		
		CheckOut_Action.Execute();
				
		// This is to check that if any of your verification during the execution is failed
		if(BaseClass.bResult==true){
			// If the value of boolean variable is True, then your test is complete pass and do this
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		}else{
			// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
			// This is to throw exception in case of fail test, this exception will be caught by catch block below
			throw new Exception("Test Case Failed because of Verification");
		}
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String windowHandle : windowHandles1) {
				driver.close();	
				driver.switchTo().window(windowHandle);
				break;
		}
		
	  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
	  }catch (Exception e){
		  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  Utils.takeScreenshot(driver, sTestCaseName);
		  Log.error(e.getMessage());
		  // Again throwing the exception to fail the test completely in the TestNG results
		  throw (e);
	  }
		
  }
		
  // Its time to close the finish the test case		
  @AfterMethod
  public void afterMethod() {
	    // Printing beautiful logs to end the test case	  
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
	    driver.close();
  		}

}

