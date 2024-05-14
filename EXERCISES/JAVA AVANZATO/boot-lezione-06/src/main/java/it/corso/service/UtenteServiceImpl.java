package it.corso.service;

import org.springframework.stereotype.Service;

import it.corso.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Override
	public void registrazioneUtente(Utente utente) {
		

		// invocazione del componente per la registrazione nel database 
		System.out.println("Utente " + utente.getNome() + " registrato");
	}

}
