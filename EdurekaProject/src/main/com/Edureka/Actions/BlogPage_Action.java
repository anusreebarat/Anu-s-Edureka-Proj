package com.Edureka.Actions;

import com.Edureka.Pages.BaseClass;
import com.Edureka.Pages.BlogsPage;
import com.Edureka.utility.Log;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import EdurekaProject.EdurekaProject.BaseClass;
//import EdurekaProject.EdurekaProject.BlogsPage;


public class BlogPage_Action extends BaseClass {
	private static WebElement element;
	
public BlogPage_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public static void Execute() throws Exception{ 
     	
	
	BlogsPage blog = new BlogsPage(driver);
	blog.clickOnCommunity();
	Log.info("Navigate to blogs page");
	
	String mainWindowHandle = driver.getWindowHandle();
	
	blog.clickOnBlog();
	Set<String> windwHandles = driver.getWindowHandles();
	for (String winHandle: windwHandles) {
		driver.switchTo().window(winHandle);
	}		
	
	blog.enterSearchText("selenium");
	blog.clickOnSearch();		
	Log.info("Refine the search for selenium blogs");
	
	blog.clickOnInterviewTab();
	
	WebDriverWait waitElement = new WebDriverWait(driver,30);
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	//Use the list of window handles to switch between windows
	String handleName = tabs.get(1);
   // driver.switchTo().window(handleName);
    //Search for edureka selenium blogs
	Log.info("Explore the blogs on interview questions");
	
    waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Interview Questions\"]")));
    Thread.sleep(2000);
    
    if(driver.getPageSource().contains("Top Selenium Interview Questions And Answers You Must Prepare In 2018"))
    	Log.info(driver.getTitle());
    
    String originalHandle = tabs.get(0);
    driver.close();
    Log.info("Close all the blogs tab");
    Thread.sleep(2000);
    driver.switchTo().window(originalHandle);
    String Pagetitle = driver.getTitle();
    System.out.println(Pagetitle);
	 
	}
}
