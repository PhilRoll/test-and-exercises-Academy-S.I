package it.corso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity 				// Indica che questa classe è un'entità JPA
@Table(name="users") 	// Specifica il nome della tabella nel database relazionale
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica che l'ID è generato automaticamente dal database
	private int id;
	@Pattern(regexp="[a-zA-Z\\s']{5,50}", message="nome non corretto") // L'annotazione @Pattern viene utilizzata per definire un vincolo sul formato dei nomi. Se il formato del nome non è corretto, verrà restituito il messaggio di errore personalizzato "nome non corretto".
	@Column(name = "name") // Indica che questa proprietà mappa il campo "name" nella tabella del database
	private String name;
	@Pattern(regexp="[a-zA-Z\\s']{5,50}", message="cognome non corretto")
	@Column(name = "lastname")
	private String lastname;
	@Pattern(regexp = "[A-Za-z0-9\\.\\+_-]+@[A-Za-z0-9\\._-]+\\.[A-Za-z]{2,24}", message="email non valida")
	@Column(name = "mail")
	private String mail;
	@Column(name = "password")
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
