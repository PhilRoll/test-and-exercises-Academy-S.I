package corso.lezione04.esercizio01;

public class Main {

	public static void main(String[] args) {
		Studente studente1 = new Studente("Luca", "Bianchi", "48302334");
		System.out.println(studente1.getNome());
		System.out.println(studente1.getCognome());
		System.out.println(studente1.getMatricola());
		
		
		Studente studente2 = new Studente("Luigi", "Verdi", "29408643");
		System.out.println("\n"+studente2.toString());
		
		
		Studente studente3 = new Studente();
		studente3.setNome("Mario");
		studente3.setCognome("Rossi");
		studente3.setMatricola("12345678");
		System.out.println("\n"+studente3.toString());

	}

}
