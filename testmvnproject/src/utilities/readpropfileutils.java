package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class readpropfileutils {
	
  public static Properties getPropertyFilePath(String filePath, String fileName) throws IOException
  {
	  File file =    new File(filePath+"\\"+fileName);
	  FileInputStream inputStream = null;
	  try 
	  {
		  inputStream = new FileInputStream(file);
	  }
	  catch (FileNotFoundException e)
	  {
		e.printStackTrace();
	  }
	  
	  Properties prop = new Properties();
	  //load properties file
	  try
	  {
		prop.load(inputStream);
	  } 
	  catch (IOException e)
	  {
		e.printStackTrace();
	  }
	  return prop;
	  
  }
}