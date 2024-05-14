package it.corso.gestionale.università;

import java.util.*;

/**
 * Rappresenta uno studente nel sistema universitario.
 */
public class Studente {
    private String nome;
    private String cognome;
    private final String matricola;
    private int annoImmatricolazione;
    private List<Corso> corsi;

    /**
     * Costruttore della classe Studente.
     * 
     * @param nome Il nome dello studente.
     * @param cognome Il cognome dello studente.
     * @param matricola La matricola dello studente.
     * @param annoImmatricolazione L'anno di immatricolazione dello studente.
     */
    public Studente(String nome, String cognome, String matricola, int annoImmatricolazione) {
        this.nome= nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.annoImmatricolazione = annoImmatricolazione;
        this.corsi = new ArrayList<>();
    }
    
    
    /**
     * Restituisce il nome dello studente.
     * 
     * @return Il nome studente.
     */
    public String getNome() {
		return nome;
	}

    /**
     * Setta il nome dello studente.
     * @param nome Il nome da impostare per lo studente.
     */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
    /**
     * Restituisce il cognome dello studente.
     * 
     * @return Il cognome studente.
     */
	public String getCognome() {
		return cognome;
	}

	
    /**
     * Setta il cognome dello studente.
     * @param cognome Il nome da impostare per lo studente.
     */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	

    /**
     * Restituisce la matricola dello studente.
     * 
     * @return La matricola dello studente.
     */
    public String getMatricola() {
        return matricola;
    }

    /**
     * Restituisce l'anno di immatricolazione dello studente.
     * 
     * @return L'anno di immatricolazione dello studente.
     */
    public int getAnnoImmatricolazione() {
        return annoImmatricolazione;
    }

    /**
     * Imposta l'anno di immatricolazione dello studente.
     * 
     * @param annoImmatricolazione L'anno di immatricolazione da impostare per lo studente.
     */
    public void setAnnoImmatricolazione(int annoImmatricolazione) {
        this.annoImmatricolazione = annoImmatricolazione;
    }

    /**
     * Restituisce la lista dei corsi a cui lo studente è iscritto.
     * 
     * @return La lista dei corsi a cui lo studente è iscritto.
     */
    public List<Corso> getCorsi() {
        return corsi;
    }

    /**
     * Imposta la lista dei corsi a cui lo studente è iscritto.
     * 
     * @param corsi La lista dei corsi a cui lo studente è iscritto.
     */
    public void setCorsi(ArrayList<Corso> corsi) {
        this.corsi = corsi;
    }
    
    /**
     * Aggiunge uno studente a un corso.
     * 
     * @param corso Il corso a cui aggiungere lo studente.
     */
    public void aggiungiCorso(Corso corso) {
        //se la lista non contiene già l'iscrizione al corso
        if (!this.corsi.contains(corso)) {
            this.corsi.add(corso);		//aggiunge corso alla lista corsi di studente
            corso.aggiungiStudente(this);	//aggiunge questo studente dalla lista studenti dell'oggetto corso
        }
    }

    /**
     * Rimuove uno studente da un corso.
     * 
     * @param corso Il corso da cui rimuovere lo studente.
     */
    public void rimuoviCorso(Corso corso) {
        //se la lista contiene il corso
        if (this.corsi.contains(corso)) {
            this.corsi.remove(corso);		//rimuove corso alla lista corsi di studente
            corso.rimuoviStudente(this);		//rimuove questo studente dalla lista studenti dell'oggetto corso
        }
    }
    
    
    /**
     * Restituisce una rappresentazione testuale dello studente.
     * 
     * @return Una stringa che rappresenta la persona nel formato "nome cognome".
     */
    @Override
    public String toString() {
        return nome + " " + cognome;
    }

}
