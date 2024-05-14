package corso.lezione05.esercizio13;

public class Ebook extends Libro implements FormatoDigitale{
	
	public Ebook(String titolo, String autore, int numPagine) {
		super(titolo, autore, numPagine);
	}

	//implemntazione del metodo astratto dichiarato nella classe Libro
	@Override
	public void informazioni() {
		System.out.println("Titolo: "+this.getTitolo()+"\nAutore: "+this.getAutore()+"\nNum.Pagine: "+this.getNumPagine());
	}
	
	public void visualizza() {
		System.out.println("Il libro è disponibile in formato digitale");
	}
}
