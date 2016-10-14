import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class BrettGUI extends JPanel implements KeyListener{
	
	protected BufferedImage hintergrund,roterKreis,blauerKreis,gelberKreis,grünerKreis,orangenerKreis,
	weißerKreis,schwarzerKreis,braunerKreis,kreuz;
	protected int zaehlerFarbe = 0;
	protected int zaehlerPosition = 0;
	SpielLogik objekt123 = new SpielLogik(2);
	protected int testEnter = 0;
	protected int angabeAbbrechen=5;

	
	public BrettGUI() {
		setLayout(null);
		this.setPreferredSize(new Dimension(800,600));
		setVisible(true);
		hintergrund = load("MastermindBild.png");
		roterKreis = load("RoterKreis.png");
		blauerKreis = load("BlauerKreis.png");
		gelberKreis = load("GelberKreis.png");
		grünerKreis = load("GrünerKreis.png");
		orangenerKreis = load("OrangenerKreis.png");
		braunerKreis = load("BraunerKreis.png");
		weißerKreis = load("WeißerKreis.png");
		schwarzerKreis = load("SchwarzerKreis.png");
		kreuz = load("Kreuz.png");
	}
	
	
	
	public void paint(Graphics gr) {
		if(MenuManager.gameMode!=0){
			objekt123 = new SpielLogik(MenuManager.gameMode);
			zaehlerFarbe = 0;
			zaehlerPosition = 0;
			testEnter = 0;
			MenuManager.gameMode = 0;
		}
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		g.drawImage(hintergrund,0,0,null);
		
		if (testEnter > 9) {
			for (int i = 0; i<objekt123.loesung.length;i++) {
				if (objekt123.loesung[i] == 1) {
					switch (i) {
					case 0: g.drawImage(roterKreis, 75,	 717, null); break;
					case 1: g.drawImage(roterKreis, 175, 717, null); break;
					case 2: g.drawImage(roterKreis, 275, 717, null); break;
					case 3: g.drawImage(roterKreis, 375, 717, null); break;
					}
				}
				if (objekt123.loesung[i] == 2) {
					switch (i) {
					case 0: g.drawImage(blauerKreis, 75,  717, null); break;
					case 1: g.drawImage(blauerKreis, 175, 717, null); break;
					case 2: g.drawImage(blauerKreis, 275, 717, null); break;
					case 3: g.drawImage(blauerKreis, 375, 717, null); break;
					}
				}
				if (objekt123.dieSchwierigkeit>1){
				if (objekt123.loesung[i] == 3) {
					switch (i) {
					case 0: g.drawImage(gelberKreis, 75,717, null); break;
					case 1: g.drawImage(gelberKreis, 175, 717, null); break;
					case 2: g.drawImage(gelberKreis, 275, 717, null); break;
					case 3: g.drawImage(gelberKreis, 375, 717, null); break;
					}
				}
				if (objekt123.loesung[i] == 4) {
					switch (i) {
					case 0: g.drawImage(grünerKreis, 75,717, null); break;
					case 1: g.drawImage(grünerKreis, 175, 717, null); break;
					case 2: g.drawImage(grünerKreis, 275, 717, null); break;
					case 3: g.drawImage(grünerKreis, 375, 717, null); break;
					}
				}
				if (objekt123.dieSchwierigkeit>2){
				if (objekt123.loesung[i] == 5) {
					switch (i) {
					case 0: g.drawImage(orangenerKreis, 75,717, null); break;
					case 1: g.drawImage(orangenerKreis, 175, 717, null); break;
					case 2: g.drawImage(orangenerKreis, 275, 717, null); break;
					case 3: g.drawImage(orangenerKreis, 375, 717, null); break;
					}
				}
				if (objekt123.loesung[i] == 6) {
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
			}
		for (int i = 0; i<objekt123.versuch.length;i++) {
			for (int j = 0; j<objekt123.versuch[i].length;j++) {
		if (objekt123.versuch[i][j] == 1) {
			switch (i) {
			case 0: g.drawImage(roterKreis, 75,	 16+72*j, null); break;
			case 1: g.drawImage(roterKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(roterKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(roterKreis, 375, 16+72*j, null); break;
			}
		}
		if (objekt123.versuch[i][j] == 2) {
			switch (i) {
			case 0: g.drawImage(blauerKreis, 75,  16+72*j, null); break;
			case 1: g.drawImage(blauerKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(blauerKreis, 275, 16+72*j, null);  	break;
			case 3: g.drawImage(blauerKreis, 375, 16+72*j, null); break;
			}
		}
		if (objekt123.versuch[i][j] == 3) {
			switch (i) {
			case 0: g.drawImage(gelberKreis, 75,16+72*j, null); break;
			case 1: g.drawImage(gelberKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(gelberKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(gelberKreis, 375, 16+72*j, null); break;
			}
		}
		if (objekt123.versuch[i][j] == 4) {
			switch (i) {
			case 0: g.drawImage(grünerKreis, 75,16+72*j, null); break;
			case 1: g.drawImage(grünerKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(grünerKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(grünerKreis, 375, 16+72*j, null); break;
			}
		}
		if (objekt123.versuch[i][j] == 5) {
			switch (i) {
			case 0: g.drawImage(orangenerKreis, 75,16+72*j, null); break;
			case 1: g.drawImage(orangenerKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(orangenerKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(orangenerKreis, 375, 16+72*j, null); break;
			}
		}
		if (objekt123.versuch[i][j] == 6) {
			switch (i) {
			case 0: g.drawImage(braunerKreis, 75,16+72*j, null); break;
			case 1: g.drawImage(braunerKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(braunerKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(braunerKreis, 375, 16+72*j, null); break;
			}	
		}
		}
		}
		for (int i = 0; i<objekt123.hint.length; i++){
			for (int j = 0; j<objekt123.hint[i].length; j++){
				if (objekt123.hint[i][j] == 2){
					switch(i) {
					case 0: g.drawImage(schwarzerKreis, 508, 14+72*j, null); break;
					case 1: g.drawImage(schwarzerKreis, 540, 14+72*j, null); break;
					case 2: g.drawImage(schwarzerKreis, 508, 40+72*j, null); break;
					case 3: g.drawImage(schwarzerKreis, 540, 40+72*j, null); break;
					}
				}
				if (objekt123.hint[i][j] == 1){
					switch(i) {
					case 0: g.drawImage(weißerKreis, 508, 14+72*j, null); break;
					case 1: g.drawImage(weißerKreis, 540, 14+72*j, null); break;
					case 2: g.drawImage(weißerKreis, 508, 40+72*j, null); break;
					case 3: g.drawImage(weißerKreis, 540, 40+72*j, null); break;
					}
				}
				if (objekt123.hint[i][j] == 3){
					switch(i) {
					case 0: g.drawImage(kreuz, 508, 14+72*j, null); break;
					case 1: g.drawImage(kreuz, 540, 14+72*j, null); break;
					case 2: g.drawImage(kreuz, 508, 40+72*j, null); break;
					case 3: g.drawImage(kreuz, 540, 40+72*j, null); break;
					}
				}
			}
		}
	}

	
	public static BufferedImage load (String name) {
		try {
			BufferedImage img = ImageIO.read(
					BrettGUI.class.getResourceAsStream(name)
					);
			return img;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		
		buchstabenUmwandeln(e);
		if (e.getKeyChar() == KeyEvent.VK_W) {
			try {
				zaehlerFarbe++;
				if (zaehlerFarbe > 2*objekt123.dieSchwierigkeit) {
					zaehlerFarbe = 1;
				}
				objekt123.versuch[zaehlerPosition][objekt123.dieVersuche] = zaehlerFarbe;
				repaint();
			} catch (Exception f) {
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_S) {
			try {
				zaehlerFarbe--;
				if (zaehlerFarbe < 1) {
					zaehlerFarbe = 2*objekt123.dieSchwierigkeit;
				}
				objekt123.versuch[zaehlerPosition][objekt123.dieVersuche] = zaehlerFarbe;
				repaint();
			} catch (Exception f) {
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_D) {
			try {
				zaehlerPosition++;
				
				if (zaehlerPosition > 3 ) {
					zaehlerPosition = 3;
				}
				zaehlerFarbe = objekt123.versuch[zaehlerPosition][objekt123.dieVersuche];
			} catch (Exception f) {
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_A) {
			try {
				zaehlerPosition--;
				if (zaehlerPosition < 0) {
					zaehlerPosition = 0;
				}
				zaehlerFarbe = objekt123.versuch[zaehlerPosition][objekt123.dieVersuche];
			} catch (Exception f) {
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			try {
				int gesetzt = 0;
				for (int i = 0; i<4 ; i++) {
					if (objekt123.versuch[i][objekt123.dieVersuche]!=0){
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
					objekt123.derVergleich2();
					if(objekt123.tempRichtig == 4){
						objekt123.dieVersuche = 10;
						testEnter = 10;
						repaint();
					}
				}
				repaint();
			} catch (Exception f) {
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
		angabeAbbrechen=JOptionPane.showConfirmDialog(null, "Zurück zum Hauptmenü?", "Abbrechen?", JOptionPane.OK_CANCEL_OPTION);
		if (angabeAbbrechen == 0) {
			MenuManager.showMainMenu();
		}
		}
		
	}
	
	public void buchstabenUmwandeln(KeyEvent e) {
		// Die eingebebenen Buchstaben werden von Großbuchstaben in Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
		e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}
	}



}

