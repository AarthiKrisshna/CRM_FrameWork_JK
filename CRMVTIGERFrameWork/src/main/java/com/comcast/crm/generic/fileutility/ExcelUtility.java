package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility
{
	public String getDataFromExcel(String sheet,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/CRMTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	    Sheet sh=wb.getSheet(sheet);
	    String data=sh.getRow(rownum).getCell(cellnum).toString();
	    wb.close();
	    return data;
	}
	public void writeBackDataToExcelFile(String sheet,int rownum,int cellnum,String cellValue) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/CRMTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
	    Row row=wb.getSheet(sheet).getRow(rownum);
	   Cell cell= row.createCell(cellnum);
	   cell.setCellType(CellType.STRING);
	   cell.setCellValue(cellValue);
	    FileOutputStream fos=new FileOutputStream("");
	    wb.write(fos);
	    wb.close();
	}
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
			FileInputStream fis=new FileInputStream("./testdata/CRMTestData.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
		    int rowcount=wb.getSheet(sheet).getLastRowNum();
		    return rowcount;
	
	}
	

}
