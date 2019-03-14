package testCases;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commons.commonLibrary;
import utilities.readwriteexcelutils;

public class tc1launchBrowser extends commonLibrary {
	public static String filePath = System.getProperty("user.dir")+"\\src\\inputs";
	public static String fileName = "test.xlsx";
	public static String sheetName = "Sheet1";
		
	//FileInputStream fs = new FileInp
	public static void loadexcel(int rownum) throws IOException
	{
		readwriteexcelutils objExcelFile = new readwriteexcelutils();
		objExcelFile.loadexcelrow(filePath, fileName, sheetName, rownum);
		return;
	}
	
	@Test
	public static void testcase1() throws Exception {
		 loadexcel(1);
		 commonLibrary.setBrowser("chrome");
		 commonLibrary.navigateToUrl("https://vdevpril036blr.dsone.3ds.com/3DSpace");
		 commonLibrary.login("VPLMAdminUser", "Passport1");
		 commonLibrary.expwait("//*[contains(@class,'topbar-app-i3dx')]");
		 commonLibrary.verifyByTitle("3DEXPERIENCE Platform");
		 commonLibrary.clickToolbarOptions("userprofile");
		 commonLibrary.logout();
		 
	}
}
