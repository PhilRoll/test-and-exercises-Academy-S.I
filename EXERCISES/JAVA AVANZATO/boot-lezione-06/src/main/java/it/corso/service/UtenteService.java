package it.corso.service;

import it.corso.model.Utente;

public interface UtenteService {
		
/* come argomento a questo metodo non è necessario far accettare i parametri nome, cognome età ecc. nè 
 * l'array varargs basta passare un oggetto di tipo Utente utente perchè quando si va ad invocare questo
 * metodo dal controller si può passare direttamente l'oggetto Utente  */	
		void registrazioneUtente (Utente utente);
		
		

}
