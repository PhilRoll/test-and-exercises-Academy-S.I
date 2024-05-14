package it.corso.esercizioNegozioAlimentare;

public class ProdottoAlimentare extends Prodotto {

	private String dataScadenza; 
	
	public ProdottoAlimentare(int codice, String descrizione, int quantitaDisponibile, double prezzoUnitario, String dataScadenza) {
		super(codice, descrizione, quantitaDisponibile, prezzoUnitario);
		this.dataScadenza =  dataScadenza;
	}

}
