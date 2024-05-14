package it.corso.gestionaleLibro;

public abstract class Libro {

	private String titolo;
	private String autore;
	private int numeroPagine;
	
	public Libro(String titolo, String autore, int numeroPagine) {
		this.titolo = titolo;
		this.autore = autore;
		this.numeroPagine = numeroPagine;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public int getNumeroPagine() {
		return numeroPagine;
	}
	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}
	
	public  abstract void informazioni();
	
}
