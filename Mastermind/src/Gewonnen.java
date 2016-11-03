import javax.swing.JOptionPane;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

// Ein Objekt der Gewonnen Klasse wird erzeugt wenn der Spieler das Spiel gewonnen hat.
public class Gewonnen {

	// benoetigte Versuche und gewaehlte Schwierigkeit werden beim Aufruf
	// uebergeben
	int anzahlVersuche;
	int schwierigkeit;

	// Für jede Schwierigkeit gibt es ein eigenes Highscore Array
	// in welchem Name[][1] und Anzahl der Versuche[][0] gespeichert werden
	//
	// Die Arrays sind 11 gross, damit der neu einzuordnende Versuch zusätzlich
	// zu den
	// vorhandenen 10 aufgenommen werden kann
	static String highscoreArray1[][] = new String[11][2];
	static String highscoreArray2[][] = new String[11][2];
	static String highscoreArray3[][] = new String[11][2];

	// higschoreArray (ohne Index) wird verwendet um die anderen Highscore
	// Arrays zu bearbeiten. Es wird nur highschoreArray bearbeitet und
	// anschließend wird der Inhalt in das entsprechende Array kopiert
	static String highscoreArray[][] = new String[11][2];

	final static String LINESEPARATOR = System.getProperty("line.separator");

	// Konstruktor
	public Gewonnen(int anzahlVersuche, int schwierigkeit) {
		this.anzahlVersuche = anzahlVersuche;
		this.schwierigkeit = schwierigkeit;
		/*
		 * Da nur 10 Highscores permanent gespeichert werden wird der Index 10
		 * anfangs mit 11 gefüllt, damit keine Null-Pointer exception auftritt.
		 * Da die 11 hoeher als die maximalen 10 Versuche ist, wird dieser Wert
		 * nicht unter die highscoreArray1[10][0]="11";
		 * highscoreArray2[10][0]="11"; highscoreArray3[10][0]="11";
		 */
		try {
			// Das aktuelle Spiel wird in die entsprechende Highscore Datei
			// gespeichert
			abspeichern();
			for (int i = 1; i <= 3; i++) {
				// Die Highscores aus den Text Dateien werden in die
				// entsprechenden Arrays geladen
				inArrayLaden(lesen(i), i);
				// Die Arrays werden sortiert
				arraySortieren(i);
				// Die sortierten Arrays werden wieder in die entsprechende
				// Datei geschrieben
				arrayAnDatei(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void abspeichern() throws IOException {
		String text = "";
		// Das aktuelle Spiel wird in einen String geschrieben
		// Die Syntax ist leichter nachvolliehbar wenn man eine Highscore.txt
		// Datei parallel dazu betrachtet.
		text = text + Integer.toString(anzahlVersuche) + LINESEPARATOR;
		text = text + MenuManager.name + LINESEPARATOR;

		// Der bisherige Inhalt der Highscore Datei wird an den String
		// angehaengt
		text = text + lesen(schwierigkeit);

		// DateiName ist der Pfad der zu speichernden Datei
		String dateiName = "Mastermind/Highscore" + schwierigkeit + ".txt";

		// Der zusammengesetzte String wird in die Datei geschrieben
		FileOutputStream schreibeStrom = new FileOutputStream(dateiName);
		for (int i = 0; i < text.length(); i++) {
			schreibeStrom.write((byte) text.charAt(i));
		}
		schreibeStrom.close();
	}

	public static String lesen(int i) throws IOException {
		// Der Uebergabeparameter spezifiziert um welche Highscore Datei es sich
		// handelt
		// Liest die entsprechende Datei aus und gibt den String zurueck
		byte zeichen = 0;
		String text = "";
		String dateiName = "Mastermind/Highscore" + i + ".txt";
		FileInputStream leseStrom = new FileInputStream(dateiName);
		
		while (zeichen != -1) {
			zeichen = (byte) leseStrom.read();
			if (zeichen != -1) {
				text += (char) zeichen;
			}
		}
		leseStrom.close();
		return text;
	}

	public static void inArrayLaden(String text, int schwierigkeit) throws IOException {
		// Der gesamte String text ist durch Zeilenumbrueche untergliedert
		//
		// textTeil ist der Teil des Textes, welcher aktuell verwendet wird.
		//
		// immer nachdem ein Teil des Strings in das Array geschrieben wurde
		// wird replica um diesen Teil gekuertzt. Replica ist also der
		// verbleibende Teil vom Text
		String textTeil = text;
		String replica = text;

		for (int i = 0; i < highscoreArray.length - 1; i++) {

			/*
			 * if (replica.indexOf(LINESEPARATOR) == -1) { // wenn es keine
			 * Zeilenumbrueche mehr gibt wird springt das // Programm aus der
			 * for Schleife, damit es zu keinen Null // Pointer Exceptions kommt
			 * break; }
			 */
			if (i == 0) {
				// beim ersten mal muss der substring bei Index 0 anfangen, da
				// kein Zeilenumbruch voran geht
				textTeil = replica.substring(0, replica.indexOf(LINESEPARATOR));
			} else {
				textTeil = replica.substring(1, replica.indexOf(LINESEPARATOR));
			}
			// Der String ist gegliedert in Versuche und Namen jeweils durch
			// Zeilenumbrueche getrennt
			replica = replica.substring(replica.indexOf(LINESEPARATOR) + 1);
			highscoreArray[i][0] = textTeil;
			textTeil = replica.substring(1, replica.indexOf(LINESEPARATOR));
			replica = replica.substring(replica.indexOf(LINESEPARATOR) + 1);
			highscoreArray[i][1] = textTeil;
		}

		switch (schwierigkeit) {
		// Der Inhalt von highscoreArray wird in das entsprechende Array kopiert
		case 1:
			highscoreArray1 = arrayDeepCopy(highscoreArray);
			break;
		case 2:
			highscoreArray2 = arrayDeepCopy(highscoreArray);
			break;
		case 3:
			highscoreArray3 = arrayDeepCopy(highscoreArray);
			break;
		}
	}

	public static void arraySortieren(int schwierigkeit) {
		// Das zu sortierende Array wird in highscoreArray kopiert
		switch (schwierigkeit) {
		case 1:
			highscoreArray = arrayDeepCopy(highscoreArray1);
			break;
		case 2:
			highscoreArray = arrayDeepCopy(highscoreArray2);
			break;
		case 3:
			highscoreArray = arrayDeepCopy(highscoreArray3);
			break;
		}
		// sollte ein Platz im aktuellen Array nicht beschrieben sein, so wird
		// er befuellt mit 99 / empty. Dies ist noetig, damit die
		// Sortierfunktion fehlerfrei ablaufen kann
		for (int i = 0; i < highscoreArray.length; i++) {
			if (highscoreArray[i][0] == null) {
				highscoreArray[i][0] = "99";
				highscoreArray[i][1] = "empty";
			}
		}
		Arrays.sort(highscoreArray, new Comparator<String[]>() {
			public int compare(final String[] entry1, final String[] entry2) {
				final String versuche1 = entry1[0];
				final String versuche2 = entry2[0];
				return versuche1.compareTo(versuche2);
			}
		});
		// Das sortierte Array wird zurück in das urspruengliche Array kopiert
		switch (schwierigkeit) {
		case 1:
			highscoreArray1 = arrayDeepCopy(highscoreArray);
			break;
		case 2:
			highscoreArray2 = arrayDeepCopy(highscoreArray);
			break;
		case 3:
			highscoreArray3 = arrayDeepCopy(highscoreArray);
			break;
		}
	}

	public static void arrayAnDatei(int i) throws IOException {
		// Schreibt den Inhalt des Arrays in die entsprechende Datei
		String dateiName = "Mastermind/Highscore" + i + ".txt";
		PrintWriter pw = new PrintWriter(dateiName);
		pw.print("");
		pw.close();
		String text = "";

		// Das zu speichernde Array wird in highscoreArray kopiert
		switch (i) {
		case 1:
			highscoreArray = arrayDeepCopy(highscoreArray1);
			break;
		case 2:
			highscoreArray = arrayDeepCopy(highscoreArray2);
			break;
		case 3:
			highscoreArray = arrayDeepCopy(highscoreArray3);
			break;
		}

		// Es werden nur die 10 besten Versuche gespeichert, so dass das
		// naechste Mal wenn ein Spieler gewonnen hat wieder ein neuer Eintrag
		// angehaengt werden kann, ohne dass das Array "ueberlaeuft"
		for (int j = 0; j < highscoreArray.length - 1; j++) {
			if (highscoreArray[j][0] != null) {

				// Das Array wird in einen String umgewandelt
				text = text + highscoreArray[j][0] + LINESEPARATOR;
				text = text + highscoreArray[j][1] + LINESEPARATOR;
			}
		}
		// Der String wird in die Datei geschrieben
		FileOutputStream schreibeStrom = new FileOutputStream(dateiName);
		for (int j = 0; j < text.length(); j++) {
			schreibeStrom.write((byte) text.charAt(j));
		}
		schreibeStrom.close();
	}

	// Kopiert die Inhalte des Arrays und nicht nur die Pointer
	public static String[][] arrayDeepCopy(String[][] original) {
		if (original == null) {
			return null;
		}
		final String[][] RESULT = new String[original.length][];
		for (int i = 0; i < original.length; i++) {
			RESULT[i] = Arrays.copyOf(original[i], original[i].length);
		}
		return RESULT;
	}
}
