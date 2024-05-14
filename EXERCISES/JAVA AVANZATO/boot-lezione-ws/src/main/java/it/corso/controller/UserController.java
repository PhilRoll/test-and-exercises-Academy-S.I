package it.corso.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import it.corso.model.User;
import it.corso.service.UserService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

// gestirà tutte le richieste che arrivano a http...../user
@Path("/user")
public class UserController {

	// iniezione del servizio per essere chiamato all'interno del controller
	@Autowired
	private UserService userService;
	
	// endpoint per la registrazione dell'utente
	// annotation utilizza quando vanno inviati i dati (tipicamente i dati proveniente da un form)
	// si mappa il singolo action/metodo/endpoint
	@POST
	@Path("/reg")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response userRegistration(@Valid @RequestBody User user) {
		
		try {
			
			// questo metodo confronta l'espressione regolare con la password presa in ingresso dall'utente
		
			if(!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}", user.getPassword())) {
				
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			
			// verifica esistenza dell'utente. In caso di true si lancia una eccezione di tipo 400 
			if(userService.existUserByEmail(user.getMail())) {
				
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			// chiamata la service che a sua volta chiamerà il dao e il metodo save() che salverà l'oggetto sul db
			userService.userRegistration(user);
			
			// se tutto va a buon fine ritornerà un generico 200 
			return Response.status(Response.Status.OK).build();
			
		} catch (Exception e) {
		
			// se qualcosa va storto ritornerà il codice HTTP 400 
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	// endpoint per la ripresa dal db dell'utente in base all'id
	@GET
	// {id} vuol dire id variabile quindi si ha un URL variabiabile 
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	// l'annotation PathParam serve per riprendere l'id dall'URL. ATTENZIONE: FARE IMPORT GIUSTO WS.RS
	public Response getUserById(@PathParam("id") int id) {
		
		try {
			User user = userService.getUserById(id);
			
			return Response.status(Response.Status.OK).entity(user).build();
			
		} catch (Exception e) {
			
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	
	// endpoint per la lista di utenti
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		
		try {
			
			List<User> userList = userService.getUsers();
			// pattern builder di risposta che contiene nel corpo l'oggetto userList recuperato dal db s
			return Response.status(Response.Status.OK).entity(userList).build();
		} catch (Exception e) {
			
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	
	
	@PUT
	@Path("/update")
	public Response updateUser(@RequestBody User user) {
		
		try {
			
			userService.updateUserData(user);
			return Response.status(Response.Status.OK).build();
			
		} catch (Exception e) {
			
			return Response.status(Response.Status.BAD_REQUEST).build();

		}
		
		
	}
}
