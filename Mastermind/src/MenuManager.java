import java.io.IOException;

import javax.swing.JFrame;

public final class MenuManager {

	private static MainMenu main;
	private static SubMenuSchwierigkeit schwierigkeit;
	private static HelpMenu help;
	private static CreditsMenu credit;
	private static BrettGUI spiel;
	private static JFrame mainFrame;

	public static void main(String[] args) throws IOException {
		MenuManager manager = new MenuManager();
		System.out.println();
	}

	private MenuManager() throws IOException {
		main = new MainMenu();
		schwierigkeit = new SubMenuSchwierigkeit();
		help = new HelpMenu();
		credit = new CreditsMenu();
		spiel = new BrettGUI();
		main.setVisible(true);

		init();
	}

	public void init() throws IOException {

		mainFrame = new JFrame();
		mainFrame.addKeyListener(main);
		mainFrame.setSize(600, 800);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.getContentPane().add(main);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	public static void showMainMenu() {
		setAllInvisible();
		main.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(main);

		removeAllContentPane();
		mainFrame.getContentPane().add(main);

	}
	
	public static void showGame(){
		setAllInvisible();
		spiel.setVisible(true);
		
		removeAllKeyListener();
		mainFrame.addKeyListener(spiel);
		
		removeAllContentPane();
		mainFrame.getContentPane().add(spiel);
	}

	public static void showSubMenu() {
		setAllInvisible();
		schwierigkeit.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(schwierigkeit);

		removeAllContentPane();
		mainFrame.getContentPane().add(schwierigkeit);
	}

	public static void showHelpMenu() { //TO DO: kann auc in eine Navigate: typ wo ich herkomme, und typ wo ich hinwill
		setAllInvisible();
		help.setVisible(true);    

		removeAllKeyListener();
		mainFrame.addKeyListener(help);

		removeAllContentPane();
		mainFrame.getContentPane().add(help);

	}
	
	public static void showCreditsMenu(){
		setAllInvisible();
		credit.setVisible(true);
		
		removeAllKeyListener();
		mainFrame.addKeyListener(credit);
		
		removeAllContentPane();
		mainFrame.getContentPane().add(credit);
		
		
	}

	public static void removeAllContentPane() {
		mainFrame.getContentPane().remove(main);
		mainFrame.getContentPane().remove(schwierigkeit);
		mainFrame.getContentPane().remove(help);
	}

	public static void removeAllKeyListener() {
		mainFrame.removeKeyListener(main);
		mainFrame.removeKeyListener(schwierigkeit);
		mainFrame.removeKeyListener(help);
	}
	
	public static void setAllInvisible(){
		main.setVisible(false);
		help.setVisible(false);
		credit.setVisible(false);
		schwierigkeit.setVisible(false);
	}

}
