package corso.lezione04.esercizio03;

public class Main {

	public static void main(String[] args) {
		Libro libro1 = new Libro("Il nome della rosa", "978-88-06-18571-3", "Umberto Eco", 1980);
		System.out.println(libro1.ottieniInfo());
		
		System.out.println("\n");
		
		Libro libro2 = new Libro();
		libro2.setAutore("J.K. Rowling");
		libro2.setIsbn("978-88-17-00023-1");
		libro2.setTitolo("Harry Potter e la pietra filosofale");
		libro2.setAnno(1998);
		libro2.stampaInfo();
	}

}
