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

// Aufz�hlung der Positionen im Hauptmen�


public class BildWinner extends JPanel implements KeyListener {

	// Speichert die aktuelle Position des Zeigers (bb8) im Hauptmen�

	private BufferedImage  winner;

	public BildWinner() throws IOException {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		setVisible(false);

		winner = load("src/Gewonnen.png");		
	}

	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());

		g.drawImage(winner, 0, 0, this);

		

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
		// Die eingebebenen Buchstaben werden von Gro�buchstaben in
		// Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
			e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}

	}

}


