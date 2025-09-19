package commands;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class CommandsFactory {
	
	private ActionListener listener;
	private int volume;
	private int pitch;
	private int rate;
	private String filepath;
	private String form;
	private String encoding;
	private ArrayList<String> contents;
	private JTextArea textArea;
	private ReplayManager replayManager;
	
	public CommandsFactory() {}
	
	public CommandsFactory(int volume,int pitch,int rate,ArrayList<String> contents,ReplayManager replayManager) {
		this.volume = volume;
		this.pitch = pitch;
		this.rate = rate;
		this.contents = contents;
		this.replayManager = replayManager;
	}
	
	public CommandsFactory(String filepath, String encoding, String form,JTextArea textArea,ReplayManager replayManager) {
		this.filepath = filepath;
		this.encoding = encoding;
		this.form = form;
		this.textArea = textArea;
		this.replayManager = replayManager;
	}
	
	public CommandsFactory(String filepath, String encoding, String form,ArrayList<String> contents,ReplayManager replayManager) {
		this.filepath = filepath;
		this.encoding = encoding;
		this.form = form;
		this.contents = contents;
		this.replayManager = replayManager;
	}
	
	
	public ActionListener createCommand(String command) {
		listener = new OpenDocument(filepath,encoding,form,textArea,replayManager); 
		switch(command) {
		case "Open Document":
			listener = new OpenDocument(filepath,encoding,form,textArea,replayManager);
			return listener;
			
		case "Save Document":
			listener = new SaveDocument(filepath,encoding,form,contents,replayManager);
			return listener;
			
		case "Document To Speech":
			listener = new DocumentToSpeech(volume,pitch,rate,contents,replayManager);
			return listener;
			
		default:
			System.out.println("An error occured!");
		}
		return listener;
	}
}
