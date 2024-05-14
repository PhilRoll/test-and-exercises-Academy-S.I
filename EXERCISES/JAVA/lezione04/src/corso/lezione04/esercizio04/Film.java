package corso.lezione04.esercizio04;

public class Film {
	
	//attributi
	private String titolo;
	private String nomeRegista;
	private String linguaOriginale;
	private int anno;
	private String nazioneDiProduzione;
	
	//costruttore che prende a parametro tutti gli attributi della classe Film
	public Film(String titolo, String nomeRegista, String lingua, int anno, String nazioneDiProduzione) {
		this.titolo = titolo;
		this.nomeRegista = nomeRegista;
		this.linguaOriginale = lingua;
		this.anno = anno;
		this.nazioneDiProduzione = nazioneDiProduzione;
	}

	//metodi getter e setter
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getNomeRegista() {
		return nomeRegista;
	}

	public void setNomeRegista(String nomeRegista) {
		this.nomeRegista = nomeRegista;
	}

	public String getLinguaOriginale() {
		return linguaOriginale;
	}

	public void setLinguaOriginale(String lingua) {
		this.linguaOriginale = lingua;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getNazioneDiProduzione() {
		return nazioneDiProduzione;
	}

	public void setNazioneDiProduzione(String nazioneDiProduzione) {
		this.nazioneDiProduzione = nazioneDiProduzione;
	}

	@Override
	public String toString() {
		return "titolo = " + titolo + "\nRegista = " + 
				nomeRegista + "\nLingua originale = " + 
				linguaOriginale + "\nanno = " + anno + 
				"\nNazione di produzione = " + nazioneDiProduzione;
	}
	
	
	
	
	
}
