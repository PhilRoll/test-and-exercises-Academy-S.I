package corso.lezione06.esercizio01.cinema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	
	@SuppressWarnings("deprecation")	//per avvisare il compilatore di ignorare il warning sull'uso di classi deprecate
	public static void main(String[] args) {
		
		//istanza della classe GestionePrenotazioni
		GestionePrenotazioni gestione = new GestionePrenotazioni();
		
		//dati cliente 
		Date dataPrenotazione = new Date(2024,03,03);
		
		//inserimento di una prenotazione singola
		gestione.aggiungiPrenotazione(new PrenotazioneSingola("Pippo", dataPrenotazione, 3));
		
		System.out.println("Stampa prenotazioni in data: "+dataPrenotazione+"\n");
		//visualizzazione delle prenotazioni in data:"dataPrenotazione"
		gestione.visualizzaPrenotazioni(dataPrenotazione);
		
		System.out.println("\n\n----------------------------------\n");
		
		//Lista di tipo String di nomi clienti
		List<String> listaClienti = new ArrayList<>();
		listaClienti.add("Gino");
		listaClienti.add("Mario");
		listaClienti.add("Luigi");
		int numBambini = 1;
		System.out.println("Inserimento prenotazione di gruppo e stampa prenotazioni in data: "+dataPrenotazione+"\n");
		gestione.aggiungiPrenotazione(new PrenotazioneGruppo(listaClienti.getFirst(), dataPrenotazione, listaClienti.size()-numBambini, 1, listaClienti));
		gestione.visualizzaPrenotazioni(dataPrenotazione);
		
		System.out.println("\n\n----------------------------------\n");
		
		int id = 1;
		System.out.println("Rimozione prenotazione con id: "+id+" e stampa prenotazioni in data: "+dataPrenotazione+"\n");
		gestione.cancellaPrenotazione(id);
		gestione.visualizzaPrenotazioni(dataPrenotazione);
	}
}
