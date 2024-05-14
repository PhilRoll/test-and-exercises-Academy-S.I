/**
 * @author Filippo Rotolo
 * @version 1.0 03/04/2024
 * 
 * Classe concreta che rappresenta una prenotazione singola.
 *
 * Questa classe eredita dalla classe astratta `Prenotazione` e aggiunge l'attributo `numPosto` per specificare il numero di posti prenotati.
 */
package corso.lezione06.esercizio01.cinema;

import java.util.*;

public class PrenotazioneSingola extends Prenotazione{

    /**
     * Numero di posti prenotati.
     */
    private int numPosto;


    /**
     * Costruttore della classe PrenotazioneSingola.
     *
     * Invoca il costruttore della classe padre `Prenotazione` e setta il valore dell'attributo `numPosto`.
     *
     * @param nomeCliente Nome del cliente che ha effettuato la prenotazione.
     * @param dataPrenotazione Data in cui è stata effettuata la prenotazione.
     * @param numPosto Numero di posti prenotati.
     */
    public PrenotazioneSingola(String nomeCliente, Date dataPrenotazione, int numPosto) {
        super(nomeCliente, dataPrenotazione);
        this.numPosto = numPosto;
    }


    /**
     * Restituisce il numero di posti prenotati.
     *
     * @return Il numero di posti prenotati.
     */
    public int getNumPosto() {
        return numPosto;
    }


    /**
     * Imposta il numero di posti prenotati.
     *
     * @param numPosto Nuovo numero di posti prenotati.
     */
    public void setNumPosto(int numPosto) {
        this.numPosto = numPosto;
    }


    /**
     * Stampa le informazioni della prenotazione singola, specificando ID Prenotazione, Data, Nome e N. Posto prenotato.
     *
     * Sovrascrive il metodo astratto `stampaPrenotazione()` della classe padre.
     */
    @Override
    public void stampaPrenotazione() {
        System.out.println("ID Prenotazione: " + this.getId());
        System.out.println("Data: " + this.getDataPrenotazione());
        System.out.println("Nome: " + this.getNomeCliente());
        System.out.println("N. Posto prenotato: " + this.getNumPosto());
    }
}
