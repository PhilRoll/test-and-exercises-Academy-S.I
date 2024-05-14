package it.corso.strutture.eserciziocinema;

import java.sql.Date;
import java.util.Calendar;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2024);
//		cal.set(Calendar.MONTH, Calendar.MAY);
//		cal.set(Calendar.DAY_OF_MONTH, 2);
//		long timestamp = cal.getTimeInMillis();
//		Date data = new Date(timestamp);

		SistemaPrenotazioni sistema = new SistemaPrenotazioni();
		
		sistema.aggiungiPrenotazione(new PrenotazioneSingola(1, "Mario Rossi", new Date(2024, 04, 02),2));
		
		sistema.aggiungiPrenotazione(new PrenotazioneGruppo(2, "Luca Bianchi",  new Date(2024, 04, 02), 5, 3, 2));
		
		System.out.println("---------");
		sistema.visualizzaPrenotazioniPerData(new Date(2024, 04, 02));
		
		
		sistema.cancellaPrenotazione(2);
		
		System.out.println("Dopo la cancellazione: ");
		
		sistema.visualizzaPrenotazioniPerData(new Date(2024, 04, 02));

	}

}
