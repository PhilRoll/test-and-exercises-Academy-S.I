package it.corso.esercizioGestionaleUniversita;



import java.util.ArrayList;
import java.util.List;

public class Corso {

    private String titolo;
    private String codice;
    private Professore professore;
    private List<Studente> studenti;
    private int maxStudenti;

    public Corso(String titolo, String codice, int maxStudenti) {
        this.titolo = titolo;
        this.codice = codice;
        this.maxStudenti = maxStudenti;
        this.studenti = new ArrayList<>();
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Professore getProfessore() {
        return professore;
    }
    // Setter per il professore, si assuma che un corso possa avere solo un professore alla volta
    public void setProfessore(Professore professore) {
        this.professore = professore;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    public int getMaxStudenti() {
        return maxStudenti;
    }

    public void setMaxStudenti(int maxStudenti) {
        this.maxStudenti = maxStudenti;
    }



    public void iscriviStudente(Studente studente) {
        if (studenti.size() < maxStudenti && !studenti.contains(studente)) {
            studenti.add(studente);
        }
    }

    // Metodo per rimuovere uno studente dal corso
    public void rimuoviStudente(Studente studente) {
        studenti.remove(studente);
    }


    // Metodo per rimuovere il professore dal corso
    public void rimuoviProfessore() {
        this.professore = null;
    }
}

