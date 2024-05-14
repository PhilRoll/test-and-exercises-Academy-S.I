package it.corso.gestionaleLibro;

public class LibroCartaceo extends Libro {
	
	public LibroCartaceo(String titolo, String autore, int numeroPagine) {
        super(titolo, autore, numeroPagine);
    }

	@Override
	public void informazioni() {
		
		  	System.out.println("Titolo: " + getTitolo());
	        System.out.println("Autore: " + getAutore());
	        System.out.println("Numero di pagine: " + getNumeroPagine());
	        System.out.println("Formato: Cartaceo");
	    	
	}
}



