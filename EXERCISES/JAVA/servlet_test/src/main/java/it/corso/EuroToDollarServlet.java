package it.corso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class EuroToDollarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EuroToDollarServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String euro =  request.getParameter("euro");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<title>Conversione Euro-Dollaro</title>");
		out.println("<body>");
		out.println("<h1>Conversione Euro-Dollaro</h1>");
		try {
			if (euro == null || euro.isEmpty()) {
		        out.println("<p>Errore: Parametro 'euro' mancante</p>");
		        }
			else {
				double tassoDiCambio = 1.22;// da euro a dollaro 
				out.println("<p>"+euro+" Euro = "+Double.parseDouble(euro)*tassoDiCambio+" Dollari</p>");
			}
		} catch (NumberFormatException e) {
			out.println("<p>Errore: inserisci un numero valido</p>");
		}
		finally {
			out.println("</body>");
		    out.println("</html>");	
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
