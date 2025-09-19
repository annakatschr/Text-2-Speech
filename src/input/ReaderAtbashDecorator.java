package input;

import java.util.ArrayList;

public class ReaderAtbashDecorator extends ReaderDecorator{
	
	public ReaderAtbashDecorator(DocumentReader docReader) {
		super(docReader);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> read() {
		ArrayList<String> message = super.read();
		ArrayList<String> decoded_contents = new ArrayList<String>();
		String [] finalList;

		String mess = "";
		for (String word: message) {
			mess += word;
		}
		String decoded = decode(mess);
		
        finalList = decoded.split("\n");
        for (String line:finalList) {
        	decoded_contents.add(line);
        }
		return decoded_contents;
	}

	
	public String decode(String message) {
		String plaintext = "";
	    for(char c : message.toCharArray())
	    {
	    	if(Character.isLetter(c))
	        {
	    		plaintext += (char) ('z' + ('a' - c));
	         }else{
	        	 plaintext += c;
	         }
	     }
	    System.out.println(plaintext);

	     return plaintext;
	}
}


