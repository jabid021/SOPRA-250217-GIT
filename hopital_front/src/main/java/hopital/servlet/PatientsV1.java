package hopital.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hopital.context.Singleton;
import hopital.model.Patient;

//@WebServlet("/patients")
public class PatientsV1 extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		List<Patient> patients = Singleton.getInstance().getDaoPatient().findAll();

		
		response.getWriter().println("<html>");
		response.getWriter().println("<h1>Liste des patients</h1>");
		
		response.getWriter().println("<table>");
		
		response.getWriter().println("<tr><th>ID</th><th>Nom</th><th>Prenom</th></tr>");
		
		for(Patient p : patients) 
		{
			response.getWriter().println("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrenom()+"</td></tr>");
		}
		response.getWriter().println("</table>");
		response.getWriter().println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
