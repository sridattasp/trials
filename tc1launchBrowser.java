package testCases;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import commons.commonLibrary;
import utilities.readwriteexcelutils;
import utilities.takepagescreenshot;

public class tc1launchBrowser extends commonLibrary {
	public static String[] rowData = new String[20]; 
	
	//FileInputStream fs = new FileInp
	public static String[] loadexcel(int rownum) throws IOException
	{
		//loadConfig();
		String filePath = System.getProperty("user.dir")+"\\src\\inputs";
		String fileName = commonLibrary.getTestDataFileName("testdataexcel");
		String sheetName = commonLibrary.getTestDataSheetName("testdatasheet");
		readwriteexcelutils objExcelFile = new readwriteexcelutils();
		return objExcelFile.loadexcelrow(filePath, fileName, sheetName, rownum);
	}
	
	public static void main(String[] args) throws Exception {
		 rowData = loadexcel(2);
		 //loadConfig();
		 takepagescreenshot tps = new takepagescreenshot();
	     tps.getScreenShot();
		 //commonLibrary.setBrowser("browser");
		 //commonLibrary.navigateToUrl("url");
		 //commonLibrary.login("aa"," password");
		 System.out.println(rowData[0]);
		 System.out.println(rowData[1]);
		 System.out.println(rowData[2]);
		 System.out.println(rowData);
		 
	}
}
