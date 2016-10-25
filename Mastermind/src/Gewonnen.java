import javax.swing.JOptionPane;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Gewonnen {
       int anzahlVersuche;
       int schwierigkeit;
       static String highscoreArray1[][] = new String[11][2];
       static String highscoreArray2[][] = new String[11][2];
       static String highscoreArray3[][] = new String[11][2];
       static String highscoreArray [][] = new String[11][2];
       final static String LINESEPARATOR = System.getProperty("line.separator");
       
       public Gewonnen(int anzahlVersuche, int schwierigkeit) {
              this.anzahlVersuche = anzahlVersuche;
              this.schwierigkeit = schwierigkeit;
              highscoreArray1[10][0]="11";
              highscoreArray2[10][0]="11";
              highscoreArray3[10][0]="11";
              try {
                     abspeichern();
                     anzeigen();
              } catch (IOException e) {
                     e.printStackTrace();
              }
       }
       
       public void abspeichern() throws IOException{
              String text = "";
              text = text + Integer.toString(anzahlVersuche) + LINESEPARATOR;
           text = text + MenuManager.name + LINESEPARATOR;
           text = text + lesen(schwierigkeit).substring(0,lesen(schwierigkeit).lastIndexOf(LINESEPARATOR)) + "&" + LINESEPARATOR;
           String dateiName = "Test" + schwierigkeit + ".txt";
           FileOutputStream schreibeStrom = 
                            new FileOutputStream(dateiName);
           for (int i=0; i < text.length(); i++){
             schreibeStrom.write((byte)text.charAt(i));
           }
           schreibeStrom.close();
           System.out.println("Datei " + dateiName + " ist geschrieben!");
           for (int i = 1; i<4;i++){
           inArrayLaden(lesen(i), i);
           arraySortieren(i);
              arrayAnDatei(i);
           }
       }
       
       public static String lesen(int i) throws IOException{
              byte zeichen=0;
              String text = "";
              String dateiName = "Test"+i+".txt";
              FileInputStream leseStrom = new FileInputStream(dateiName);
              while(zeichen !=-1){
                     zeichen = (byte)leseStrom.read();
                     if(zeichen!=-1 && zeichen!=38){text += (char)zeichen;}
              }
              leseStrom.close();
              return text;
       }
       
       public static void inArrayLaden(String text, int schwierigkeit) throws IOException {
              String textTeil = text;
              String replica = text;
              while (textTeil!="&"){
                     for (int i = 0; i<11; i++){
                           if(replica.indexOf(LINESEPARATOR)==-1){break;}
                           if(i==0) {textTeil = replica.substring(0,replica.indexOf(LINESEPARATOR));}
                           else{textTeil = replica.substring(1, replica.indexOf(LINESEPARATOR));}
                           replica = replica.substring(replica.indexOf(LINESEPARATOR)+1);
                           highscoreArray[i][0] = textTeil;
                           textTeil = replica.substring(1, replica.indexOf(LINESEPARATOR));
                           replica = replica.substring(replica.indexOf(LINESEPARATOR)+1);
                           highscoreArray[i][1] = textTeil;
                           if(textTeil.endsWith("&")||i==9){textTeil = "&";}
                     }
                     if(replica.indexOf(LINESEPARATOR) == -1){textTeil = "&";}
              }
              switch(schwierigkeit){
              case 1: highscoreArray1 = arrayDeepCopy(highscoreArray);break;
              case 2: highscoreArray2 = arrayDeepCopy(highscoreArray);break;
              case 3: highscoreArray3 = arrayDeepCopy(highscoreArray);break;
              }
       }
       
       public static void arraySortieren(int schwierigkeit) {
              switch(schwierigkeit){
              case 1: highscoreArray = arrayDeepCopy(highscoreArray1);break;
              case 2: highscoreArray = arrayDeepCopy(highscoreArray2);break;
              case 3: highscoreArray = arrayDeepCopy(highscoreArray3);break;
              }
              for(int i = 0; i<highscoreArray.length;i++){
                     if(highscoreArray[i][0]==null){
                           highscoreArray[i][0]="99";
                           highscoreArray[i][1]="empty";
                     }
              }
        Arrays.sort(highscoreArray, new Comparator<String[]>() {
            public int compare(final String[] entry1, final String[] entry2) {
              final String time1 = entry1[0];
              final String time2 = entry2[0];
              return time1.compareTo(time2);
            }
           });
              switch(schwierigkeit){
              case 1: highscoreArray1 = arrayDeepCopy(highscoreArray);break;
              case 2: highscoreArray2 = arrayDeepCopy(highscoreArray);break;
              case 3: highscoreArray3 = arrayDeepCopy(highscoreArray);break;
              }
       }
       
       public static void arrayAnDatei(int i) throws IOException{
              String dateiName = "Test"+ i + ".txt";
              PrintWriter pw = new PrintWriter(dateiName);
              pw.print("");
              pw.close();
              System.out.println("Cleared");
              String text = "";
              for(int j=0;j<10;j++){
                     switch(i){
                     case 1: highscoreArray = arrayDeepCopy(highscoreArray1);break;
                     case 2: highscoreArray = arrayDeepCopy(highscoreArray2);break;
                     case 3: highscoreArray = arrayDeepCopy(highscoreArray3);break;
                     }
                     if(highscoreArray[j][0]!=null){
                           text = text + highscoreArray[j][0] + LINESEPARATOR;
                           text = text + highscoreArray[j][1] + LINESEPARATOR;
                     }
                     if(j == 9){
                           text = text.substring(0, text.lastIndexOf(LINESEPARATOR)) + "&" + LINESEPARATOR;
                     }
              }
              FileOutputStream schreibeStrom = 
                              new FileOutputStream(dateiName);
              for (int j=0; j < text.length(); j++){
                     schreibeStrom.write((byte)text.charAt(j));
              }
              schreibeStrom.close();
              System.out.println("Datei " + dateiName + " ist geschrieben!");
       }
       
       public static String[][] arrayDeepCopy(String[][] original) {
              if(original == null){return null;}
              final String[][] RESULT = new String [original.length][];
              for (int i = 0; i < original.length; i++) {
                     RESULT[i] = Arrays.copyOf(original[i], original[i].length);
              }
              return RESULT;
       }
       
       public static void anzeigen() throws IOException{
             
              System.out.println("Highscores");
              for(int i = 0; i<3; i++){
                     switch(i){
                     case 0:System.out.println("Highscores - Einfach");highscoreArray=arrayDeepCopy(highscoreArray1);break;
                     case 1:System.out.println("Highscores - Mittel");highscoreArray=arrayDeepCopy(highscoreArray2);break;
                     case 2:System.out.println("Highscores - Schwer");highscoreArray=arrayDeepCopy(highscoreArray3);break;
                     }
                     System.out.println("Versuche / Name");
                     for(int j = 0; j < 10; j++){
                           if(highscoreArray[j][0]!=null&&highscoreArray[j][1]!=null){
                                  if(Integer.parseInt(highscoreArray[j][0])<10){
                                         if (Integer.parseInt(highscoreArray[j][0])==9){
                                                System.out.print((Integer.parseInt(highscoreArray[j][0]) + 1) + "   ");
                                         }else{
                                                System.out.print((Integer.parseInt(highscoreArray[j][0]) + 1) + "    ");
                                         }
                                  }else{
                                         System.out.print("-    ");
                                  }
                                  System.out.println(highscoreArray[j][1]);
                           }
                     }
                     System.out.println();
              }
       }
}
