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

public class AnzeigeHighscore extends JPanel implements KeyListener{
	
	protected BufferedImage anzeigeHintergrund;
	protected static JTextArea taAusgabeHighscore;
	protected int angabeAbbrechen = 5;
	protected static String[] namen = new String[100];
	
	public AnzeigeHighscore() {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		anzeigeHintergrund = load("src/Highscore_2.png");
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
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		g.drawImage(anzeigeHintergrund, -5, 0, null);
	}
	
	
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
	public void keyTyped(KeyEvent e) {
		buchstabenUmwandeln(e);
		// TODO Auto-generated method stub
		if (e.getKeyChar() == KeyEvent.VK_ESCAPE||e.getKeyChar() == KeyEvent.VK_Z) {
			MenuManager.showMainMenu();
		}
	}
	public void buchstabenUmwandeln(KeyEvent e) {
		// Die eingebebenen Buchstaben werden von Groﬂbuchstaben in
		// Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
			e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}

	}
	

}
