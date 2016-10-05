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

public class MainMenu extends JPanel implements KeyListener{
	
	protected BufferedImage bg, bb8;
	int zaehler = 0;
	private String[] options ={"START", "HIGHSCORE","HILFE", "CREDITS"};
	
	public MainMenu() {
		setLayout(null);
		this.setPreferredSize(new Dimension(800,600));
		setVisible(true);
		bg = load("C:/Users/staniend/workspace/Test/src/Men_1_.jpg");
		bb8 = load("C:/Users/staniend/git/mastermind/Mastermind/src/Menü/BB8.png");
		
	}
	
	public static void main (String[] args) {
		MainMenu brett = new MainMenu();
		brett.methode(brett);

	}
	
	public void methode(MainMenu brett) {
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
		g.drawImage(bg,-10,0,null);
		
		if (zaehler == 1) {
			g.drawImage(bb8, 30,240, 90,90, this);
		}
		if (zaehler == 2) {
			 g.drawImage(bb8, 30,320, 90,90,this);
		}
		if (zaehler == 3) {
			g.drawImage(bb8, 30,410, 90,90,this);
		}
		if (zaehler == 4) {
			g.drawImage(bb8, 30,490, 90,90,this);
		}
		
//		g.drawImage(weißerKreis,540,14,null);
//		g.drawImage(schwarzerKreis, 508, 14, null);
	}

	
	public static BufferedImage load (String name) {
		try {
			BufferedImage img = ImageIO.read(new File(name));
					
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

	@Override
	public void keyTyped(KeyEvent e) {
		buchstabenUmwandeln(e);
		if (e.getKeyChar() == KeyEvent.VK_S && zaehler < options.length) {
			System.out.println("hi");
			zaehler++;
			repaint();
		}
		
		if (e.getKeyChar()== KeyEvent.VK_W && zaehler > 1){
			zaehler--;
			repaint();
		}
		
		
		
	
		
	}
	
	public void buchstabenUmwandeln(KeyEvent e) {
		// Die eingebebenen Buchstaben werden von Großbuchstaben in Kleinbuchstaben umgewandelt
		if (e.getID() == KeyEvent.KEY_TYPED) {
		e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
		}
	}








}