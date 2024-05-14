package it.corso;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


public class SpiegazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SpiegazioneServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//stampa "  -il metodo e'¨:GET /servlet_test"
		response.getWriter().append(" "+" - il metodo e':" +request.getMethod()).append(" "+request.getContextPath());
		response.getWriter().append(" "+"- l'ora locale e': "+request.getLocale());
		response.getWriter().append(" " + "- l'host e':"+ request.getHeader("host"));
		response.getWriter().append(" " + "- Lo User-agent e':"+ request.getHeader("User-agent"));
		response.getWriter().append(" " + "- i cookies sono:"+ request.getCookies());
		
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()){
			String element = en.nextElement();
			response.getWriter().append(" - "+ element + ":" + request.getHeader(element));
		}
		
		
		response.getWriter().append("\n\n" + "- queryString:"+ request.getQueryString());
	}


	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	

}
