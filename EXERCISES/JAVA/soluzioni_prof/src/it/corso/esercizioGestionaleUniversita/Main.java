package it.corso.esercizioGestionaleUniversita;

public class Main {

	public static void main(String[] args) {
        // Creazione dell'oggetto università
        Universita universita = new Universita();

        // Creazione di studenti
        Studente studente1 = new Studente("Mario", "Rossi", "S123");
        Studente studente2 = new Studente("Luigi", "Bianchi", "S124");

        // Creazione di professori
        Professore professore1 = new Professore("Giulia", "Verdi", "P123");
        Professore professore2 = new Professore("Marco", "Neri", "P124");

        // Registrazione degli studenti e dei professori all'università
        universita.registraStudente(studente1);
        universita.registraStudente(studente2);
        universita.registraProfessore(professore1);
        universita.registraProfessore(professore2);

        // Creazione di corsi
        Corso corso1 = new Corso("Programmazione Java", "C123", 30);
        Corso corso2 = new Corso("Database", "C124", 25);

        // Aggiunta dei corsi all'università
        universita.aggiungiCorso(corso1);
        universita.aggiungiCorso(corso2);

        // Iscrizione di uno studente a un corso
        universita.iscriviStudenteACorso(studente1, corso1);
        universita.iscriviStudenteACorso(studente2, corso1);

        // Assegnazione di un professore a un corso
        universita.assegnaProfessoreACorso(professore1, corso1);
        universita.assegnaProfessoreACorso(professore2, corso2);

        // Stampare l'elenco degli studenti in un corso
        System.out.println("Studenti iscritti al corso di Programmazione Java:");
        for (Studente s : corso1.getStudenti()) {
            System.out.println(s.getNome() + " " + s.getCognome());
        }

        // Stampare l'elenco dei corsi insegnati da un professore
        System.out.println("Corsi insegnati da Giulia Verdi:");
        for (Corso c : professore1.getCorsiInsegnati()) {
            System.out.println(c.getTitolo());
        }
    }
}
