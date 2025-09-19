package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTSFacade implements ITTSFacade{
	
	private VoiceManager vm;
	private Voice voice;

	public TTSFacade() {

	    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	    vm = VoiceManager.getInstance();
	    voice = vm.getVoice("kevin16");
	    voice.allocate();
	}

	@Override
	public void play(String text, float volume, float pitch, float rate) {
		// TODO Auto-generated method stub
		voice.allocate();

		voice.speak(text);
		voice.deallocate();
	}
	

//	public void setVolume(int volume) {
//		volume = volume/10;
//		voice.setVolume(volume);
//	}
//	
//	public void setPitch(int pitch) {
//		voice.setPitch(pitch);
//	}
//	
//	public void setRate(int rate) {
//		voice.setRate(rate);
//	}
}
