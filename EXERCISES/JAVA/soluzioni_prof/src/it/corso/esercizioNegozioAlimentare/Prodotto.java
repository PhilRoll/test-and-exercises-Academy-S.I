package it.corso.esercizioNegozioAlimentare;

public class Prodotto {

	
	 private int codice;
	 private String descrizione;
	 private int quantitaDisponibile;
	 private double prezzoUnitario;

	 public Prodotto(int codice, String descrizione, int quantitaDisponibile, double prezzoUnitario) {
		 this.codice = codice;
	     this.descrizione = descrizione;
	     this.quantitaDisponibile = quantitaDisponibile;
	     this.prezzoUnitario = prezzoUnitario;
	 }
	 
	 

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}
	 
	 

	
}
