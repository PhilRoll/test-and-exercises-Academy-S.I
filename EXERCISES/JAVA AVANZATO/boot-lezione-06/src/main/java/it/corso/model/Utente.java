package it.corso.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

/* https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary.html */


public class Utente {

/* il nome ad esempio è una stringa quindi la scelta migliore è l'annotation Pattern e si definisce 
 * l'attributo regexp in cui valore è un'espressione regolare e si specifica anche la lunghezza. Si può 
 * sempre dentro l'annotation Pattern implementare l'attributo message che verrà proposto nel caso in cui
 * il valore che viene utilizzato per istanziare nome non sia conforme con l'espressione regolare */ 
	
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "Nome non corretto")
	private String nome;
	
	@Min(value = 1, message= "valore troppo basso")
	@Max(value = 101, message = "valore troppo alto")
	private int eta;
/* questa espressione regolare è per la password e sta a significare che la password supera il controllo 
 * se contiene almeno un numero (la d indica un qualsiasi carattere numerico), una lettera minuscola 
 * minuscola compresa tra a e z, una lettera maiuscola e c'è un elenco dei caratteri ammessi escludendo gli
 * altri (quindi in questo caso solo caratteri numerici, maiuscole e minuscole), infine, la password deve
 * avere minimo 6 caratteri e massimo 20 caratteri */
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,20}", message = "Password non valida, inserire un carattere numerico, almeno una maiscuola e almeno una minuscola. Minimo 6 caratteri e massimo 20")
	private String password;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
