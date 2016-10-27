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
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Nutzername extends JPanel implements KeyListener {

	protected static JTextField tfName;
	protected static JButton btWeiter;
	protected BufferedImage hintergrundNutzername;

	public Nutzername() {
		setLayout(null);
		this.setPreferredSize(new Dimension(800, 600));
		hintergrundNutzername = load("src/Nutzername.png");
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
				if (tfName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Bitte Namen angeben", "Fehler", JOptionPane.ERROR_MESSAGE);
				}
				else {
					nameErfassen();
					MenuManager.showSubMenu();
				}
			}
			
		});
		setVisible(false);
	}

	public void paint(Graphics gr) {
		super.paintComponent(gr);
		Graphics2D g = (Graphics2D) gr;
		g.setColor(Color.WHITE);
		g.fill(g.getClipBounds());
		g.drawImage(hintergrundNutzername, -5, 0, null);
	}
	
	public void nameErfassen() {
		MenuManager.name = tfName.getText();
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
		switch(e.getKeyChar()){ 
		case KeyEvent.VK_ESCAPE:
			MenuManager.showMainMenu();
			break;
		case KeyEvent.VK_Z:
			MenuManager.showMainMenu();
			break;
		}

	}
}
