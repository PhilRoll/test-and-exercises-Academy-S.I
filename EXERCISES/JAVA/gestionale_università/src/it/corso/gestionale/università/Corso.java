package it.corso.gestionale.università;

import java.util.*;

/**
 * Rappresenta un corso all'interno del sistema universitario.
 */
public class Corso {
    
    private String nomeCorso;
    private String idCorso;
    private Professore professore;
    private List<Studente> listaStudenti;
    private int maxStudenti;
    
    /**
     * Costruttore della classe Corso.
     * 
     * @param nomeCorso Il nome del corso.
     * @param idCorso L'identificativo del corso.
     * @param maxStudenti Il numero massimo di studenti che possono iscriversi al corso.
     */
    public Corso(String nomeCorso, String idCorso, int maxStudenti) {
        this.nomeCorso = nomeCorso;
        this.idCorso = idCorso;
        this.listaStudenti = new ArrayList<>();
        this.maxStudenti = maxStudenti;
    }

    /**
     * Restituisce il nome del corso.
     * 
     * @return Il nome del corso.
     */
    public String getNomeCorso() {
        return nomeCorso;
    }

    /**
     * Imposta il nome del corso.
     * 
     * @param nomeCorso Il nome del corso da impostare.
     */
    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    /**
     * Restituisce l'identificativo del corso.
     * 
     * @return L'identificativo del corso.
     */
    public String getIdCorso() {
        return idCorso;
    }

    /**
     * Imposta l'identificativo del corso.
     * 
     * @param idCorso L'identificativo del corso da impostare.
     */
    public void setIdCorso(String idCorso) {
        this.idCorso = idCorso;
    }

    /**
     * Restituisce il professore titolare del corso.
     * 
     * @return Il professore titolare del corso.
     */
    public Professore getProfessore() {
        return professore;
    }
    
    
    /**
     * Rimuove il riferimento all'attributo Professore (setta a null).
     * 
     */
	public void rimuoviProfessore() {
		this.professore = null;
	}

    /**
     * Restituisce la lista degli studenti iscritti al corso.
     * 
     * @return La lista degli studenti iscritti al corso.
     */
    public List<Studente> getListaStudenti() {
        return listaStudenti;
    }

    /**
     * Imposta la lista degli studenti iscritti al corso.
     * 
     * @param listaStudenti La lista degli studenti da impostare per il corso.
     */
    public void setListaStudenti(ArrayList<Studente> listaStudenti) {
        if (listaStudenti.size() <= this.maxStudenti) {
            this.listaStudenti = listaStudenti;
        }
    }

    /**
     * Restituisce il numero massimo di studenti che possono iscriversi al corso.
     * 
     * @return Il numero massimo di studenti che possono iscriversi al corso.
     */
    public int getMaxStudenti() {
        return maxStudenti;
    }

    /**
     * Imposta il numero massimo di studenti che possono iscriversi al corso.
     * 
     * @param maxStudenti Il numero massimo di studenti da impostare per il corso.
     */
    public void setMaxStudenti(int maxStudenti) {
        this.maxStudenti = maxStudenti;
    }
    
    /**
     * Aggiunge uno studente alla lista degli studenti iscritti al corso.
     * 
     * @param studente Lo studente da aggiungere.
     */
    public void aggiungiStudente(Studente studente) {
        // se il corso raggiunge il numero massimo di studenti:
        if (this.listaStudenti.size()<this.maxStudenti && !this.listaStudenti.contains(studente) ) {
        	this.listaStudenti.add(studente);
        }  
    }
    
    /**
     * Rimuove uno studente dalla lista degli studenti iscritti al corso.
     * 
     * @param studente Lo studente da rimuovere.
     */
    public void rimuoviStudente(Studente studente) {
        // se la lista NON è vuota e contiene lo studente
        if (!this.listaStudenti.isEmpty() && this.listaStudenti.contains(studente)) {
            this.listaStudenti.remove(studente);
        }
    }
    
    /**
     * Imposta il professore titolare del corso.
     * 
     * @param professoreTitolare Il professore titolare da impostare per il corso.
     */
    public void setProfessoreTitolare(Professore professoreTitolare) {
        this.professore = professoreTitolare;
    }

    /**
     * Restituisce una rappresentazione testuale del corso.
     * 
     * @return Una stringa che rappresenta il corso con il nome, l'identificativo, il professore titolare e la lista degli studenti iscritti.
     */
    @Override
    public String toString() {
        return "Corso=" + nomeCorso + "\nidCorso=" + idCorso + 
                "\nprofessoreTitolare=" + professore.getNome() +
                " " + professore.getCognome() +
                "\nstudenti=[" + listaStudenti.toString() + 
                "]\n(maxStudenti=" + maxStudenti + ")";
    }
}
