package it.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DbSpiegazione {
	/* una connessione (sessione) con un db specifico. 
	 * le istruzioni vengono eseguite e i risultati vengono restituiti all'interno 
	 * del contesto di una connessione
	 * (sarebbe piu corretto fare un pool di connessioni)
	 */
	
	private Connection con;
	
	
	public static void main(String[] args) {
		DbSpiegazione prova = new DbSpiegazione();
		try {
			System.out.println(prova.startConnection().isValid(100)); //verifica se la connessione è andata a buon fine (se si stampa true)
			// System.out.println(prova.startConnection().isClosed());	//stampa false perchè nn la sto chiudendo
		
			prova.esempioSelect();
			prova.esempioInsert("Pino", "Rossi", "pino.rossi@email.com");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private Connection startConnection() throws SQLException{
		if(con==null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setServerName("127.0.0.1");
			dataSource.setPortNumber(3306);
			dataSource.setUser("root");
			dataSource.setPassword("admin");
			dataSource.setDatabaseName("corso_java");
			
			con = dataSource.getConnection();
		}
		return con;
	}
	
	
	private void esempioSelect() throws SQLException{
		
		//String "sql" contiene la query da eseguire
		String sql = "SELECT * FROM utenti";
		
		//restituisce un prepared statement per evitare sql injection
		//passiamo la query in ingresso
		PreparedStatement ps = startConnection().prepareStatement(sql);
		
		//esecuzione della query
		//restituisce un oggetto di tipo ResultSet
		ResultSet rs = ps.executeQuery();
		
		// per prendere tutte le righe trovate iteriamo finchè rs ha righe
		// il while prende l'iesima riga
		while(rs.next()){
			
			// rs.getMetaData().getColumnName(1); //SE volessimo avere info sulle tabelle (nn si userà)
			
			//stampiamo i valori della query
			System.out.println("id: "+rs.getInt(1));
			System.out.println("nome: "+rs.getString(2));
			System.out.println("cognome: "+rs.getString(3));
			System.out.println("email: "+rs.getString(4));
			System.out.println("-----------------");
		}
	}
	
	/*
	 * ExecuteQuery vs ExecuteUpdate:
	 * ExecuteQuery: operazioni di lettura
	 * ExecuteUpdate: per tutte le altre operazioni
	 */
	private void esempioInsert(String nome, String cognome, String email) throws SQLException{
		
		// INSERT INTO tabella (campo1,...,campoN) VALUES ('val1',...,'valN')
		String sql = "INSERT INTO utenti (nome,cognome,email) VALUES ('"+nome+"','"+cognome+"','"+email+"')";
		PreparedStatement ps = startConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// manipolazione sul db (inserimento)
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		//quando inseriamo una riga, il cursore si trova ancora alla posizione prima dell'inserimento
		//il cursore allora si deve spostare di uno
		rs.next();
		System.out.println("id è: "+rs.getInt(1));
		
		
		/*
		 * ResultSet occupa risorse sia nel programma java sia nel database server
		 * manterlo apert occupa memoria e tiene impegnate le risorse del database
		 */
		//rs.close();

		
		//OPPURE
		int affectedRows = ps.executeUpdate();
		if(affectedRows>0) {
			ResultSet rs1 = ps.getGeneratedKeys();
			if(rs.next()){
				System.out.println("id è: "+rs1.getInt(1));	
			}
			else {
				System.out.println("nessuna riga trovata");
			}
		}
	}
	
	
	
	private void esempioUpdate() throws SQLException {
		
		String sql = "UPDATE CLIENTI SET nome='mario' WHERE id=1";
		PreparedStatement ps = startConnection().prepareStatement(sql);
		ps.executeUpdate();
	}
	
	
	private void esempioDelete() throws SQLException {
		
		String sql = "DELETE FROM CLIENTI WHERE id=2";
		PreparedStatement ps = startConnection().prepareStatement(sql);
		ps.executeUpdate();
	}
	
	
	// prevenire attacchi SQL-injection
	private void esempioSelect2(String cognome) throws SQLException {
		
		String sql = "SELECT id, nome, email FROM utenti WHERE cognome = ?";
		PreparedStatement ps = startConnection().prepareStatement(sql);
		//1 perche è è il primo "?"
		ps.setString(1,cognome);
		ps.executeQuery();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("id: "+rs.getInt(1));
		}
		
		rs.close();
	}
	
	
	private void esempioUpdate2() throws SQLException {
		
		String sql = "UPDATE CLIENTI SET nome=? WHERE id=?";
		PreparedStatement ps = startConnection().prepareStatement(sql);
		ps.setString(1,"Luigi");
		ps.setInt(2,2);
		ps.executeUpdate();
		
		ps.close();
	}
	
}
