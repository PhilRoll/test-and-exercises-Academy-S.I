package corso.lezione07.esercizio01.negozio;

import java.util.*;

public class Negozio {
	
	List<Prodotto> prodotti;
	
	public Negozio(){
		prodotti = new ArrayList<>();
	}
	
	
	public void aggiungiProdotto(Prodotto prodotto){
		this.prodotti.add(prodotto);
	}
	
	public void modificaQuantita(int id, int nuovaQuantita){
		Iterator<Prodotto> iteratore = this.prodotti.iterator();
		while(iteratore.hasNext()){
			Prodotto prodotto = iteratore.next();
			if(prodotto.getId()==id){
				prodotto.setQuantita(nuovaQuantita);
				break;
			}
		}	
	}
	
	
	public void visualizzaProdotti(){
		if(!this.prodotti.isEmpty()) {
			this.prodotti.forEach(c -> {
				c.stampaInfo();
				System.out.println("---");
				});
		}
		
	}
	
	
	public void rimuoviProdotto(int id){
		Iterator<Prodotto> iteratore = this.prodotti.iterator();
		while(iteratore.hasNext()){
			Prodotto prodotto = iteratore.next();
			if(prodotto.getId()==id){
				prodotti.remove(prodotto);
				break;
			}
		}	
	}
	
	
}
