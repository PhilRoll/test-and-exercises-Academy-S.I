package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import it.corso.model.User;

/*
 * Nel contesto di Spring Data JPA, il Dao (Data Access Object) è un'interfaccia che estende o utilizza le interfacce fornite da Spring Data, come ad esempio CrudRepository
 * CrudRepository è un'interfaccia di base per la gestione delle operazioni CRUD (Create, Read, Update, Delete) su un'entità.
 * 
 * L'interfaccia UserDao estende CrudRepository<User, Integer>, indicando a Spring Data di fornire un'implementazione per il Dao di accesso ai dati per l'entità User.
 * - "User": è l'entità che desideri gestire attraverso il Dao.
 * - "Integer:" è il tipo dell'ID dell'entità User.
 */
public interface UserDao extends CrudRepository<User, Integer>{
	
	//metodo aggiuntivo: verifica se esiste già un utente con l'indirizzo email fornito.
	boolean existsByMail(String email);
}
