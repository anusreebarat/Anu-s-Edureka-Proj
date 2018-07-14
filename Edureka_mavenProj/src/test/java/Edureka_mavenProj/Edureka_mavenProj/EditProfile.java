package Edureka_mavenProj.Edureka_mavenProj;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditProfile {
 
	WebDriver driver = null;
	
	@BeforeTest
	public void launchBrowse()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anusree\\Documents\\Edureka\\ChromeDriver2.39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.Edureka.co");
	}
	
	
	@Test
	public void loginBrowser()
	{
		driver.findElement(By.linkText("Log In")).click();
		try {
			Thread.sleep(2000);
		
			driver.findElement(By.id("inputName")).sendKeys("anusreebarat@gmail.com");
			driver.findElement(By.id("pwd1")).sendKeys("edureka@123");
			driver.findElement(By.xpath("//*[@id='signinForm']/div[4]/button")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id='header-II']/section/nav/div/ul[2]/li[1]/a/span")).click();
			driver.findElement(By.linkText("My Profile")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("personal_details")).click();
			Thread.sleep(2000);
			driver.findElement(By.className("icon-camera")).click();
			Thread.sleep(2000);
			
			List<WebElement> ele = driver.findElements(By.xpath("//*[@id='onboarding']/div/div[1]/div[2]/div[2]/app-onboarding-personal-details/div[2]/div/div/div[1]/a/i"));
			
			for (WebElement webElement : ele) {
				if(webElement.isDisplayed())
				{
					webElement.click();
				}
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='collapseOne']/div/div/form/button")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='onboarding']/div/div[1]/div[1]/app-onboarding-leftnav/ul/li[1]/a[1]/i")).click();
			
			driver.findElement(By.xpath("//*[@id='footauto']/app-root/app-profile-main/app-header/header/nav/div/div[3]/ul/li[8]/div/button/span")).click();
			driver.findElement(By.linkText("Log Out")).click();
			
			
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
}
