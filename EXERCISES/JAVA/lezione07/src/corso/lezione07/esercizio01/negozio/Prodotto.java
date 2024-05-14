package corso.lezione07.esercizio01.negozio;

public abstract class Prodotto {
	private static int counter=0;
	private int id;
	private String descrizione;
	private int quantita;
	private double prezzo;
	
	
	public Prodotto(String descrizione, int quantita, double prezzo) {
		this.id=counter++;
		this.descrizione = descrizione;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public int getQuantita() {
		return quantita;
	}


	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}


	public double getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}


	public int getId() {
		return id;
	}
	
	
	public abstract void stampaInfo();
	
	
}
