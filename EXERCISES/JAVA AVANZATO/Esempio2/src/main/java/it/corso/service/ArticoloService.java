package it.corso.service;

import java.util.List;
import it.corso.model.Articolo;

public interface ArticoloService {
	//metodo che l'interfaccia va ad esporre
	List<Articolo> getCatalogo();
}
