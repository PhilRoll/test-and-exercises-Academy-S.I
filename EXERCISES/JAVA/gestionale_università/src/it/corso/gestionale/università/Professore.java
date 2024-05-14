package it.corso.gestionale.università;

import java.util.*;

/**
 * Rappresenta un professore nel sistema universitario.
 */
public class Professore {
    
    private String nome;
    private String cognome;
    private final String idDocente;
    private List<Corso> corsi;
    
    /**
     * Costruttore della classe Professore.
     * 
     * @param nome Il nome del professore.
     * @param cognome Il cognome del professore.
     * @param idDocente L'identificativo del professore.
     */
    public Professore(String nome, String cognome, String idDocente) {
    	this.nome = nome;
        this.cognome = cognome;
        this.idDocente = idDocente;
        this.corsi = new ArrayList<>();
    }

    

    /**
     * Restituisce il nome del Professore.
     * 
     * @return Il nome Professore.
     */
    public String getNome() {
		return nome;
	}

    /**
     * Setta il nome del Professore.
     * @param nome Il nome da impostare per il professore.
     */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
    /**
     * Restituisce il cognome del professore.
     * 
     * @return Il cognome del professore.
     */
	public String getCognome() {
		return cognome;
	}

	
    /**
     * Setta il cognome del professore.
     * @param cognome Il nome da impostare per il professore.
     */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
    
    /**
     * Restituisce la lista dei corsi tenuti dal professore.
     * 
     * @return La lista dei corsi tenuti dal professore.
     */
    public List<Corso> getCorsi() {
        return corsi;
    }

    /**
     * Imposta la lista dei corsi tenuti dal professore.
     * 
     * @param corsi La lista dei corsi da impostare per il professore.
     */
    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }

    /**
     * Restituisce l'identificativo del professore.
     * 
     * @return L'identificativo del professore.
     */
    public String getIdDocente() {
        return idDocente;
    }
    
    /**
     * Aggiunge un corso alla lista dei corsi tenuti dal professore.
     * 
     * @param corso Il corso da aggiungere.
     */
    public void aggiungiCorso(Corso corso) {
        // se la lista non contiene già il corso
        if (!this.corsi.contains(corso)) {
            this.corsi.add(corso);				//aggiunge corso alla lista corsi di professore
            corso.setProfessoreTitolare(this);	//setta questo professore come attributo "professore" dell'oggetto corso
        }
    }
    
    /**
     * Rimuove un corso dalla lista dei corsi tenuti dal professore.
     * 
     * @param corso Il corso da rimuovere.
     */
    public void rimuoviCorso(Corso corso) {
        // se la lista contiene il corso
        if (this.corsi.contains(corso)) {
            this.corsi.remove(corso);	//rimuove corso alla lista corsi di professore
            corso.rimuoviProfessore();	//metodo che setta a null il riferimento "professore" dell'oggetto corso
        }
    }
    
    
    /**
     * Restituisce una rappresentazione testuale del professore.
     * 
     * @return Una stringa che rappresenta la persona nel formato "nome cognome".
     */
    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}