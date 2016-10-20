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

//hallo
// Aufzählung der Positionen im Hauptmenü
enum MainMenuPositions {
	NEUESSPIEL, HIGHSCORE, HILFE, CREDITS;
	// Speichert die Positionen in einem Array 
	private static MainMenuPositions[] vals = values();
	
	//ordinal gibt aktuelle Position zurück, und setzt sie Plus ein und nimmt den Modulo von der länge des Arrays
	//Modulo stellt sicher, dass es nicht über die länge des Arrays hinausgeht
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

	//Konstruktor 
	public MainMenu() throws IOException {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		setVisible(false);
		bg = load("src/Menü1.png");
		bb8 = load("src/BB8.png");
	}
	//Malt das Hintergrundbild und den Cursor in den verschiedenen Positionen
	// bekommt das BufferedImage übergeben
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

	//Lädt das Bild in ein BufferedImage
	//wirft IOException
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
		
		//Nach jedem KeyListenerEvent soll die Oberfläche neu gezeichnet werden
		repaint();

	}
	
	
	private void sPressed() {
		//Enumeration wird einen Wert weiter gesetzt
		currentMainMenu = currentMainMenu.next();
	}
	
	

	private void wPressed() {
		//Enumeration wird einen Wert zurück gesetzt
		currentMainMenu = currentMainMenu.previous();
	}
	
	// Methode, die entscheidet, was bei Enter gemacht wird

	private void enterPressed() {
		//wenn Cursor bei Neues Spiel ist, wird das Untermenü aufgerufen
		if (currentMainMenu == MainMenuPositions.NEUESSPIEL) {
			MenuManager.showSubMenu();
		}
		
		//wenn bei Hilfe wird das Hilfemenü aufgerufen

		if (currentMainMenu == MainMenuPositions.HILFE) {
			MenuManager.showHelpMenu();
		}
		// Creditsmenü wird aufgerufen 
		if (currentMainMenu == MainMenuPositions.CREDITS) {
			MenuManager.showCreditsMenu();
		}

	}
	
	//Main Menu wird immer aufgerufen, wenn zurück oder ESC gedrückt wird

	private void zPressed() {
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