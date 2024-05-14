package it.corso.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import it.corso.model.Utente;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Override
	public void registrazioneUtente(String nome, String username, String password) {
		
		Utente utente = new Utente();
		utente.setNome(nome);
		utente.setUsername(username);
		utente.setPassword(password);
		// invocare componente del Data Layer per la registrazione nel database
		System.out.println("utente " + utente.getNome() + " " + "registrato");		
		
	}

	@Override
	public boolean controlloDatiUtente(String... dati) {
		
		boolean controlloNome = Pattern.matches(REGEX_NOME, dati[0]);
		boolean controlloUsername = Pattern.matches(REGEX_USERNAME, dati[1]);
		boolean controlloPassword = Pattern.matches(REGEX_PASSWORD, dati[2]);
		return controlloNome && controlloUsername && controlloPassword;
	}

}
