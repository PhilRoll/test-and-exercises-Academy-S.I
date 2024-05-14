package it.corso.gestionaleLibro;

public class Ebook extends Libro implements FormatoDigitale {

	public Ebook(String titolo, String autore, int numeroPagine) {
		super(titolo, autore, numeroPagine);
		// TODO Auto-generated constructor stub
	}

	// Implementazione del metodo astratto informazioni
    @Override
    public void informazioni() {
        System.out.println("Titolo: " + getTitolo());
        System.out.println("Autore: " + getAutore());
        System.out.println("Numero di pagine: " + getNumeroPagine());
        System.out.println("Formato: E-book");
    }

    // Implementazione del metodo visualizza dell'interfaccia FormatoDigitale
    @Override
    public void visualizza() {
        System.out.println("Il libro è disponibile in formato digitale.");
    }	

}

