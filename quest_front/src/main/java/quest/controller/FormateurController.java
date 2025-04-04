package quest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Formateur;
import quest.model.Genre;

@WebServlet("/formateur")
public class FormateurController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			request.setAttribute("formateurs", Singleton.getInstance().getDaoUtilisateur().findAllFormateur());
			request.setAttribute("genres", Genre.values());
			request.getRequestDispatcher("/formateurs.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("formateur", Singleton.getInstance().getDaoUtilisateur().findById(id));
				request.setAttribute("genres", Genre.values());
				request.getRequestDispatcher("/updateFormateur.jsp").forward(request, response);
			}
			else 
			{
				Singleton.getInstance().getDaoUtilisateur().delete(id);
				response.sendRedirect("formateur");
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
			
			Formateur formateur = new Formateur(login,password,nom,prenom,civilite);
			Singleton.getInstance().getDaoUtilisateur().save(formateur);
		
			response.sendRedirect("formateur");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Genre civilite = Genre.valueOf(request.getParameter("genre"));
			
			Formateur formateur = new Formateur(id,login,password,nom,prenom,civilite);
			Singleton.getInstance().getDaoUtilisateur().save(formateur);
		
			response.sendRedirect("formateur");
		}
	}

}
