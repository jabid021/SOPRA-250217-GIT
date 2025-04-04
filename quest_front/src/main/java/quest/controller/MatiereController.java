package quest.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quest.context.Singleton;
import quest.model.Matiere;
import quest.model.Formateur;
import quest.model.Genre;

@WebServlet("/matiere")
public class MatiereController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) 
		{
			request.setAttribute("matieres", Singleton.getInstance().getMatiereService().getAll());
			request.getRequestDispatcher("/matieres.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("matiere", Singleton.getInstance().getMatiereService().getById(id));
				request.getRequestDispatcher("/updateMatiere.jsp").forward(request, response);
			}
			else 
			{
				Singleton.getInstance().getMatiereService().deleteById(id);
				response.sendRedirect("matiere");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			Matiere matiere = new Matiere(libelle);
			Singleton.getInstance().getMatiereService().create(matiere);
			response.sendRedirect("matiere");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			Matiere matiere = new Matiere(id,libelle);
			Singleton.getInstance().getMatiereService().update(matiere);
			response.sendRedirect("matiere");
		}
	}
}
