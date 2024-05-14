package corso.lezione05.esercizio13;

public abstract class Libro {
	//attributi
	private String titolo;
	private String autore;
	private int numPagine;
	
	//costruttore
	public Libro(String titolo, String autore, int numPagine) {
		this.titolo = titolo;
		this.autore = autore;
		this.numPagine = numPagine;
	}


	//getter e setter
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


	public int getNumPagine() {
		return numPagine;
	}


	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}

	//metodo abstract di stampa informazioni
	public abstract void informazioni();
	
}
