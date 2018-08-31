package com.Edureka.Actions;

import com.Edureka.Pages.BaseClass;
import com.Edureka.Pages.EditProfile;
import com.Edureka.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditProfile_Action extends BaseClass {
	
	public EditProfile_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
		// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method
		public static void execute() throws Exception{
			try{
				
				EditProfile editProfile = new EditProfile(driver);
				editProfile.navigate_to_my_profile();
				Log.info("Navgating to my profile page");
				editProfile.clickMyprofile();
				Log.info("CLick on edit profile page");
				WebDriverWait waitElement = new WebDriverWait(driver,20);
				waitElement.until(ExpectedConditions.visibilityOf(editProfile.professionalDetailsHeader()));
				editProfile.ClickOnEditProfessionalDetails();
				Thread.sleep(2000);
				
				editProfile.selectCurrentIndustry(2);
				Log.info("Selected the current industry from the dropdown menu");
				editProfile.SelectCurrentJob(2);				
				editProfile.EnterCompanyName("STArMind Technologies Pvt Ltd");
				editProfile.EnterUserSkills("Selenium Testing,Manual Testing");
				Log.info("Update all the Professional details");
				
				waitElement = new WebDriverWait(driver,20);
				waitElement.until(ExpectedConditions.visibilityOf(editProfile.save_profile()));
				Log.info("Save the data");
				
				editProfile.ClickOnBackBtn();
				
				Thread.sleep(2000);
				
			}catch(Exception e){
				throw(e);
				}

		}
}
