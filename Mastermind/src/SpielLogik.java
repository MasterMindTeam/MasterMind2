import java.io.IOException;

/*
 *Beschreibung:
 *Farben
 *	rot-1
 *	blau-2
 *	gelb-3
 *	grün-4
 *	orange-5
 *	braun-6
 *
 *Hint-Farben
 *	schwarz-2	Position und Farbe korrekt
 *	weiss-1		Farbe korrekt - Position falsch
 *	rotes Kreuz- 3		Farbe kommt nicht in der LÃ¶sung vor
 */

public class SpielLogik {
	protected int[][] versuch = new int[4][10]; // String-Array, in dem die
												// Farben des aktuellen
												// Versuches gespeichert werden
	protected int[] loesung = new int[4]; // String-Array, in dem die Farben des
											// geheimen Codes gespeichert werden
	protected int[] versuchAktuell = new int[4]; // String-Array, in dem die
													// Farben des aktuellen
													// Versuches gespeichert
													// sind
	protected int[][] hint = new int[4][10]; // Array, in dem die
												// LÃ¶sungshinweise
												// gespeichert
												// sind
	protected int dieVersuche; // Zeigt an, um welchen Versuch es sich handelt
	protected int dieSchwierigkeit; // Ã„ndert die Anazahl zu verfÃ¼gbaren
									// Farben
	protected int tempRichtig; // Anzahl richtige Pins in diesem Versuch

	// Konstruktor
	public SpielLogik(int pSchwierigkeit) {

		// zu Beginn ist man bei Versuch 0
		dieVersuche = 0;

		// die Schwierigkeit wird je nach Auswahl gesetzt
		dieSchwierigkeit = pSchwierigkeit;

		// zufÃ¤llige Loesung generieren
		setLoesung();
	}

	// hier wird die LÃ¶sungsreihe zufÃ¤llig gesetzt
	public void setLoesung() {
		int dieZufallszahl;

		// 1.Stufe der Schwierigkeit - 2 Farben sind mÃ¶glich
		for (int i = 0; i < loesung.length; i++) {
			dieZufallszahl = ((int) (Math.random() * 2 * dieSchwierigkeit + 1)); // Zufallszahl
			// von 1 bis
			// 2 wird
			// generiert
			loesung[i] = dieZufallszahl;
		}
	}

	// TO-DO: Nicht genutzt - lÃ¶schen?
	// gibt das Array der LÃ¶sung zurÃ¼ck
	public int[] getLoesung() {
		return loesung;
	}

	// TO-DO: Kann eingegebenerVersuch auch ohne seperate Methode in das versuch
	// array geschrieben werden?
	// eingegebener Versuch ist das Array mit den Farben, die zur Auswahl
	// bestÃ¤tigt wurden
	// hier werden die Farben also "fest" in einem 2D-Array gespeichert
	// hier muss der "aktuelleVersuch" Ã¼bergeben werden
	public void setVersuch(int[][] eingegebenerVersuch) {

		// for-Schleife, mit der die eingegebenen Farben im Array gespeichert
		// werden
		for (int i = 0; i < versuch.length; i++) {
			this.versuch[i][dieVersuche] = eingegebenerVersuch[i][dieVersuche];
		}
	}

	// TO-DO: Nicht genutzt - lÃ¶schen?
	public int[][] getVersuch() {
		return versuch;
	}

	// TO-DO: Vereinfachen?
	// 2-schwarz(genau richtig), 1-weiss(farbe richtig), 0-nichts
	public void setHint(int farbe, int i) {
		// schwarze Farbe setzen
		if (farbe == 2) {
			hint[i][dieVersuche] = farbe;
		}
		// weisse Farbe setzen
		if (farbe == 1) {
			hint[i][dieVersuche] = farbe;
		}
		// keine Farbe setzen
		if (farbe == 3) {
			hint[i][dieVersuche] = farbe;
		}
	}

	public int[][] getHint() {
		return hint;
	}

	// Achtung: diese Methode muss beim Bestaetigen des Versuchs 4x aufgerufen
	// werden (da alle 4 Farben gesetzt werden mÃ¼ssen)
	// hier wird der aktuelle Versuch gesetzt
	public void setVersuchAktuell(int farbe, int i) {

		// setzt die übergebene Farbe an den übergebenen Wert
		versuch[i][dieVersuche] = farbe;
	}

	// Achtung: nach dem aktuellen Versuch wird "derVergleich" zur Aenderung
	// aufgerufen
	public int[] getVersuchAktuell() {
		return versuchAktuell;
	}

	// hier werden die Hinweise geordnet, so dass nicht ersichlich ist, welcher
	// Hinweis zu welchem Pin gehoert
	public void hintOrdnen() {
		int anzahl1 = 0;
		int anzahl2 = 0;
		int anzahl3 = 0;
		int zaehler = 0;
		// hier werden die Pins zum Loesungshinweis gezählt und gespeichert
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
		// das hint-array (Loesungshinweise) wird zuerst mit allen schwarzen
		// Pins überschrieben
		for (int j = 0; j < anzahl2; j++) {
			hint[zaehler][dieVersuche] = 2;
			zaehler++;
		}
		// dannach alle 1er
		for (int j = 0; j < anzahl1; j++) {
			hint[zaehler][dieVersuche] = 1;
			zaehler++;
		}
		// und am Schluss mit den restlichen -1er
		for (int j = 0; j < anzahl3; j++) {
			hint[zaehler][dieVersuche] = 3;
			zaehler++;
		}
	}

	public void derVergleich() throws IOException {
		// temporärer Zähler, wenn Farbe und Position richtig
		tempRichtig = 0;
		int benutztschwarz[] = { 0, 0, 0, 0 };
		int benutztweis[] = { 0, 0, 0, 0 };
		int schonGenutzt;

		for (int i = 0; i < loesung.length; i++) {

			// Position und Farbe richtig? (schwarz setzen)
			if (loesung[i] == versuch[i][dieVersuche]) {
				setHint(2, i); // schwarze Farbe und der Index der richtigen
								// Stelle werden übergeben

				// diesen Versuchs-Pin speichern, da er beim Überprüfen auf
				// eine
				// Übereinstimung
				// mit der Farbe nicht mehr berücksichtigt werden darf (sonst
				// doppelte Überprüfung und setzen der Antwort)
				benutztschwarz[i] = 1;
				benutztweis[i] = 1;

				tempRichtig++; //
			}
		}

		for (int i = 0; i < loesung.length; i++) {

			for (int j = 0; j < loesung.length; j++) {
				// es werden alle Farben der Lösung mit allen Farben des
				// Versuch
				// verglichen
				// es wird die weiße Hint-Farbe gesetzt (1), wenn die Farben
				// gleich sind und die Positionen nicht gleich sind und
				// der Versuchs-Pin (array benutztschwarz[] und benutztweis[])
				// noch nicht mit einer schwarzen Antwort gesetzt wurde (siehe
				// oben)
				if (loesung[i] == versuch[j][dieVersuche] && benutztschwarz[i] != 1 && benutztweis[j] != 1) {
					benutztweis[j] = 1;
					benutztschwarz[i] = 1;
					setHint(1, i);
					break;
				}
			}
			// wenn die Farbe nicht mit einer der Farben aus
			// der Lösung übereinstimmt wird nichts gespeichert(hint = 0)
			if (hint[i][dieVersuche] != 1 && hint[i][dieVersuche] != 2) {
				setHint(3, i);
			}
		}

	

		if (dieVersuche == 10 && tempRichtig < 4) {
			// setVersuch(getVersuchAktuell());
			verloren();
		}
		// wenn alle 4 Farben richtig sind und an der richtigen Stelle stehen,
		// wird die Methode "gewonnen" aufgerufen
		if (tempRichtig == 4) {
			// setVersuch(getVersuchAktuell());
			gewonnen();
		}

		hintOrdnen();
		dieVersuche++;
	}

	

	// Verhalten wenn der Spieler verloren hat
	// Diese Methode beinhaltet ein Bild, das im aktuellen Fenster erscheint
	private void verloren() {

	}

	// Methode, in der man einen neuen Versuch aus dem Spiel heraus starten kann
	public void neuerVersuch() {

	}

	// Verhalten wenn der Spieler gewonnen hat
	// Diese Methode beinhaltet ein Bild, das im aktuellen Fenster erscheint
	public void gewonnen() throws IOException {
		Gewonnen g1 = new Gewonnen(dieVersuche, dieSchwierigkeit);
	}
}
