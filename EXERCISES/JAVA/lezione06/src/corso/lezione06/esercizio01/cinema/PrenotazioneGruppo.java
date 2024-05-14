/**
 * @author Filippo Rotolo
 * @version 1.0 03/04/2024
 * 
 * Classe concreta che rappresenta una prenotazione di gruppo.
 *
 * Questa classe eredita dalla classe astratta `Prenotazione` e aggiunge degli attributi specifici per le prenotazioni di gruppo:
 * - `numPostiPrenotatiTot`: Numero totale di posti prenotati.
 * - `numAdulti`: Numero di adulti prenotati.
 * - `numBambini`: Numero di bambini prenotati.
 * - `listaClienti`: Lista contenente i nomi di tutti i partecipanti alla prenotazione di gruppo.
 */

package corso.lezione06.esercizio01.cinema;

import java.util.*;

public class PrenotazioneGruppo extends Prenotazione{
    /**
     * Numero totale di posti prenotati per il gruppo.
     */
	private int numPostiTot;
	
	 /**
     * Numero di adulti prenotati nel gruppo.
     */
	private int numAdulti;
	
    /**
     * Numero di bambini prenotati nel gruppo.
     */
	private int numBambini;
	
    /**
     * Lista contenente i nomi di tutti i partecipanti alla prenotazione di gruppo.
     */
	private List<String> listaClienti;
	
    /**
     * Costruttore della classe PrenotazioneGruppo.
     *
     * Invoca il costruttore della classe padre `Prenotazione` e setta i valori degli attributi specifici per le prenotazioni di gruppo.
     *
     * @param nomeCliente Nome del cliente referente della prenotazione di gruppo.
     * @param dataPrenotazione Data in cui è stata effettuata la prenotazione.
     * @param numAdulti Numero di adulti prenotati nel gruppo.
     * @param numBambini Numero di bambini prenotati nel gruppo.
     * @param listaClienti Lista contenente i nomi di tutti i partecipanti alla prenotazione di gruppo.
     */
	public PrenotazioneGruppo(String nomeCliente, Date dataPrenotazione,
			int numAdulti, int numBambini, List<String> listaClienti) {
		super(nomeCliente, dataPrenotazione);
		this.numAdulti = numAdulti;
		this.numBambini = numBambini;
		this.numPostiTot = numAdulti+numBambini;
		this.listaClienti = listaClienti;
	}


    /**
     * Restituisce il numero totale di posti prenotati per il gruppo.
     *
     * @return Il numero totale di posti prenotati per il gruppo.
     */
	public int getNumPostiTot() {
		return numPostiTot;
	}


    /**
     * Imposta il numero totale di posti prenotati per il gruppo.
     *
     * @param numPostiTot Nuovo numero totale di posti prenotati per il gruppo.
     */
	public void setNumPostiTot(int numPostiTot) {
		this.numPostiTot = numPostiTot;
	}


    /**
     * Restituisce il numero di adulti prenotati nel gruppo.
     *
     * @return Il numero di adulti prenotati nel gruppo.
     */
	public int getNumAdulti() {
		return numAdulti;
	}


    /**
     * Imposta il numero di adulti prenotati nel gruppo.
     *
     * @param numAdulti Nuovo numero di adulti prenotati nel gruppo.
     */
	public void setNumAdulti(int numAdulti) {
		this.numAdulti = numAdulti;
	}


    /**
     * Restituisce il numero di bambini prenotati nel gruppo.
     *
     * @return Il numero di bambini prenotati nel gruppo.
     */
	public int getNumBambini() {
		return numBambini;
	}

	
    /**
     * Imposta il numero di bambini prenotati nel gruppo.
     *
     * @param numBambini Nuovo numero di bambini prenotati nel gruppo.
     */
	public void setNumBambini(int numBambini) {
		this.numBambini = numBambini;
	}


	/**
	 * Restituisce la lista contenente i nomi di tutti i partecipanti alla prenotazione di gruppo.
	 *
	 * @return La lista contenente i nomi di tutti i partecipanti alla prenotazione di gruppo.
	 */
	public List<String> getListaClienti() {
		return listaClienti;
	}


	/**
	 * Imposta la lista contenente i nomi di tutti i partecipanti alla prenotazione di gruppo.
	 *
	 * @param listaClienti Nuova lista contenente i nomi di tutti i partecipanti alla prenotazione di gruppo.
	 */
	public void setListaClienti(List<String> listaClienti) {
		this.listaClienti = listaClienti;
	}
	
	
    /**
     * Stampa le informazioni della prenotazione di gruppo, specificando ID Prenotazione, Data, Nome del prenotante, Lista delle persone, N. di adulti, N. di bambini e e N. di posti totali prenotati.
     *
     * Sovrascrive il metodo astratto `stampaPrenotazione()` della classe padre.
     */
	@Override
	public void stampaPrenotazione() {
		System.out.println("ID Prenotazione: "+this.getId());
		System.out.println("Data: "+this.getDataPrenotazione());
		System.out.println("Prenotazione a nome di : "+this.getNomeCliente());
		System.out.println("Lista persone: "+this.listaClienti);
		System.out.println("N. Adulti: "+this.numAdulti);
		System.out.println("N. Bambini: "+this.numBambini);
		System.out.println("N. Posti prenotati TOT: "+this.numPostiTot);
	}
	

}
