package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.*;
import it.corso.service.UtenteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {

/* senza aggiungere altro se chiamo la pagina si avrà un errore 500, errore di parsing del template.
 * Ovviamente bisogna aggiungere il Model 
 */
	
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping
	public String getPage(Model model) {
		
		Utente utente = new Utente();
		
		model.addAttribute("utente", utente);
		return "index";
	}
	
/* Al posto di RequestParam ("nome") String nome ecc (ovvero i singoli paramentri) si passa direttamente 
 * l'oggetto di tipo Utente utente andandolo ad annotare con l'annotation ModelAttribute passandogli come 
 * riferimento la chiave utente. Quindi nel metodo getPage l'oggetto utente viene dichiarato e istanziato 
 * e poi viene passato tramite il model al file di view quindi arriva nel form. L'utilizzatore compila i 
 * campi e invia i dati quindi lo stesso utente che è un attributo del model (avendo utilizzato 
 * model.addAttribute) verrà utilizzato per valorizzare la variabile utente di tipo Utente nel metodo 
 * registraUtente che verrà acquisita direttamente nel metodo.
 */

/* Dopo aver fatto il service, dopo aver contrassegnato con l'autowired utenteService e averlo richiamato
 * all'interno di registraUtente, dopo aver messo return "redirect:/" e dopo aver definito con 
 * jakarta.validations.constraint nella classe Utente la validazione dei campi si inserisce all'interno di
 * registraUtente l'annotation @Valid che permette di fare la pre-validazione dei dati con cui gli attributi
 * dell'utente vengono valorizzati.
 */

/* A questo punto si ha bisogno anche di capire se ci sono degli errori e quali sono per questo motivo 
 * si fa in modo che il metodo registraUtente accetti un altro argomento che sarà un oggetto di tipo 
 * BindingResult (interfaccia che fa parte dello Springframework.validation) chiamato result. Questo oggetto
 * è una sorta di registro errore che se ci sono vengono registrati qui dentro
 */
	@PostMapping
	public String registraUtente(@Valid @ModelAttribute ("utente") Utente utente, BindingResult result) {
		
/* Prima di attivare l'effettiva registrazione dell'utente quindi prima che i dati possano raggiungere il 
 * database si farà un controllo attraverso un if utilizzando il metodo messo a disposizione per BindingResult
 * chiamato hasError() che ritorna un booleano. In caso di true ritornerà non il redirect ma la risorsa 
 * index. Questo perchè avendo il processo di validazione con il registro che tiene traccia e avendo i messaggi
 * di errore si ci può permettere di ritornare sull'index un paragrafo con una th:if invoncando la funzione
 * hasErrors() passando il riferimento al campo
 * 
 */		
		if(result.hasErrors()) {
			return "index";
		}
		
		utenteService.registrazioneUtente(utente);
		/*return null senza aggiungere altro prima, di fare il service */
		return "redirect:/";
	}
	
/* https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary.html */
}
