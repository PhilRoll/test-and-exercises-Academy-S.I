package corso.lezione04.esercizio03;

public class Libro {
	
	/*ATTRIBUTI*/
	private String titolo;
	private String isbn;
	private String autore;
	private int anno;
	
	/*COSTRUTTORI*/
	
	public Libro() {}

	public Libro(String titolo, String isbn, String autore, int anno) {
		this.titolo = titolo;
		this.isbn = isbn;
		this.autore = autore;
		this.anno = anno;
	}
	
	/*METODI*/
	
	
	//GETTERS
	public String getTitolo() {
		return titolo;
	}


	public String getIsbn() {
		return isbn;
	}


	public String getAutore() {
		return autore;
	}


	public int getAnno() {
		return anno;
	}
	
	
	//SETTERS
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public void setAnno(int anno) {
		this.anno = anno;
	}

	//STAMPA INFO
	public void stampaInfo() {
		System.out.println("info sul libro:\ntitolo = " + this.titolo + "\nisbn = " + this.isbn + "\nautore = " + this.autore + "\nanno = " + this.anno);
	}
	
	public String ottieniInfo() {
		return "\"" + this.titolo + "\", libro scritto da " + this.autore + " e pubblicato nel " + this.anno+" (ISBN:"+this.isbn+")";
	}
	
	
	
	
}
