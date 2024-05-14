package corso.lezione04.esercizio04;

import java.util.Arrays;

public class FilmDVD extends Film{
	//Attributi di FilmDVD
	String[] lingueAudio;				//una "lista" di lingue audio
	String[] lingueSottotitoli;			//una "lista" di lingue sottotitoli
	boolean hasBonus;
	
	
	//costruttore che inizializza le dimensioni di lingueDVD e lingueSottotitoli
	public FilmDVD(String titolo, String nomeRegista, String lingua, int anno, String nazioneDiProduzione, int maxLingue, int maxSottotitoli, boolean hasBonus) {
		super(titolo, nomeRegista, lingua, anno, nazioneDiProduzione);
		this.lingueAudio = new String[maxLingue-1];
		this.lingueSottotitoli = new String[maxSottotitoli-1];
		this.hasBonus = hasBonus;
	}
	
	//costruttore che prende a parametro gli array lingueDVD e lingueSottotitoli
	public FilmDVD(String titolo, String nomeRegista, String lingua, int anno, String nazioneDiProduzione,String[] lingueDVD, String[] lingueSottotitoli, boolean hasBonus) {
		super(titolo, nomeRegista, lingua, anno, nazioneDiProduzione);
		this.lingueAudio = lingueDVD;
		this.lingueSottotitoli = lingueSottotitoli;
		this.hasBonus = hasBonus;
	}
	
	

	//metodi getter e setter
	
	public String[] getLingueAudio() {
		return lingueAudio;
	}


	public void setLingueAudio(String[] lingueDVD) {
		this.lingueAudio = lingueDVD;
	}
	
	public String[] getLingueSottotitoli() {
		return lingueSottotitoli;
	}

	public void setLingueSottotitoli(String[] lingueSottotitoli) {
		this.lingueSottotitoli = lingueSottotitoli;
	}
	
	public boolean hasBonus() {
		return hasBonus;
	}


	public void setHasBonus(boolean hasBonus) {
		this.hasBonus = hasBonus;
	}
	
	
	//metodo che aggiunge una lingua all'interno dell'array lingueAudio
	public void setLinguaDVD(String linguaDVD) {
		for(int i=0;i<this.lingueAudio.length;i++) {
			if(this.lingueAudio[i]==null) {
				this.lingueAudio[i]=linguaDVD;
				break;
			}
		}
	}
	
	
	//metodo che aggiunge la lingua per i sottotitoli all'interno dell'array lingueSottotitoli
	public void setLinguaSottotitoli(String linguaSottotitoli) {
		for(int i=0;i<this.lingueSottotitoli.length;i++) {
			if(this.lingueAudio[i]==null) {
				this.lingueAudio[i]=linguaSottotitoli;
				break;
			}
		}
	}


	@Override
	public String toString() {
		return super.toString()+"\nlingue Audio = " + Arrays.toString(lingueAudio) + "\nlingueSottotitoli = "
				+ Arrays.toString(lingueSottotitoli) + "\nBonus =" + hasBonus;
	}
	
	
	public boolean eq(Film f) {
		return f.getTitolo().equals(this.getTitolo()) &&
				f.getNomeRegista().equals(this.getNomeRegista()) &&
				f.getAnno()==this.getAnno() &&
				f.getNazioneDiProduzione().equals(this.getNazioneDiProduzione()) &&
				f.getLinguaOriginale().equals(this.getLinguaOriginale());
	}
	
	
	
	
	
	
	
}
