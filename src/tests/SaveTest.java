package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveTest {
	
	private String filepath_atbash = "C://Users//user//Desktop//ImprovedTextToSpeech//test files//atbash_word_document.docx";
	private String filepath_regular = "C://Users//user//Desktop//ImprovedTextToSpeech//test files//regular_word.docx";
	private String filepath_rot13 = "C://Users//user//Desktop//ImprovedTextToSpeech//test files//rot13_word.docx";
	private String filepath_excel = "C://Users//user//Desktop//ImprovedTextToSpeech//test files/shows3.xlsx";
	private ArrayList<String> edited = new ArrayList<String>();
	private String[] words;
	
	private String checkText = "One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed"
			+ " into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his"
			+ " brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover "
			+ "it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of"
			+ " him, waved about helplessly as he looked. \"What's happened to me?\" he thought. It wasn't a dream. His room, a "
			+ "proper human";
	
	public SaveTest() {
		words = checkText.split(" ");
		for(String word:words) {
			edited.add(word);
		}
	}
	
	public void test() throws Exception {
		FakeFactory fake1 = new FakeFactory();
		fake1.testSave(filepath_regular,null,"docx",edited);
		int i = 0;
		File file1 = new File(filepath_regular);  
		Scanner sc1 = null;
		try {
			sc1 = new Scanner(file1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while (sc1.hasNextLine()) {
			assertEquals(sc1.nextLine(),words[i]);
			i++;
		}
		
		FakeFactory fake2 = new FakeFactory();
		fake2.testSave(filepath_regular,null,"excel",edited);
				
		File file2 = new File(filepath_excel);  
		Scanner sc2 = null;
		try {
			sc2 = new Scanner(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		i=0;
		while (sc2.hasNextLine()) {
			assertEquals(sc2.nextLine(),words[i]);
			i++;
		}
		
		
	}

}
