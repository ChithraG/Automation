package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public ArrayList getData(String caseName) throws IOException {
		FileInputStream fis = new FileInputStream("C://Users//H208266//Book2.xlsx");

		XSSFWorkbook xssf = new XSSFWorkbook(fis);
		ArrayList<String> creds = new ArrayList();
		int sheets = xssf.getNumberOfSheets();
		 
		for(int i=0;i<sheets;i++)
		{
			if(xssf.getSheetName(i).equalsIgnoreCase("Test"))
			{
				XSSFSheet sheet = xssf.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row row1 = rows.next();
				Iterator<Cell> cells = row1.iterator();
				int columnIndex = 0;
				while(cells.hasNext())
				{
					Cell c = cells.next();
					if(c.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						columnIndex = c.getColumnIndex();
						System.out.println(columnIndex);
					}
				}
				while(rows.hasNext())
				{
					//creds = null;
					Row nextRow = rows.next();
					System.out.println(nextRow.getCell(columnIndex).getStringCellValue());
					if(nextRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase(caseName))
					{
						Iterator<Cell> userNameCell = nextRow.iterator();
						userNameCell.next();
						while(userNameCell.hasNext())
						{
							Cell c2 = userNameCell.next();
							if(c2.getCellTypeEnum()==CellType.STRING)
							{
								creds.add(c2.getStringCellValue());
							}
							else
							{
								creds.add(NumberToTextConverter.toText(c2.getNumericCellValue()));
							}
						}
					}
					
				}
			}
		}
		return creds;
	}
}


