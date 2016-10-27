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
	private static Nutzername namenEingeben;
	private static AnzeigeHighscore anzeige;
	private static MP3_Player music;
	private static JFrame mainFrame;
	protected static int gameMode;
	protected static String name;
	protected static boolean highscoreOderGame;

	// erstellt ein Objekt von Klasse MenuManager
	public static void main(String[] args) throws IOException {
		MenuManager manager = new MenuManager();
		Gewonnen arrayInit = new Gewonnen(999,3);
		music = new MP3_Player();
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
		namenEingeben = new Nutzername();
		anzeige = new AnzeigeHighscore();
		main.setVisible(true);
		init();
	}

	// initialisiert den JFrame und fügt immer von Beginn an die Klasse
	// MainMenu
	// als ContentPane

	public void init() throws IOException {

		mainFrame = new JFrame();
		mainFrame.addKeyListener(main);
		mainFrame.setSize(600, 800);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.getContentPane().add(main);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	// zeigt das Hauptmenü
	public static void showMainMenu() {
		setAllInvisible();
		main.setVisible(true);

		 mainFrame.remove(AnzeigeHighscore.taAusgabeHighscore);
		removeAllKeyListener();
		mainFrame.addKeyListener(main);

		removeAllContentPane();
		Nutzername.tfName.setText("");
		mainFrame.getContentPane().remove(Nutzername.tfName);
		mainFrame.getContentPane().remove(Nutzername.btWeiter);
		mainFrame.getContentPane().remove(Nutzername.btHome);
		mainFrame.getContentPane().add(main);
	}

	// zeigt das Spiel
	public static void showGame() {
		setAllInvisible();
		spiel.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(spiel);

		removeAllContentPane();
		mainFrame.getContentPane().add(spiel);
	}

	public static void showAnzeigeHighscore() {
		setAllInvisible();
		anzeige.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(anzeige);

		removeAllContentPane();
		mainFrame.getContentPane().add(AnzeigeHighscore.taAusgabeHighscore);
		mainFrame.getContentPane().add(anzeige);
	}

	public static void showNutzername() {
		setAllInvisible();
		namenEingeben.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(namenEingeben);

		removeAllContentPane();
		mainFrame.getContentPane().add(Nutzername.btWeiter);
		mainFrame.getContentPane().add(Nutzername.btHome);
		mainFrame.getContentPane().add(Nutzername.tfName);
		mainFrame.getContentPane().add(namenEingeben);
	}

	// zeigt das Untermenü mit den Schwierigkeiten
	public static void showSubMenu() {
		setAllInvisible();
		schwierigkeit.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(schwierigkeit);
		mainFrame.setFocusable(true);

		removeAllContentPane();
		Nutzername.tfName.setText("");
		mainFrame.getContentPane().remove(Nutzername.tfName);
		mainFrame.getContentPane().remove(Nutzername.btWeiter);
		mainFrame.getContentPane().remove(Nutzername.btHome);
		mainFrame.getContentPane().add(schwierigkeit);
	}

	// zeugt die Hilfe an
	public static void showHelpMenu() {
		setAllInvisible();
		help.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(help);

		removeAllContentPane();
		mainFrame.getContentPane().add(help);

	}

	// zeigt die Credits

	public static void showCreditsMenu() {
		setAllInvisible();
		credit.setVisible(true);

		removeAllKeyListener();
		mainFrame.addKeyListener(credit);

		removeAllContentPane();
		mainFrame.getContentPane().add(credit);

	}

	// löscht ContentPanes, Hilfsmethode
	public static void removeAllContentPane() {
		mainFrame.getContentPane().remove(main);
		mainFrame.getContentPane().remove(schwierigkeit);
		mainFrame.getContentPane().remove(help);
		mainFrame.getContentPane().remove(spiel);
		mainFrame.getContentPane().remove(winner);
		mainFrame.getContentPane().remove(namenEingeben);
		mainFrame.getContentPane().remove(anzeige);
	}

	// löscht alle KeyListener, Hilfsmethode
	public static void removeAllKeyListener() {
		mainFrame.removeKeyListener(main);
		mainFrame.removeKeyListener(schwierigkeit);
		mainFrame.removeKeyListener(help);
		mainFrame.removeKeyListener(spiel);
		mainFrame.removeKeyListener(winner);
		mainFrame.removeKeyListener(namenEingeben);
		mainFrame.removeKeyListener(anzeige);
	}

	// Setzt alle Objekte unsichtbar
	public static void setAllInvisible() {
		main.setVisible(false);
		help.setVisible(false);
		credit.setVisible(false);
		schwierigkeit.setVisible(false);
		spiel.setVisible(false);
		winner.setVisible(false);
		namenEingeben.setVisible(false);
		anzeige.setVisible(false);
	}

}
