package corso.lezione05.esercizio13;

public class LibroCartaceo extends Libro{
	
	//costruttore
	public LibroCartaceo(String titolo, String autore, int numPagine) {
		super(titolo, autore, numPagine);
	}

	//implemntazione del metodo astratto dichiarato nella classe Libro
	@Override
	public void informazioni() {
		System.out.println("Titolo: "+this.getTitolo()+"\nAutore: "+this.getAutore()+"\nNum.Pagine: "+this.getNumPagine()+"\nFormato: cartaceo.");
	}
	
	
}
