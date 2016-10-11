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
	
	protected BufferedImage hintergrund,roterKreis,blauerKreis,gelberKreis,gr�nerKreis,orangenerKreis,
	wei�erKreis,schwarzerKreis,braunerKreis;
	protected int zaehlerFarbe = 0;
	protected int [][] arrayFarbe = new int[8][10];
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
		gr�nerKreis = load("Gr�nerKreis.png");
		orangenerKreis = load("OrangenerKreis.png");
		braunerKreis = load("BraunerKreis.png");
		wei�erKreis = load("Wei�erKreis.png");
		schwarzerKreis = load("SchwarzerKreis.png");
	}
	
	
	
	public void paint(Graphics gr) {
		if(MenuManager.resetSpiel){
			MenuManager.resetSpiel = false;
			objekt123 = new SpielLogik(2);
			arrayFarbe = new int [8][10];
			zaehlerFarbe = 0;
			zaehlerPosition = 0;
			testEnter = 0;
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
					case 0: g.drawImage(gr�nerKreis, 75,717, null); break;
					case 1: g.drawImage(gr�nerKreis, 175, 717, null); break;
					case 2: g.drawImage(gr�nerKreis, 275, 717, null); break;
					case 3: g.drawImage(gr�nerKreis, 375, 717, null); break;
					}
				}
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
		for (int i = 0; i<arrayFarbe.length;i++) {
			for (int j = 0; j<arrayFarbe[i].length;j++) {
		if (arrayFarbe[i][j] == 1) {
			switch (i) {
			case 0: g.drawImage(roterKreis, 75,	 16+72*j, null); break;
			case 1: g.drawImage(roterKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(roterKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(roterKreis, 375, 16+72*j, null); break;
			}
		}
		if (arrayFarbe[i][j] == 2) {
			switch (i) {
			case 0: g.drawImage(blauerKreis, 75,  16+72*j, null); break;
			case 1: g.drawImage(blauerKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(blauerKreis, 275, 16+72*j, null);  	break;
			case 3: g.drawImage(blauerKreis, 375, 16+72*j, null); break;
			}
		}
		if (arrayFarbe[i][j] == 3) {
			switch (i) {
			case 0: g.drawImage(gelberKreis, 75,16+72*j, null); break;
			case 1: g.drawImage(gelberKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(gelberKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(gelberKreis, 375, 16+72*j, null); break;
			}
		}
		if (arrayFarbe[i][j] == 4) {
			switch (i) {
			case 0: g.drawImage(gr�nerKreis, 75,16+72*j, null); break;
			case 1: g.drawImage(gr�nerKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(gr�nerKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(gr�nerKreis, 375, 16+72*j, null); break;
			}
		}
		if (arrayFarbe[i][j] == 5) {
			switch (i) {
			case 0: g.drawImage(orangenerKreis, 75,16+72*j, null); break;
			case 1: g.drawImage(orangenerKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(orangenerKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(orangenerKreis, 375, 16+72*j, null); break;
			}
		}
		if (arrayFarbe[i][j] == 6) {
			switch (i) {
			case 0: g.drawImage(braunerKreis, 75,16+72*j, null); break;
			case 1: g.drawImage(braunerKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(braunerKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(braunerKreis, 375, 16+72*j, null); break;
			}	
		}
		}
		}
		g.drawImage(wei�erKreis,540,14,null);
		g.drawImage(schwarzerKreis, 508, 14, null);
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
				if (zaehlerFarbe > 6) {
					zaehlerFarbe = 1;
				}
				arrayFarbe[zaehlerPosition][objekt123.dieVersuche] = zaehlerFarbe;
				repaint();
			} catch (Exception f) {
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_S) {
			try {
				zaehlerFarbe--;
				if (zaehlerFarbe < 1) {
					zaehlerFarbe = 6;
				}
				arrayFarbe[zaehlerPosition][objekt123.dieVersuche] = zaehlerFarbe;
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
				zaehlerFarbe = 0;
			} catch (Exception f) {
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_A) {
			try {
				zaehlerPosition--;
				if (zaehlerPosition < 0) {
					zaehlerPosition = 0;
				}
				zaehlerFarbe = 0;
			} catch (Exception f) {
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			try {
				int gesetzt = 0;
				for (int i = 0; i<4 ; i++) {
					if (arrayFarbe[i][objekt123.dieVersuche]!=0){
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
					objekt123.setVersuch(arrayFarbe);
					objekt123.derVergleich2();
					if(objekt123.tempRichtig == 4){
						testEnter = 10;
						repaint();
					}
					System.out.println();
					System.out.println("L�sung: ");
					for ( int j = 0; j<4; j++){
						switch (objekt123.loesung[j]){
						case 1:
							System.out.print("rot   ");
							break;
						case 2:
							System.out.print("blau   ");
							break;
						case 3:
							System.out.print("gelb   ");
							break;
						case 4:
							System.out.print("gr�n    ");
							break;
						}
					}
				}
			} catch (Exception f) {
			}
		}
		if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
		angabeAbbrechen=JOptionPane.showConfirmDialog(null, "Zur�ck zum Hauptmen�?", "Abbrechen?", JOptionPane.OK_CANCEL_OPTION);
		if (angabeAbbrechen == 0) {
			MenuManager.showMainMenu();
		}
		}
		
	}
	
	public void buchstabenUmwandeln(KeyEvent e) {
		// Die eingebebenen Buchstaben werden von Gro�buchstaben in Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
		e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}
	}



}

