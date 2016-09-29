/*
 *Beschreibung:
 *Farben
 *	gelb-1
 *	blau-2
 *	grün-3
 *	rot-4
 *	braun-5
 *	orange-6
 *
 *Hint-Farben
 *	schwarz-2	Position und Farbe korrekt
 *	weiß-1		Farbe korrekt - Position falsch
 *	leer-0		Farbe kommt nicht in der Lösung vor
 */

public class SpielLogik {
protected int[][] versuch = new int[4][10];					//String-Array, in dem die Farben des aktuellen Versuches gespeichert werden
protected int[] loesung = new int[4];						//String-Array, in dem die Farben des geheimen Codes gespeichert werden 
protected int[] versuchAktuell = new int[4];				//String-Array, in dem die Farben des aktuellen Versuches gespeichert sind 
protected int[][] hint = new int [4][10];					//Array, in dem die Lösungshinweise gespeichert sind
protected int dieVersuche;									//Zeigt an, um welchen Versuch es sich handelt
protected int dieSchwierigkeit;								//Ändert die Anazahl zu verfügbaren Farben
protected int tempRichtig;									//Anzahl richtige Pins in diesem Versuch

															//Konstruktor
public SpielLogik(int pSchwierigkeit){
	
															//zu Beginn ist man bei Versuch 0
	dieVersuche = 0;
	
															//die Schwierigkeit wird je nach Auswahl gesetzt
	dieSchwierigkeit = pSchwierigkeit;
	
															//zufällige Loesung generieren
    setLoesung();
}

															//hier wird die Lösungsreihe zufällig gesetzt
public void setLoesung(){
	int dieZufallszahl;
															//1.Stufe der Schwierigkeit - 2 Farben sind möglich
	if(dieSchwierigkeit == 1){
	    for(int i = 0; i < loesung.length; i++) {
	        dieZufallszahl = ((int)(Math.random()*2+1));	//Zufallszahl von 1 bis 2 wird generiert
	        loesung[i] = dieZufallszahl;
	    }
	}
															//2.Stufe - 4 Farben sind möglich
	if(dieSchwierigkeit == 2){
	    for(int i = 0; i < loesung.length; i++) {
	        dieZufallszahl = ((int)(Math.random()*4+1));	//Zufallszahl von 1 bis 4 wird generiert
	        loesung[i] = dieZufallszahl;
	    }
	}
															//3. Stufe - 6 Farben sind möglich
	if(dieSchwierigkeit == 3){
	    for(int i = 0; i < loesung.length; i++) {
	        dieZufallszahl = ((int)(Math.random()*6+1));	//Zufallszahl von 1 bis 6 wird generiert
	        loesung[i] = dieZufallszahl;
	    }
	}
}
//													TO-DO: Nicht genutzt - löschen?
															//gibt das Array der Lösung zurück
public int[] getLoesung(){
	return loesung;
}

//													TO-DO: Kann eingegebenerVersuch auch ohne seperate Methode in das versuch array geschrieben werden?
															//eingegebener Versuch ist das Array mit den Farben, die zur Auswahl bestätigt wurden
															//hier werden die Farben also "fest" in einem 2D-Array gespeichert
															//hier muss der "aktuelleVersuch" übergeben werden
public void setVersuch(int[] eingegebenerVersuch){
	
															//for-Schleife, mit der die eingegebenen Farben im Array gespeichert werden
  for (int i = 0; i < versuch.length; i++) {
      this.versuch[i][dieVersuche] = eingegebenerVersuch[i];
  }
}
//													TO-DO: Nicht genutzt - löschen?
public int[][] getVersuch(){
    return versuch;
}

//													TO-DO: Vereinfachen? 
															//2-schwarz(genau richtig), 1-weiß(farbe richtig), 0-nichts
public void setHint(int farbe, int i){
															//schwarze Farbe setzen
	if(farbe == 2){
		hint[i][dieVersuche] = farbe;
	}
															//weiße Farbe setzen
	if(farbe == 1){
		hint[i][dieVersuche] = farbe;
	}
															//keine Farbe setzen
	if(farbe == 0){
		hint[i][dieVersuche] = farbe;
	}
}

//													TO-DO: Nicht genutzt - löschen?
public int[][] getHint(){
	return hint;
}

//													TO-DO: Andere Lösung möglich? Aktuell eher Umständlich
															//Achtung: diese Methode muss beim Bestätigen des Versuchs 4x aufgerufen werden (da alle 4 Farben gesetzt werden müssen)
															//hier wird der aktuelle Versuch gesetzt
public void setVersuchAktuell(int farbe, int i){
															//setzt alle Farben des aktuellen Versuches
	versuch[i][dieVersuche] = farbe;
}

//													TO-DO: Brauchen wir seperate getter/setter?
															//Achtung: nach dem aktuellen Versuch wird "derVergleich" zur Überprüfung aufgerufen
public int[] getVersuchAktuell(){
	return versuchAktuell;
}

															//hier werden die Hinweise geordnet, so dass nicht ersichlich ist, welcher Hinweis zu welchem Pin gehört
public void hintOrdnen(){
	int anzahl0 = 0;
	int anzahl1 = 0;
	int anzahl2 = 0;
	int zaehler = 0;
	for (int i=0;i<4;i++){
		switch (hint[i][dieVersuche]){						//speichert Anzahl 0er, 1er, 2er aus dem hint array
		case 0:
			anzahl0++;
			break;
		case 1:
			anzahl1++;
			break;
		case 2:
			anzahl2++;
			break;
		}
	}
	for (int j=0; j<anzahl2; j++){							//überschreibt das hint array mit zuerst allen 2er
		hint[zaehler][dieVersuche]=2;
		zaehler++;
	}
	for (int j=0; j<anzahl1; j++){							//dannach alle 1er
		hint[zaehler][dieVersuche]=1;
		zaehler++;
	}
	for (int j=0; j<anzahl0; j++){							//und am Schluss mit den restlichen 0er
		hint[zaehler][dieVersuche]=0;
		zaehler++;
	}
}

															//hier werden die Farben miteinander verglichen
															//diese Funktion wird immer nach dem Bestätigen einer Reihe aufgerufen
public void derVergleich(){
	
															//temporärer Zähler der richtigen Farben&Position wird gesetzt
	tempRichtig = 0;
	int [][] schonBenutzt = {{-1,-1,-1,-1},{-1,-1,-1,-1}};	//wichtig, damit kein Pin doppelt verwendet wird. Bereits verwendete Versuchs und Lösungs Indizes werden hier gespeichert
	int hilfszaehler = 0;									//benutzt um den Index des schonBenutzt arrays zu verschieben
	boolean benutzt = false;								//Ist der aktuelle Index bereits als Hinweis verwendet, so wird er bei der nächsten Überprüfung übersprungen

	for(int i = 0; i < 4; i++){
															//wenn die Position und die Farbe übereinstimmen wird die schwarze Hint-Farbe gesetzt bzw Zahl 2
		if (versuch[i][dieVersuche]==loesung[i]){
			setHint(2,i);
			tempRichtig++;
			schonBenutzt[0][hilfszaehler]=i;				//Index des benutzten Versuchs wird gespeichert
			schonBenutzt[1][hilfszaehler]=i;				//Index der benutzten Lösung wird gespeichert
			hilfszaehler++;
		}
	}
	for(int i = 0; i<4; i++){
		for(int l = 0; l < 4; l++){							//Wurde der Versuch mit diesem Index bereits als Hinweis verwendet?
			if (schonBenutzt[0][l]==i){
				benutzt = true;
				break;
			}
		}
		if (benutzt) {										//Falls benutzt --> überspringen
			benutzt = false;
			continue;
		}
		for(int j = 0; j < 4; j++){							//Wurde die Lösung mit diesem Index bereits als Hinweis verwendet?
			for(int k=0;k<4;k++){
				if (schonBenutzt[1][k]==j){
					benutzt = true;
					break;
				}
			}
			if (benutzt) {									//Falls benutzt --> überspringen
				benutzt = false;
				continue;
			}
															//es werden alle Farben der Lösung mit allen Farben des Versuch verglichen
															//es wird die weiße Hint-Farbe gesetzt (1), wenn die Farben gleich sind und die Positionen nicht gleich sind
			if (versuch[i][dieVersuche]==loesung[j]){		//Farbe+Position gleich ist hier nicht mehr möglich, da der entsprechende Index übersprungen wurde
				setHint(1,i);
				schonBenutzt[0][hilfszaehler]=i;			//Index des benutzten Versuchs wird gespeichert
				schonBenutzt[1][hilfszaehler]=j;			//Index der benutzten Lösung wird gespeichert
				hilfszaehler++;
				break;										//Rest der Lösungsindizes wird übersprungen, da der aktuelle Versuchsindex bereits verwendet wird
			}
		}
															//wenn der geprüfte Versuch nicht mit einer Farbe aus der Lösung übereinstimmt wird nichts gespeichert(0)
		if (hint[i][dieVersuche]!=1 && hint[i][dieVersuche]!=2) {
			setHint(0,i);
		}
	}
	
	if(dieVersuche == 10 && tempRichtig == 4){
//													TO-DO: Warum? Sollte auch ohne dieses IF funktionieren. Brauchen nur test ob dieVersuche = 10 und nicht alle richtig.
//														   Nur test auf gewonnen muss vor test auf 10 versuche kommen!
															//zuerst noch die Farben auf dem Spielfeld setzen
		setVersuch(getVersuchAktuell());
															//danach die Gewonnen-Methode aufrufen
		gewonnen();
	}
	else if(dieVersuche == 10 && tempRichtig < 4){			//wenn der letzte(10.) Versuch erreicht ist und nicht alle Pins korrekt gesetzt sind wird die "verloren" Methode aufgerufen
		setVersuch(getVersuchAktuell());
		verloren();
	}
															//wenn alle 4 Farben richtig sind und an der richtigen STelle stehen, wird die Methode "gewonnen" aufgerufen
	if(tempRichtig == 4){
		gewonnen();
	}
	
	hintOrdnen();											//wenn weder gewonnen noch verloren, dann werden die Hinweise geordnet um anschließend angezeigt zu werden
	dieVersuche++;											//die Anzahl der Versuche wird erhöht
}

															//Verhalten wenn der Spieler verloren hat
private void verloren() {//							TO-DO: Methode füllen

}

															//Methode, in der man einen neuen Versuch aus dem Spiel heraus starten kann
public void neuerVersuch(){//						TO-DO: Methode füllen
	
}

															//Verhalten wenn der Spieler gewonnen hat
public void gewonnen(){
	new Gewonnen();											//Objekt der Gewonnenklasse wird erzeugt
//													TO-DO: Gewonnen Klasse ändern bzw Methode an sich umwerfen/neu machen
}
}
