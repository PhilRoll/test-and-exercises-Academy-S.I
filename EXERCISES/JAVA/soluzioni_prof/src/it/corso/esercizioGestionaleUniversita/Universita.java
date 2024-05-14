package it.corso.esercizioGestionaleUniversita;


import java.util.ArrayList;
import java.util.List;

public class Universita {

    private List<Studente> studenti;
    private List<Professore> professori;
    private List<Corso> corsi;

    public Universita() {
        this.studenti = new ArrayList<>();
        this.professori = new ArrayList<>();
        this.corsi = new ArrayList<>();
    }

    // Metodo per registrare un nuovo studente
    public void registraStudente(Studente studente) {
        if (!studenti.contains(studente)) {
            studenti.add(studente);
        }
    }

    // Metodo per registrare un nuovo professore
    public void registraProfessore(Professore professore) {
        if (!professori.contains(professore)) {
            professori.add(professore);
        }
    }

    // Metodo per aggiungere un nuovo corso
    public void aggiungiCorso(Corso corso) {
        if (!corsi.contains(corso)) {
            corsi.add(corso);
        }
    }

    // Metodo per iscrivere uno studente a un corso
    public void iscriviStudenteACorso(Studente studente, Corso corso) {
        if (studenti.contains(studente) && corsi.contains(corso) && corso.getStudenti().size() < corso.getMaxStudenti()) {
            studente.iscriviACorso(corso);
        }
        // Considerare l'aggiunta di gestione delle eccezioni qui per gestire casi in cui lo studente o il corso non esistano, o il corso sia pieno.
    }

    // Metodo per assegnare un professore a un corso
    public void assegnaProfessoreACorso(Professore professore, Corso corso) {
        if (professori.contains(professore) && corsi.contains(corso) && corso.getProfessore() == null) {
            corso.setProfessore(professore);
            professore.aggiungiCorsoInsegnato(corso);
        }
        // Anche qui, considerare la gestione delle eccezioni per casi di errore.
    }

}

