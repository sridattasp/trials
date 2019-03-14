package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readwriteexcelutils {
	
	/*
	 * In this class, getFileName method is defined since it is being resued in all excel methods
	 * Go through the excel function to understand its reusability.
	 */
	public static XSSFWorkbook wb;
	public static HSSFWorkbook hwb;
	public static Sheet worksheet;
	public static Row row;
	public static Cell cell;

	public static void getFileName(String filePath, String fileName) throws IOException
	{
		File file =    new File(filePath+"\\"+fileName);
	    //System.out.println(file);
	    
	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream(file);
	    wb = null;
	    hwb = null;
	    
	    //Find the file extension by splitting file name in substring  and getting only extension name
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file
	    if(fileExtensionName.equals(".xlsx"))
	    {
		    //If it is xlsx file then create object of XSSFWorkbook class
		    //System.out.println("xlsx");
	    	wb = new XSSFWorkbook(inputStream);
	    }
	    //Check condition if the file is xls file
	    else if(fileExtensionName.equals(".xls"))
	    {
	    	//System.out.println("xls");
	        //If it is xls file then create object of XSSFWorkbook class
	        hwb = new HSSFWorkbook(inputStream);
	    }
	   

	}
	
	public static void fileOS(String filePath, String fileName) throws IOException
	{
		File file =    new File(filePath+"\\"+fileName);
	    //Create an object of FileInputStream class to read excel file
	    FileOutputStream outputStream = new FileOutputStream(file);
	    wb.write(outputStream);
	    outputStream.close();
	    System.out.println("END OF WRITING DATA IN EXCEL");
	}
	
	 /*
     * Function to read and print all values from excel
     */
    public static void readExcel (String filePath, String fileName, String sheetName) throws IOException
    {
     getFileName(filePath, fileName);
    //Read sheet inside the workbook by its name
     worksheet = wb.getSheet(sheetName);
        
    //Find number of rows in excel file
    int rowCount = worksheet.getLastRowNum()-worksheet.getFirstRowNum();
        
    //Create a loop over all the rows of excel file to read it
    for (int i = 0; i < rowCount+1; i++) 
    {
        row = worksheet.getRow(i);
        //Create a loop to print cell values in a row
        for (int j = 0; j < row.getLastCellNum(); j++)
        {
            //Print Excel data in console
            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
        }

        System.out.println();
    } 
    }  

    /*
     * Function to return cell value based on rownum and colnum
     */
    public String getCellData(String filePath,String fileName, String sheetName, int rownum, int colnum) throws IOException
    {
    	 getFileName(filePath, fileName);
         worksheet = wb.getSheet(sheetName);
         row = worksheet.getRow(rownum);
		 cell = row.getCell(colnum);
		 System.out.println(cell);
		 String  cellval = cell.getStringCellValue(); 
		 System.out.println(cellval);
		 return cellval;
    }  
    
    /*
     * Function to return cell value based on rownum and colnum
     */
    public String setCellData(String filePath,String fileName, String sheetName, String cellval, int rownum, int colnum) throws IOException
    {
    	
    	 getFileName(filePath, fileName);
         worksheet = wb.getSheet(sheetName);
         row = worksheet.createRow(rownum);
         cell = row.createCell(colnum);
         //row = worksheet.getRow(rownum);
     	 //cell = row.getCell(colnum);
		 cell.setCellValue(cellval);
		 fileOS(filePath, fileName); //required to write data to excel otherwise wont work.
		 return cellval;
		 //FileOutputStream fos = new FileOutputStream("D:\\Test.xlsx");
		 //wb.write(fos);
		 //fos.close();
		 //System.out.println("END OF WRITING DATA IN EXCEL");
		
    }  

    /*
     * Function to read and print all values from excel
     */
    public static void loadexcelrow (String filePath, String fileName, String sheetName, int rownum) throws IOException
    {
     getFileName(filePath, fileName);
     worksheet = wb.getSheet(sheetName);
     System.out.println(filePath);
     System.out.println(fileName);
     System.out.println(sheetName);
     //Find number of rows in excel file
     row = worksheet.getRow(rownum-1);
     int rowData[];  
     for (int j = 0; j < row.getLastCellNum(); j++)
	 {
	       System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	       rowData[] = row.getCell(j).getStringCellValue();
	  }
	  System.out.println();
     }
  
} 	