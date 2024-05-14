package it.corso.strutture.eserciziocinema;

import java.util.Date;
/**
 * La classe rappresenta una prenotazione.
 * Una prenotazione contiene un identificatore univoco, il nome del cliente e la data della prenotazione.
 */
public class Prenotazione {
	
	private int id;
	private String nomeCliente;
	private Date dataPrenotazione;
	
	/**
     * Costruttore della classe Prenotazione.
     * @param id L'identificatore univoco della prenotazione.
     * @param nomeCliente Il nome del cliente che ha effettuato la prenotazione.
     * @param dataPrenotazione La data in cui è stata effettuata la prenotazione.
     */
	public Prenotazione(int id, String nomeCliente, Date dataPrenotazione) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.dataPrenotazione = dataPrenotazione;
	}

	/**
     * Restituisce l'identificatore della prenotazione.
     * @return L'identificatore della prenotazione.
     */
	public int getId() {
		return id;
	}

	/**
     * Imposta l'identificatore della prenotazione.
     * @param id Il nuovo identificatore della prenotazione.
     */
	public void setId(int id) {
		this.id = id;
	}

	/**
     * Restituisce il nome del cliente che ha effettuato la prenotazione.
     * @return Il nome del cliente.
     */
	public String getNomeCliente() {
		return nomeCliente;
	}

	 /**
     * Imposta il nome del cliente che ha effettuato la prenotazione.
     * @param nomeCliente Il nuovo nome del cliente.
     */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	
	
	

}
