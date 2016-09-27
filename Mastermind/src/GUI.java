import java.awt.*;
import javax.swing.*;
import java.util.*;

public class GUI {
	public static void main (String [] args){
		for(int i=0;i<15;i++){
			System.out.println();
		}
		SpielLogik logik = new SpielLogik(2);
		Scanner user_input = new Scanner (System.in);
		System.out.println("Type 'OK' and confirm with 'Enter' to start");
		boolean boolvar = user_input.next().equals("admin");
		
		for (int i = 0; i<10; i++){
			if (boolvar){
				for ( int j = 0; j<4; j++){
					switch (logik.loesung[j]){
					case 1:
						System.out.print("gelb  ");
						break;
					case 2:
						System.out.print("blau  ");
						break;
					case 3:
						System.out.print("grün  ");
						break;
					case 4:
						System.out.print("rot   ");
						break;
					default:
						System.out.println("  >>Wrong input<<  ");
					}
				}
				System.out.println();
			}
			System.out.println("Please Enter 4 Numbers from 1-4 and confirm each number with 'Enter'");
			logik.setVersuchAktuell(user_input.nextInt(), 0);
			logik.setVersuchAktuell(user_input.nextInt(), 1);
			logik.setVersuchAktuell(user_input.nextInt(), 2);
			logik.setVersuchAktuell(user_input.nextInt(), 3);
			for (int j = 0; j<4; j++){
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
			logik.derVergleich();
			for (int i1 = 0; i1<4; i1++){
				if (logik.tempRichtig==4){
					break;
				}
				switch (logik.hint[i1][logik.dieVersuche]){
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
			if (logik.tempRichtig==4){
				break;
			}
		}
	}
}
