package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import it.corso.model.User;
import it.corso.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.regex.Pattern;

//gestirà tutte le richieste che arrivano all'URL "http://localhost:8080/api/user"
@Path("/user")
public class UserController {
	
	//dependency injection che implementa IoC. iniezione del servizio per essere chiamato all'interno del controller
	@Autowired //oppure @Inject
	private UserService userService;
	
	
	//endpoint per la registrazione dell'utente
	@POST
	@Path("/reg") //percorso "http://localhost:8080/api/user/reg"
	@Consumes(MediaType.APPLICATION_JSON) //specifica il tipo di dati che l'endpoint può accettare nel corpo della richiesta HTTP. In questo caso:"formato JSON" nel corpo della richiesta.
	public Response userRegistration(@Valid @RequestBody User user){ //validazione dei dati forniti nel corpo della richiesta HTTP tramite un oggetto di tipo User
		try {
			// validazione della password prima di eventualmente hasharla (altrimenti la regex non funzionerebbe piu)
			if(!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}",user.getPassword())){
				
				return Response.status(Response.Status.BAD_REQUEST).build(); //restisce una risposta HTTP con lo stato "Bad Request" (400) al client che ha inviato la richiesta.
				
				//in particolare:
				//Response.Status.BAD_REQUEST -> costante
				//Response.status(Response.Status.OK): costruisce un oggetto ResponseBuilder con lo stato "Bad Request" specificato.
				//.build() builder che builda l'oggetto ResponseBuilder
				
				
			}
			
			// controlla se l'email esiste gia sul DB
			if(userService.existsUserMail(user.getMail())){
				return Response.status(Response.Status.BAD_REQUEST).build(); //restisce una risposta HTTP con lo stato "Bad Request" (400) al client che ha inviato la richiesta.
			}
			
			
			// chiamata al service che utilizzando il metodo userRegistration che a sua volta chiamerà il dao e chiamerà il metodo save() che salverà l'oggetto sul db
			userService.userRegistration(user);
			return Response.status(Response.Status.OK).build(); 
			
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST).build(); //restisce una risposta HTTP con lo stato "Bad Request" (400) al client che ha inviato la richiesta.
		}
	}
	
}
