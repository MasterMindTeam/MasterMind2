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
 *	schwarz-2
 *	weiß-1
 *	leer-0
 */

public class SpielLogik {
String[][] versuch = new String[4][10];	//String-Array, in dem die Farben des aktuellen Versuches gespeichert werden
String[] loesung = new String[4];		//String-Array, in dem die Farben des geheimen Codes gespeichert werden 
String[] versuchAktuell = new String[4];		//String-Array, in dem die Farben des aktuellen Versuches gespeichert sind 
String[][] hint = new String [4][10];	//Array, in dem die Lösungshinweise gespeichert sind
int dieVersuche;
int dieSchwierigkeit;

//Konstruktor
public SpielLogik(int pSchwierigkeit){
	
	//zu Beginn hat man 0 Versuche
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
	        loesung[i] = Integer.toString(dieZufallszahl);
	    }
	}
	//2.Stufe - 4 Farben sind möglich
	if(dieSchwierigkeit == 2){
	    for(int i = 0; i < loesung.length; i++) {
	        dieZufallszahl = ((int)(Math.random()*4+1));	//Zufallszahl von 1 bis 4 wird generiert
	        loesung[i] = Integer.toString(dieZufallszahl);
	    }
	}
	//3. Stufe - 6 Farben sind möglich
	if(dieSchwierigkeit == 3){
	    for(int i = 0; i < loesung.length; i++) {
	        dieZufallszahl = ((int)(Math.random()*6+1));	//Zufallszahl von 1 bis 6 wird generiert
	        loesung[i] = Integer.toString(dieZufallszahl);
	    }
	}
}

//gibt das Array der Lösung zurück
public String[] getLoesung(){
	return loesung;
}


//eingegebener Versuch ist das Array mit den Farben, die zur Auswahl bestätigt wurden
//hier werden die Farben also "fest" in einem 2D-Array gespeichert
//hier muss der "aktuelleVersuch" übergeben werden
public void setVersuch(String[] eingegebenerVersuch){
	
	//die Anzahl der Versuche werden erhöht
	dieVersuche++;
	//for-Schleife, mit der die eingegebenen Farben im Array gespeichert werden
  for (int i = 0; i < versuch.length; i++) {
      this.versuch[dieVersuche][i] = eingegebenerVersuch[i];
  }
}

public String[][] getVersuch(){
    return versuch;
}


//1-schwarz(genau richtig), 2-weiß(farbe richtig), 0-nichts
public void setHint(int farbe){
	for(int i = 0; i < hint.length; i++){
		//schwarze Farbe setzen
		if(farbe == 2){
			hint[dieVersuche][i] = Integer.toString(farbe);
		}
		//weiße Farbe setzen
		if(farbe == 1){
			hint[dieVersuche][i] = Integer.toString(farbe);
		}
		//keine Farbe setzen
		if(farbe == 0){
			hint[dieVersuche][i] = Integer.toString(farbe);
		}
	}
}

public String[][] getHint(){
	return hint;
}


//Achtung: diese Methode muss beim Bestätigen des Versuchs 4x aufgerufen werden (da alle 4 Farben gesetzt werden müssen)
//hier wird der aktuelle Versuch gesetzt
public void setVersuchAktuell(int farbe){
	
	//for-Schleife, die alle Farben des Versuches setzt
	for(int i = 0; i < versuchAktuell.length; i++){
		
		//switch-case, mit der die einzelnen Farben an der entsprechenden Stelle gesetzt werden
		switch(farbe){
		case 1: versuchAktuell[i] = Integer.toString(1);	//geld
				break;
		case 2: versuchAktuell[i] = Integer.toString(2);	//blau
				break;
		case 3: versuchAktuell[i] = Integer.toString(3);	//grün
				break;
		case 4: versuchAktuell[i] = Integer.toString(4);	//rot
				break;
		case 5: versuchAktuell[i] = Integer.toString(5);	//braun
				break;
		case 6: versuchAktuell[i] = Integer.toString(6);	//orange
				break;
		}
	}
}

//Achtung: nach dem aktuellen Versuch wird "derVergleich" zur Überprüfung aufgerufen
public String[] getVersuchAktuell(){
	return versuchAktuell;
}


//hier werden die Farben miteinander verglichen
//diese Funktion wird immer nach dem Bestätigen einer Reihe aufgerufen
public void derVergleich(){
	
	//temporärer Zähler der richtigen Farben&Position wird gesetzt
	int tempRichtig = 0;
	//ist die letzte Zeile erreicht?
	for(int i = 0; i < loesung.length; i++){
		for(int j = 0; j < loesung.length; j++){
			//es werden alle Farben der Lösung mit allen Farben des Versuch verglichen
			//es wird die weiße Hint-Farbe gesetzt (2), wenn die Farben gleich sind und die Positionen nicht gleich sind
			if (loesung[i] == versuch[dieVersuche][j] && loesung[i] != versuch[dieVersuche][i]){
				setHint(2);
			}
		}
		//wenn die Position und die Farbe übereinstimmen wird die schwarze Hint-Farbe gesetzt
		if (loesung[i] == versuch[dieVersuche][i]){
			setHint(1);
			tempRichtig++;
		}
		//wenn die Farbe nicht mit einer der Farben aus der Lösung übereinstimmt wird nichts gespeichert(0)
		else{
			setHint(0);
		}
	
	}
	
	if(dieVersuche == 10 && tempRichtig == 4){
		//zuerst noch die Farben auf dem Spielfeld setzen
		setVersuch(getVersuchAktuell());
		//danach die Gewonnen-Methode aufrufen
		gewonnen();
	}
	else if(dieVersuche == 10 && tempRichtig < 4){
		setVersuch(getVersuchAktuell());
		verloren();
	}
	//wenn alle 4 Farben richtig sind und an der richtigen STelle stehen, wird die Methode "gewonnen" aufgerufen
	if(tempRichtig == 4){
		gewonnen();
	}
}


//Methode, in der man einen neuen Versuch aus dem Spiel heraus starten kann
public void neuerVersuch(){
	
}

public void gewonnen(){
	
}
}