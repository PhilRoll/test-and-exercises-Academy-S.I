/*FILIPPO ROTOLO*/

package it.db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DbTest {
	//attributo di tipo Connection
	private static Connection con;
	
	
	//main
	public static void main(String[] args) {
		DbTest test = new DbTest();
		try {
			String dbName = "test_jdbc";
			test.createDb(dbName);
			/*test.createTableUtente(dbName);
			test.createTableLibro(dbName);
			test.createTablePrestiti(dbName);
			//inserimento degli utenti
			test.insertUtente(dbName,1, "Mario", "Rossi");
			test.insertUtente(dbName,2, "Andrea", "Verdi");
			test.insertUtente(dbName,3, "Massimo", "Bianchi");
			test.insertUtente(dbName,4, "Sara", "Vallieri");
			test.insertUtente(dbName,5, "Marco", "Graviglia");
			test.insertUtente(dbName,6, "Marzia", "Esposito");
			//inserimento dei libri
			test.insertLibro(dbName,1, "transistor", "coppelli");
			test.insertLibro(dbName,2, "compilatore", "ranieri");
			test.insertLibro(dbName,3, "diodi", "stortoni");
			test.insertLibro(dbName,4, "algoritmi", "sedge");
			test.insertLibro(dbName,5, "pascal", "wirth");*/
			test.query1(dbName, "Vallieri");
			test.query2(dbName);
			test.query3(dbName);
			test.query4(dbName, "Vallieri");
			test.query6(dbName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Metodo per avviare la connessione al DB
	private static Connection startConnection(String dbName) throws SQLException{
		if(con==null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("127.0.0.1");
			dataSource.setPortNumber(3306);
			dataSource.setUser("root");
			dataSource.setPassword("admin");
		    dataSource.setDatabaseName(dbName);
			con = dataSource.getConnection();
		}
		return con;
	}
	
	//crea il db
	static void createDb(String dbName) throws SQLException {
		//crea il db se non esiste
		String sql = "CREATE DATABASE IF NOT EXISTS "+dbName;
	    PreparedStatement ps = startConnection(null).prepareStatement(sql);
	    ps.executeUpdate();
	    //usa il db
	    String useDbSQL = "USE " + dbName;
	    PreparedStatement useDbStatement = startConnection(dbName).prepareStatement(useDbSQL);
	    useDbStatement.executeUpdate();
	}
	
	
	//QUERY
	
	//query 1
	//Tutti i libri prestati a all'utente Vallieri in ordine cronologico.
	private void query1(String dbName, String surname) throws SQLException{
		String sql = "SELECT titolo, autore, inizio, fine FROM "+
				"libro JOIN prestiti ON libro.id = prestiti.id_L "+
				"JOIN utente ON prestiti.id_U = utente.id "+
				"WHERE utente.cognome = '"+surname+"' ORDER BY prestiti.inizio DESC";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println("titolo: "+rs.getString(1));
			System.out.println("autore: "+rs.getString(2));
			System.out.println("inizio: "+rs.getString(3));
			System.out.println("fine: "+rs.getString(4));
			System.out.println("-----------------");
		}
	}
	
	//query 2
	//Individua i primi tre lettori che hanno letto più libri.
	private void query2(String dbName) throws SQLException{
		String sql = "SELECT utente.nome, utente.cognome, COUNT(prestiti.id_L) AS 'numero libri prestati' FROM "+
				"libro JOIN prestiti ON libro.id = prestiti.id_L " +
				"JOIN utente ON prestiti.id_U = utente.id " +
				"GROUP BY utente.nome, utente.cognome ORDER BY 'numero libri prestati' DESC LIMIT 3;";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println("nome: "+rs.getString(1));
			System.out.println("cognome: "+rs.getString(2));
			System.out.println("n. libri prestati: "+rs.getString(3));
			System.out.println("-----------------");
		}
	}
	
	//query 3
	//Individua tutti i possessori dei libri non ancora rientrati e il titolo degli stessi.
	private void query3(String dbName) throws SQLException{
		String sql = "SELECT nome, cognome, titolo FROM " +
				"utente JOIN prestiti ON utente.id = prestiti.id_U JOIN libro ON prestiti.id_L = libro.id " +
				"WHERE prestiti.fine IS null;";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println("nome: "+rs.getString(1));
			System.out.println("cognome: "+rs.getString(2));
			System.out.println("titolo: "+rs.getString(3));
			System.out.println("-----------------");
		}
	}
	
	
	//query 4
	//Dare lo storico dei libri chiesi in prestito da un utente indicando il periodo
	private void query4(String dbName, String surname) throws SQLException{
		String sql = "SELECT nome, cognome, titolo, inizio, fine FROM " +
				"utente JOIN prestiti ON utente.id = prestiti.id_U JOIN libro ON prestiti.id_L = libro.id " +
				"WHERE prestiti.inizio ='2023-04-16' AND prestiti.fine=current_date() AND utente.cognome='"+surname+"'";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println("nome: "+rs.getString(1));
			System.out.println("cognome: "+rs.getString(2));
			System.out.println("titolo: "+rs.getString(3));
			System.out.println("inizio prestito: "+rs.getString(4));
			System.out.println("inizio prestito: "+rs.getString(5));
			System.out.println("-----------------");
		}
	}
	
	
	//query 6
	//Individua prestiti la cui durata supera i 15gg.
	private void query6(String dbName) throws SQLException{
		String sql = "SELECT nome, cognome, titolo, inizio, fine FROM "+
				"utente JOIN prestiti ON utente.id = prestiti.id_U JOIN libro ON prestiti.id_L = libro.id "+
				"WHERE datediff(prestiti.fine, prestiti.inizio)>15 "+
				"OR (prestiti.fine IS NULL AND datediff(current_date(), prestiti.inizio)>15);";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println("nome: "+rs.getString(1));
			System.out.println("cognome: "+rs.getString(2));
			System.out.println("titolo: "+rs.getString(3));
			System.out.println("inizio prestito: "+rs.getString(4));
			System.out.println("inizio prestito: "+rs.getString(5));
			System.out.println("-----------------");
		}
	}
	
	
		
		
	//EXTRA
		
		
	//METODI CRUD
	//crea la tabella utente
	private void createTableUtente(String dbName) throws SQLException {
	    String sql = "CREATE TABLE IF NOT EXISTS Utente (" +
	                 "id INT PRIMARY KEY NOT NULL," +
	                 "Nome VARCHAR(255)," +
	                 "Cognome VARCHAR(255)" +
	                 ");";
	    
	    PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
	    ps.executeUpdate();
	}
	
	
	//crea la tabella libro
	private void createTableLibro(String dbName) throws SQLException {
	    String sql = "CREATE TABLE IF NOT EXISTS Libro (" +
	                 "id INT PRIMARY KEY NOT NULL," +
	                 "Titolo VARCHAR(255)," +
	                 "Autore VARCHAR(255)" +
	                 ")";
	    
	    PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
	    ps.executeUpdate();
	}
	
	
	//crea la tabella libro
	private void createTablePrestiti(String dbName) throws SQLException {
	    String sql = "CREATE TABLE IF NOT EXISTS Prestiti(" +
	                 "id INT PRIMARY KEY NOT NULL," +
	                 "inizio DATE," +
	                 "fine DATE," +
	                 "id_U INT NOT NULL," +
	                 "id_L INT NOT NULL," +
	                 "FOREIGN KEY (id_U) REFERENCES utente(id)," +
	                 "FOREIGN KEY (id_L) REFERENCES libro(id)" +
	                 ")";
	    PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
	    ps.executeUpdate();
	}
	
	
	
	//inserimento di un utente
	private void insertUtente(String dbName, int id, String nome, String cognome) throws SQLException {
		String sql = "INSERT INTO utente (id, Nome, Cognome) VALUES (?, ?, ?)";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, nome);
        ps.setString(3, cognome);
		ps.executeUpdate();
	}
	
	
	//inserimento di un libro
	private void insertLibro(String dbName, int id, String titolo, String autore) throws SQLException {
		String sql = "INSERT INTO libro (id, Titolo, Autore) VALUES (?, ?, ?)";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, titolo);
        ps.setString(3, autore);
		ps.executeUpdate();
	}
	
	
	//inserimento di un libro
	private void insertPrestito(String dbName, int id, int id_U, int id_L, Date inizio, Date fine) throws SQLException {
		String sql = "INSERT INTO libro (id, id_U, id_L, inizio, fine) VALUES (?, ?, ? ,? , ?)";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
        ps.setInt(1, id);
        ps.setInt(2, id_U);
        ps.setInt(3, id_L);
        ps.setDate(4, inizio);
        ps.setDate(4, fine);
		ps.executeUpdate();
	}
	
	
	
	
	
	
	/*
	 * QUERY SQL
	SELECT titolo, autore, inizio, fine FROM
	libro JOIN prestiti ON libro.id = prestiti.id_L JOIN utente ON prestiti.id_U = utente.id 
	WHERE utente.cognome = "Vallieri" ORDER BY prestiti.inizio DESC;
	
	SELECT utente.nome, utente.cognome, COUNT(prestiti.id_L) AS numero_di_libri_prestati FROM 
	libro JOIN prestiti ON libro.id = prestiti.id_L
	JOIN utente ON prestiti.id_U = utente.id
	GROUP BY utente.nome, utente.cognome ORDER BY numero_di_libri_prestati DESC LIMIT 3;
	
	SELECT nome, cognome, titolo FROM
	utente JOIN prestiti ON utente.id = prestiti.id_U JOIN libro ON prestiti.id_L = libro.id 
	WHERE prestiti.fine IS null;
	
	SELECT nome, cognome, titolo, inizio, fine FROM
	utente JOIN prestiti ON utente.id = prestiti.id_U JOIN libro ON prestiti.id_L = libro.id 
	WHERE prestiti.inizio ="2023-04-16" AND prestiti.fine=current_date() AND utente.nome="Mario";
	
	
	SELECT nome, cognome, titolo, inizio, fine FROM
	utente JOIN prestiti ON utente.id = prestiti.id_U JOIN libro ON prestiti.id_L = libro.id 
	WHERE datediff(prestiti.fine, prestiti.inizio)>15 
	OR (prestiti.fine IS NULL AND datediff(current_date(), prestiti.inizio)>15);
	*/
	
	
	
}
