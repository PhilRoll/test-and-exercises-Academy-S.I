package it.corso.service;

public interface UtenteService {

	
	String REGEX_NOME = "[a-zA-Z\\s']{1,100}";
	String REGEX_USERNAME = "[a-zA-Z.]{1,10}";
	String REGEX_PASSWORD = "[a-zA-Z0-9]{5,20}";
	
	void registrazioneUtente(String nome, String username, String password);
	
	// String... quando non si sa a priori il numero di parametri da passare 
	boolean controlloDatiUtente(String...dati);
	
}
