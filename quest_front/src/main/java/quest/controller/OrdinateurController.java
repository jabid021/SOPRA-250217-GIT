package quest.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Filiere;
import quest.model.Ordinateur;
import quest.model.Stagiaire;

@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("numero")==null) 
		{
			request.setAttribute("ordinateurs", Singleton.getInstance().getDaoOrdinateur().findAll());
			request.setAttribute("stagiaires", Singleton.getInstance().getDaoUtilisateur().findAllStagiaireDisponibles());
			request.getRequestDispatcher("/ordinateurs.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("numero"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("ordinateur", Singleton.getInstance().getDaoOrdinateur().findById(id));
				request.setAttribute("stagiaires", Singleton.getInstance().getDaoUtilisateur().findAllStagiaireDisponibles());
				request.getRequestDispatcher("/updateOrdinateur.jsp").forward(request, response);
			}
			else 
			{
				Singleton.getInstance().getDaoOrdinateur().delete(id);
				response.sendRedirect("ordinateur");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("numero")==null) 
		{
			String marque=request.getParameter("marque");
			int ram = Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire.id"));
			Stagiaire stagiaire = (Stagiaire) Singleton.getInstance().getDaoUtilisateur().findById(idStagiaire);
			
			Ordinateur ordinateur = new Ordinateur(marque,ram,stagiaire);
			
			Singleton.getInstance().getDaoOrdinateur().save(ordinateur);
			response.sendRedirect("ordinateur");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("numero"));
			String marque=request.getParameter("marque");
			int ram = Integer.parseInt(request.getParameter("ram"));
			Integer idStagiaire = Integer.parseInt(request.getParameter("stagiaire.id"));
			Stagiaire stagiaire = (Stagiaire) Singleton.getInstance().getDaoUtilisateur().findById(idStagiaire);
			
			Ordinateur ordinateur = new Ordinateur(id,marque,ram,stagiaire);
	
			Singleton.getInstance().getDaoOrdinateur().save(ordinateur);
			response.sendRedirect("ordinateur");
		}
	}

}
