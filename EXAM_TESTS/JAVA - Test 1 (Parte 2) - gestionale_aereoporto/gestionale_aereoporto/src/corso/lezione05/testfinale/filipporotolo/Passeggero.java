package corso.lezione05.testfinale.filipporotolo;

public class Passeggero {
	//attributi
	private String nome;
	private String nazionalita;
	private String siglaVolo;
	private String postoAssegnato;
	private String tipoDiPasto;
	
	//costruttore
	public Passeggero(String nome, String nazionalita, String siglaVolo, String postoAssegnato, String tipoDiPasto) {
		super();
		this.nome = nome;
		this.nazionalita = nazionalita;
		this.siglaVolo = siglaVolo;
		this.postoAssegnato = postoAssegnato;
		this.tipoDiPasto = tipoDiPasto;
	}


	//getter e setter
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNazionalita() {
		return nazionalita;
	}


	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}


	public String getSiglaVolo() {
		return siglaVolo;
	}


	public void setSiglaVolo(String siglaVolo) {
		this.siglaVolo = siglaVolo;
	}


	public String getPostoAssegnato() {
		return postoAssegnato;
	}


	public void setPostoAssegnato(String postoAssegnato) {
		this.postoAssegnato = postoAssegnato;
	}


	public String getTipoDiPasto() {
		return tipoDiPasto;
	}


	public void setTipoDiPasto(String tipoDiPasto) {
		this.tipoDiPasto = tipoDiPasto;
	}
	
	
	//altri metodi
	public void cambiaPostoAssegnato(Passeggero passeggero) {
		String tmp = passeggero.getPostoAssegnato();
		passeggero.setPostoAssegnato(this.getPostoAssegnato());
		this.setPostoAssegnato(tmp);
	}
	
	
	
}
