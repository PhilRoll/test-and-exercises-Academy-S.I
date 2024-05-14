package it.corso.esercizioelencotelefonico;

public class ContattoLavoro extends Contatto{ 
	
	private String posizioneLavorativa;

	
	public ContattoLavoro(String nome, String numeroTelefono, String posizioneLavorativa) {
		super(nome, numeroTelefono);
		this.posizioneLavorativa = posizioneLavorativa;
	}


	public String getPosizioneLavorativa() {
		return posizioneLavorativa;
	}


	public void setPosizioneLavorativa(String posizioneLavorativa) {
		this.posizioneLavorativa = posizioneLavorativa;
	}
	
	

	

	
}
