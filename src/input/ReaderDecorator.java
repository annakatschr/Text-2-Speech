package input;

import java.util.ArrayList;

public abstract class ReaderDecorator implements DocumentReader {

	private DocumentReader componentReader;

	public ReaderDecorator(DocumentReader componentReader){
		this.componentReader = componentReader;
	} 
	
	@Override
	public ArrayList<String> read() {
		return componentReader.read();
	}

}
