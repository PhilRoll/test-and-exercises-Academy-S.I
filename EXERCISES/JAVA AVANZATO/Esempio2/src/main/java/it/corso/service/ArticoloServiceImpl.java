package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import it.corso.model.Articolo;



@Service //il service stabilisce che questa è una classe di servizio, ovvero un componente dell'applicazione
public class ArticoloServiceImpl implements ArticoloService{
	
	//nella realta bisognerebbe chiamare il DAO che permette di riprendere i dati dal DB
	@Override
	public List<Articolo> getCatalogo() {
		List<Articolo> catalogo = new ArrayList<>();
		
		Articolo articoloUno = new Articolo();
		articoloUno.setDescrizione("maglia");
		articoloUno.setId(1);
		articoloUno.setPrezzo(124.32);
		
		Articolo articoloDue = new Articolo();
		articoloDue.setDescrizione("televisione");
		articoloDue.setId(2);
		articoloDue.setPrezzo(232.32);		
		catalogo.add(articoloUno);
		catalogo.add(articoloDue);
		return catalogo;
	}

}
