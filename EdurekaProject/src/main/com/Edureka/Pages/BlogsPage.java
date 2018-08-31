package com.Edureka.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Edureka.utility.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BlogsPage extends BaseClass {
	
	///////////////////////////////
	
	private static WebElement element;
	
		@FindBy(id = "dropdownMenu4")
		WebElement COMMUNITY;
		
		@FindBy(linkText = "Blog")
		WebElement BLOG;
		
		@FindBy(id ="search-inp")
		WebElement SEARCH_INP;
		
		@FindBy(xpath = "//*[@id='remote']/div[1]/span[2]/i[1]")	
		WebElement SEARCH;
		
		@FindBy(className = "interviewclick")
		WebElement INTERVIEWTAB;
		
		public BlogsPage(WebDriver driver)
		{
			super(driver);
			PageFactory.initElements(driver, this);
		}
		
		public void clickOnCommunity() throws Exception
		{
			try {
				COMMUNITY.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.error("Community field on Blog Page is not found");
				e.printStackTrace();
			}
		}
		
		public void clickOnBlog() throws Exception
		{
			try {
				BLOG.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.error("Blog field on Blog Page is not found");
				e.printStackTrace();
			}
		}
		
		public void enterSearchText(String searchText) throws Exception
		{
			try {
				SEARCH_INP.sendKeys(searchText);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.error("Search input field on Blog Page is not found");
				e.printStackTrace();
			}
		}
		
		public void clickOnSearch() throws Exception
		{
			try {
				SEARCH.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.error("Search field on Blog Page is not found");
				e.printStackTrace();
			}
		}
		
		public void clickOnInterviewTab() throws Exception
		{
			try {
				INTERVIEWTAB.click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.error("Interview tab on Blog Page is not found");
				e.printStackTrace();
			}
		}

	


}
