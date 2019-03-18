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


import configs.browserConfig;
import pageObjects.enoGlobalToolbar;
import pageObjects.enoLoginPage;
import utilities.readpropfileutils;
import utilities.takepagescreenshot;

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
	     loadprop = readpropfileutils.getPropertyFilePath(filePath,"config.properties");
	     return loadprop;
	     
	}
	 
	 
	public static WebDriver setBrowser(String browser) throws IOException
	{
		try
		{
		loadConfig();
		browser = loadprop.getProperty("browser");
		browserConfig getDriverInstance = new browserConfig();
		driver = getDriverInstance.setBrowserConfig(browser);
		
		}
		catch (Exception e)
		{
			takepagescreenshot tps = new takepagescreenshot();
			tps.getScreenShot();
			throw(e);
		}
		return driver;
	}
	
	
	public static String navigateToUrl(String url) throws IOException
	{
		loadConfig();
		url = loadprop.getProperty("url");
		driver.get(url);
		return url;
	}

	public static String getTestDataFileName(String testDataExcelFileName) throws IOException
	{
		loadConfig();
		String testdataexcel = loadprop.getProperty("testdataexcel");
		//driver.get(testdataexcel);
		return testdataexcel;
	}
	
	public static String getTestDataSheetName(String testDataSheetName) throws IOException
	{
		loadConfig();
		String testdatasheet = loadprop.getProperty("testdatasheet");
		//driver.get(testdatasheet);
		return testdatasheet;
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
	   try
	   {
		enoLoginPage h = new enoLoginPage(driver);
		h.username.sendKeys(username);
		h.password.sendKeys(password);
		h.loginbtn.click();
	   }
		catch (Exception e)
		{
			System.out.println("in exception");
			takepagescreenshot tps = new takepagescreenshot();
			tps.getScreenShot();
			//throw(e);
		}
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