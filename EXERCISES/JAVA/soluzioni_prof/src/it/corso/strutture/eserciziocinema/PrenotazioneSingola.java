package it.corso.strutture.eserciziocinema;

import java.util.Date;

public class PrenotazioneSingola  extends Prenotazione{
	
	private int numeroPosto;

	public PrenotazioneSingola(int id, String nomeCliente, Date dataPrenotazione, int numeroPosto) {
		super(id, nomeCliente, dataPrenotazione);
		this.numeroPosto =  numeroPosto;
	}

	public int getNumeroPosto() {
		return numeroPosto;
	}

	public void setNumeroPosto(int numeroPosto) {
		this.numeroPosto = numeroPosto;
	}
	
	

}
