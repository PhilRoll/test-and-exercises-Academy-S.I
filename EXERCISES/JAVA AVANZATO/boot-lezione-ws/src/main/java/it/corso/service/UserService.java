package it.corso.service;

import java.util.List;

import it.corso.model.User;

public interface UserService {

	// inserimento dell'utente 
	void userRegistration(User user);
	// ritorna un utente in base all'id
	User getUserById(int id);
	// aggiornamento dati utenti
	void updateUserData (User user);
	// ritorna la lista degli utenti
	List<User> getUsers();
	// cancellazione utente in base all'id
	void deleteUser(int id);
	// esistenza utente tramite email
	boolean existUserByEmail(String email);
}
