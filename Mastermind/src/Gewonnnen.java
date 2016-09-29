import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Gewonnen extends JFrame{
	
	public Gewonnen(){
		super("Gewonnen");
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    add(createMenuPanel());
	    pack();
	    setLocationRelativeTo(null);
	    setVisible(true);
}

private JPanel createMenuPanel() {
    JPanel panel = new JPanel(new GridLayout(0, 1));
    
    JButton start = new JButton("Super!");
    start.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Dummy Knopf
        }
    });
    
    JButton restart = new JButton("Nochmal!");
    restart.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		setVisible(false);
    		GUI.main(null);
    	}
    });
    
    JButton close = new JButton("Close");
    close.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });

    panel.add(start);
    panel.add(restart);
    panel.add(close);
    return panel;
}
}