package quest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Filiere;
import quest.model.Genre;
import quest.model.Stagiaire;

@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			request.setAttribute("stagiaires", Singleton.getInstance().getDaoUtilisateur().findAllStagiaire());
			request.setAttribute("filieres", Singleton.getInstance().getDaoFiliere().findAll());
			request.setAttribute("genres", Genre.values());
			request.getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("stagiaire", Singleton.getInstance().getDaoUtilisateur().findById(id));
				request.setAttribute("filieres", Singleton.getInstance().getDaoFiliere().findAll());
				request.setAttribute("genres", Genre.values());
				request.getRequestDispatcher("/WEB-INF/updateStagiaire.jsp").forward(request, response);
			}
			else 
			{
				Singleton.getInstance().getDaoUtilisateur().delete(id);
				response.sendRedirect("stagiaire");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Genre civilite = Genre.valueOf(request.getParameter("genre"));
			String email = request.getParameter("email");
			String numero = request.getParameter("adresse.numero");
			String voie = request.getParameter("adresse.voie");
			String ville = request.getParameter("adresse.ville");
			String cp = request.getParameter("adresse.cp");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(idFiliere);
			Stagiaire stagiaire = new Stagiaire(login, password, nom, prenom, civilite, email, numero, voie, ville, cp, filiere);
			Singleton.getInstance().getDaoUtilisateur().save(stagiaire);
			
			response.sendRedirect("stagiaire");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Genre civilite = Genre.valueOf(request.getParameter("genre"));
			String email = request.getParameter("email");
			String numero = request.getParameter("adresse.numero");
			String voie = request.getParameter("adresse.voie");
			String ville = request.getParameter("adresse.ville");
			String cp = request.getParameter("adresse.cp");
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(idFiliere);
			Stagiaire stagiaire = new Stagiaire(id,login, password, nom, prenom, civilite, email, numero, voie, ville, cp, filiere);
			Singleton.getInstance().getDaoUtilisateur().save(stagiaire);
		
			response.sendRedirect("stagiaire");
		}
	}

}
