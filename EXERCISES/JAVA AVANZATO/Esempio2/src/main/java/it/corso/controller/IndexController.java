package it.corso.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Articolo;
import it.corso.service.ArticoloService;

@Controller
@RequestMapping
public class IndexController {
	
	//dependency injection quindi IoC
	@Autowired
	private ArticoloService articoloService;
	
	/* ALTERNATIVA con la COSTRUCTION INJECTION (se si fa cosi si deve togliere @Autowired sull'attributo)
	 * public IndexController(ArticoloService articoloService){}
	 * this.articoloService = articoloService;*/
	
	@GetMapping
	public String getPage(Model model) {
		List<Articolo> listaCatalogo = articoloService.getCatalogo();
		//inserisco dentro al model un attributo che ha chiave "catalogo" che contiene la lista di articoli che nella realta verrebbe dal db
		model.addAttribute("catalogo", listaCatalogo);
		return "index";
	}
}
