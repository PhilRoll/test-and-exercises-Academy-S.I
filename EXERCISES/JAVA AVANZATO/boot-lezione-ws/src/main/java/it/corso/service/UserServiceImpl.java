package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.UserDao;
import it.corso.model.User;

/*
 * il servizio verrà chiamato dal controller e a sua volta andrà a chiamare il dao che comunicherà con il db 
 */


// annotando con @Service stiamo dicendo all'IoC Container che questa classe è un servizio quindi è un componente 
@Service
public class UserServiceImpl implements UserService {

	// dichiaro un oggetto userDao di tipo userDao e tramite la dependency poi avverrà l'istanza 
	@Autowired
	private UserDao userDao;
	
	@Override
	public void userRegistration(User user) {

		// hashing sha-256. Si utilizza una crittografia unidirezionale 
		String sha256hex = DigestUtils.sha256Hex(user.getPassword());
		// settiamo la password hashata con il setPassword
		user.setPassword(sha256hex);
		// metodo save() messo a disposizione di CrudRepository per salvare o aggiornare i dati
		userDao.save(user);
	}

	@Override
	public User getUserById(int id) {

/*
 * Optional<User> è una classe introdotta dalla versione di Java 8 e permette di ritornare un optional. Quando si fa ritorare
 * un oggetto dal db in base in questo all'id non è che quel record sia presente sul database. Questo può essere visto
 * come una scatola che può contenere l'utente oppure no
 */
		Optional<User> userOptionalDb = userDao.findById(id);
		
		// il metodo isPresent() verifica se esiste oppure no l'oggetto all'interno ed è un metodo booleano
		if(!userOptionalDb.isPresent()) {
			
			return new User();
		}
		// una volta verificato si può estrarre l'oggetto utilizzando il metodo get()
		return userOptionalDb.get();
	}
	
	
	@Override
	public boolean existUserByEmail(String email) {
		
		return userDao.existsByMail(email);
	}

	@Override
	public void updateUserData(User user) {

	try {
		// recupero l'optional dell'oggetto dal db in base all'id ripreso dall'oggetto user di tipo User
		Optional<User> userOptionalDb = userDao.findById(user.getId());
		
		// verifico se presente
		if(userOptionalDb.isPresent()) {
			
			// estraggo l'oggetto e lo inserisco in un oggetto di tipo User
			User userDb = userOptionalDb.get();
			// attraverso i setter aggiorno i valori dell'utente esistente passando i valori estratti dal parametro tramite i getter
			userDb.setName(user.getName());
			userDb.setLastname(user.getLastname());
			userDb.setMail(user.getMail());
			userDb.setPassword(user.getPassword());
			// chiamo il dao invocando sull'oggetto userDao di tipo UserDao il metodo save
			userDao.save(userDb);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	}

	@Override
	public List<User> getUsers() {
		
		return (List<User>) userDao.findAll();
	}

	@Override
	public void deleteUser(int id) {
		
		Optional<User> userOptionalDb = userDao.findById(id);
		
		if(userOptionalDb.isPresent()) {
			
			userDao.delete(userOptionalDb.get());
			
		}
		

	}

}
