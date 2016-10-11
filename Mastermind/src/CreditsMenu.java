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
// hallo

public class CreditsMenu extends JPanel implements KeyListener {

	// Speichert die aktuelle Position des Zeigers (bb8) im Hauptmenü

	private BufferedImage  credits;

	public CreditsMenu() throws IOException {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		setVisible(false);

		credits = load("src/Credits.png");		
	}

	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());

		g.drawImage(credits, -10, 0, this);

		

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

	}
	
	private void zPressed(){
		MenuManager.showMainMenu();
	}

	private void sPressed() {
		
	}
	
	

	private void wPressed() {
		
	}

	private void enterPressed() {
		// currentSubMenu = currentSubMenu.LEICHT;
		//
		// case currentMainMenu == NEUESSPIEL
		// MenuManager.Instance.ShowSubMenuNeuesSpiel();

	}

	public void buchstabenUmwandeln(KeyEvent e) {
		// Die eingebebenen Buchstaben werden von Großbuchstaben in
		// Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
			e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}

	}

}

