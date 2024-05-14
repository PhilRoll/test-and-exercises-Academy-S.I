package corso.lezione06.esercizio02.elencotelefonico;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Rubrica r = new Rubrica();
		r.aggiungiContatto(new ContattoPersonale("pippo", "123456789", "cugino", "via Roma 32 (PA)"));
		r.aggiungiContatto(new ContattoLavoro("Mario", "01209876", "collega", "Programmatore"));
		
		String query = "mar";
		System.out.println("Ricerca:\""+query+"\"\n");
		List<Contatto> risultato = r.trovaContatto(query);
		if(risultato!=null){
			risultato.forEach(c -> {
				c.stampaContatto();
				System.out.println();
			});
		}
		else {
			System.out.println("Nessun contatto trovato");
		}
		System.out.println("---------------------------------------");	
		
		String numero = "01209876";
		System.out.println("Cancellazione numero:\""+numero+"\"\n");
		r.cancellaContatto(numero);
		List<Contatto> elenco = r.getContatti();
		elenco.forEach(c -> c.stampaContatto());
	}

}
