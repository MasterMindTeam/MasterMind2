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
		AnzeigeHighscore.taAusgabeHighscore.setText("");
		for (int i = 0; i < 10; i++) {
			System.out.println(MenuManager.gameMode);
			switch(MenuManager.gameMode){
			case 1:
				if(Gewonnen.highscoreArray1[i][0]!=null){
					AnzeigeHighscore.taAusgabeHighscore.append(i + 1 + ") " + Gewonnen.highscoreArray1[i][1] + "\t"
							+ "Anzahl Versuche: " + (Integer.parseInt(Gewonnen.highscoreArray1[i][0]) + 1) + "\n");
				}
				break;
			case 2:
				if(Gewonnen.highscoreArray2[i][0]!=null){
					AnzeigeHighscore.taAusgabeHighscore.append(i + 1 + ") " + Gewonnen.highscoreArray2[i][1] + "\t"
							+ "Anzahl Versuche: " + (Integer.parseInt(Gewonnen.highscoreArray2[i][0]) + 1) + "\n");
				}
				break;
			case 3:
				if(Gewonnen.highscoreArray3[i][0]!=null){
					AnzeigeHighscore.taAusgabeHighscore.append(i + 1 + ") " + Gewonnen.highscoreArray3[i][1] + "\t"
							+ "Anzahl Versuche: " + (Integer.parseInt(Gewonnen.highscoreArray3[i][0]) + 1) + "\n");
				}
				break;
			default: AnzeigeHighscore.taAusgabeHighscore.append("Error404");
			}
		}
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
		// Die eingebebenen Buchstaben werden von Großbuchstaben in
		// Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
			e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}

	}
	

}
