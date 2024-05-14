package it.corso.esercizioelencotelefonico;

public class ContattoPersonale extends Contatto {
	
	private String indirizzoCasa;

	public ContattoPersonale(String nome, String numeroTelefono, String indirizzoCasa) {
		super(nome, numeroTelefono);
		this.indirizzoCasa = indirizzoCasa;
	}

	public String getIndirizzoCasa() {
		return indirizzoCasa;
	}

	public void setIndirizzoCasa(String indirizzoCasa) {
		this.indirizzoCasa = indirizzoCasa;
	}

	
	

}
