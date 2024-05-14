package it.corso.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.UserDao;
import it.corso.model.User;

//@Service indica che questa classe è un servizio di spring e 
//dietro le quinte spring farà l'istanza dell'interfaccia tramite questa classe
@Service
public class UserServiceImpl implements UserService {
	
	//dependency injection che implementa IoC. iniezione del dao per essere chiamato all'interno del servizio
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public void userRegistration(User user) {
		//"userDao.save(user);" cosi salva l'oggetto user però cosi salva le password in chiaro  
		
		//sfruttiamo allora la libreria per hashing sha-256. Si utilizza una crittografia unidirezionale
		String sha256hex = DigestUtils.sha256Hex(user.getPassword());
		//settiamo la password hashata
		user.setPassword(sha256hex);
		//metodo save() di CrudRepository chiamato sull'interfaccia userDao per salvare o aggiornare i dati.
		userDao.save(user);
		

	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUserData(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsUserMail(String email) {
		return userDao.existsByMail(email);
	}

}
