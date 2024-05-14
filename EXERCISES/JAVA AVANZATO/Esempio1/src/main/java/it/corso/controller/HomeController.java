package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * a differenza della JEE non si ha il metodo doGet e doPost, 
 * inoltre mentre nella servlet avevamo un solo do post e doget 
 * qui possiamo avere piu metodi annotati con get e post (ovviamente il pat dovrà essere differente)
 * */


@Controller	//controller per indicare che questa classe è un controller di spring 
@RequestMapping("/") //in spring MVC RequestMapping serve per mappare le richieste di questo controller
@ResponseBody //di default la stringa di ritorno "benvenuto" del metodo getHome viene vista come una pagina html di template
//@Controller + @ResponseBoby = @RestController
public class HomeController {
	
	@GetMapping
	public String getHome() {
		return "benvenuto1";
	}
	
	
	@GetMapping("/1")
	public String getHome1() {
		return "benvenuto1";
	}
}
	
