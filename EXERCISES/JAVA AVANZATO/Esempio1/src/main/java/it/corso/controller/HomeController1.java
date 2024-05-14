package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController1 {

    @GetMapping
    public String getHome() {
        return "benvenuto";	// con Thymeleaf, prende il file templates/benvenuto.html
    }
    
    @GetMapping("homepage")
    public String getHome2(){
    	return "home";
    }
}