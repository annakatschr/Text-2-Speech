package tests;

import java.util.ArrayList;

import commands.DocumentToSpeech;
import commands.OpenDocument;
import commands.ReplayManager;
import commands.SaveDocument;

public class FakeFactory {
	
	public FakeFactory(){}
	
	public String testOpen(String filepath,String encoding,String form){
		OpenDocument open = new OpenDocument();
		return open.test(filepath,encoding,form);
	}
	
	public void testSave(String filepath,String encoding,String form,ArrayList<String> contents) throws Exception{
		SaveDocument save = new SaveDocument();
		save.test(filepath,encoding,form,contents);
	}
	
	public ReplayManager testStartRecording(String filepath,String encoding,String form){
		ReplayManager replay = new ReplayManager();
		replay.startRecording();
		OpenDocument open = new OpenDocument();
		open.testStartRecording(filepath, encoding, form);
		return replay;
	}
	
	public ReplayManager testStopRecording(String filepath,String encoding,String form){
		ReplayManager replay = new ReplayManager();
		OpenDocument open = new OpenDocument();
		open.testStartRecording(filepath, encoding, form);
		return replay;
	}
}
