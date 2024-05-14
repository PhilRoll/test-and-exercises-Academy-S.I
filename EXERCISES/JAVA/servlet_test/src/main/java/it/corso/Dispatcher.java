package it.corso;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Dispatcher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina =  request.getParameter("pagina");
		response.setContentType("text/html");
		if(pagina.equals("1")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/pagina1.jsp");
			dispatcher.include(request, response);
		}
		if(pagina.equals("2")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/pagina2.jsp");
			dispatcher.include(request, response);
		}
		if(pagina.equals("3")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/pagina3.jsp");
			dispatcher.include(request, response);
		}
		else {
			response.getWriter().println("Pagina non trovata");
		}
		
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
