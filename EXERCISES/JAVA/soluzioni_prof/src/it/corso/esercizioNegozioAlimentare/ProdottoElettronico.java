package it.corso.esercizioNegozioAlimentare;

public class ProdottoElettronico  extends Prodotto {

	private int garanziaMesi;
	
	public ProdottoElettronico(int codice, String descrizione, int quantitaDisponibile, double prezzoUnitario, int garanziaMesi) {
		super(codice, descrizione, quantitaDisponibile, prezzoUnitario);
		this.garanziaMesi = garanziaMesi;
	}

	public int getGaranziaMesi() {
		return garanziaMesi;
	}

	public void setGaranziaMesi(int garanziaMesi) {
		this.garanziaMesi = garanziaMesi;
	}

	
	
}
