package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.ProdottoDao;
import it.corso.model.Prodotto;

@Service
public class ProdottoServiceImpl implements ProdottoService {
	
	
	// dependecy injection ovvero funzionamento alla base del pattern Inversion of Control attraverso annotation Autowired
	@Autowired
	private ProdottoDao prodottoDao;

	
	@Override
	public void registraProdotto(Prodotto prodotto) {
		
		/* Su prodottoDao si invoca il metodo save (della CrudRepository). 
		 * Il metodo di creazione o modifica riceve un oggetto di tipo Prodotto, va a fare la chiamata 
		 * quindi passerà la palla al Dao passandogli l'oggetto prodotto e il Dao procederà all'archiviazione
		 */	 
		prodottoDao.save(prodotto);
		
	}

	@Override
	public Prodotto getProdottoById(int id) {
	
		/* Il valore ritornato dal metodo findById non è direttamente un oggetto, ma è un optional.
		 * Optional è un oggetto che è stato introdotto con la versione 8 di Java ed è un elemento studiato
		 * appositamente per prevedere la possibilità che quel valore che si sta cercando possa anche non 
		 * esserci. Sostanzialmente è una scatola dentro il quale al suo interno potrebbe esserci un 
		 * Prodotto. Questa scatola la si ottiene invocando il metodo findById passando l'id che si ha 
		 * come parametro nel metodo.
		 */
		Optional<Prodotto> prodottoOptional = prodottoDao.findById(id);
		
		/* Il findById non ritorna direttamente il prodotto perchè quel determinato ID non sia presente,
		 * quindi per prevenire potenziali problemi/eccezioni viene ritornato l'optional al cui interno 
		 * può esserci il prodotto oppure no. A questo punto si può verificare se nella scatola c'è il
		 * prodotto e quindi usando un costrutto if ed invocando sull'oggetto optional il metodo 
		 * isPresent() si va a fare questo controllo. In caso di esito positivo attraverso il metodo get()
		 * ritornerà un oggetto di tipo Prodotto
		 */
		
		
		if (prodottoOptional.isPresent()) {
			return prodottoOptional.get();
		}
		
		// se non 'è niente nell'Optional ritorna null ed ovviamente andrà gestito 
		return null;
	}

	@Override
	public List<Prodotto> getProdotti() {
		
		/* Il metodo findAll ritorna un Iterable<Prodotto>. Se si va ad implementare il findAll() si ottiene
		 * un errore perchè Iterable è un qualcosa di più ampio di una lista quindi è necessario castarlo
		 * ad una lista. Iterable sostanzialmente è un'interfaccia che viene implementata da tutti quegli
		 * elementi che in ambito Java rappresentano delle sequenze iterabili (List, Map ecc).
		 */
		return (List<Prodotto>) prodottoDao.findAll();
	}

	@Override
	public void cancellaProdotto(int id) {
		
		/* Il metodo delete deve ricevere un oggetto da cancellare quindi in questo caso un oggetto di tipo
		 * prodotto. E' necessario aggiungere il metodo get() senza fare controllo del fatto che ci sia 
		 * oppure no nella castola. Si parte dal presupposto che ci sia e lo si tira fuori.
		 * Senza il metodo get() si ottiene un errore.
		 */
		Prodotto prodotto = prodottoDao.findById(id).get();
		prodottoDao.delete(prodotto);
		
	}

}
