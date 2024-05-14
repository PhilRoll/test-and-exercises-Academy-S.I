package it.corso.esercizioelencotelefonico;

public class Main {
	
	public static void main(String[] args) {
		
		GestoreElencoTelefonico gestore = new GestoreElencoTelefonico();
		
		gestore.aggiungiContatto(new ContattoPersonale("Mario Rossi", "12345454", "Via Prova"));
		gestore.aggiungiContatto(new ContattoLavoro("Luca Rossi", "998989393", "Manager"));
		
		Contatto contatto = gestore.ricercaContattoPerNome("Mario Rossi");
		System.out.println("Contatto trovato: " +  contatto.getNome() + ", Tel " + contatto.getNumeroTelefono());
		
		gestore.eliminaContattoPerNumero("998989393");
		
		System.out.println("Dopo l'eliminazione: ");
		
		contatto = gestore.ricercaContattoPerNome("Luca Rossi");
		System.out.println("Contatto: " + (contatto !=null ? contatto.getNome()+ ", Tel" +
		contatto.getNumeroTelefono() : "Non trovato"));
		
		

	}
}
