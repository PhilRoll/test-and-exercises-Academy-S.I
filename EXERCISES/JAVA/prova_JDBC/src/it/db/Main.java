package it.db;

import java.time.LocalDate;
import java.util.Date;
import java.sql.SQLException;

public class Main {
	//main
	public static void main(String[] args) {
		DbTest2 test = new DbTest2();
		String dbName = "test2_jdbc";
		try {
			test.createDb(dbName);
			test.createTableUtente(dbName);
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
			test.insertLibro(dbName,5, "pascal", "wirth");
			//inserimento dei prestiti
			test.insertPrestito(dbName, 1, 1, 3, new String("2023-04-16"), null);
			test.insertPrestito(dbName, 2, 4, 1, new String("2023-04-16"), null);
			test.insertPrestito(dbName, 3, 4, 2, new String("2023-05-16"), null);
			test.insertPrestito(dbName, 4, 4, 3, new String("2023-06-16"), null);
			test.insertPrestito(dbName, 5, 2, 4, new String("2023-04-16"), new String("2024-04-16"));
			test.insertPrestito(dbName, 6, 2, 5, new String("2023-04-16"), new String("2024-04-16"));
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

}
