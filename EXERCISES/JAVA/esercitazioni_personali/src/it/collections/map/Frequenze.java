package it.collections.map;
import java.util.*;
import java.io.*;

public class Frequenze {
	/**
	 * 
	 */
	private Map<String,Integer> dizionario;
	
	public Frequenze(){
		dizionario = new TreeMap<>();
	}
	
	
	public Map<String,Integer> calcolaOccorrenzeDaStringa(String stringa){
		stringa = stringa.toLowerCase().trim();
		String regex = "[\\s.,;:!?]+";
		String[] parole = stringa.split(regex);
		
		for(String parola: parole){
			if(!parola.isEmpty() && !this.dizionario.containsKey(parola)){
				this.dizionario.put(parola, 1);
			}
			else {
				this.dizionario.put(parola, this.dizionario.get(parola)+1);
			}
		}
		return this.dizionario;
	}
	
	
	public Map<String,Integer> calcolaOccorrenzeDaFile(String path){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			String riga;
			while((riga=reader.readLine())!=null){
				calcolaOccorrenzeDaStringa(riga);
			}
		} 
		
		catch (FileNotFoundException e) {
			System.out.println("File non trovato :\""+path+"\"");
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			if(reader!=null) {
				try {
					reader.close();
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		return this.dizionario;
	}
	
	
	public int numeroOccorrenza(String key){
		if(this.dizionario.get(key)==null){
			return -1;
		}
		return this.dizionario.get(key);
	}
	
	
	public void stampaFrequenze(){
		for(Map.Entry<String,Integer> entry: this.dizionario.entrySet()){
			System.out.println("Parola: \""+ entry.getKey()+"\" - occorrenze: "+entry.getValue());
		}
	}
	
	
	public static void main(String[] args) {
		Frequenze frequenze = new Frequenze();
		//c.calcolaOccorrenzeDaStringa("ciao come stai? ciao io sto bene");
		frequenze.calcolaOccorrenzeDaFile("C:\\Users\\filip\\Desktop\\Lavoro\\AZIENDE\\Academy - Sistemi Informativi\\Modulo Java\\Esercizi\\esercitazioni_personali\\testo.txt");
		System.out.println(frequenze.numeroOccorrenza("ciao"));
		frequenze.stampaFrequenze();
	}
	
}
