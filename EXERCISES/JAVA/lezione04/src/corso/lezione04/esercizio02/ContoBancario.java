package corso.lezione04.esercizio02;


public class ContoBancario {
	//ATTRIBUTI
	private static int idCounter = 0;
	private final  int idConto;
	private double saldo;
	private String nome;
	private String cognome;
	
	
	//COSTRUTTORE
	public ContoBancario(String nome, String cognome) {
		this.idConto = idCounter;
		idCounter++;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	
	//METODI
	public void versa(double somma) {
		this.saldo+=somma;
	}
	
	public void preleva(double somma) {
		if(this.saldo>=somma) {
			this.saldo-=somma;
		}
		else {
			System.out.println("Errore, credito insufficiente");
		}
	}

	public int getIdConto() {
		return idConto;
	}


	public double getSaldo() {
		return saldo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	

	
}
