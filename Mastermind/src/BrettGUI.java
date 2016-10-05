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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class BrettGUI extends JPanel implements KeyListener{
	
	protected BufferedImage hintergrund,roterKreis,blauerKreis,gelberKreis,grünerKreis,orangenerKreis,
	weißerKreis,schwarzerKreis,braunerKreis;
	int zaehlerFarbe = 0;
	int [][] arrayFarbe = new int[8][10];
	int zaehlerPosition = 0;
	SpielLogik objekt123 = new SpielLogik(2);

	
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
	}
	
	public static void main (String[] args) {
		BrettGUI brett = new BrettGUI();
		brett.methode(brett);
	}
	
	public void methode(BrettGUI brett) {
		JFrame jf = new JFrame();
		jf.addKeyListener(this);
		jf.setSize(600, 800);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().add(brett);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		g.drawImage(hintergrund,0,0,null);
		
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
			case 2: g.drawImage(blauerKreis, 275, 16+72*j, null); break;
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
			case 0: g.drawImage(grünerKreis, 75,16+72*j, null); break;
			case 1: g.drawImage(grünerKreis, 175, 16+72*j, null); break;
			case 2: g.drawImage(grünerKreis, 275, 16+72*j, null); break;
			case 3: g.drawImage(grünerKreis, 375, 16+72*j, null); break;
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
		g.drawImage(weißerKreis,540,14,null);
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
			zaehlerFarbe++;
			if (zaehlerFarbe > 6) {
				zaehlerFarbe = 1;
			}
			arrayFarbe[zaehlerPosition][objekt123.dieVersuche] = zaehlerFarbe;
			repaint();
		}
		if (e.getKeyChar() == KeyEvent.VK_S) {
			zaehlerFarbe--;
			if (zaehlerFarbe < 1) {
				zaehlerFarbe = 6;
			}
			arrayFarbe[zaehlerPosition][objekt123.dieVersuche] = zaehlerFarbe;
			repaint();
		}
		if (e.getKeyChar() == KeyEvent.VK_D) {
			zaehlerPosition++;
			
			if (zaehlerPosition > 3 ) {
				zaehlerPosition = 3;
			}
			zaehlerFarbe = 0;
		}
		if (e.getKeyChar() == KeyEvent.VK_A) {
			zaehlerPosition--;
			if (zaehlerPosition < 0) {
				zaehlerPosition = 0;
			}
			zaehlerFarbe = 0;
		}
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			int gesetzt = 0;
			for (int i = 0; i<4 ; i++) {
				if (arrayFarbe[i][objekt123.dieVersuche]!=0){
					gesetzt++;
				}
			}
			if (gesetzt==4){
				objekt123.dieVersuche++;
				zaehlerPosition = 0;
				zaehlerFarbe = 0;
				
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

