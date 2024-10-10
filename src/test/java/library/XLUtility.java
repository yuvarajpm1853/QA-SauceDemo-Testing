package library;

import java.io.*;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class XLUtility {

	public FileInputStream fileIP;
	public FileOutputStream fileOP;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell	cell;
	public CellStyle style;
	String path;

	public XLUtility(String path) {
		this.path=path;
	}
		
	public int getRowCount(String sheetName) throws IOException
	{
		fileIP = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileIP);
		sheet= workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fileIP.close();
		return rowCount;
	}
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		fileIP = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileIP);
		sheet= workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fileIP.close();
		return cellCount;
	}
	
	public Object[][] twoDArray(String sheet) throws IOException{
		int rowNum=getRowCount(sheet);
		int cellNum=getCellCount(sheet, 1);
		Object[][] data=new String[rowNum][cellNum];
		
		for(int i=1;i<rowNum+1;i++)
		{
			for(int j=0;j<cellNum;j++)
			{
				data[i-1][j]=getCellData(sheet, i, j);
			}
		}
		return data;
		
		
	}
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fileIP = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileIP);
		sheet= workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);		
			}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fileIP.close();
		return data;
	}
}
