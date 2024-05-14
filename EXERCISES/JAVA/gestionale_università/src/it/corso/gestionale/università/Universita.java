package it.corso.gestionale.università;

import java.util.*;

/**
 * Rappresenta un'istituzione universitaria.
 */
public class Universita {
    
    private List<Studente> studenti;
    private List<Professore> professori;
    private List<Corso> corsi;
    
    /**
     * Costruttore della classe Universita.
     */
    public Universita() {
        studenti = new ArrayList<>();
        professori = new ArrayList<>();
        corsi = new ArrayList<>();
    }
    
    /**
     * Restituisce la lista degli studenti registrati all'università.
     * 
     * @return La lista degli studenti registrati all'università.
     */
    public List<Studente> getStudenti() {
        return studenti;
    }
    
    /**
     * Imposta la lista degli studenti registrati all'università.
     * 
     * @param studenti La lista degli studenti da impostare per l'università.
     */
    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }
    
    /**
     * Restituisce la lista dei professori registrati all'università.
     * 
     * @return La lista dei professori registrati all'università.
     */
    public List<Professore> getProfessori() {
        return professori;
    }
    
    /**
     * Imposta la lista dei professori registrati all'università.
     * 
     * @param professori La lista dei professori da impostare per l'università.
     */
    public void setProfessori(List<Professore> professori) {
        this.professori = professori;
    }
    
    /**
     * Restituisce la lista dei corsi disponibili all'università.
     * 
     * @return La lista dei corsi disponibili all'università.
     */
    public List<Corso> getCorsi() {
        return corsi;
    }
    
    /**
     * Imposta la lista dei corsi disponibili all'università.
     * 
     * @param corsi La lista dei corsi da impostare per l'università.
     */
    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }
    
    /**
     * Registra uno studente all'università.
     * 
     * @param studente Lo studente da registrare.
     */
    public void registraStudente(Studente studente) {
        if (!this.studenti.contains(studente)) {
            this.studenti.add(studente);
        }
    }
    
    /**
     * Registra un professore all'università.
     * 
     * @param professore Il professore da registrare.
     */
    public void registraProfessore(Professore professore) {
        if (!this.professori.contains(professore)) {
            this.professori.add(professore);
        }
    }
    
    /**
     * Crea un nuovo corso all'università.
     * 
     * @param corso Il corso da creare.
     */
    public void creaCorso(Corso corso) {
        if (!this.corsi.contains(corso)) {
            this.corsi.add(corso);
        }
    }
    
    /**
     * Assegna un professore a un corso all'università.
     * 
     * @param professore Il professore da assegnare.
     * @param corso Il corso a cui assegnare il professore.
     */
    public void assegnaProfessoreACorso(Professore professore, Corso corso) {
        if (this.professori.contains(professore) && this.corsi.contains(corso) && corso.getProfessore()==null) {
            corso.setProfessoreTitolare(professore);
            professore.aggiungiCorso(corso);
        }
    }
    
    /**
     * Assegna uno studente a un corso all'università.
     * 
     * @param studente Lo studente da assegnare.
     * @param corso Il corso a cui assegnare lo studente.
     */
    public void iscriviStudenteACorso(Studente studente, Corso corso) {
        if (this.studenti.contains(studente) && this.corsi.contains(corso) && corso.getListaStudenti().size() < corso.getMaxStudenti()) {
            corso.aggiungiStudente(studente);
            studente.aggiungiCorso(corso);
        }
    }
}
