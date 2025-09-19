package input;

import java.util.ArrayList;

public class ReaderRot13Decorator extends ReaderDecorator {
	
	public ReaderRot13Decorator(DocumentReader docReader) {
		super(docReader);
	}

	public ArrayList<String> read() {
		ArrayList<String> decoded_contents = new ArrayList<String>();
		String [] finalList;

		ArrayList<String> contents = super.read();
			String returned = "";
			for (int i = 0; i < contents.size(); i++) {
			  returned += contents.get(i);
			  returned += " ";
			}
        String rot13 = decode(returned);
        finalList = rot13.split("\n");
        for (String line:finalList) {
        	decoded_contents.add(line);
        }
       return decoded_contents;
	}
	
	public String decode(String value) {

        char[] values = value.toCharArray();
        for (int i = 0; i < values.length; i++) {
            char letter = values[i];

            if (letter >= 'a' && letter <= 'z') {

                if (letter > 'm') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            } else if (letter >= 'A' && letter <= 'Z') {

                if (letter > 'M') {
                    letter -= 13;
                } else {
                    letter += 13;
                }
            }
            values[i] = letter;
        }
        String ret = "";
        for (int i = 0; i < values.length; i++) {
        	ret += values[i];
        }
		 System.out.println("decoded:"+ret);

        return ret;
    }

}

