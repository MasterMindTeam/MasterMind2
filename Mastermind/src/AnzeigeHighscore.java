import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AnzeigeHighscore extends JPanel implements KeyListener {

	// Variablendeklaration
	protected BufferedImage anzeigeHintergrund;
	protected static JTextArea taAusgabeHighscore;

	// Konstruktor, in dem die verschiedenen Komponenten sowie das
	// Hintergrundbild hinzugef�gt werden
	public AnzeigeHighscore() {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		anzeigeHintergrund = load("Mastermind/src/Highscore_2.png");
		taAusgabeHighscore = new JTextArea(MenuManager.name);
		taAusgabeHighscore.setBackground(SystemColor.window);
		taAusgabeHighscore.setBounds(70, 350, 450, 250);
		taAusgabeHighscore.setFont(new Font("HP Simplified", Font.PLAIN, 20));
		taAusgabeHighscore.setEnabled(false);
		taAusgabeHighscore.setDisabledTextColor(Color.black);
		setVisible(false);
	}

	public void paint(Graphics gr) {
		super.paintComponent(gr);
		AnzeigeHighscore.taAusgabeHighscore.setText("");
		// In dem Highscore Array befindet sich die Anzahl der Versuche sowie
		// der zugeoerige Name
		// Die TextArea taAusgabeHighscore wird mit den Werten von dem Array
		// bef�llt, je nach gewaehlter Schwierigkeit (leicht/mittel/schwer)
		switch (MenuManager.gameMode) {
		case 1:
			Gewonnen.highscoreArray = Gewonnen.arrayDeepCopy(Gewonnen.highscoreArray1);
			break;
		case 2:
			Gewonnen.highscoreArray = Gewonnen.arrayDeepCopy(Gewonnen.highscoreArray2);
			break;
		case 3:
			Gewonnen.highscoreArray = Gewonnen.arrayDeepCopy(Gewonnen.highscoreArray3);
			break;
		}
		for (int i = 0; i < 10; i++) {
			// Ist der Wert an einem bestimmten Index "null" oder "99" (also der
			// Standardwert) wird nichts ausgegeben
			if (Gewonnen.highscoreArray[i][0] != null && Integer.parseInt(Gewonnen.highscoreArray[i][0]) != 99) {
				AnzeigeHighscore.taAusgabeHighscore.append(i + 1 + ") " + Gewonnen.highscoreArray[i][1] + "\t"
						+ "Anzahl Versuche: " + (Integer.parseInt(Gewonnen.highscoreArray[i][0]) + 1) + "\n");
			} else if (i == 0 && Integer.parseInt(Gewonnen.highscoreArray[i][0]) == 99){
				AnzeigeHighscore.taAusgabeHighscore.append("\n     F�r diese Schwierigkeit wurden noch\n     keine Highscores aufgestellt.");
			}
		}
		// Hintergrundbild wird gezeichnet
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		g.drawImage(anzeigeHintergrund, -5, 0, null);
	}

	// Methode zum Laden der Bilder
	public static BufferedImage load(String name) {
		try {
			return ImageIO.read(new File(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	// KeyListener, der auf die Tasten ESC und Z reagiert, man landet wieder im
	// Hauptmen�
	public void keyTyped(KeyEvent e) {
		buchstabenUmwandeln(e);
		// TODO Auto-generated method stub
		if (e.getKeyChar() == KeyEvent.VK_ESCAPE || e.getKeyChar() == KeyEvent.VK_Z) {
			MenuManager.showMainMenu();
		}
	}

	public void buchstabenUmwandeln(KeyEvent e) {
		// Die eingebebenen Buchstaben werden von Gro�buchstaben in
		// Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
			e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}

	}

}
