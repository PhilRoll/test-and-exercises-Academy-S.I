package it.corso.esercizioGestionaleUniversita;

import java.util.ArrayList;
import java.util.List;

public class Professore {

    private String nome;
    private String cognome;
    private String id;
    private List<Corso> corsiInsegnati;

    public Professore(String nome, String cognome, String id) {
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.corsiInsegnati = new ArrayList<>();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Corso> getCorsiInsegnati() {
        return corsiInsegnati;
    }

    public void setCorsiInsegnati(List<Corso> corsiInsegnati) {
        this.corsiInsegnati = corsiInsegnati;
    }

    public void aggiungiCorsoInsegnato(Corso corso) {
        if (!corsiInsegnati.contains(corso)) {
            corsiInsegnati.add(corso);
            corso.setProfessore(this);
        }
    }

    // Metodo per rimuovere un corso dall'insegnamento
    public void rimuoviCorsoInsegnato(Corso corso) {
        if (corsiInsegnati.contains(corso)) {
            corsiInsegnati.remove(corso);
            corso.rimuoviProfessore(); 
        }
    }

}

