package com.Edureka.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Edureka.utility.Log;

public class SignIn_Page extends BaseClass{

	WebElement element;
	
	@FindBy(linkText="Log In")
	WebElement LOGIN;
	
	@FindBy(id="inputName")
	WebElement INPUTNAME;
	
	@FindBy(id="pwd1")
	WebElement PASSWORD;
	
	@FindBy(xpath="//*[@id='signinForm']/div[4]/button")
	WebElement SIGNIN;
	
	public SignIn_Page(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement username() throws Exception
	{
		try {
			element=INPUTNAME;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Inputname field is not found on the SignIn Page");
			e.printStackTrace();
		}
		return element;
	}
	
	public WebElement password() throws Exception
	{
		try {
			element=PASSWORD;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Password field is not found on the SignIn Page");
			e.printStackTrace();
		}
		return element;
	}
	
	public WebElement signIn() throws Exception
	{
		try {
			element=SIGNIN;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("SignIn field is not found on the SignIn Page");
			e.printStackTrace();
		}
		return element;
	}
	
	public void clickOnLogin() throws Exception
	{
		try {
			LOGIN.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Login field is not found on the SignIn Page");
			e.printStackTrace();
		}
	}
	
	public void enterUsername(String username) throws Exception
	{
		try {
			INPUTNAME.sendKeys(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Username field is not found on the SignIn Page");
			e.printStackTrace();
		}
	}
	
	public void enterPassword(String password) throws Exception
	{
		try {
			PASSWORD.sendKeys(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("Password field is not found on the SignIn Page");
			e.printStackTrace();
		}
	}
	
	public void clickOnSignIn() throws Exception
	{
		try {
			SIGNIN.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.error("SignIn button field is not found on the SignIn Page");
			e.printStackTrace();
		}
	}

}
