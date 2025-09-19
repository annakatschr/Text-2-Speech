package input;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader implements DocumentReader {
	
	private String filepath;
	
	public ExcelReader(String filepath) {
		this.filepath = filepath;
	}
	
	public ExcelReader() {}
	
	@Override
	public ArrayList<String> read() {
		// TODO Auto-generated method stub
		ArrayList<String> contents = new ArrayList<String>();
		
		 try {
	            FileInputStream file = new FileInputStream(new File(filepath));
	  
	            // Create Workbook instance holding reference to .xlsx file
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	  
	            // Get first/desired sheet from the workbook
	            XSSFSheet sheet = workbook.getSheetAt(0);
	  
	            // Iterate through each rows one by one
	            Iterator<Row> rowIterator = sheet.iterator();
	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                // For each row, iterate through all the columns
	                Iterator<Cell> cellIterator = row.cellIterator();
	  
	                while (cellIterator.hasNext()) {
	                    Cell cell = cellIterator.next();
                        contents.add(cell.getStringCellValue());
	                }
	            }
	            workbook.close();
	            file.close();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
		 return contents;
	    }
	
}


