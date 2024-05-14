package corso.lezione07.esercizio01.negozio;

public class ProdottoElettronico extends Prodotto{

	private int mesiGaranzia;

	public ProdottoElettronico(String descrizione, int quantita, double prezzo, int mesiGaranzia) {
		super(descrizione, quantita, prezzo);
		this.mesiGaranzia = mesiGaranzia;
	}

	public int getMesiGaranzia() {
		return mesiGaranzia;
	}

	public void setMesiGaranzia(int mesiGaranzia) {
		this.mesiGaranzia = mesiGaranzia;
	}

	
	@Override
	public void stampaInfo() {
		System.out.println("ID :"+this.getId());
		System.out.println("Descrizione :"+this.getDescrizione());
		System.out.println("Prezzo :"+this.getPrezzo());
		System.out.println("Mesi garanzia :"+this.mesiGaranzia);
		System.out.println("Quantità :"+this.getQuantita());
	}
	
}
