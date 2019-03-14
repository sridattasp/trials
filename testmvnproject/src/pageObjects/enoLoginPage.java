package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.readwriteexcelutils;


public class enoLoginPage {
	
		public enoLoginPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this); 
			
		}
	
		@FindBy(xpath="//*[@name='username']") 
		public WebElement username; 
	
		@FindBy(xpath="//*[@name='password']") 
		public WebElement password;
		
		@FindBy(xpath="//*[contains(@type,'submit')]") 
		public WebElement loginbtn;
}
