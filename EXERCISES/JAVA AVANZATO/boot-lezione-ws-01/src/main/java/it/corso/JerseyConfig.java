package it.corso;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import jakarta.ws.rs.ApplicationPath;

/*
 * Questa classe, chiamata JerseyConfig, viene utilizzata per configurare e inizializzare Jersey, 
 * che è un framework per lo sviluppo di servizi RESTful in Java.
 * La classe JerseyConfig estende ResourceConfig, che è una classe fornita da Jersey per la configurazione delle risorse REST.
 * */


@Component //Indica che questa classe è un componente gestito da Spring
@ApplicationPath("/api") //Specifica il percorso di base per tutte le risorse REST nell'applicazione
public class JerseyConfig extends ResourceConfig {
 
	/*Nel costruttore della classe JerseyConfig, configuriamo Jersey per cercare le risorse REST 
	 * nel package "it.corso.controller" utilizzando il metodo packages(). 
	 * Questo significa che Jersey cercherà le classi che annotiamo con @Path all'interno di questo package
	 * per gestire le richieste REST.*/
	public JerseyConfig() {
		packages("it.corso.controller"); //Configura Jersey per cercare le risorse REST nel package specificato
	}
	
	
}