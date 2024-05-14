package corso.lezione07.esercizio01.negozio;

import java.util.*;

public class ProdottoAlimentare extends Prodotto {
	
	private Date scadenza;

	public ProdottoAlimentare(String descrizione, int quantita, double prezzo, Date scadenza) {
		super(descrizione, quantita, prezzo);
		this.scadenza = scadenza;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	@Override
	public void stampaInfo() {
		System.out.println("ID :"+this.getId());
		System.out.println("Descrizione :"+this.getDescrizione());
		System.out.println("Prezzo :"+this.getPrezzo());
		System.out.println("Scadenza :"+this.scadenza);
		System.out.println("Quantità :"+this.getQuantita());
	}


	
	
}
