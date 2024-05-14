/**
 * Classe che rappresenta un contatto lavorativo.
 */
package corso.lezione06.esercizio02.elencotelefonico;

public class ContattoLavoro extends Contatto {
	
	/**
	 * Posizione lavorativa del contatto.
	 */
	private String posizioneLavorativa;

	/**
	 * Costruttore della classe.
	 * 
	 * @param nome Nome del contatto.
	 * @param numero Numero di telefono del contatto.
	 * @param etichetta Etichetta del contatto.
	 * @param posizioneLavorativa Posizione lavorativa del contatto.
	 */
	public ContattoLavoro(String nome, String numero, String etichetta, String posizioneLavorativa) {
		super(nome, numero, etichetta);
		this.posizioneLavorativa = posizioneLavorativa;
	}

	/**
	 * Restituisce la posizione lavorativa del contatto.
	 * 
	 * @return Posizione lavorativa del contatto.
	 */
	public String getPosizioneLavorativa() {
		return posizioneLavorativa;
	}

	/**
	 * Imposta la posizione lavorativa del contatto.
	 * 
	 * @param posizioneLavorativa Posizione lavorativa del contatto.
	 */
	public void setPosizioneLavorativa(String posizioneLavorativa) {
		this.posizioneLavorativa = posizioneLavorativa;
	}
	
	/**
	 * Stampa a video le informazioni del contatto.
	 */
	@Override
	public void stampaContatto() {
		System.out.println("Nome: "+this.getNome());
		System.out.println("Numero: "+this.getNumero());
		System.out.println("Posizione Lavorativa: "+this.getPosizioneLavorativa());
		System.out.println("Etichetta: "+this.getEtichetta());
	}
	
}
