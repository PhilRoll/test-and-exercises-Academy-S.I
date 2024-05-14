package it.corso.service;

import java.util.List;

import it.corso.model.Prodotto;


/* In un'interfaccia, i metodi sono implicitamente public e abstract (non c'è bisogno di specificare questi 
 * modificatori) e non contengono un corpo di implementazione, quindi non ci sono parentesi graffe
 */
public interface ProdottoService {

	
	/*un unico metodo registraProdotto e non il metodo creaProdotto e il metodo aggiornaProdotto 
	 * in quanto il metodo save è intelligente e capisce se salvare o aggiornare */
	void registraProdotto(Prodotto prodotto);
	Prodotto getProdottoById(int id);
	List<Prodotto> getProdotti();
	void cancellaProdotto(int id);
	
}
