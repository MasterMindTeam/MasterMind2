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

enum SubMenuPositions {
	LEICHT, MITTEL, SCHWER;
	private static SubMenuPositions[] vals = values();

	public SubMenuPositions next() {
		return vals[(this.ordinal() + 1) % vals.length];
	}

	public SubMenuPositions previous() {
		int rest = (this.ordinal() - 1) % vals.length;
		if (rest < 0) {
			rest += vals.length;
		}
		return vals[rest];
	}
}

public class SubMenuSchwierigkeit extends JPanel implements KeyListener {
	// Speichert die aktuelle Position des Zeigers (bb8) im Hauptmenü

	private SubMenuPositions currentSubMenu = SubMenuPositions.LEICHT;

	private BufferedImage bg, bb8, sub;

	public SubMenuSchwierigkeit() throws IOException {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		setVisible(false);

		bb8 = load("src/BB8.png");
		sub = load("src/Sub.png");
	}

	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());

		g.drawImage(sub, -5, 0, this);

		switch (currentSubMenu) {
		case LEICHT:
			g.drawImage(bb8, 90, 305, 90, 90, this);
			break;
		case MITTEL:
			g.drawImage(bb8, 90, 390, 90, 90, this);
			break;
		case SCHWER:
			g.drawImage(bb8, 90, 450, 90, 90, this);
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

	}

	private void zPressed() {
		MenuManager.showMainMenu();
	}

	private void sPressed() {
		currentSubMenu = currentSubMenu.next();
	}

	private void wPressed() {
		currentSubMenu = currentSubMenu.previous();
	}

	private void enterPressed() {
		if (currentSubMenu == SubMenuPositions.LEICHT) {
			MenuManager.gameMode = 1;
			if(!MenuManager.highscoreOderGame){
				MenuManager.showGame();
			} else if(MenuManager.highscoreOderGame){
				MenuManager.showAnzeigeHighscore();
			}
		}
		if (currentSubMenu == SubMenuPositions.MITTEL) {
			MenuManager.gameMode = 2;
			if(!MenuManager.highscoreOderGame){
				MenuManager.showGame();
			} else if(MenuManager.highscoreOderGame){
				MenuManager.showAnzeigeHighscore();
			}
		}
		if (currentSubMenu == SubMenuPositions.SCHWER) {
			MenuManager.gameMode = 3;
			if(!MenuManager.highscoreOderGame){
				MenuManager.showGame();
			} else if(MenuManager.highscoreOderGame){
				MenuManager.showAnzeigeHighscore();
			}
		}

	}

	public void buchstabenUmwandeln(KeyEvent e) {
		// Die eingebebenen Buchstaben werden von Großbuchstaben in
		// Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
			e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}

	}

}