package it.corso.esercizioGestionaleUniversita;

import java.util.List;
import java.util.*;

public class Studente {

    private String nome;
    private String cognome;
    private String matricola;
    private List<Corso> corsi;

    public Studente(String nome, String cognome, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.corsi = new ArrayList<>();
    }

    // Getter e Setter qui
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public List<Corso> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }


    public void iscriviACorso(Corso corso) {
        if (!corsi.contains(corso)) {
            corsi.add(corso);
            corso.iscriviStudente(this);
        }
    }

    // Metodi per iscriversi e rimuovere l'iscrizione da un corso
    public void rimuoviDaCorso(Corso corso) {
        if (corsi.contains(corso)) {
            corsi.remove(corso);
            corso.rimuoviStudente(this);
        }
    }

}
