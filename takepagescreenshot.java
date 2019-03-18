package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.TakesScreenshot;

public class takepagescreenshot {
  
  public WebDriver driver;
  
  public void getScreenShot() throws IOException 
  {
	 DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
	 File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 String logFilePath = System.getProperty("user.dir")+"\\src\\logs\\";
     System.out.println(logFilePath);
	 FileUtils.copyFile(srcFile,new File(logFilePath+dateFormat+"_"+".png"));
	 return;
  }
}