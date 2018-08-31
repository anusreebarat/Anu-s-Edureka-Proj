package com.Edureka.Pages;


import com.Edureka.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditProfile extends BaseClass {
	private static WebElement element;
	
	@FindBy(xpath="//*[@id='header-II']/section/nav/div[1]/ul[2]/li[1]/a")
	WebElement MYPROFILE;
	
	@FindBy(xpath="//*[@href='https://learning.edureka.co/my-profile']")
	WebElement SELECTMYPROFILE;
	
	@FindBy(xpath="//*[@id='myprofilenew']/div[2]/div[1]/div[1]/h4")
	WebElement ProfessionalDetailsHeader;
	
	@FindBy(xpath="//*[@id='professional_details']/i")
	WebElement EditProfessionalDetails;
	
	@FindBy(name="currentIndustry")
	WebElement CurrentIndustry;
	
	@FindBy(name="currentjob")
	WebElement CurrentJob;
	
	@FindBy(name="companyName")
	WebElement CompanyName;
	
	@FindBy(name="userSkill")
	WebElement UserSkill;
	
	@FindBy(xpath="//*[@id='onboarding']/div/div[1]/div[2]/div[2]/app-onboarding-professional-details/accordion/accordion-group/div/div[2]/div/span[2]")
	WebElement SAVEPROFILE;
	
	@FindBy(xpath="//*[@id='onboarding']/div/div[1]/div[1]/app-onboarding-leftnav/ul/li[1]/a[1]/i")
	WebElement BACKBTN;
	
	
	public EditProfile(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	
	public void navigate_to_my_profile() throws Exception{
	   	   	try{
	      		MYPROFILE.click();
	      		}catch (Exception e){
	      		Log.error("My Profile on Home page is not found");
	      		throw(e);
	      		}
	      	}
	
	public void clickMyprofile() throws Exception{
	   	
	      	try{
	      		SELECTMYPROFILE.click();
	      		}catch (Exception e){
	      		Log.error("Select my profile on Home page is not found");
	      		throw(e);
	      		}
	      	 }
	
	public WebElement professionalDetailsHeader() throws Exception
	{
		try {
			element = ProfessionalDetailsHeader;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Professional details header on Home page is not found");
			e.printStackTrace();
		}
		
		return element;
	}
	
	
	public void ClickOnEditProfessionalDetails() throws Exception{	   	
      	try{
      		EditProfessionalDetails.click();
      		
      	}catch (Exception e){
      		Log.error("Edit professional details button on Home page is not found");
      		throw(e);
      		}	      	
       }
		
	
	public void selectCurrentIndustry(int index) throws Exception{
	   	   	try{
	      		Select dropdown1=new Select(CurrentIndustry);
				dropdown1.selectByIndex(index);
	      		
	      	}catch (Exception e){
	      		Log.error("current industry dropdown button is  notfound on the Edit profile");
	      		throw(e);
	      		}
	      	
	       }
	
	public void SelectCurrentJob(int index) throws Exception{
	   	   	try{
	      		Select dropdownCurrentJob=new Select(CurrentJob);
				dropdownCurrentJob.selectByIndex(index);
	      		
	      	}catch (Exception e){
	      		Log.error("current job dropdown button is not found on the Edit profile");
	      		throw(e);
	      		}
	      	
	       }
	
	
	public void EnterCompanyName(String companyname) throws Exception{
	   	   	try{
	      		CompanyName.clear();
	      		CompanyName.sendKeys(companyname);
	      		element = driver.findElement(By.name("companyName"));
	      		
	      	}catch (Exception e){
	      		Log.error("company name field is not found on the Edit profile");
	      		throw(e);
	      		}
	      	 }
	
	
	
	public void EnterUserSkills(String userskills) throws Exception{
	   	
	      	try{	      		
	      		UserSkill.clear();
	      		UserSkill.sendKeys(userskills);
	      		
	      	}catch (Exception e){
	      		Log.error("user skill field is not found on the Edit profile");
	      		throw(e);
	      		}
	      	
	       }
	
	
	
	public WebElement save_profile() throws Exception{
	   	 element = null;
	      	try{
	      		element= SAVEPROFILE;
	      		
	      	}catch (Exception e){
	      		Log.error("Save profile is not found");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	public void ClickOnBackBtn() throws Exception{	   	
      	try{
      		BACKBTN.click();
      		
      	}catch (Exception e){
      		Log.error("Back button on EditProfile page is not found");
      		throw(e);
      		}	      	
       }

}
