package it.corso.strutture.eserciziocinema;

import java.util.Date;

/**
 * La classe rappresenta una prenotazione di gruppo, estendendo la classe Prenotazione base.
 * Una prenotazione di gruppo contiene un identificatore univoco, il nome del cliente, la data della prenotazione,
 * il numero totale di posti prenotati, il numero di adulti e il numero di bambini.
 *
 * @author Lorenzo Taverna
 */
public class PrenotazioneGruppo extends Prenotazione {
	
	private int numeroTotaliPosti;
	private int numeroAdulti;
	private int numeroBambini;

	/**
     * Costruttore della classe PrenotazioneGruppo.
     * @param id L'identificatore univoco della prenotazione.
     * @param nomeCliente Il nome del cliente che ha effettuato la prenotazione.
     * @param dataPrenotazione La data in cui è stata effettuata la prenotazione.
     * @param numeroTotaliPosti Il numero totale di posti prenotati per il gruppo.
     * @param numeroAdulti Il numero di adulti nel gruppo.
     * @param numeroBambini Il numero di bambini nel gruppo.
     */
	
	public PrenotazioneGruppo(int id, String nomeCliente, Date dataPrenotazione, int numeroTotaliPosti, int numeroAdulti, int numeroBambini) {
		super(id, nomeCliente, dataPrenotazione);
		this.numeroTotaliPosti = numeroTotaliPosti;
		this.numeroAdulti = numeroAdulti;
		this.numeroBambini = numeroBambini;
	}

	/**
     * Restituisce il numero totale di posti prenotati per il gruppo.
     * @return Il numero totale di posti prenotati.
     */
	public int getNumeroTotaliPosti() {
		return numeroTotaliPosti;
	}

	/**
     * Imposta il numero totale di posti prenotati per il gruppo.
     * @param numeroTotaliPosti Il nuovo numero totale di posti prenotati.
     */
	public void setNumeroTotaliPosti(int numeroTotaliPosti) {
		this.numeroTotaliPosti = numeroTotaliPosti;
	}

	/**
     * Restituisce il numero di adulti nel gruppo.
     * @return Il numero di adulti nel gruppo.
     */
	public int getNumeroAdulti() {
		return numeroAdulti;
	}

	/**
     * Imposta il numero di adulti nel gruppo.
     * @param numeroAdulti Il nuovo numero di adulti nel gruppo.
     */
	public void setNumeroAdulti(int numeroAdulti) {
		this.numeroAdulti = numeroAdulti;
	}

	/**
     * Restituisce il numero di bambini nel gruppo.
     * @return Il numero di bambini nel gruppo.
     */
	public int getNumeroBambini() {
		return numeroBambini;
	}

	 /**
     * Imposta il numero di bambini nel gruppo.
     * @param numeroBambini Il nuovo numero di bambini nel gruppo.
     */
	public void setNumeroBambini(int numeroBambini) {
		this.numeroBambini = numeroBambini;
	}
	
	 
	
	

}
