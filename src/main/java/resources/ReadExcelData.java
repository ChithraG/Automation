package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	public ReadExcelData(String path) {
		try
		{
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	
	public String getData(int sheetnumber, int row, int column)
	{
		sheet = wb.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;	
	}
	
	public int getRows(int sheetnumber)
	{
		int rows = wb.getSheetAt(sheetnumber).getLastRowNum();
		System.out.println(rows);
		rows = rows+1;
		return rows;
	}
	
	
}