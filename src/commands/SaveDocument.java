package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Document;

public class SaveDocument implements ActionListener {
	
	private String filepath;
	private String form;
	private String encoding;
	private ReplayManager replayManager;
	private Document document = new Document();
	private ArrayList<String> edited;
	
	public SaveDocument() {}
	
	public SaveDocument(String filepath,String encoding,String form,ArrayList<String> edited,ReplayManager replayManager) {
		this.filepath = filepath;
		this.form = form;
		this.encoding = encoding;
		this.edited = edited;
		this.replayManager = replayManager;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();

		if ("Save File".equals(command)) {
			try {
				document.setEditedContents(edited);
				System.out.println(edited.toString());
				document.save(filepath, encoding, form);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			if (replayManager.isActiveRecording() == true) {
				replayManager.addCommandList(e);
			}
		}
	}
	
	public void test(String filepath,String encoding,String form,ArrayList<String> contents) throws Exception {
		document.setEditedContents(contents);
		document.save(filepath, encoding, form);
	}
}
