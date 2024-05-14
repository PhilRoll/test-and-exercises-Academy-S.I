/**
 * Classe che rappresenta una rubrica telefonica.
 * 
 * @author Nome Cognome
 * @version 1.0
 * @since 2024-04-03
 */
package corso.lezione06.esercizio02.elencotelefonico;

import java.util.*;

public class Rubrica {
	
	/**
	 * Elenco dei contatti in rubrica.
	 */
	private List<Contatto> contatti;
	
	/**
	 * Costruttore della classe.
	 */
	public Rubrica() {
		contatti = new LinkedList<>();
	}

	/**
	 * Restituisce l'elenco dei contatti in rubrica.
	 * 
	 * @return Elenco dei contatti.
	 */
	public List<Contatto> getContatti() {
		return contatti;
	}

	/**
	 * Imposta l'elenco dei contatti in rubrica.
	 * 
	 * @param contatti Elenco dei contatti.
	 */
	public void setContatti(List<Contatto> contatti) {
		this.contatti = contatti;
	}

	/**
	 * Aggiunge un nuovo contatto alla rubrica.
	 * 
	 * @param contatto Contatto da aggiungere.
	 */
	public void aggiungiContatto(Contatto contatto){
		this.contatti.add(contatto);
	}
	
	/**
	 * Trova i contatti che contengono il nome specificato nella ricerca.
	 * 
	 * @param nome Nome da cercare.
	 * @return Lista di contatti trovati.
	 */
	public List<Contatto> trovaContatto(String nome){
		if(this.contatti.isEmpty() || nome.equals("")) {
			return null;
		}
		List<Contatto> query = new LinkedList<>();
		nome = nome.toLowerCase();
		for(Contatto contatto: this.contatti) {
			if(contatto.getNome().toLowerCase().startsWith(nome)) {
				query.add(contatto);
			}
		}
		return query;
	}
	
	/**
	 * Cancella un contatto dalla rubrica specificando il suo numero di telefono.
	 * 
	 * @param numero Numero di telefono del contatto da cancellare.
	 */
	public void cancellaContatto(String numero){
		this.contatti.removeIf(contatto -> contatto.getNumero().equalsIgnoreCase(numero));
	}
	
}