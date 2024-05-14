package it.corso.strutture.eserciziocinema;

import java.util.ArrayList;
import java.util.Date;
/**
 * La classe rappresenta un sistema per la gestione delle prenotazioni di un cinema.
 * Questo sistema consente di aggiungere, visualizzare e cancellare prenotazioni.
 * Le prenotazioni sono memorizzate in una lista.
 * @author Lorenzo Taverna
 */

public class SistemaPrenotazioni {
	
	private ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
	
	/**
     * Aggiunge una prenotazione alla lista delle prenotazioni.
     * @param prenotazione La prenotazione da aggiungere.
     */
	public void aggiungiPrenotazione(Prenotazione prenotazione) {
		
		prenotazioni.add(prenotazione);
	}
	/**
     * Visualizza le prenotazioni effettuate per una determinata data.
     * @param data La data delle prenotazioni da visualizzare.
     */
	public void visualizzaPrenotazioniPerData(Date data) {
		
		for(Prenotazione prenotazione : prenotazioni) {
			
			if(prenotazione.getDataPrenotazione().equals(data)) {
				
				System.out.println("id: " + prenotazione.getId() + ", Cliente: " + prenotazione.getNomeCliente());
			}
		}
	}
	/**
     * Cancella una prenotazione dalla lista in base all'ID.
     * @param id L'ID della prenotazione da cancellare.
     */
	public void cancellaPrenotazione(int id) {
		
		/*
		 * metodo removeIf utilizzato per rimuovere una prenotazione dalla lista prenotaoni in base 
		 * all'ID. removeIf() accetta un predicato com parametro e rimuove gli elementi che soddisfano
		 * il predicato. prenotazione -> prenotazione.getId() == id è un'espressione lambda che definisce
		 * il predicato. Questa espressione prende ciascuna prenotazione nella lista e verifica se l'ID
		 * della prenotazione è uguale all'ID. Se la condizione è vera, l'elemento corrente viene rimosso
		 * dalla lista. 
		 */
		prenotazioni.removeIf(prenotazione -> prenotazione.getId() == id);
		
	}


}
