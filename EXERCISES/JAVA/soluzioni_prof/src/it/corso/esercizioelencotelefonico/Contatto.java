package it.corso.esercizioelencotelefonico;

public class Contatto {
	
	private String nome;
	private String numeroTelefono;
	
	public Contatto(String nome, String numeroTelefono) {
		super();
		this.nome = nome;
		this.numeroTelefono = numeroTelefono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	
	
	

}
