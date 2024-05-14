package it.filippo.registration.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.MysqlDataSource;
import it.filippo.registration.model.Employee;

public class EmployeeDAO {
	

	private static final String SERVER_NAME = "localhost";
	private static final int PORT_NUMBER = 3306;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	private static final String DB_NAME = "login_db_servlet";
	private static Connection con;


	//start connection:
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
	
	//stop connection:
	public static void stopConnection() throws SQLException{
		if (con != null) {
			con.close();
		}
	}
	
	
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
	
	
	public void createTableEmployees(String dbName) throws SQLException {
		createDb(DB_NAME);
		
	    String sql = "CREATE TABLE IF NOT EXISTS employees (" +
	                 "id INT PRIMARY KEY AUTO_INCREMENT NOT NULL," +
	                 "first_name VARCHAR(255)," +
	                 "last_name VARCHAR(255)," +
	                 "username VARCHAR(255)," +
	                 "password VARCHAR(255)," +
	                 "email VARCHAR(255)" +
	                 ");";
	    
	    PreparedStatement ps = startConnection(dbName).prepareStatement(sql);
	    ps.executeUpdate();
	    ps.close();
	}
	

	
	public int registerEmployee(Employee employee) throws ClassNotFoundException, SQLException{
		//la crea se non esiste
		createTableEmployees(DB_NAME);
		
		String sql = "INSERT INTO employees "+
					 "(first_name, last_name, username, password, email) VALUES "+
					 "(?,?,?,?,?)";
		
		PreparedStatement ps = startConnection(DB_NAME).prepareStatement(sql);
		ps.setString(1, employee.getFirstName());
		ps.setString(2, employee.getLastName());
		ps.setString(3, employee.getUsername());
		ps.setString(4, employee.getPassword());
		ps.setString(5, employee.getEmail());
		int result = ps.executeUpdate();
		ps.close();
		stopConnection();
		return result;
	}
	
	
	public List<Employee> getAllEmployees() throws SQLException{
		String sql = "SELECT * FROM employees";
		PreparedStatement ps = startConnection(DB_NAME).prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<Employee> employeesList = new ArrayList<>();
		while(rs.next()){ //colonne: (id, first_name, last_name, username, password, email)
			Employee employee = new Employee();
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String address = rs.getString("email");
			
			employee.setId(id);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setUsername(username);
			employee.setPassword(password);
			employee.setEmail(address);
			employeesList.add(employee);
		}
			return employeesList;
	}
	
	
	
	
}
