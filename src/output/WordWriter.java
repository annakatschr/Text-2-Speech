package output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWriter implements DocumentWriter {

    private String filepath;
    private ArrayList<String> newContents;
    private String plain = "";
    
	public WordWriter(String filepath) {
		this.filepath = filepath;

	}
	
	@Override
	public void setContents(ArrayList<String> contents) {
		this.newContents = contents;
        for(String line: newContents) {
        	plain += line;
        	plain += " ";
        }
	}
	
	@Override
	public void write() throws Exception {
		try {
			   FileInputStream fis = new FileInputStream(filepath);
			   XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			   List<XWPFParagraph> paragraphs = xdoc.getParagraphs();
//
//			    for (XWPFParagraph paragraph : paragraphs)
//			    {
//			        for (int i = 0; i <= paragraph.getRuns().size(); i++)
//			           {
//			        	
//			              paragraph.removeRun(i);
//			      
//			           }
//			    }
	            XWPFParagraph paragraph = xdoc.createParagraph();  
	            XWPFRun run = paragraph.createRun();  
	            run.setText(plain);
		        OutputStream fos = new FileOutputStream(filepath);
		        xdoc.write(fos);
		        fos.close();
		} catch(Exception ex) {
			    ex.printStackTrace();
		}
	}
}
