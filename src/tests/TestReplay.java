package tests;

import static org.junit.Assert.assertEquals;

import commands.ReplayManager;

public class TestReplay {
	private String filepath_atbash = "C://Users//user//Desktop//ImprovedTextToSpeech//test files//atbash_word_document.docx";
	private String filepath_regular = "C://Users//user//Desktop//ImprovedTextToSpeech//test files//regular_word.docx";
	private String filepath_rot13 = "C://Users//user//Desktop//ImprovedTextToSpeech//test files//rot13_word.docx";
	private String filepath_excel = "C://Users//user//Desktop//ImprovedTextToSpeech//test files/shows3.xlsx";
	private String checkText = "One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed"
			+ " into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his"
			+ " brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover "
			+ "it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of"
			+ " him, waved about helplessly as he looked. \"What's happened to me?\" he thought. It wasn't a dream. His room, a "
			+ "proper human";
	
	public TestReplay() {}
	
	public void testStart() {
		System.out.println("Testing <Start Recording> command...");
		FakeFactory fake = new FakeFactory();
		ReplayManager status = fake.testStartRecording(filepath_atbash,"atbash","docx");
		assertEquals(status.isActiveRecording(),true);	
	}
	
	public void testStop() {
		System.out.println("Testing <Stop Recording> command...");
		FakeFactory fake = new FakeFactory();
		ReplayManager status = fake.testStartRecording(filepath_atbash,"atbash","docx");
		assertEquals(status.isActiveRecording(),false);
	}
	public void testReplay() {
		System.out.println("Testing Replay command...");
		FakeFactory fake = new FakeFactory();

	}
}
