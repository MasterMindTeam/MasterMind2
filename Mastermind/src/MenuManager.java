import java.applet.AudioClip;
import java.io.IOException;

import javax.swing.JFrame;

//Klasse mit der Main
//verwaltet alle anderen Klassen 
public final class MenuManager {
	// Variablendeklaration
	private static MainMenu main;
	private static SubMenuSchwierigkeit schwierigkeit;
	private static HelpMenu help;
	private static CreditsMenu credit;
	private static BrettGUI spiel;
	private static BildWinner winner;
	private static Highscore highscore;
	private static JFrame mainFrame;
	protected static int gameMode;

	// erstellt ein Objekt von Klasse MenuManager
	public static void main(String[] args) throws IOException {
		MenuManager manager = new MenuManager();
		System.out.println();
	}

	// Konstruktor
	// erzeugt Objekte von allen involvierten Klassen
	// setzt Visibilität von dem der Klasse MainMenu wahr
	private MenuManager() throws IOException {
		main = new MainMenu();
		schwierigkeit = new SubMenuSchwierigkeit();
		help = new HelpMenu();
		credit = new CreditsMenu();
		spiel = new BrettGUI();
		winner = new BildWinner();
		highscore=new Highscore();
		main.setVisible(true);
		init();
	}

	// initialisiert den JFrame und fügt immer von Beginn an die Klasse MainMenu
	// als ContentPane

	public void init() throws IOException {

		mainFrame = new JFrame();
		mainFrame.addKeyListener(main);
		mainFrame.setSize(600, 800);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.getContentPane().add(main);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	// zeigt das Hauptmenü
	public static void showMainMenu() {
		setAllInvisible();
		main.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(main);

		removeAllContentPane();
		mainFrame.getContentPane().add(main);

	}
	//zeigt das Spiel
	public static void showGame() {
		setAllInvisible();
		spiel.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(spiel);

		removeAllContentPane();
		mainFrame.getContentPane().add(spiel);
	}
	public static void showHighscore() {
		setAllInvisible();
		highscore.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(highscore);

		removeAllContentPane();
		mainFrame.getContentPane().add(Highscore.btWeiter);
		mainFrame.getContentPane().add(Highscore.tfName);
		mainFrame.getContentPane().add(highscore);
	}
	
	//zeigt das Untermenü mit den Schwierigkeiten
	public static void showSubMenu() {
		setAllInvisible();
		schwierigkeit.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(schwierigkeit);
		main.setFocusable(true);

		removeAllContentPane();
		mainFrame.getContentPane().remove(Highscore.tfName);
		mainFrame.getContentPane().remove(Highscore.btWeiter);
		mainFrame.getContentPane().add(schwierigkeit);
	}
	//zeugt die Hilfe an 
	public static void showHelpMenu() { 
		setAllInvisible();
		help.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(help);

		removeAllContentPane();
		mainFrame.getContentPane().add(help);

	}
	
	//zeigt die Credits

	public static void showCreditsMenu() {
		setAllInvisible();
		credit.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(credit);

		removeAllContentPane();
		mainFrame.getContentPane().add(credit);

	}
	//löscht ContentPanes, Hilfsmethode
	public static void removeAllContentPane() {
		mainFrame.getContentPane().remove(main);
		mainFrame.getContentPane().remove(schwierigkeit);
		mainFrame.getContentPane().remove(help);
		mainFrame.getContentPane().remove(spiel);
		mainFrame.getContentPane().remove(winner);
		mainFrame.getContentPane().remove(highscore);
	}
	//löscht alle KeyListener, Hilfsmethode
	public static void removeAllKeyListener() {
		mainFrame.removeKeyListener(main);
		mainFrame.removeKeyListener(schwierigkeit);
		mainFrame.removeKeyListener(help);
		mainFrame.removeKeyListener(spiel);
		mainFrame.removeKeyListener(winner);
		mainFrame.removeKeyListener(highscore);
	}
	//Setzt alle Objekte unsichtbar
	public static void setAllInvisible() {
		main.setVisible(false);
		help.setVisible(false);
		credit.setVisible(false);
		schwierigkeit.setVisible(false);
		spiel.setVisible(false);
		winner.setVisible(false);
		highscore.setVisible(false);

	}

}
