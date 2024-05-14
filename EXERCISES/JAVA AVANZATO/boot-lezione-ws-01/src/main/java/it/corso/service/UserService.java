package it.corso.service;

import java.util.List;

import it.corso.model.User;

public interface UserService {
	
	//inserimento utente
	void userRegistration(User user);
	
	//restituisce l'utente in base all'id
	User getUserById(int id);
	
	//aggiornamento dell'utente
	void updateUserData(User user);
	
	//restituisce la lista degli utenti
	List<User> getUsers();
	
	//cancellazione utente in base all'id
	void deleteUser(int id);
	
	boolean existsUserMail(String mail);

}
