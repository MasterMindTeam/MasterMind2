package Menü;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JPanel {
	
	private BufferedImage hG,mP1,mP2,mP3, mP4;
	
	public MainMenu() {
		setLayout(null);
		this.setPreferredSize(new Dimension(800,600));
		setVisible(true);
		hG = load("C:/Users/staniend/workspace/Test/src/Men_1_.jpg");
		bildPos1();
		bildPos2();
//		img2 = load("");
//		img3 = load("");
	}
	
	
	public void bildPos1(){
		mP1 = load("C:/Users/staniend/git/mastermind/Mastermind/src/Menü/BB8.png");
	}
	
	public void bildPos2(){
		mP2= load("C:/Users/staniend/git/mastermind/Mastermind/src/Menü/BB8.png");
	}
	
	public void paint(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		
		g.drawImage(hG,-10,0,this);
		g.drawImage(mP1, 30,240, 90,90, this);
		g.drawImage(mP2,30,320, 90,90,this);
		g.drawImage(mP3, 30,410, 90,90,this);
		g.drawImage(mP4,30,490, 90,90,this);
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
	
	public static void main (String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(600, 800);
		jf.setLocationRelativeTo(null);
		jf.getContentPane().add(new MainMenu());
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
	}
}

