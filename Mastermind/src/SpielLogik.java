import java.io.IOException;

/*
 *Beschreibung:
 *Farben
 *	rot-1
 *	blau-2
 *	gelb-3
 *	gruen-4
 *	orange-5
 *	braun-6
 *
 *Hint-Farben
 *	schwarz-2			Position und Farbe korrekt
 *	weiss-1				Farbe korrekt - Position falsch
 *	rotes Kreuz- 3		Farbe kommt nicht in der Loesung vor
 */

public class SpielLogik {
	protected int[][] versuch = new int[4][10]; // String-Array, in dem die
												// Farben des aktuellen
												// Versuches gespeichert werden
	protected int[] loesung = new int[4];		// String-Array, in dem die Farben des
												// geheimen Codes gespeichert werden
	protected int[] versuchAktuell = new int[4];// String-Array, in dem die
												// Farben des aktuellen
												// Versuches gespeichert
												// sind
	protected int[][] hint = new int[4][10]; 	// Array, in dem die
												// Loesungshinweise
												// gespeichert
												// sind
	protected int dieVersuche; 					// Zeigt an, um welchen Versuch es sich handelt
	protected int dieSchwierigkeit; 			// aendert die Anazahl zu verfuegbaren
												// Farben
	protected int tempRichtig; 					// Anzahl richtige Pins in diesem Versuch

	// Konstruktor
	public SpielLogik(int pSchwierigkeit) {

												// zu Beginn ist man bei Versuch 0
		dieVersuche = 0;

												// die Schwierigkeit wird je nach Auswahl gesetzt
		dieSchwierigkeit = pSchwierigkeit;

												// zufaellige Loesung generieren
		setLoesung();
	}

												// hier wird die Loesungsreihe zufaellig gesetzt
	public void setLoesung() {
		int dieZufallszahl;
												// Je nach Schwierigkeit liegen die zufaellig erzeugten int-Werte
												// zwischen 1 und 2/4/6
		for (int i = 0; i < loesung.length; i++) {
			dieZufallszahl = ((int) (Math.random() * 2 * dieSchwierigkeit + 1));
												// Zufallszahl wird generiert
			loesung[i] = dieZufallszahl;
												// das Array loesung wird mit den Zufallszahlen gefuellt
		}
	}

												// 2-schwarz(genau richtig), 1-weiss(farbe richtig), 0-nichts
	public void setHint(int farbe, int i) {
												//setzt die uebergebene Farbe an die uebergebene Stelle
												//fuer den aktuellen Versuch
		hint[i][dieVersuche] = farbe;
	}

	// hier werden die Hinweise geordnet, so dass nicht ersichlich ist, welcher
	// Hinweis zu welchem Pin gehoert
	public void hintOrdnen() {
		int anzahl1 = 0;
		int anzahl2 = 0;
		int anzahl3 = 0;
		int zaehler = 0;
		// hier werden die Pins zum Loesungshinweis gezaehlt und gespeichert
		for (int i = 0; i < 4; i++) {
			switch (hint[i][dieVersuche]) { // speichert Anzahl 0er, 1er, 2er
											// aus dem hint array
			case 3:
				anzahl3++;
				break;
			case 1:
				anzahl1++;
				break;
			case 2:
				anzahl2++;
				break;
			}
		}
		// das hint-array (Loesungshinweise) wird zuerst mit allen schwarzen (2)
		// Pins ueberschrieben
		for (int j = 0; j < anzahl2; j++) {
			hint[zaehler][dieVersuche] = 2;
			zaehler++;
		}
		// dannach alle weissen (1)
		for (int j = 0; j < anzahl1; j++) {
			hint[zaehler][dieVersuche] = 1;
			zaehler++;
		}
		// und am Schluss mit den nicht getroffenen (3)
		for (int j = 0; j < anzahl3; j++) {
			hint[zaehler][dieVersuche] = 3;
			zaehler++;
		}
	}

	public void derVergleich() throws IOException {
		// temporaerer Zaehler, wenn Farbe und Position richtig um zu ermitteln, ob der Spieler gewonnen hat
		tempRichtig = 0;
		int benutztschwarz[] = { 0, 0, 0, 0 };
		int benutztweis[] = { 0, 0, 0, 0 };

		for (int i = 0; i < loesung.length; i++) {

			// Position und Farbe richtig? (schwarz setzen)
			if (loesung[i] == versuch[i][dieVersuche]) {
				setHint(2, i);	// schwarze Farbe (2) und der Index der richtigen
								// Stelle werden uebergeben

				// dieser Versuchs-Pin wird gespeichert, da er beim Ueberpruefen auf
				// eine Uebereinstimung
				// mit der Farbe nicht mehr beruecksichtigt werden darf (sonst
				// kann es zu einere doppelten Ueberpruefung und setzen der Antwort kommen)
				benutztschwarz[i] = 1;
				benutztweis[i] = 1;

				tempRichtig++; 
			}
		}

		for (int i = 0; i < loesung.length; i++) {

			for (int j = 0; j < loesung.length; j++) {
				// es werden alle Farben der Loesung mit allen Farben des
				// Versuchs verglichen
				// es wird die weiße Hint-Farbe gesetzt (1), wenn die Farben
				// gleich sind und die Positionen nicht gleich sind und
				// der Versuchs-Pin (array benutztschwarz[] und benutztweis[])
				// noch nicht mit einer schwarzen Antwort gesetzt wurde (siehe
				// oben)
				if (loesung[i] == versuch[j][dieVersuche] && benutztschwarz[i] != 1 && benutztweis[j] != 1) {
					// wieder werden die benutzten Indizes gespeichert, um doppelte Verwendung
					// eines Hinweises auszuschließen
					benutztweis[j] = 1;
					benutztschwarz[i] = 1;
					setHint(1, i);
					break;
				}
			}
			// wenn die Farbe nicht mit einer der Farben aus
			// der Loesung Uebereinstimmt wird nichts gespeichert(hint = 3)
			if (hint[i][dieVersuche] != 1 && hint[i][dieVersuche] != 2) {
				setHint(3, i);
			}
		}

		// wurde nach 10 Versuchen die Loesung nicht gefunden wird in der BrettGUI Klasse
		// das "Verloren" Bild angezeigt
		
		// wenn alle 4 Farben richtig sind und an der richtigen Stelle stehen,
		// wird die Methode "gewonnen" aufgerufen
		if (tempRichtig == 4) {
			gewonnen();
		}
		//Die Hinweise werden geordnet, damit nicht ersichtlich ist zu welchem Pin die Hinweise
		//gehoeren
		hintOrdnen();
		//Nach dem der Vergleich beendet ist wird die Zahl der Versuche um 1 erhoeht
		dieVersuche++;
	}
	
	// Verhalten wenn der Spieler gewonnen hat
	// Das "Gewonnen" Bild wird von der BrettGUI Klasse angezeigt
	// Es wird ein Objekt der Gewonnen Klasse erzeugt
	// Dort wird der Name und die Zahl der benoetigten Versuche in den Highscore eingetragen
	// Fuer die drei Schwierigkeitsstufen gibt es seperate Highscores
	public void gewonnen() throws IOException {
		Gewonnen g1 = new Gewonnen(dieVersuche, dieSchwierigkeit);
	}
}
