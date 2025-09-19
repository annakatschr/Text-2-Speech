package commands;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ReplayManager{
	
	private ArrayList<ActionEvent> commandList = new ArrayList<ActionEvent>();
	private boolean recordingStatus;
	
	public ReplayManager() {
		recordingStatus = false;
	}

	public void addCommandList(ActionEvent e) {
		this.commandList.add(e);
		System.out.println(commandList.toString());

	}
	
	public void clearList() {
		commandList.clear();
	}
	
	public ArrayList<ActionEvent> getList() {
		return commandList;
	}
	
	public void startRecording() {
		recordingStatus = true;
	}
	
	public void endRecording() {
		recordingStatus = false;
	}
	
	public boolean isActiveRecording() {
		if (recordingStatus == true) {
			return true;
		}else {
			return false;
		}
	}
	
}