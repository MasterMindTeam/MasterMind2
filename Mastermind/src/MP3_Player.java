import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


public class MP3_Player {

	
	// Laden der Musikdatei in das Programm
	public MP3_Player(){
		String p = "Mastermind/Answers-REMAKE.mp3";
		try{
			FileInputStream in = new FileInputStream(p);
			Player pl = new Player(in);
			pl.play();
		}
		catch(JavaLayerException jle){
			jle.printStackTrace();
		}
		catch(FileNotFoundException fnf){
			fnf.printStackTrace();
		}
	
	}
}
