package configs;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class browserConfig {

    String filePath = System.getProperty("user.dir")+"\\src\\drivers\\";
    String geckodriver = "geckodriver.exe";
    String chromedriver = "chromedriver.exe";
    String geckofullpath = filePath.concat(geckodriver);
    String chromefullpath = filePath.concat(chromedriver);
    public WebDriver driver;
    
	public WebDriver setBrowserConfig(String browser)
    {
    	if(browser.equals("firefox"))
    	{
	        System.setProperty("webdriver.gecko.driver", geckofullpath);
	        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	        capabilities.setCapability("marionette", true);
	        driver = new FirefoxDriver(capabilities);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}
    	else
    	{
    		System.out.println(browser);
    		System.setProperty("webdriver.chrome.driver",chromefullpath);
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();
    	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	}
    	return driver;
    }
    
}