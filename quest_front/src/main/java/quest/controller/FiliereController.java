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

@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			request.setAttribute("filieres", Singleton.getInstance().getDaoFiliere().findAll());
			request.getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("filiere", Singleton.getInstance().getDaoFiliere().findById(id));
				request.getRequestDispatcher("/WEB-INF/updateFiliere.jsp").forward(request, response);
			}
			else 
			{
				Singleton.getInstance().getDaoFiliere().delete(id);
				response.sendRedirect("filiere");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			LocalDate debut = LocalDate.parse(request.getParameter("debut"));
			LocalDate fin = LocalDate.parse(request.getParameter("fin"));
			
			Filiere filiere = new Filiere(libelle, debut, fin);
			Singleton.getInstance().getDaoFiliere().save(filiere);
			response.sendRedirect("filiere");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			LocalDate debut = LocalDate.parse(request.getParameter("debut"));
			LocalDate fin = LocalDate.parse(request.getParameter("fin"));
			
			Filiere filiere = new Filiere(id,libelle, debut, fin);
			Singleton.getInstance().getDaoFiliere().save(filiere);
			response.sendRedirect("filiere");
		}
	}

}
