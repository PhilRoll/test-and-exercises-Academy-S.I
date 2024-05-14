package it.filippo.registration.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.filippo.registration.dao.EmployeeDAO;
import it.filippo.registration.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/showEmployees")
public class ShowEmployeesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDao = new EmployeeDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Simulazione di un elenco di oggetti Employee
        List<Employee> employeesList;
		try {
			employeesList = employeeDao.getAllEmployees();
			// Imposta l'elenco degli employee come attributo nella richiesta
	        request.setAttribute("employeeList", employeesList);
	        // Inoltro alla pagina JSP per la visualizzazione
	        request.getRequestDispatcher("/listEmployees.jsp").forward(request, response);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    }
}