package corso.lezione06.esercizio01.cinema;

import java.util.*;

public class GestionePrenotazioni {
	/**
	 * Lista di tutte le prenotazioni effettuate.
	 *
	 * @see Prenotazione
	 */
	private List<Prenotazione> prenotazioni;
	
	/**
	 *  Costruttore che inizializza l'ArrayList
	 */
	public GestionePrenotazioni(){
		this.prenotazioni = new ArrayList<>();
	}
	
	
    /**
     * Aggiunge una prenotazione singola.
     */
	public void aggiungiPrenotazione(Prenotazione p){
		this.prenotazioni.add(p);
	}
	
	
    /**
     * Visualizza le prenotazioni per una data specifica.
     *
     * @param data La data delle prenotazioni da visualizzare.
     */
	public void visualizzaPrenotazioni(Date data){
		Iterator<Prenotazione> iteratore = this.prenotazioni.iterator();
		while (iteratore.hasNext()) {
		    Prenotazione prenotazione = iteratore.next();
		    if(prenotazione!= null){
		    	if(prenotazione.getDataPrenotazione().equals(data)){
		    		prenotazione.stampaPrenotazione();
		    		System.out.println();
		    	}
		    }
		}
	}
	
	
    /**
     * Cancella una prenotazione.
     *
     * @param id L'ID della prenotazione da cancellare.
     */
	public void cancellaPrenotazione(int id){
		Iterator<Prenotazione> iteratore = this.prenotazioni.iterator();
		while (iteratore.hasNext()) {
		    Prenotazione prenotazione = iteratore.next();
		    if (prenotazione != null && prenotazione.getId() == id) {
		    	prenotazioni.remove(prenotazione);
		    	break;
		    }
		}
	}
	
		/*
	 	//in alternativa
		public void cancellaPrenotazione(int id){
 			this.prenotazioni.removeIf(prenotazione -> prenotazione.getId() == id);
		} 
		 */
	
}
