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

	protected BufferedImage hintergrund, roterKreis, blauerKreis, gelberKreis, grünerKreis, orangenerKreis, weißerKreis,
			schwarzerKreis, braunerKreis, kreuz, winner, loser, balken;
	protected int zaehlerFarbe = 0;
	protected int zaehlerPosition = 0;
	SpielLogik logik = new SpielLogik(MenuManager.gameMode);
	protected int testEnter = 0;
	protected int angabeAbbrechen = 5;
	protected boolean done = false;
	protected boolean helpDisplayed = false;

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
		if (MenuManager.gameMode != 0) {
			logik = new SpielLogik(MenuManager.gameMode);
			zaehlerFarbe = 0;
			zaehlerPosition = 0;
			testEnter = 0;
			MenuManager.gameMode = 0;
		}
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		g.drawImage(hintergrund, 0, 0, null);

		
		
     for (int i = 0; i<logik.versuch.length;i++) {
            for (int j = 0; j<logik.versuch[i].length;j++) {
     if (logik.versuch[i][j] == 1) {
            switch (i) {
            case 0: g.drawImage(roterKreis, 75,      16+72*j, null); break;
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
   g.drawImage(balken, 100*zaehlerPosition, 6+72*logik.dieVersuche,null);
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
       if (logik.tempRichtig == 4) {
			g.drawImage(winner, 0, 0, null);
		} else {
			g.drawImage(loser, 0, 0, null);
		}
       done = true;
       }
}


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
	case KeyEvent.VK_KP_UP:
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
	case KeyEvent.VK_KP_RIGHT:
		zaehlerPosition++;
		if (zaehlerPosition > 3 ) {
			zaehlerPosition = 3;
		}
		zaehlerFarbe = logik.versuch[zaehlerPosition][logik.dieVersuche];
		repaint();
        break;
	case KeyEvent.VK_KP_LEFT:
		zaehlerPosition--;
		if (zaehlerPosition < 0) {
			zaehlerPosition = 0;
		}
		zaehlerFarbe = logik.versuch[zaehlerPosition][logik.dieVersuche];
		repaint();
		break;
	case KeyEvent.VK_UP:
		zaehlerFarbe++;
		if (zaehlerFarbe > 2*logik.dieSchwierigkeit) {
			zaehlerFarbe = 1;
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
	case KeyEvent.VK_RIGHT:
		zaehlerPosition++;
		if (zaehlerPosition > 3 ) {
			zaehlerPosition = 3;
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
	     case KeyEvent.VK_ENTER:
	    	 int gesetzt = 0;
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
	     case KeyEvent.VK_ESCAPE:
	    	 if(done){
	    		 MenuManager.showMainMenu();
	    	 }else{
	    		 angabeAbbrechen=JOptionPane.showConfirmDialog(null, "Zurück zum Hauptmenü?", "Abbrechen?", JOptionPane.OK_CANCEL_OPTION);
	    		 if (angabeAbbrechen == 0) {
	    			 MenuManager.showMainMenu();
	    		 }
	    	 }
	    	 break;
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