/**
 * @author Filippo Rotolo
 * @version 1.0 03/04/2024
 * Classe astratta che rappresenta una prenotazione generica.
 *
 * Questa classe fornisce gli attributi e i metodi comuni a tutte le tipologie di prenotazione.
 * Le sottoclassi specifiche dovranno implementare il metodo astratto `stampaPrenotazione()`.
 */
package corso.lezione06.esercizio01.cinema;

import java.util.*;

public abstract class Prenotazione {

    /**
     * Contatore statico per assegnare un identificativo univoco ad ogni prenotazione.
     */
    private static int counter = 0;

    /**
     * Identificativo univoco della prenotazione.
     */
    private int id;

    /**
     * Nome del cliente che ha effettuato la prenotazione.
     */
    private String nomeCliente;

    /**
     * Data in cui è stata effettuata la prenotazione.
     */
    private Date dataPrenotazione;

    /**
     * Costruttore della classe Prenotazione.
     *
     * Assegna un identificativo univoco alla prenotazione e setta i valori degli attributi nomeCliente e dataPrenotazione.
     *
     * @param nomeCliente Nome del cliente che ha effettuato la prenotazione.
     * @param dataPrenotazione Data in cui è stata effettuata la prenotazione.
     */
    public Prenotazione(String nomeCliente, Date dataPrenotazione) {
        this.id = counter++;
        this.nomeCliente = nomeCliente;
        this.dataPrenotazione = dataPrenotazione;
    }

    /**
     * Restituisce l'identificativo della prenotazione.
     *
     * @return L'identificativo univoco della prenotazione.
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta l'identificativo della prenotazione.
     *
     * @param id Nuovo identificativo della prenotazione.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce il nome del cliente associato alla prenotazione.
     *
     * @return Il nome del cliente.
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Imposta il nome del cliente associato alla prenotazione.
     *
     * @param nomeCliente Nuovo nome del cliente.
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * Restituisce la data in cui è stata effettuata la prenotazione.
     *
     * @return La data della prenotazione.
     */
    public Date getDataPrenotazione() {
        return dataPrenotazione;
    }

    /**
     * Imposta la data in cui è stata effettuata la prenotazione.
     *
     * @param dataPrenotazione Nuova data della prenotazione.
     */
    public void setDataPrenotazione(Date dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    /**
     * Metodo astratto che deve essere implementato dalle sottoclassi per stampare le informazioni della prenotazione
     * in un formato specifico.
     */
    public abstract void stampaPrenotazione();
}
