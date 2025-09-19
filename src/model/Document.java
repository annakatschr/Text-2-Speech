package model;

import java.util.ArrayList;

import input.DocumentReader;
import input.DocumentReaderFactory;
import input.ReaderAtbashDecorator;
import input.ReaderRot13Decorator;
import output.DocumentWriter;
import output.DocumentWriterFactory;

public class Document {
	
	private TTSFacade audioManager;
	private ArrayList<String> contents;
	private DocumentWriter documentWriter;
	private DocumentWriterFactory docWriterFactory = new DocumentWriterFactory();
	private DocumentReader documentReader;
	private DocumentReaderFactory docReaderFactory = new DocumentReaderFactory();
	private String speakText;
	private int volume;
	private int pitch;
	private int rate;
	
	public Document() {
		audioManager = new TTSFacade();
	}
	
	public ArrayList<String> getContents(){
		return contents;
	}
	
	public void setSpeechContents(ArrayList<String> edited){
		speakText = "";
		for (int i = 0; i < edited.size(); i++) {
			speakText += edited.get(i);
			speakText += " ";
		}
	}
	
	public void setEditedContents(ArrayList<String> newContents){
		this.contents = newContents;
	}
	
	public void setControls(int volume,int pitch,int rate) {
		this.volume = volume;
		this.pitch = pitch;
		this.rate = rate;
	}
	
	public void setAudioManager(TTSFacade facade) {
		this.audioManager = facade;
	}
	
	public void setDocReaderFactory(DocumentReaderFactory reader) {
		this.docReaderFactory = reader;
	}
	
	public void setDocWriterFactory(DocumentWriterFactory writer) {
		this.docWriterFactory = writer;
	}
	
	public void open(String filename, String encoding, String form) {

		if (encoding == null) {
			documentReader = docReaderFactory.createReader(filename, encoding, form);
			contents = documentReader.read();
		}else if ("rot13".equals(encoding)) {
			documentReader = docReaderFactory.createReader(filename, encoding, form);
			ReaderRot13Decorator rot13 = new ReaderRot13Decorator(documentReader);
			contents = rot13.read();
		} else if ("atbash".equals(encoding)) {
			documentReader = docReaderFactory.createReader(filename, encoding, form);
			ReaderAtbashDecorator atbash = new ReaderAtbashDecorator(documentReader);
			contents = atbash.read();
		}
	}
	
	public void playContents(int volume,int pitch,int rate) {
//		audioManager.setVolume(volume);
//		audioManager.setPitch(pitch);
//		audioManager.setRate(rate);
		audioManager.play(speakText,volume,pitch,rate);
	}
	
	public void save(String filename, String encoding, String form) throws Exception {
		 documentWriter = docWriterFactory.createWriter(filename, encoding, form);
		 documentWriter.setContents(contents);
		 documentWriter.write();
	}

}
