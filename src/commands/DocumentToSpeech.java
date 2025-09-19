package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Document;

public class DocumentToSpeech implements ActionListener {

	private Document doc = new Document();
	private ReplayManager replayManager;
	private int volume;
	private int pitch;
	private int rate;
	private ArrayList<String> speakcontents;
	
	public DocumentToSpeech() {}

	public DocumentToSpeech(int volume,int pitch,int rate,ArrayList<String> contents,ReplayManager replayManager) {
		this.volume = volume;
		this.pitch = pitch;
		this.rate = rate;
		this.speakcontents = contents;
		this.replayManager = replayManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();

		if ("Play".equals(command)) {
			doc.setSpeechContents(speakcontents);
			doc.playContents(volume,pitch,rate); 
			
			if (replayManager.isActiveRecording() == true) {
				replayManager.addCommandList(e);
			}
		}
	}
	
	public void test() {

	}

}
