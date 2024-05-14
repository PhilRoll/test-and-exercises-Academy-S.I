package corso.lezione05.testfinale.filipporotolo;

public class Volo {
	//attributi
	private String sigla;
	private Aereoporto aereoportoDiPartenza;
	private Aereoporto aereoportoDiDestinazione;
	private String aereomobile;
	private Passeggero[] passeggeri;
	

	
	//costruttori
	
	//costruttore che setta il numero massimo di passeggeri
	public Volo(String sigla, Aereoporto aereoportoDiPartenza, Aereoporto aereoportoDiDestinazione,
			String aereomobile, int maxPasseggeri) {
		this.sigla = sigla;
		this.aereoportoDiPartenza = aereoportoDiPartenza;
		this.aereoportoDiDestinazione = aereoportoDiDestinazione;
		this.aereomobile = aereomobile;
		this.passeggeri = new Passeggero[maxPasseggeri];
	}

	
	
	//getter e setter
	public String getSigla() {
		return sigla;
	}
	

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public Aereoporto getAereoportoDiPartenza() {
		return aereoportoDiPartenza;
	}
	
	public void setAereoportoDiPartenza(Aereoporto aereoportoDiPartenza) {
		this.aereoportoDiPartenza = aereoportoDiPartenza;
	}
	
	public Aereoporto getAereoportoDiDestinazione() {
		return aereoportoDiDestinazione;
	}
	
	public void setAereoportoDiDestinazione(Aereoporto aereoportoDiDestinazione) {
		this.aereoportoDiDestinazione = aereoportoDiDestinazione;
	}
	
	public String getAereomobile() {
		return aereomobile;
	}
	
	public void setAereomobile(String aereomobile) {
		this.aereomobile = aereomobile;
	}
	
	public Passeggero[] getPasseggeri() {
		return passeggeri;
	}
	
	public void setPasseggeri(Passeggero[] passeggeri) {
		this.passeggeri = passeggeri;
	}
	
	
	//altri metodi
	
	//metodo che aggiunge un passeggero 
	public void aggiungiPasseggero(Passeggero passeggero) {
		for(int i=0; i<this.passeggeri.length; i++) {
			if(passeggeri[i]!=null) {
				continue;
			}
			passeggeri[i]= passeggero;
			break;	
		}
	}


	//metodo di stampa info volo (ES Volo AZ108 Roma Fiumicino - Londra Heathrow;
	public String descrizioneVolo() {
		return "Volo " + this.getSigla() + " " + 
				this.getAereoportoDiPartenza().getCitta() + " " +
				this.getAereoportoDiPartenza().getNome() + " - " + 
				this.getAereoportoDiDestinazione().getCitta() + " " +
				this.getAereoportoDiDestinazione().getNome();
	}
	
	//metodo che restituisce l'elenco di nomi dei passeggeri
	public String[] getNomiPasseggeri() {
		int dim = this.passeggeri.length;
		String[] elencoNomi = new String[dim];
		
		for(int i=0; i<dim; i++) {
			elencoNomi[i]= passeggeri[i].getNome();
		}
		
		return elencoNomi;
	}
	
	
	//metodo che restituisce l'elenco di nomi dei passeggeri
	public String[] getPostiPasseggeriVegetariani() {
		int dim = this.passeggeri.length;
		int j=0;
		String[] elencoNomi = new String[dim];
		
		for(int i=0; i<dim; i++) {
			if(passeggeri[i].getTipoDiPasto().equals("vegetariano")){
				elencoNomi[j]= passeggeri[i].getPostoAssegnato();
				j++;
			}
			
		}
		
		return elencoNomi;
	}
	
	
	
}
	
