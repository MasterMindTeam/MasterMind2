import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GUI {
	public static void main (String [] args){						//Spacing
		for(int i=0;i<15;i++){
			System.out.println();
		}
		SpielLogik logik = new SpielLogik(2);						//Erzeugt Objekt von SpielLogik
		Scanner user_input = new Scanner (System.in);
		System.out.println("Type 'OK' and confirm with 'Enter' to start");
		boolean boolvar = user_input.next().equals("admin");		//"Cheat" um die LÃ¶sung anzuzeigen
		
		for (int i = 0; i<10; i++){									//Anzeigen der LÃ¶sung, wenn admin eigegeben
			if (boolvar){
				for ( int j = 0; j<4; j++){
					switch (logik.loesung[j]){
					case 1:
						System.out.print("gelb   ");
						break;
					case 2:
						System.out.print("blau   ");
						break;
					case 3:
						System.out.print("grün   ");
						break;
					case 4:
						System.out.print("rot    ");
						break;
					}
				}
				System.out.println();
			}
			System.out.println("Please Enter 4 Numbers from 1-4 and confirm each number with 'Enter'");
			logik.setVersuchAktuell(user_input.nextInt(), 0);		//Nutzereingabe wird registriert (4mal)
			logik.setVersuchAktuell(user_input.nextInt(), 1);
			logik.setVersuchAktuell(user_input.nextInt(), 2);
			logik.setVersuchAktuell(user_input.nextInt(), 3);
			for (int j = 0; j<4; j++){								//Nutzereingabe wird auf dem Bildschirm angezeigt
				switch (logik.versuch[j][logik.dieVersuche]){
				case 1:
					System.out.print("gelb    ");
					break;
				case 2:
					System.out.print("blau    ");
					break;
				case 3:
					System.out.print("grün    ");
					break;
				case 4:
					System.out.print("rot     ");
					break;
				default:
					System.out.println("  >>Wrong input<<  ");
				}
			}
			System.out.println("");
			System.out.println("");
			logik.derVergleich();									//Hinweise werden erstellt
			for (int i1 = 0; i1<4; i1++){
				if(logik.tempRichtig==4){							//Wenn gewonnen: Ãœerspringt anzeigen der LÃ¶sung
					break;
				}
				switch (logik.hint[i1][logik.dieVersuche-1]){			//Hinweise werden angezeigt
				case 0:
					System.out.print("nix     ");
					break;
				case 1:
					System.out.print("weiß    ");
					break;
				case 2:
					System.out.print("schwarz ");
					break;
				default:
					System.out.println("  >>Sorry, Systemfehler...<<  ");
				}
			}
			System.out.println("");
			System.out.println("");
			if(logik.tempRichtig==4){								//Wenn gewonnen: Fragt nicht nach neuer Eingabe
				Gewonnnen gewonnen = new Gewonnnen();
				break;
			}
		}
	}
}
