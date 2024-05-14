package it.corso.gestionevoti;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Filippo Rotolo
 * 
 * Questa classe rappresenta la gestione dei voti degli studenti.
 * Fornisce metodi per aggiungere un voto ad uno studente, recuperare il voto di uno studente e stampare tutti i voti.
 */
public class StudentGrades {
	/**
	 * Mappa che memorizza i voti degli studenti, dove la chiave è il nome dello studente e il valore è il suo voto.
	 */
	Map<String,Integer> studentGrades = new HashMap<>();
	
	
	/**Aggiunge un voto ad uno studente.
	 * 
	 * @param studentName Il nome dello studente.
	 * @param grade Il voto dello studente (deve essere un valore valido).
	 */
	public void addgrade(String studentName, Integer grade){
		try {
			if(studentName!=null && grade!=null) {
				this.studentGrades.put(studentName, grade);
			}
			
		} catch (Exception e) {
			System.out.println("Inserimento non valido");
		}
		
	}
	
	
	/**Recupera il voto di uno studente.
	 * 
	 * @param studentName Il nome dello studente.
	 * @return Il voto dello studente, oppure -1 se lo studente non è presente.
	 */
	public int getGrade(String studentName){
		try {
			if(this.studentGrades.containsKey(studentName)){
				return this.studentGrades.get(studentName);
			}
			return -1;
			
		} catch (Exception e) {
			System.out.println("Errore nella ricerca");
		}

		return -1;
	}
	
	
	/**
	 * Stampa tutti i voti degli studenti.
	 */
	public void printGrades(){
		try {
			for(Map.Entry<String,Integer> entry: this.studentGrades.entrySet()){
				System.out.println("Studente: \""+ entry.getKey()+"\" - voto: "+entry.getValue());
			}
		} catch (Exception e) {
			System.out.println("Errore nella stampa");
		}
	}
	

}
