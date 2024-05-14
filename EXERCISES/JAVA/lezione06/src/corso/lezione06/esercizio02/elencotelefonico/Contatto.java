package corso.lezione06.esercizio02.elencotelefonico;

/**
 * Classe astratta che rappresenta un contatto generico in un elenco telefonico.
 * 
 * @author Filippo Rotolo
 * @version 1.0
 */
public abstract class Contatto {

	/**
	 * Nome del contatto.
	 */
	private String nome;

	/**
	 * Numero di telefono del contatto.
	 */
	private String numero;

	/**
	 * Etichetta associata al contatto.
	 */
	private String etichetta;

	/**
	 * Costruttore che inizializza i dati del contatto.
	 * 
	 * @param nome Il nome del contatto.
	 * @param numero Il numero di telefono del contatto.
	 * @param etichetta L'etichetta associata al contatto.
	 */
	public Contatto(String nome, String numero, String etichetta) {
		this.nome = nome;
		this.numero = numero;
		this.etichetta = etichetta;
	}

	/**
	 * Restituisce il nome del contatto.
	 * 
	 * @return Il nome del contatto.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome del contatto.
	 * 
	 * @param nome Il nuovo nome del contatto.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce il numero di telefono del contatto.
	 * 
	 * @return Il numero di telefono del contatto.
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Imposta il numero di telefono del contatto.
	 * 
	 * @param numero Il nuovo numero di telefono del contatto.
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Restituisce l'etichetta associata al contatto.
	 * 
	 * @return L'etichetta associata al contatto.
	 */
	public String getEtichetta() {
		return etichetta;
	}

	/**
	 * Imposta l'etichetta associata al contatto.
	 * 
	 * @param etichetta La nuova etichetta del contatto.
	 */
	public void setEtichetta(String etichetta) {
		this.etichetta = etichetta;
	}

	/**
	 * Stampa a video le informazioni del contatto.
	 * 
	 * Questo metodo è astratto e deve essere implementato nelle classi concrete che 
	 * estendono questa classe.
	 */
	public abstract void stampaContatto();

}
