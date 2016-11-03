import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class BrettGUI extends JPanel implements KeyListener {
	
	// Variablendeklaration 
	protected BufferedImage hintergrund, roterKreis, blauerKreis, gelberKreis, grünerKreis, orangenerKreis, weißerKreis,
			schwarzerKreis, braunerKreis, kreuz, winner, loser, balken;
	protected int zaehlerFarbe = 0;
	protected int zaehlerPosition = 0;
	SpielLogik logik = new SpielLogik(MenuManager.gameMode);
	protected int testEnter = 0;
	protected int angabeAbbrechen = 5;
	protected boolean done = false;
	protected boolean helpDisplayed = false;
	
	// Konstruktor, in dem die Bilder geladen werden, welche für das Spiel benötigt werden
	public BrettGUI() {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		setVisible(true);
		hintergrund = load("Mastermind/src/MastermindBild.png");
		roterKreis = load("Mastermind/src/RoterKreis.png");
		blauerKreis = load("Mastermind/src/BlauerKreis.png");
		gelberKreis = load("Mastermind/src/GelberKreis.png");
		grünerKreis = load("Mastermind/src/GrünerKreis.png");
		orangenerKreis = load("Mastermind/src/OrangenerKreis.png");
		braunerKreis = load("Mastermind/src/BraunerKreis.png");
		weißerKreis = load("Mastermind/src/WeißerKreis.png");
		schwarzerKreis = load("Mastermind/src/SchwarzerKreis.png");
		kreuz = load("Mastermind/src/Kreuz.png");
		winner = load("Mastermind/src/Gewonnen.png");
		loser = load("Mastermind/src/Verloren.png");
		balken = load("Mastermind/src/Balken.png");
	}
	
	public void paint(Graphics gr) {
		// logik, zaehlerFarbe, zaehlerPosition und testEnter werden auf 0 gesetzt, sobald eine Schwierigkeit ausgewählt ist 
		// gameMode wird am Schluss auf 0 gesetzt, sodass die Variablen nur beim ersten Mal auf 0 gesetzt werden
		if (MenuManager.gameMode != 0) {
			logik = new SpielLogik(MenuManager.gameMode);
			zaehlerFarbe = 0;
			zaehlerPosition = 0;
			testEnter = 0;
			MenuManager.gameMode = 0;
		}
		// Zeichnen des Hintergrundbildes 
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		g.drawImage(hintergrund, 0, 0, null);

		
	// Alle bisher eingegebeben Farben werden an der entsprechenden (Pixel)Stelle gezeichnet 
     for (int i = 0; i<logik.versuch.length;i++) {
            for (int j = 0; j<logik.versuch[i].length;j++) {
     if (logik.versuch[i][j] == 1) {
            switch (i) {
            case 0: g.drawImage(roterKreis, 75,  16+72*j, null); break;
            case 1: g.drawImage(roterKreis, 175, 16+72*j, null); break;
            case 2: g.drawImage(roterKreis, 275, 16+72*j, null); break;
            case 3: g.drawImage(roterKreis, 375, 16+72*j, null); break;
            }
     }
     if (logik.versuch[i][j] == 2) {
            switch (i) {
            case 0: g.drawImage(blauerKreis, 75,  16+72*j, null); break;
            case 1: g.drawImage(blauerKreis, 175, 16+72*j, null); break;
            case 2: g.drawImage(blauerKreis, 275, 16+72*j, null);         break;
            case 3: g.drawImage(blauerKreis, 375, 16+72*j, null); break;
            }
     }
     if (logik.versuch[i][j] == 3) {
            switch (i) {
            case 0: g.drawImage(gelberKreis, 75,16+72*j, null); break;
            case 1: g.drawImage(gelberKreis, 175, 16+72*j, null); break;
            case 2: g.drawImage(gelberKreis, 275, 16+72*j, null); break;
            case 3: g.drawImage(gelberKreis, 375, 16+72*j, null); break;
            }
     }
     if (logik.versuch[i][j] == 4) {
            switch (i) {
            case 0: g.drawImage(grünerKreis, 75,16+72*j, null); break;
            case 1: g.drawImage(grünerKreis, 175, 16+72*j, null); break;
            case 2: g.drawImage(grünerKreis, 275, 16+72*j, null); break;
            case 3: g.drawImage(grünerKreis, 375, 16+72*j, null); break;
            }
     }
     if (logik.versuch[i][j] == 5) {
            switch (i) {
            case 0: g.drawImage(orangenerKreis, 75,16+72*j, null); break;
            case 1: g.drawImage(orangenerKreis, 175, 16+72*j, null); break;
            case 2: g.drawImage(orangenerKreis, 275, 16+72*j, null); break;
            case 3: g.drawImage(orangenerKreis, 375, 16+72*j, null); break;
            }
     }
     if (logik.versuch[i][j] == 6) {
            switch (i) {
            case 0: g.drawImage(braunerKreis, 75,16+72*j, null); break;
            case 1: g.drawImage(braunerKreis, 175, 16+72*j, null); break;
            case 2: g.drawImage(braunerKreis, 275, 16+72*j, null); break;
            case 3: g.drawImage(braunerKreis, 375, 16+72*j, null); break;
            }      
     }
     }
     }
     // Hier werden die schwarzen / weißen Hinweise gezeichnet, je nachdem wie viele Farben richtig ausgewählt wurden 
     for (int i = 0; i<logik.hint.length; i++){
            for (int j = 0; j<logik.hint[i].length; j++){
                  if (logik.hint[i][j] == 2){
                         switch(i) {
                         case 0: g.drawImage(schwarzerKreis, 508, 14+72*j, null); break;
                         case 1: g.drawImage(schwarzerKreis, 540, 14+72*j, null); break;
                         case 2: g.drawImage(schwarzerKreis, 508, 40+72*j, null); break;
                         case 3: g.drawImage(schwarzerKreis, 540, 40+72*j, null); break;
                         }
                  }
                  if (logik.hint[i][j] == 1){
                         switch(i) {
                         case 0: g.drawImage(weißerKreis, 508, 14+72*j, null); break;
                         case 1: g.drawImage(weißerKreis, 540, 14+72*j, null); break;
                         case 2: g.drawImage(weißerKreis, 508, 40+72*j, null); break;
                         case 3: g.drawImage(weißerKreis, 540, 40+72*j, null); break;
                         }
                  }
                  if (logik.hint[i][j] == 3){
                         switch(i) {
                         case 0: g.drawImage(kreuz, 508, 14+72*j, null); break;
                         case 1: g.drawImage(kreuz, 540, 14+72*j, null); break;
                         case 2: g.drawImage(kreuz, 508, 40+72*j, null); break;
                         case 3: g.drawImage(kreuz, 540, 40+72*j, null); break;
                         }
                  }
            }
     }
     // hier wird der Balken gezeichnet, der die Position angibt
     // der Balken wandert je nachdem ob der Benutzer nach rechts oder nach links drückt 
   g.drawImage(balken, 100*zaehlerPosition, 6+72*logik.dieVersuche,null);
   // hier wird die Lösung gezeichnet, abhängig von dem SChwierigkeitsgrad
   // wird erst ausgeführt, wenn alle Zeilen gefüllt sind oder die Lösung gefunden wurde
   if (testEnter > 9) {
       for (int i = 0; i<logik.loesung.length;i++) {
             if (logik.loesung[i] == 1) {
                    switch (i) {
                    case 0: g.drawImage(roterKreis, 75,      717, null); break;
                    case 1: g.drawImage(roterKreis, 175, 717, null); break;
                    case 2: g.drawImage(roterKreis, 275, 717, null); break;
                    case 3: g.drawImage(roterKreis, 375, 717, null); break;
                    }
             }
             if (logik.loesung[i] == 2) {
                    switch (i) {
                    case 0: g.drawImage(blauerKreis, 75,  717, null); break;
                    case 1: g.drawImage(blauerKreis, 175, 717, null); break;
                    case 2: g.drawImage(blauerKreis, 275, 717, null); break;
                    case 3: g.drawImage(blauerKreis, 375, 717, null); break;
                    }
             }
             // wenn die Schwierigkeit größer als 1 (Mittel oder schwer) ist, sind weitere mögliche Farben für die Lösung vorgesehen
             if (logik.dieSchwierigkeit>1){
             if (logik.loesung[i] == 3) {
                    switch (i) {
                    case 0: g.drawImage(gelberKreis, 75,717, null); break;
                    case 1: g.drawImage(gelberKreis, 175, 717, null); break;
                    case 2: g.drawImage(gelberKreis, 275, 717, null); break;
                    case 3: g.drawImage(gelberKreis, 375, 717, null); break;
                    }
             }
             if (logik.loesung[i] == 4) {
                    switch (i) {
                    case 0: g.drawImage(grünerKreis, 75,717, null); break;
                    case 1: g.drawImage(grünerKreis, 175, 717, null); break;
                    case 2: g.drawImage(grünerKreis, 275, 717, null); break;
                    case 3: g.drawImage(grünerKreis, 375, 717, null); break;
                    }
             }
             // wenn die Schwierigkeit größer als 2 (schwer) ist, sind erneut mehr mögliche Farben für die Lösung vorgesehen
             if (logik.dieSchwierigkeit>2){
             if (logik.loesung[i] == 5) {
                    switch (i) {
                    case 0: g.drawImage(orangenerKreis, 75,717, null); break;
                    case 1: g.drawImage(orangenerKreis, 175, 717, null); break;
                    case 2: g.drawImage(orangenerKreis, 275, 717, null); break;
                    case 3: g.drawImage(orangenerKreis, 375, 717, null); break;
                    }
             }
             if (logik.loesung[i] == 6) {
                    switch (i) {
                    case 0: g.drawImage(braunerKreis, 75,717, null); break;
                    case 1: g.drawImage(braunerKreis, 175, 717, null); break;
                    case 2: g.drawImage(braunerKreis, 275, 717, null); break;
                    case 3: g.drawImage(braunerKreis, 375, 717, null); break;
                    }
             }
             }
             }
       }
       // je nachdem, ob man gewonnen hat oder nicht, wird das winner / loser Bild gezeichnet 
       if (logik.tempRichtig == 4) {
			g.drawImage(winner, 0, 0, null);
		} else {
			g.drawImage(loser, 0, 0, null);
		}
       done = true;
       }
}

	// Laden der Bilder 
	private BufferedImage load(String name) {
		try {

			return ImageIO.read(new File(name));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

@Override
public void keyPressed(KeyEvent e) {
	try {
	switch(e.getKeyCode()){
	// sobald Pfeiltaste nach oben/unten/w/s gedrückt wird, wird die nächste mögliche Farbe, abhängig vom Schwierigkeitsgrad, angezeigt
	case KeyEvent.VK_KP_UP:
		zaehlerFarbe++;
		if (zaehlerFarbe > 2*logik.dieSchwierigkeit) {
			zaehlerFarbe = 1;
		}
		logik.versuch[zaehlerPosition][logik.dieVersuche] = zaehlerFarbe;
		repaint();	// mit der repaint Methode wird die paint Methode erneut aufgerufen und die Bilder werden gezeichnet 
		break;
	case KeyEvent.VK_UP:
		zaehlerFarbe++;
		if (zaehlerFarbe > 2*logik.dieSchwierigkeit) {
			zaehlerFarbe = 1;
		}
		logik.versuch[zaehlerPosition][logik.dieVersuche] = zaehlerFarbe;
		repaint();
		break;
	case KeyEvent.VK_KP_DOWN:
		zaehlerFarbe--;
		if (zaehlerFarbe < 1) {
			zaehlerFarbe = 2*logik.dieSchwierigkeit;
		}
		logik.versuch[zaehlerPosition][logik.dieVersuche] = zaehlerFarbe;
		repaint();
		break;
	case KeyEvent.VK_DOWN:
		zaehlerFarbe--;
		if (zaehlerFarbe < 1) {
			zaehlerFarbe = 2*logik.dieSchwierigkeit;
		}
		logik.versuch[zaehlerPosition][logik.dieVersuche] = zaehlerFarbe;
		repaint();
		break;
	// wenn die Pfeiltaste nach rechts/d gedrückt wird, kann der nächste Kreis mit einer Farbe ausgefüllt werden
	case KeyEvent.VK_KP_RIGHT:
		zaehlerPosition++;
		if (zaehlerPosition > 3 ) {
			zaehlerPosition = 3;
		}
		zaehlerFarbe = logik.versuch[zaehlerPosition][logik.dieVersuche];
		repaint();
        break;
	case KeyEvent.VK_RIGHT:
		zaehlerPosition++;
		if (zaehlerPosition > 3 ) {
			zaehlerPosition = 3;
		}
		zaehlerFarbe = logik.versuch[zaehlerPosition][logik.dieVersuche];
		repaint();
		break;
	// Wenn die Pfeiltaste nach links / a gedrückt wird, kann der vorherige Kreis mit einer Farbe erneut ausgefüllt werden
	case KeyEvent.VK_KP_LEFT:
		zaehlerPosition--;
		if (zaehlerPosition < 0) {
			zaehlerPosition = 0;
		}
		zaehlerFarbe = logik.versuch[zaehlerPosition][logik.dieVersuche];
		repaint();
		break;
	case KeyEvent.VK_LEFT:
		zaehlerPosition--;
		if (zaehlerPosition < 0) {
			zaehlerPosition = 0;
		}
		zaehlerFarbe = logik.versuch[zaehlerPosition][logik.dieVersuche];
		repaint();
		break;
	}
	} catch (Exception f){}
	repaint();
}

@Override
public void keyReleased(KeyEvent e) {


}

public void keyTyped(KeyEvent e) {
     buchstabenUmwandeln(e);
     try{
	     switch(e.getKeyChar()){
	     case KeyEvent.VK_W:
	    	 zaehlerFarbe++;
	    	 if (zaehlerFarbe > 2*logik.dieSchwierigkeit) {
	    		 zaehlerFarbe = 1;
	    	 }
	    	 logik.versuch[zaehlerPosition][logik.dieVersuche] = zaehlerFarbe;
	    	 repaint();
	         break;
	     case KeyEvent.VK_S:
	    	 zaehlerFarbe--;
	    	 if (zaehlerFarbe < 1) {
	    		 zaehlerFarbe = 2*logik.dieSchwierigkeit;
	    	 }
	    	 logik.versuch[zaehlerPosition][logik.dieVersuche] = zaehlerFarbe;
	    	 repaint();
	         break;
	     case KeyEvent.VK_D:
	    	 zaehlerPosition++;
	    	 if (zaehlerPosition > 3 ) {
	    		 zaehlerPosition = 3;
	    	 }
	    	 zaehlerFarbe = logik.versuch[zaehlerPosition][logik.dieVersuche];
	    	 repaint();
	         break;
	     case KeyEvent.VK_A:
	    	 zaehlerPosition--;
	    	 if (zaehlerPosition < 0) {
	    		 zaehlerPosition = 0;
	    	 }
	    	 zaehlerFarbe = logik.versuch[zaehlerPosition][logik.dieVersuche];
	    	 repaint();
	         break;
	     // Wenn Enter gedrückt wird, wird die nächste Zeile zum Farbe auswählen aufgerufen
	     case KeyEvent.VK_ENTER:
	    	 int gesetzt = 0;
	    	 // wenn done = true ist, dann wird das Hauptmenü angezeigt , done = true, wenn der Zähler vom Enter = 10 ist 
	    	 if(done){
	    		 done=false;
	    		 MenuManager.showMainMenu();
	    	 }
	    	 for (int i = 0; i<4 ; i++) {
	    		 if (testEnter < 10 && logik.versuch[i][logik.dieVersuche]!=0){
	    			 gesetzt++;
	    		 }
	    	 }
	    	 if (gesetzt==4){
	    		 testEnter++;
	    		 if (testEnter > 9) {
	    			 repaint();
	    		 }
	    		 zaehlerPosition = 0;
	    		 zaehlerFarbe = 0;
	    		 logik.derVergleich();
	    		 if(logik.tempRichtig == 4){
	    			 logik.dieVersuche = 10;
	    			 testEnter = 10;
	    			 repaint();
	    		 }
	    	 }
	    	 repaint();
	    	 break;
	    // Wenn die ESC Taste gedrückt wird, erscheint ein Fenster, ob man zurück zum Hauptmenü möchte
	     case KeyEvent.VK_ESCAPE:
	    	 if(done){
	    		 done = false;
	    		 MenuManager.showMainMenu();
	    	 }else{
	    		 angabeAbbrechen=JOptionPane.showConfirmDialog(null, "Zurück zum Hauptmenü?", "Abbrechen?", JOptionPane.OK_CANCEL_OPTION);
	    		 if (angabeAbbrechen == 0) {
	    			 MenuManager.showMainMenu();
	    		 }
	    	 }
	    	 break;
	    // mit H kann die Hilfe angezeigt werden oder wieder entfernt werden 
	     case KeyEvent.VK_H:
	    	 if(helpDisplayed){
	    		 helpDisplayed = false;
	    		 MenuManager.showGame();
	    	 }else{
	    		 showHelpInGame();
	    	 }
	     }
     }catch(Exception f){
     }
}
// Hilfe wird angezeigt 
public void showHelpInGame(){
	MenuManager.setAllInvisible();
	MenuManager.help.setVisible(true);
	
	helpDisplayed = true;

	MenuManager.removeAllContentPane();
	MenuManager.mainFrame.getContentPane().add(MenuManager.help);
}

public void buchstabenUmwandeln(KeyEvent e) {
     // Die eingebebenen Buchstaben werden von Großbuchstaben in Kleinbuchstaben umgewandelt
     if (e.getID() == KeyEvent.KEY_TYPED) {
     e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
     }
}

}