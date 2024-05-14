package it.corso.esercizioelencotelefonico;

import java.util.LinkedList;

public class GestoreElencoTelefonico {

	private LinkedList<Contatto> elencoTelefonico = new LinkedList<>();
	
	public void aggiungiContatto(Contatto contatto) {
		
		elencoTelefonico.add(contatto);
	}
	
	public Contatto ricercaContattoPerNome(String nome) {
		
		for (Contatto contatto : elencoTelefonico) {
			
			if (contatto.getNome().equals(nome)) {
				return contatto;
			}
		}
		return null;
	}
	
	public void eliminaContattoPerNumero(String numeroTelefono) {
		
		elencoTelefonico.removeIf(contatto -> contatto.getNumeroTelefono().equals(numeroTelefono));
	}
	
	
	
}
