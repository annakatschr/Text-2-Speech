package output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter implements DocumentWriter {
	
	private String filepath;
	private ArrayList<String> newContents;
	
	public ExcelWriter(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public void setContents(ArrayList<String> contents) {
		this.newContents = contents;
//		for (String line: newContents) {
//			System.out.println(line);
//		}
	}
	
	@Override
	public void write() throws IOException {
        	
        	FileInputStream file = new FileInputStream(filepath);
      	  
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            int cellnum = 0;
            // remove the current values from the cells
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
  
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() != CellType.BLANK) {
                    	 cell.setBlank();
//                         cell.setCellValue((String)newContents.get(cellnum++));
                    }
                    cell.setCellValue((String)newContents.get(cellnum++));
                }
            }

            try
            {
                FileOutputStream out = new FileOutputStream("C://Users//user//Desktop//shows.xlsx");
                workbook.write(out);
                out.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
            workbook.close();
            file.close();
	}
}





