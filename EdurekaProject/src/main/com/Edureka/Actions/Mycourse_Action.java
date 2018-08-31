package com.Edureka.Actions;

import com.Edureka.Pages.BaseClass;
import com.Edureka.Pages.Mycousre_page;
import com.Edureka.utility.Log;

import org.openqa.selenium.WebDriver;

public class Mycourse_Action extends BaseClass {
	
	 static Mycousre_page myCoursePage;
	
	public Mycourse_Action(WebDriver driver) {
		super(driver);
		myCoursePage = new Mycousre_page(driver);
		// TODO Auto-generated constructor stub
	}

		// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
		// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method
		public static void execute() throws Exception{
			try{
				
				myCoursePage.clickOnCourses();
				Log.info("Navigate to the My Course Page ");
				
				myCoursePage.selectMyClassroon();
				Log.info("Validate if any courses have been enrolled");
				
				Thread.sleep(2000);
				if(driver.getPageSource().contains("It looks like you are not enrolled for any course")){
			        /*System.out.println("Not enrolled to any course");*/
					Log.info("Not enrolled to any course");
			    }
				else 
				{
					String text = myCoursePage.enrollCourse();
					Log.info("You are enroller for "+text);
				}
				
				
			}catch(Exception e){
				throw(e);
				}
		}
		
		public static void logout() throws Exception{
			
			Thread.sleep(2000);
			myCoursePage.clickOnProfilename();
			myCoursePage.logout();
			Log.info("Lgout from account");
		
		}

}
