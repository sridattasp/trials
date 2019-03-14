package commons;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configs.browserConfig;
import pageObjects.enoGlobalToolbar;
import pageObjects.enoLoginPage;
import utilities.readpropfileutils;

public class commonLibrary {
	
	 public static WebDriver driver;
     public static WebElement webelement;
     public static Properties loadprop;
	 public static readpropfileutils objPropFile;
	 public static String filePath;
	
	 public static Properties loadConfig() throws IOException
	 {
		 objPropFile = new readpropfileutils();
		 filePath = System.getProperty("user.dir")+"\\src\\properties\\";
	     System.out.println(filePath);
	     loadprop = objPropFile.getPropertyFilePath(filePath, "config.properties");
	     return loadprop;
	}
	 
	 
	public static WebDriver setBrowser(String browser)
	{
		browserConfig getDriverInstance = new browserConfig();
		driver = getDriverInstance.setBrowserConfig(browser);
		return driver;
	}
	
	
	public static void navigateToUrl(String url)
	{
		  driver.get(url);
	}


   public static WebElement getElementbyXpath(String locatortype,String locator) throws Exception
   {
	loadConfig();
    WebElement element = null;
	try
	   {
	   locatortype = loadprop.getProperty("locatortype");
	   if(locatortype.equals("xpath"))
		{
		   	element = driver.findElement(By.xpath(loadprop.getProperty("path")));
		   	System.out.println(element);
		}
	   }
	   catch (Exception e)
		  {
			e.printStackTrace();
		  }
	   return element;
   }
   
   
   public static void type(String inputname,String locatortype, String locator) throws Exception
   {
	   try
	   {
	 	   WebElement typelement = getElementbyXpath(locatortype, locator);
	 	   typelement.sendKeys(inputname);
	   }
	   catch (Exception e)
	  {
		e.printStackTrace();
	  }
	}
   
   public static void login(String username, String password) throws Exception
	{
		enoLoginPage h = new enoLoginPage(driver);
		h.username.sendKeys(username);
		h.password.sendKeys(password);
		h.loginbtn.click();
	}
   
  
   public static void verifyByTitle(String assertTitleName)
   {
	   Assert.assertEquals(assertTitleName, driver.getTitle());
	   
   }
   
   public static void clickToolbarOptions(String actionName)
   {
	   enoGlobalToolbar e = new enoGlobalToolbar(driver);
	   
	   if(actionName == "userprofile")
	   {
		   e.userprofileicon.click();
	   }
	   else if(actionName == "plus") 
	   {
		   e.plusicon.click();
	   }
	   else if(actionName == "home") 
	   {
		   e.homeicon.click();
	   }
	   else if(actionName == "help") 
	   {
		   e.helpicon.click();
	   }
	   else
	   {
		   System.out.println("no action mentioned");
	   }
	   
   }
   
   public static void logout()
   {
	   enoGlobalToolbar e = new enoGlobalToolbar(driver);
	   e.signoutbtn.click();
   }
   
   public static void expwait(String xpathExpression)
   {
	   WebDriverWait wait = new WebDriverWait(driver,30);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
	   System.out.println("wait done, either element found or max timeout");
   }
}