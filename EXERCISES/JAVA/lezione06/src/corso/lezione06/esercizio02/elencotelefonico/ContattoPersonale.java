/**
 * Classe che rappresenta un contatto personale.
 */
package corso.lezione06.esercizio02.elencotelefonico;

public class ContattoPersonale extends Contatto{
	
	/**
	 * Indirizzo del contatto.
	 */
	private String indirizzo;


	/**
	 * Costruttore della classe.
	 * 
	 * @param nome Nome del contatto.
	 * @param numero Numero di telefono del contatto.
	 * @param etichetta Etichetta del contatto.
	 * @param indirizzo Indirizzo del contatto.
	 */
	public ContattoPersonale(String nome, String numero, String etichetta,String indirizzo) {
		super(nome, numero, etichetta);
		this.indirizzo = indirizzo;
	}

	/**
	 * Restituisce l'indirizzo del contatto.
	 * 
	 * @return Indirizzo del contatto.
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Imposta l'indirizzo del contatto.
	 * 
	 * @param indirizzo Indirizzo del contatto.
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Stampa a video le informazioni del contatto.
	 */
	@Override
	public void stampaContatto() {
		System.out.println("Nome: "+this.getNome());
		System.out.println("Numero: "+this.getNumero());
		System.out.println("Indirizzo: "+this.getIndirizzo());
		System.out.println("Etichetta: "+this.getEtichetta());
	}
	
	
}
