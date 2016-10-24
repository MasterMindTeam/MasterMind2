import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Highscore extends JPanel implements KeyListener {

	protected static JTextField tfName;
	protected static JButton btWeiter;
	protected BufferedImage hintergrundHighscore;
	protected String[] arrayName = new String[100];
	protected int zaehlerArray = 0;

	public Highscore() {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		hintergrundHighscore = load("Highscore.png");
		tfName = new JTextField();
		tfName.setBounds(70, 350, 450, 80);
		tfName.setFont(new Font("HP Simplified", Font.PLAIN, 50));
		tfName.setForeground(Color.BLACK);
		tfName.setDisabledTextColor(Color.black);
		tfName.setHorizontalAlignment(JTextField.CENTER);
		btWeiter = new JButton("Weiter");
		btWeiter.setBounds(240, 470, 100, 60);
		btWeiter.setOpaque(false);
		btWeiter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nameErfassen();
				MenuManager.showSubMenu();
			}
			
		});
		setVisible(false);
	}

	public void paint(Graphics gr) {
		super.paintComponent(gr);
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		g.drawImage(hintergrundHighscore, -10, 0, null);
		// getRootPane().add(tfName);
	}

	public void nameErfassen() {
		arrayName[zaehlerArray] = tfName.getText();
//		for (int j = zaehlerArray; j< arrayName.length; j++) {
//			if(arrayName[j] == null) {
//			}
//			else {
//				System.out.println(arrayName[j]);
//			}
//		}
		zaehlerArray++;
	}
	

	public static BufferedImage load(String name) {
		try {
			BufferedImage img = ImageIO.read(BrettGUI.class.getResourceAsStream(name));
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
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
			MenuManager.showSubMenu();

		}

	}
}
