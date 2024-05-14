package corso.lezione05.testfinale.filipporotolo;

public class VoloNonDiretto extends Volo{
	//attributi di VoloNonDiretto
	private Aereoporto[] scali;
	private int numScali;
	
	//costruttore che inizializza il numero massimo di scali
	public VoloNonDiretto(String sigla, Aereoporto aereoportoDiPartenza, Aereoporto aereoportoDiDestinazione,
			String aereomobile, int maxPasseggeri, int numScali) {
		
		super(sigla, aereoportoDiPartenza, aereoportoDiDestinazione, aereomobile, maxPasseggeri);
		this.numScali = numScali;
		this.scali=new Aereoporto[numScali];;
	}
	
	
	//metodi getter e setter
	public Aereoporto[] getScali() {
		return scali;
	}


	public void setScali(Aereoporto[] scali) {
		this.scali = scali;
	}


	public int getNumScali() {
		return numScali;
	}


	public void setNumScali(int numScali) {
		this.numScali = numScali;
	}


	//altri metodi
	public void setScaloIntermedio(Aereoporto scalo) {
		int dim = this.scali.length;
		for(int i=0; i<dim; i++){
			if(this.scali[i]!=null) {
				continue;
			}
			this.scali[i]= scalo;
			break;
		}
		this.setScali(scali);
	}

	
	@Override
	public String descrizioneVolo(){
		StringBuilder tmp = new StringBuilder("Volo "+this.getSigla()+" "+
												this.getAereoportoDiPartenza().getCitta()+
												this.getAereoportoDiPartenza().getNome()+" ");
		for(int i=0; i<this.scali.length; i++){
			tmp.append(this.scali[i].getCitta()+" "+this.scali[i].getNome()+" - ");
		}
		tmp.append(this.getAereoportoDiDestinazione().getCitta()+" "+ 
					this.getAereoportoDiDestinazione().getNome());
		return tmp.toString();
	}
}
