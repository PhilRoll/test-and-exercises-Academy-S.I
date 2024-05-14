package it.corso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

/*
 * inizialmente questo è un POJO e sarà la nostra classe che diventerà un entity quindi attraverso la tecnologia
 * ORM mapperemo gli oggetti sul db. A livello teorico questa classe dovrebbe trovarsi nello strato di DATA LAYER,
 * ma viene rappresentata nel package dedicato ai modelli che rispecchiano il db
 */

@Entity
@Table(name = "users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Nome con caratteri non ammessi")
	@Column(name = "name")
	private String name;
	
	@Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Cognome con caratteri non ammessi")
	@Column(name = "lastname")
	private String lastname;
	
	@Pattern(regexp = "[A-z0-9\\.\\+_-]+@[A-z0-9\\._-]+\\.[A-z]{2,8}", message="Mail non valida")
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
