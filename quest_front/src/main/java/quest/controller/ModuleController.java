package quest.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import quest.config.AppConfig;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOModule;
import quest.model.Filiere;
import quest.model.Matiere;
import quest.model.Module;
import quest.service.MatiereService;

@WebServlet("/module")
public class ModuleController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException
	 {
	 super.init(config);
	 SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOModule daoModule = ctx.getBean(IDAOModule.class);
		MatiereService matiereService = ctx.getBean(MatiereService.class);
		IDAOFiliere daoFiliere = ctx.getBean(IDAOFiliere.class);
		if(request.getParameter("id")==null) 
		{
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
			Filiere filiere = daoFiliere.findByIdWithModules(idFiliere);
			request.setAttribute("filiere", filiere);
			request.setAttribute("matieres", matiereService.getAll());
			request.getRequestDispatcher("/WEB-INF/modules.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("module", daoModule.findById(id).get());
				request.setAttribute("matieres", matiereService.getAll());
				request.getRequestDispatcher("/WEB-INF/updateModule.jsp").forward(request, response);
			}
			else 
			{
				Integer idFiliere = Integer.parseInt(request.getParameter("filiere"));
				daoModule.deleteById(id);
				response.sendRedirect("module?filiere="+idFiliere);
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOModule daoModule = ctx.getBean(IDAOModule.class);
		MatiereService matiereService = ctx.getBean(MatiereService.class);
		IDAOFiliere daoFiliere = ctx.getBean(IDAOFiliere.class);
		if(request.getParameter("id")==null) 
		{
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = daoFiliere.findById(idFiliere).get();
			Integer idMatiere = Integer.parseInt(request.getParameter("matiere.id"));
			Matiere matiere = matiereService.getById(idMatiere);
			Integer duree = Integer.parseInt(request.getParameter("duree"));
			Integer quest = Integer.parseInt(request.getParameter("quest"));
			
			Module module = new Module(quest, duree,filiere,matiere);
			daoModule.save(module);
			response.sendRedirect("module?filiere="+idFiliere);
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			Integer idFiliere = Integer.parseInt(request.getParameter("filiere.id"));
			Filiere filiere = daoFiliere.findById(idFiliere).get();
			Integer idMatiere = Integer.parseInt(request.getParameter("matiere.id"));
			Matiere matiere = matiereService.getById(idMatiere);
			Integer duree = Integer.parseInt(request.getParameter("duree"));
			Integer quest = Integer.parseInt(request.getParameter("quest"));
			
			Module module = new Module(id,quest, duree,filiere,matiere);
			daoModule.save(module);
			response.sendRedirect("module?filiere="+idFiliere);
		}
	}

}
