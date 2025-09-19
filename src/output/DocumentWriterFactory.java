package output;

public class DocumentWriterFactory {
	
	public DocumentWriterFactory() {}
	
	public DocumentWriter createWriter(String filename,String encoding, String form) {

	        if (filename == null){
	        	return null;
	        }
	        
	        if (form == null) {
	        	return null;
	        }
	        
	        if("xlsx".equals(form)) {
	        	return new ExcelWriter(filename);
	        }else if ("docx".equals(form)) {
	        	return new WordWriter(filename);
	        }
	        return null;
			        
	}
}
