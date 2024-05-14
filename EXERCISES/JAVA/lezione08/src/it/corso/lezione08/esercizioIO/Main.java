package it.corso.lezione08.esercizioIO;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		String inputPath = "C:\\Users\\filip\\Desktop\\Lavoro\\AZIENDE\\Academy - Sistemi Informativi\\Modulo Java\\Esercizi\\lezione08\\src\\it\\corso\\lezione08\\input.txt";
		String outputPath = "C:\\Users\\filip\\Desktop\\Lavoro\\AZIENDE\\Academy - Sistemi Informativi\\Modulo Java\\Esercizi\\lezione08\\src\\it\\corso\\lezione08\\ouput.txt";
		String regex = "[\\s,.-_!?;]+";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputPath));
			int numParole = 0;
			String riga;
			while((riga = reader.readLine())!=null){
				System.out.println(riga);
				String[] parole = riga.split(regex);
				for(String parola:parole){
					if(!parola.isEmpty()){
						numParole++;
					}
				}
			}
			reader.close();
			System.out.println("numero di parole: "+numParole);
			BufferedWriter output = new BufferedWriter(new FileWriter(outputPath));
			output.write(String.valueOf(numParole));
			output.close();
		} 
		catch (FileNotFoundException e) {
			System.err.println("File non trovato");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
