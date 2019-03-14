package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.readwriteexcelutils;


public class enoGlobalToolbar {
	
		public enoGlobalToolbar(WebDriver driver) 
		{
			PageFactory.initElements(driver, this); 
			
		}
	
		@FindBy(xpath="//*[contains(@class,'profile topbar-menu-item topbar-cmd fonticon fonticon-user-alt')]") 
		public WebElement userprofileicon; 
		
		@FindBy(xpath="//*[contains(@class,'add topbar-menu-item topbar-cmd fonticon fonticon-plus')]") 
		public WebElement plusicon; 
		
		@FindBy(xpath="//*[contains(@class,'share topbar-menu-item topbar-cmd fonticon fonticon-mail-forward-alt')]") 
		public WebElement mailfwdicon; 
		
		@FindBy(xpath="//*[contains(@class,'home topbar-menu-item topbar-cmd fonticon fonticon-home-alt')]") 
		public WebElement homeicon; 
		
		@FindBy(xpath="//*[contains(@class,'help topbar-menu-item topbar-cmd fonticon fonticon-question-circle')]") 
		public WebElement helpicon; 
		
		@FindBy(xpath="//*[text()='Sign Out']")
		public WebElement signoutbtn; 
}
