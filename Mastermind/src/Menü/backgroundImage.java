package Menü;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class backgroundImage extends JPanel {
	

		  private Image backgroundImage;

		  // Some code to initialize the background image.
		  // Here, we use the constructor to load the image. This
		  // can vary depending on the use case of the panel.
		 
		  public void paintComponent(Graphics g) {
		    super.paintComponent(g);

		    // Draw the background image.
		    g.drawImage(Toolkit.getDefaultToolkit().getImage("C:/Users/staniend/workspace/Test/src/Men_1_.jpg"), -10, 0, this);
		  }
		  
		  public backgroundImage(String fileName) throws IOException {
			    backgroundImage = ImageIO.read(new File(fileName));
			  }
		}

