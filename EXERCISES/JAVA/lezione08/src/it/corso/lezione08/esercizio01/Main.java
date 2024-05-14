package it.corso.lezione08.esercizio01;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		//path dove si trova il file
		String filePath = System.getProperty("user.home")+
											File.separator+
											"Downloads"+
											File.separator+
											"file.txt";
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int parole = 0;
            int caratteri = 0;
            String riga;
            
            
			while((riga = reader.readLine())!=null){
				String regex = "[\\s,.-_!?;]+"; //Trova uno o più spazi o punteggiatura
				
				String[] arrayParole = riga.split(regex);	
				
				//parole+=arrayParole.length;
				
				//conta le parole non vuote
				for (String s : arrayParole){
					 if (!s.isEmpty()) {
						 parole++;
					 }
				}
				
				
				caratteri+= riga.replaceAll(regex,"").length();
			}
			
            System.out.println("Numero di parole: " + parole);
            System.out.println("Numero di caratteri (escluso spazio): " + caratteri);
            System.out.println("Media lungezza parola: " + (double) caratteri/parole);
          
        } 
		
		catch (FileNotFoundException e) {
            System.err.println("Errore: File non trovato - " + filePath);
        } 
		catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
        }
		catch (ArithmeticException e) {
            System.err.println("Errore, impossibile dividere per 0: " + e.getMessage());
        }
		
    }
	
	

}
