package corso.lezione03.esercizio04;


public class Main {

	public static void main(String[] args) {
		Esercizio esercizio = new Esercizio();
		String s = "Proova";
		char c = 'o';
		System.out.println("Stringa:\""+s+"\" ; carattere:\'"+c+"\'");
		System.out.println("trova occorrenza: "+esercizio.trovaOccorrenza(s, c));
		System.out.println("conta occorrenze: "+esercizio.contaOccorrenze(s, c));
		System.out.println("posizione occorrenza: "+esercizio.trovaPosizioneOccorrenza(s, c));
		
		System.out.println("\n");
		
		String s2 = "alloro";
		char c2 = '-';
		Esercizio2 esercizio2 = new Esercizio2();
		System.out.println(esercizio2.modificaStringa(s2, c2));
		System.out.println(esercizio2.calcolaFibonacci(10));
	}

}
