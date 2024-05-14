package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Prodotto;
import it.corso.service.ProdottoService;

@Controller
@RequestMapping("/")
public class indexController {
	
	
	// Il controller dovrà agganciarsi al service 
	@Autowired
	private ProdottoService prodottoService;
	
	
	/* Metodo che mappa la richiesta get principale per ottenere la pagina index. Il metodo dovrà accettare
	 * l'oggetto Model come argomento perchè dovrà andare a comunicare con il file di view per trasferire
	 * la collezione di prodotti 
	 */
	@GetMapping
	public String getPage(Model model) {
	
		// Il metodo getProdotti() ritorna una lista di Prodotti
		List<Prodotto> prodotti = prodottoService.getProdotti();
		/* Avendo la collezione si può utilizzare il model per aggiungere un attributo e con chiave prodotti
		 * definita nel file HTML si passa la collezione proodtti.  
		 */
		
		model.addAttribute("prodotti", prodotti);
		return "index";
	}
	
	// la parte di sotto del codice deve essere fatta dopo aver visto la modifica
	
	/*
	 * In questo caso non serve required = false perchè bisogna sempre cancellare, inoltre, a differenza
	 * del formController dove c'era Integer id qui si passa int id perchè Integer è un wrapper per 
	 * un tipo primitivo int e può contenre un valore null oltre ai valori interi, mentre, in questo caso
	 * il valore può essere visto come obbligatorio ovvero che il parametro id deve essere presente nella 
	 * richiesta e contenere un valore intero valido. Se non viene fornito un valore intero valido nella 
	 * richiesta, si verificherà un errore 
	 */
	@GetMapping("/cancella")
	public String cancellaProdotto(@RequestParam("id") int id) {
		
		prodottoService.cancellaProdotto(id);
		return "redirect:/";
	}
}
