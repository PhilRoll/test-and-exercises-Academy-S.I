package corso.lezione05.esercizio13;

public class Main {

	public static void main(String[] args) {
		Libro l1 = new LibroCartaceo("Harry Potter e la pietra filosofale","J.K. Rowling", 300);
		l1.informazioni();
		
		Ebook l2 = new Ebook("Harry Potter e la camera dei Segreti","J.K. Rowling", 400);	
		l2.informazioni();
		l2.visualizza();

	}

}
