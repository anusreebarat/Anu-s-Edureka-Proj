package com.Edureka.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Edureka.utility.Log;

public class Mycousre_page extends BaseClass {
	
	
	private static WebElement element;
	
	@FindBy(xpath="//*[@id='dropdownMenu3']")
	WebElement COURSES;
	
	@FindBy(linkText="My Classroom")
	WebElement MyClassroom;
	
	@FindBy(xpath="//*[@id='footauto']/app-root/app-mycourse-main/section/section[2]/div/div/div/div[2]/div[3]/div[1]/h2")
	WebElement ENROLLCOURSE;
	
	@FindBy(className="user_name")
	WebElement USERNAME;
	
	@FindBy(xpath="//*[@id='footauto']/app-root/app-mycourse-main/section/app-header/header/nav/div/div[3]/ul/li[8]/div/ul/li[12]/a")
	WebElement LOGOUT;
	
	public Mycousre_page(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCourses() throws Exception{
		try {
			COURSES.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Course field is not found on the Mycourse Page");
			e.printStackTrace();
		}
	}
	
	public void selectMyClassroon() throws Exception
	{
		try {
			MyClassroom.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Myclassroom field is not found on the Mycourse Page");
			e.printStackTrace();
		}
	}
	
	public String enrollCourse() throws Exception
	{
		String str = "";
		try {
			 str = ENROLLCOURSE.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Enroll course field is not found on the Mycourse Page");
			e.printStackTrace();
		}
		return str;
	}
	
	public void clickOnProfilename() throws Exception
	{
		try {
			USERNAME.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Username field is not found on the Mycourse Page");
			e.printStackTrace();
		}
	}
	
	public void logout() throws Exception
	{
		try {
			LOGOUT.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Logout field is not found on the Mycourse Page");
			e.printStackTrace();
		}
	}

}
