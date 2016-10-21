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

public class BildWinner extends JPanel implements KeyListener {

	private BufferedImage winner;

	public BildWinner() throws IOException {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		setVisible(false);
		// l‰dt das Bild in den Speicher
		winner = load("src/Gewonnen.png");
	}

	// malt das Bild
	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());

		g.drawImage(winner, 0, 0, this);

	}

	// Methode die das BufferedImage l‰dt
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

	// ‹ber Switch Case Auswahl
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

	}

	private void wPressed() {

	}

	private void enterPressed() {
		
	}

	public void buchstabenUmwandeln(KeyEvent e) {
		// Die eingebebenen Buchstaben werden von Groﬂbuchstaben in
		// Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
			e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}

	}

}
