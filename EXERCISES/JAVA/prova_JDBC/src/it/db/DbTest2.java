package it.db;

import java.sql.*;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DbTest2 {
	
	private static final String SERVER_NAME = "localhost";
    private static final int PORT_NUMBER = 3306;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static Connection con;
    
    
    public static Connection startConnection(String dbName) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(SERVER_NAME);
        dataSource.setPortNumber(PORT_NUMBER);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);

        if (con == null) {
            dataSource.setDatabaseName(dbName);
            con = dataSource.getConnection();
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
            con = null;
        }
    }
	
	//crea il db
	public static void createDb(String dbName) throws SQLException {
		//crea il db se non esiste
		String sql = "CREATE DATABASE IF NOT EXISTS "+dbName;
	    PreparedStatement ps = startConnection(null).prepareStatement(sql);
	    ps.executeUpdate();
	    //usa il db
	    String useDbSQL = "USE " + dbName;
	    PreparedStatement useDbStatement = startConnection(dbName).prepareStatement(useDbSQL);
	    useDbStatement.executeUpdate();
	    ps.close();
	}
	
	
	//QUERY
	
	//query 1
	//Tutti i libri prestati a all'utente Vallieri in ordine cronologico.
	public void query1(String dbName, String surname) throws SQLException{
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
	public void query2(String dbName) throws SQLException{
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
	public void query3(String dbName) throws SQLException{
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
	public void query4(String dbName, String surname) throws SQLException{
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
			System.out.println("fine prestito: "+rs.getString(5));
			System.out.println("-----------------");
		}
	}
	
	
	//query 6
	//Individua prestiti la cui durata supera i 15gg.
	public void query6(String dbName) throws SQLException{
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
			System.out.println("fine prestito: "+rs.getString(5));
			System.out.println("-----------------");
		}
	}
	
	
		
		
	//EXTRA
		
		
	//METODI CRUD
	//crea la tabella utente
	public void createTableUtente(String dbName) throws SQLException {
	    String sql = "CREATE TABLE IF NOT EXISTS Utente (" +
	                 "id INT PRIMARY KEY NOT NULL," +
	                 "Nome VARCHAR(255)," +
	                 "Cognome VARCHAR(255)" +
	                 ");";
	    
	    PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
	    ps.executeUpdate();
	    ps.close();
	}
	
	
	//crea la tabella libro
	public void createTableLibro(String dbName) throws SQLException {
	    String sql = "CREATE TABLE IF NOT EXISTS Libro (" +
	                 "id INT PRIMARY KEY NOT NULL," +
	                 "Titolo VARCHAR(255)," +
	                 "Autore VARCHAR(255)" +
	                 ")";
	    
	    PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
	    ps.executeUpdate();
	    ps.close();
	}
	
	
	//crea la tabella libro
	public void createTablePrestiti(String dbName) throws SQLException {
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
	    ps.close();
	}
	
	
	
	//inserimento di un utente
	public void insertUtente(String dbName, int id, String nome, String cognome) throws SQLException {
		String sql = "INSERT INTO utente (id, Nome, Cognome) VALUES (?, ?, ?)";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, nome);
        ps.setString(3, cognome);
		ps.executeUpdate();
	}
	
	
	//inserimento di un libro
	public void insertLibro(String dbName, int id, String titolo, String autore) throws SQLException {
		String sql = "INSERT INTO libro (id, Titolo, Autore) VALUES (?, ?, ?)";
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, titolo);
        ps.setString(3, autore);
		ps.executeUpdate();
	}
	
	
	//inserimento di un prestito
	public void insertPrestito(String dbName, int id, int id_U, int id_L, String inizio, String fine) throws SQLException {
		String sql = "INSERT INTO prestiti (id, inizio, fine, id_U, id_L) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
        ps.setInt(1, id);
        ps.setDate(2, java.sql.Date.valueOf(inizio));
        if(fine!=null) {
        	ps.setDate(3, java.sql.Date.valueOf(fine));
        }
        else {
        	ps.setDate(3, null);
        }
        ps.setInt(4, id_U);
        ps.setInt(5, id_L);
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
