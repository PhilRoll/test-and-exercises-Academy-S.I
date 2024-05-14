package corso.lezione04.esercizio02;

public class Main {

	public static void main(String[] args) {
		ContoBancario conto = new ContoBancario("Mario","Rossi");
		conto.versa(1000.0);
		conto.preleva(500);
		conto.preleva(400);
		System.out.println(conto.getSaldo());
		//System.out.println(conto.getIdConto());
		
		//ContoBancario conto2 = new ContoBancario("Luigi","Verdi");
		//System.out.println(conto2.getIdConto());
	}

}
