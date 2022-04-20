package com.salesforce.base;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {
	public static ArrayList getData(String filePath) {
		ArrayList data = new ArrayList();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<Row> itr = sheet.iterator();
			while(itr.hasNext()) {
				  Row row = itr.next();
				  Iterator<Cell> cellitr = row.cellIterator();
				  while(cellitr.hasNext()) {
					  Cell cell = cellitr.next();
					  data.add(cell.getStringCellValue());
				  }
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
