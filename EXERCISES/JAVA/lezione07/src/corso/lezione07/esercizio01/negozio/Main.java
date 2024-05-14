package corso.lezione07.esercizio01.negozio;

import java.util.Date;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Negozio negozio = new Negozio();
		
		Prodotto p1 = new ProdottoAlimentare("pizza margherita", 10, 8.99, new Date(2025, 11, 30));
		Prodotto p2 = new ProdottoElettronico("smartphone 5g", 4, 399.99, 24);
		
		negozio.aggiungiProdotto(p1);
		negozio.aggiungiProdotto(p2);
		
		negozio.visualizzaProdotti();
		
		System.out.println("\n\nmodifica quantita per p1");
		
		negozio.modificaQuantita(p1.getId(), 20);
		negozio.visualizzaProdotti();
		
		System.out.println("\n\nrimozione di p2");
		negozio.rimuoviProdotto(p2.getId());
		negozio.visualizzaProdotti();
		
		
	}

}
