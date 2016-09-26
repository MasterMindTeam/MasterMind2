package Menü;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.IOException;
public class MainMenu {
	
	public MainMenu() throws IOException{
		
		JFrame main = new JFrame("Main");
		main.setSize(600, 800);
		main.setLocationRelativeTo(null);
		main.getContentPane().add(new backgroundImage("C:/Users/staniend/workspace/Test/src/Men_1_.jpg"));
			
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
