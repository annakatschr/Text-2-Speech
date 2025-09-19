package input;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordReader implements DocumentReader {

    public String filepath;
    public ArrayList<String> contents;
    
	public WordReader(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public ArrayList<String> read() {
		ArrayList<String> contents = new ArrayList<String>();
		String [] arrayOfLines;
		// TODO Auto-generated method stub		 

		 try {
			   FileInputStream fis = new FileInputStream(filepath);
			   XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			   XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
			   String txt = extractor.getText();
			   arrayOfLines = txt.split("\n");
			   extractor.close();
			   for (String line: arrayOfLines) {
					 contents.add(line);
				 }
			   return contents;
			} catch(Exception ex) {
			    ex.printStackTrace();
			}
		 return null;
	}
}
