/*
 *Beschreibung:
 *Farben
 *	gelb-1
 *	blau-2
 *	gruen-3
 *	rot-4
 *	braun-5
 *	orange-6
 *
 *Hint-Farben
 *	schwarz-2	Position und Farbe korrekt
 *	weiss-1		Farbe korrekt - Position falsch
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

//TO-DO: Vereinfachen? 
//2-schwarz(genau richtig), 1-weiss(farbe richtig), 0-nichts
public void setHint(int farbe, int i){
															//schwarze Farbe setzen
	if(farbe == 2){
		hint[i][dieVersuche] = farbe;
	}
															//weisse Farbe setzen
	if(farbe == 1){
		hint[i][dieVersuche] = farbe;
	}
															//keine Farbe setzen
	if(farbe == 0){
		hint[i][dieVersuche] = farbe;
	}
}


public int[][] getHint(){
	return hint;
}

//Achtung: diese Methode muss beim Bestaetigen des Versuchs 4x aufgerufen werden (da alle 4 Farben gesetzt werden müssen)
//hier wird der aktuelle Versuch gesetzt
public void setVersuchAktuell(int farbe, int i){

	//setzt die �bergebene Farbe an den �bergebenen Wert
	versuch[i][dieVersuche] = farbe;
}

//Achtung: nach dem aktuellen Versuch wird "derVergleich" zur Aenderung aufgerufen
public int[] getVersuchAktuell(){
	return versuchAktuell;
}

//hier werden die Hinweise geordnet, so dass nicht ersichlich ist, welcher Hinweis zu welchem Pin gehoert
public void hintOrdnen(){
	int anzahl0 = 0;
	int anzahl1 = 0;
	int anzahl2 = 0;
	int zaehler = 0;
	//hier werden die Pins zum Loesungshinweis gez�hlt und gespeichert
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
	//das hint-array (Loesungshinweise) wird zuerst  mit allen schwarzen Pins �berschrieben
	for (int j=0; j<anzahl2; j++){							
		hint[zaehler][dieVersuche]=2;
		zaehler++;
	}
	//dannach alle 1er
	for (int j=0; j<anzahl1; j++){							
		hint[zaehler][dieVersuche]=1;
		zaehler++;
	}
	//und am Schluss mit den restlichen 0er
	for (int j=0; j<anzahl0; j++){							
		hint[zaehler][dieVersuche]=0;
		zaehler++;
	}
}

public void derVergleich2(){
	//tempor�rer Z�hler, wenn Farbe und Position richtig
	int tempRichtig = 0;
	int benutztschwarz[] = {0,0,0,0};
	int benutztweis[] = {0,0,0,0};
	int schonGenutzt;
	

	for(int i = 0; i < loesung.length; i++){
		
		//Position und Farbe richtig? (schwarz setzen)
		if (loesung[i] == versuch[i][dieVersuche]){
			setHint(2,i);	//schwarze Farbe und der Index der richtigen Stelle werden �bergeben
			
			//diesen Versuchs-Pin speichern, da er beim �berpr�fen auf eine �bereinstimung
			//mit der Farbe nicht mehr ber�cksichtigt werden darf (sonst doppelte �berpr�fung und setzen der Antwort)
			benutztschwarz[i] = 1;
			
			tempRichtig++;	//
		}
		
		for(int j = 0; j < loesung.length; j++){
			//es werden alle Farben der L�sung mit allen Farben des Versuch verglichen
			//es wird die wei�e Hint-Farbe gesetzt (1), wenn die Farben gleich sind und die Positionen nicht gleich sind und
			//der Versuchs-Pin (array benutztschwarz[] und benutztweis[]) noch nicht mit einer schwarzen Antwort gesetzt wurde (siehe oben)
			if (loesung[i] == versuch[j][dieVersuche] && loesung[i] != versuch[j][dieVersuche]
					&& benutztschwarz[i]!=1 && benutztweis[j]!=1){
				benutztweis[j]=1;
				setHint(1,i);
				break;
			}
		}
		//wenn die Farbe nicht mit einer der Farben aus
		//der L�sung �bereinstimmt wird nichts gespeichert(hint = 0)
		if (hint[i][dieVersuche]!=1 && hint[i][dieVersuche]!=2) {
			setHint(0,i);
		}
	}

	/*
	if(dieVersuche == 10 && tempRichtig == 4){
		//zuerst noch die Farben auf dem Spielfeld setzen (zum Anzeigen)
		setVersuch(getVersuchAktuell());
		//danach die Gewonnen-Methode aufrufen
		gewonnen();
	}
	*/
	
	
	if(dieVersuche == 10 && tempRichtig < 4){
		setVersuch(getVersuchAktuell());
		verloren();
	}
	//wenn alle 4 Farben richtig sind und an der richtigen Stelle stehen, wird die Methode "gewonnen" aufgerufen
	if(tempRichtig == 4){
		setVersuch(getVersuchAktuell());
		gewonnen();
	}
	
	hintOrdnen();
	dieVersuche++;
}
															//hier werden die Farben miteinander verglichen
															//diese Funktion wird immer nach dem Bestaetigen einer Reihe aufgerufen
public void derVergleich(){
	
															//temporaerer Zaehler der richtigen Farben&Position wird gesetzt
	tempRichtig = 0;
	int [][] schonBenutzt = {{-1,-1,-1,-1},{-1,-1,-1,-1}};	//wichtig, damit kein Pin doppelt verwendet wird. Bereits verwendete Versuchs und Loesungs Indizes werden hier gespeichert
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
		if (benutzt) {										//Falls benutzt --> Ueberspringen
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
//Diese Methode beinhaltet ein Bild, das im aktuellen Fenster erscheint
private void verloren() {

}

//Methode, in der man einen neuen Versuch aus dem Spiel heraus starten kann
public void neuerVersuch(){
	
}

//Verhalten wenn der Spieler gewonnen hat
//Diese Methode beinhaltet ein Bild, das im aktuellen Fenster erscheint
public void gewonnen(){

}
}
