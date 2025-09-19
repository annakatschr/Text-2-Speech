package output;

import java.util.ArrayList;

public interface DocumentWriter {
	
	public void write()throws Exception;

	public void setContents(ArrayList<String> contents);

}
