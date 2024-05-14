package corso.lezione04.esercizio01;

public class Studente {
	//attributi
	
	private String nome;
	private String cognome;
	private String matricola;
	
	
	//costruttori
	
	public Studente() {
	}

	public Studente(String nome, String cognome, String matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}
	
	
	//metodi
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public String getMatricola() {
		return this.matricola;
	}
	
	@Override
	public String toString() {
		return "Nome: "+this.nome+"\nCognome: "+this.cognome+"\nMatricola: "+this.matricola;
	}
	
	
}
