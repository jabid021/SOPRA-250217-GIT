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
import quest.model.Matiere;
import quest.model.Module;

@WebServlet("/module")
public class ModuleController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("id")==null) 
		{
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Filiere filiere = Singleton.getInstance().getDaoFiliere().findByIdWithModules(idFiliere);
			request.setAttribute("filiere", filiere);
			request.setAttribute("matieres", Singleton.getInstance().getMatiereService().getAll());
			request.getRequestDispatcher("/modules.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("module", Singleton.getInstance().getDaoModule().findById(id));
				request.setAttribute("matieres", Singleton.getInstance().getMatiereService().getAll());
				request.getRequestDispatcher("/updateModule.jsp").forward(request, response);
			}
			else 
			{
				Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
				Singleton.getInstance().getDaoModule().delete(id);
				response.sendRedirect("module?filiere="+idFiliere);
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(idFiliere);
			Integer idMatiere = Integer.parseInt(request.getParameter("matiere.id"));
			Matiere matiere = Singleton.getInstance().getMatiereService().getById(idMatiere);
			Integer duree = Integer.parseInt(request.getParameter("duree"));
			Integer quest = Integer.parseInt(request.getParameter("quest"));
			
			Module module = new Module(quest, duree,filiere,matiere);
			Singleton.getInstance().getDaoModule().save(module);
			response.sendRedirect("module?filiere="+idFiliere);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = Singleton.getInstance().getDaoFiliere().findById(idFiliere);
			Integer idMatiere = Integer.parseInt(request.getParameter("matiere.id"));
			Matiere matiere = Singleton.getInstance().getMatiereService().getById(idMatiere);
			Integer duree = Integer.parseInt(request.getParameter("duree"));
			Integer quest = Integer.parseInt(request.getParameter("quest"));
			
			Module module = new Module(id,quest, duree,filiere,matiere);
			Singleton.getInstance().getDaoModule().save(module);
			response.sendRedirect("module?filiere="+idFiliere);
		}
	}

}
