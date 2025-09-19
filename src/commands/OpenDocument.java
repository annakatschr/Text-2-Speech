 package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextArea;

import model.Document;

public class OpenDocument implements ActionListener{
	
	private String filepath;
	private String form;
	private String encoding;
	private ReplayManager replayManager;
	private Document doc = new Document();
	private ArrayList<String> contents;
	private JTextArea TextArea;
	
	public OpenDocument() {}
	
	public OpenDocument(String filepath, String encoding, String form,JTextArea textArea,ReplayManager replayManager) {
		this.filepath = filepath;
		this.encoding = encoding;
		this.form = form;
		this.TextArea = textArea;
		this.replayManager = replayManager;
	}
	
	public OpenDocument(String filepath, String encoding, String form,ReplayManager replayManager) {
		this.filepath = filepath;
		this.encoding = encoding;
		this.form = form;
		this.replayManager = replayManager;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();

		if ("Open File".equals(command)) {
			doc.open(filepath, encoding, form);
			String returned = "";
			contents = doc.getContents();

			for (int i = 0; i < contents.size(); i++) {
			  returned += contents.get(i);
			  returned += " ";
			}
			TextArea.setText(returned);
			if (replayManager.isActiveRecording() == true) {
				replayManager.addCommandList(e);
			}
		}else if("Rot13".equals(command)){
			doc.open(filepath, encoding, form);
			String returned = "";
			contents = doc.getContents();

			for (int i = 0; i < contents.size(); i++) {
			  returned += contents.get(i);
			  returned += " ";
			}
			TextArea.setText(returned);
			if (replayManager.isActiveRecording() == true) {
				replayManager.addCommandList(e);
			}
		}else if("Atbash".equals(command)){
			doc.open(filepath, encoding, form);
			String returned = "";
			contents = doc.getContents();

			for (int i = 0; i < contents.size(); i++) {
			  returned += contents.get(i);
			  returned += " ";
			}
			TextArea.setText(returned);
			if (replayManager.isActiveRecording() == true) {
				replayManager.addCommandList(e);
			}
		}
		
	}
	
	public String test(String filepath, String encoding, String form){
		doc.open(filepath, encoding, form);
		String returned = "";
		contents = doc.getContents();

		for (int i = 0; i < contents.size(); i++) {
		  returned += contents.get(i);
		  returned += " ";
		}
		return returned;
	}
	
	public void testStartRecording(String filepath, String encoding, String form){
		doc.open(filepath, encoding, form);
	}
	
	public void testStopRecording(String filepath, String encoding, String form){
		doc.open(filepath, encoding, form);
	}

}
