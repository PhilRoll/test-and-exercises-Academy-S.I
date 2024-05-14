package corso.lezione03.esercizio05;

public class Quadrato {
	
	//attributi della classe
	private int lato;

	//costruttori
	public Quadrato(int lato) {
		this.lato = lato;
	}
	
	
	//metodi

	public int calcolaPerimetro(){
		return this.lato*4;
	}
	
	public static int perimetro(int lato){
		return lato*4;
	}

	public int calcolaArea(){
		return this.lato*this.lato;
	}

	public int getLato() {
		return this.lato;
	}


	public void setLato(int lato) {
		this.lato = lato;
	}

}
