package input;

public class DocumentReaderFactory {
	
	public DocumentReaderFactory() {}
	
	public DocumentReader createReader(String filename,String encoding, String form) {
	
        if (filename == null){
        	return null;
        }
        
        if (form == null) {
        	return null;
        }
        
        if("xlsx".equals(form)) {
        	return new ExcelReader(filename);
        }else if ("docx".equals(form)) {
        	return new WordReader(filename);
        }
        return null;
	}
        
}

