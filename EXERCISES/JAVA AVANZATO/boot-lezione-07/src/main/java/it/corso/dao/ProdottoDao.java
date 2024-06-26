package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.corso.model.Prodotto;

public interface ProdottoDao extends CrudRepository<Prodotto, Integer>{
	
	
	List<Prodotto> findByPrezzo(double prezzo);
	

	
	@Query 
	(value = "SELECT * FROM prodotti WHERE prezzo=:p", nativeQuery = true)
	List<Prodotto> dammiPrezzo(@Param("p") double prezzo);
		
	
}



