import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

// Aufzählung der Positionen im Hauptmenü
enum MainMenuPositions {
	NEUESSPIEL, HIGHSCORE, HILFE, CREDITS;
	private static MainMenuPositions[] vals = values();

	public MainMenuPositions next() {
		return vals[(this.ordinal() + 1) % vals.length];
	}

	public MainMenuPositions previous() {
		int rest = (this.ordinal() - 1) % vals.length;
		if (rest < 0) {
			rest += vals.length;
		}
		return vals[rest];
	}
}



public class MainMenu extends JPanel implements KeyListener {

	// Speichert die aktuelle Position des Zeigers (bb8) im Hauptmenü
	private MainMenuPositions currentMainMenu = MainMenuPositions.NEUESSPIEL;	

	private BufferedImage bg, bb8, sub, hilfe, credits;

	public MainMenu() throws IOException {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		setVisible(false);
		bg = load("src/Men_1_.jpg");
		bb8 = load("src/BB8.png");
	}		

	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		g.drawImage(bg, -10, 0, null);

		switch (currentMainMenu) {
		case NEUESSPIEL:
			g.drawImage(bb8, 30, 240, 90, 90, this);
			break;
		case HIGHSCORE:
			g.drawImage(bb8, 30, 320, 90, 90, this);
			break;
		case HILFE:
			g.drawImage(bb8, 30, 410, 90, 90, this);
			break;
		case CREDITS:
			g.drawImage(bb8, 30, 490, 90, 90, this);
			break;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		buchstabenUmwandeln(e);

		switch (e.getKeyChar()) {
		case KeyEvent.VK_S:
			sPressed();
			break;
		case KeyEvent.VK_W:
			wPressed();
			break;
		case KeyEvent.VK_ESCAPE:
			zPressed();
			break;
		case KeyEvent.VK_Z:
			zPressed();
			break;
		case KeyEvent.VK_ENTER:
			enterPressed();
			break;
		}
		repaint();

		// if (e.getKeyChar() == KeyEvent.VK_S && zaehler < options.length) {
		// zaehler++;
		// repaint();
		// }
		// if (e.getKeyChar() == KeyEvent.VK_S && counter < optionen.length) {
		// counter++;
		// repaint();
		// }
		// if (e.getKeyChar() == KeyEvent.VK_W && zaehler > 1) {
		// zaehler--;
		// repaint();
		// }
		//
		// if (e.getKeyChar() == KeyEvent.VK_W && counter > 1) {
		// counter--;
		// repaint();
		// }
		//
		// if (e.getKeyChar() == KeyEvent.VK_ESCAPE || e.getKeyChar() ==
		// KeyEvent.VK_Z) {
		// zaehler = 1;
		// counter = 0;
		// pointer = 0;
		// credit = 0;
		// repaint();
		//
		// }
		//
		// if (e.getKeyChar() == KeyEvent.VK_ENTER) {
		// if (zaehler == 1) {
		// pointer = 1;
		// repaint();
		//
		// }
		//
		// if (zaehler == 3) {
		// pointer = 2;
		// repaint();
		//
		// }
		//
		// if (zaehler == 4) {
		// pointer = 3;
		// repaint();
		// }
		//
		// }
	}

	private void sPressed() {
		currentMainMenu = currentMainMenu.next();
	}

	private void wPressed() {
		currentMainMenu = currentMainMenu.previous();
	}

	private void enterPressed() {
		if (currentMainMenu==MainMenuPositions.NEUESSPIEL){
			MenuManager.showSubMenu();
		}
		
		if(currentMainMenu==MainMenuPositions.HILFE){
			MenuManager.showHelpMenu();
		}
		
		if (currentMainMenu == MainMenuPositions.CREDITS){
			MenuManager.showCreditsMenu();
		}
		
	
		
				

	}
	
	
	private void zPressed(){
		MenuManager.showMainMenu();
	}

	public void buchstabenUmwandeln(KeyEvent e) {
		// Die eingebebenen Buchstaben werden von Großbuchstaben in
		// Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
			e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}

	}

}