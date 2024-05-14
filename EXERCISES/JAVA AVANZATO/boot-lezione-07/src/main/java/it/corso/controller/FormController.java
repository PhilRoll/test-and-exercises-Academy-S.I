package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.*;
import it.corso.service.ProdottoService;


@Controller
@RequestMapping("/form")

public class FormController {

	@Autowired
	private ProdottoService prodottoService;

	/*
	 * Al metodo getPage dopo aver fatto tutto per la l'inserimento dei dati si
	 * aggiunge un altro parametro in ingresso ovvero l'argomento che annotato con
	 * requestParam permette di intercettare la presenza di eventuali parametri. Il
	 * parametro deve essere facoltativo altrimenti se lo si rende obbligatorio non
	 * si entrerà più nella registrazione del nuovo prodotto. Con l'aggiunta di
	 * RequestParam con required = false si può intercettare, se presente, il valore
	 * che viene trasferito tramite il link. Come si utilizza? Sapendo che il form
	 * lavora in modalità binding (dove acquisisce l'istanza di un oggetto di tipo
	 * prodotto e ne rappresenta i valori tramite i campi di input) si cambia la
	 * riga 36 ovvero l'istanza del prodotto
	 */

	@GetMapping
	public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id) {

//		Prodotto prodotto = new Prodotto();
		
		/*
		 * La riga seguente utilizza l'operatore ternario condizione ? istruzione1; :
		 * istruzione2 e si può tradurre questa sintassi in questo modo: se la
		 * condizione è vera esegui l'istruzione n1., in caso contrario esegui
		 * l'istruzione n2. Si può dire, dunque, che il simbolo punto interrogativo (?)
		 * che segue alla condizione equivale ad una if ed i due punti (:) ad un else.
		 * La condizione è id == null e quindi verifica se la variabile id è null ovvero
		 * non ha valore. Se la condizione è true allora alla variabile prodotto viene
		 * assegnato il valore new Prodotto() ovvero se l'id è null viene creato un
		 * nuovo oggetto Prodotto e assegnato alla variabile prodotto Se la condizione è
		 * falsa il valore che viene assegnato a prodotto è
		 * prodottoService.getProdottoById(id). Quindi nel caso in cui sia falsa la
		 * condizione viene utilizzato il metodo su un oggetto prodottoService che si
		 * presume restiuisca un ogetto Prodotto in base all'ID fornito. Quindi in
		 * sintesi in base alla condizione si verifica che se id è null viene creato un
		 * oggetto altrimenti verrà utilizzato il valore restituito da
		 * prodottoService.getProdottoById(id) per inizializzare prodotto.
		 * 
		 */
		Prodotto prodotto = id == null ? new Prodotto() : prodottoService.getProdottoById(id);
		model.addAttribute("prodotto", prodotto);
		return "form";
	}

	@PostMapping
	public String registraProdotto(@ModelAttribute("prodotto") Prodotto prodotto) {

	
		prodottoService.registraProdotto(prodotto);
		return "redirect:/";
	}
}
