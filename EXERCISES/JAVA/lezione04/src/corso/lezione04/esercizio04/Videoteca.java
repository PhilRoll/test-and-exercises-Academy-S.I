package corso.lezione04.esercizio04;

public class Videoteca {
	
	private String nomeVideoteca;
	private String indirizzo;
	private String nomeProprietario;
	private FilmDVD[] elencoFilm;


	public Videoteca(String nomeVideoteca, String indirizzo, String nomeProprietario, FilmDVD[] elencoFilm) {
		this.nomeVideoteca = nomeVideoteca;
		this.indirizzo = indirizzo;
		this.nomeProprietario = nomeProprietario;
		this.elencoFilm = elencoFilm;
	}
	
	
	public Videoteca(int maxFilm) {
		this.elencoFilm = new FilmDVD[maxFilm];
	}


	public String getNomeVideoteca() {
		return nomeVideoteca;
	}


	public void setNomeVideoteca(String nomeVideoteca) {
		this.nomeVideoteca = nomeVideoteca;
	}


	public String getIndirizzo() {
		return indirizzo;
	}


	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}


	public String getNomeProprietario() {
		return nomeProprietario;
	}


	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}


	public FilmDVD[] getElencoFilm() {
		return elencoFilm;
	}


	public void setElencoFilm(FilmDVD[] elencoFilm) {
		this.elencoFilm = elencoFilm;
	}
	
	
	
	public void setFilm(FilmDVD film) {
		for(int i=0; i<this.elencoFilm.length; i++) {
			if(this.elencoFilm[i]!=null) {
				continue;
			}
			else {
				this.elencoFilm[i]=film;
				break;
			}
		}
	}
	
	
	//metodo che cerca il titolo di un film all'interno dell'elenco di FilmDVD 
	//della videoteca. Restituisce true se lo trova 
	public boolean contienteFilm(Film f) {
		for(int i=0; i<this.elencoFilm.length; i++) {
			if(this.elencoFilm[i].getTitolo().equals(f.getTitolo())) {
				return true;
			}
		}
		return false;
	}
	
	
	//restituisce un array di stringhe contenenti i titoli dei film della videoteca
	public String[] getTitoliFilm() {
		int dim = this.elencoFilm.length;
		String[] elencoTitoli = new String[dim];
		for(int i=0;i<dim;i++) {
			elencoTitoli[i] = this.elencoFilm[i].getTitolo();
		}
		
		return elencoTitoli;
	}
	
	

}
