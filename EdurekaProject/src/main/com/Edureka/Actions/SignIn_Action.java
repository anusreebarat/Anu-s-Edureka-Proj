package com.Edureka.Actions;
import com.Edureka.Pages.BaseClass;
import com.Edureka.Pages.Home_Page;
import com.Edureka.Pages.SignIn_Page;
import com.Edureka.utility.Constant;
import com.Edureka.utility.ExcelUtils;
import com.Edureka.utility.Log;
import com.Edureka.utility.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

     
    public class SignIn_Action  extends BaseClass {
    	
        
        public SignIn_Action(WebDriver driver){
            	super(driver);
        }    
        public static void Execute(int iTestCaseRow) throws Exception{
        	
        	// Clicking on the My Account link on the Home Page
        Log.info("Click action is perfromed on My Account link" );
        	
        	// Storing the UserName in to a String variable and Getting the UserName from Test Data Excel sheet
        	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
        	// Constant.Col_UserName is the column number for UserName column in the Test Data sheet
        SignIn_Page signInPage = new SignIn_Page(driver);
        signInPage.clickOnLogin();
        
        try {
      		Thread.sleep(1000);
      	} catch (InterruptedException e) {
      		e.printStackTrace();
      	}

        
        	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
        	// Here we are sending the UserName string to the UserName Textbox on the LogIN Page
        	Actions actions = new Actions(driver);
            actions.moveToElement(signInPage.username());
            actions.click();
            signInPage.enterUsername(sUserName);
            actions.build().perform();
            
            // Printing the logs for what we have just performed
            Log.info(sUserName+" is entered in UserName text box" );
            
            String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
            /*System.out.println(sPassword);*/
            actions.moveToElement(signInPage.password());
            actions.click();
            signInPage.enterPassword(sPassword);
            actions.build().perform();
            actions.moveToElement(signInPage.signIn());
            signInPage.clickOnSignIn();
            actions.build().perform();
            Log.info("Click action is performed on Submit button");
            
            // Now it will wait 10 secs separately before jumping out to next step
            try {
          		Thread.sleep(5000);
          	} catch (InterruptedException e) {
          		e.printStackTrace();
          	}
            
            Home_Page homePage = new Home_Page(driver);
            
            Utils.waitForElement(homePage.SearchBar());
            
            // This is another type of logging, with the help of TestNg Reporter log
            // This has to be very carefully used, you should only print the very important message in to this
            // This will populate the logs in the TestNG HTML reports
            Reporter.log("SignIn Action is successfully perfomred");
            
        }
    }
