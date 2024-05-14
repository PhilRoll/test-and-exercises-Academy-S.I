package it.corso.gestionaleLibro;

public class Main {

	public static void main(String[] args) {
        // Creazione di un libro cartaceo e visualizzazione delle informazioni
        LibroCartaceo libroCartaceo = new LibroCartaceo("Il signore degli anelli", "J.R.R. Tolkien", 1178);
        libroCartaceo.informazioni();
        System.out.println("----------------");

        // Creazione di un ebook e visualizzazione delle informazioni
        Ebook ebook = new Ebook("1984", "George Orwell", 328);
        ebook.informazioni();
        ebook.visualizza();
    }
}

