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
import quest.model.Matiere;
import quest.service.MatiereService;

@WebServlet("/matiere")
public class MatiereController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException
	 {
	 super.init(config);
	 SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MatiereService matiereService = ctx.getBean(MatiereService.class);
		if(request.getParameter("id")==null) 
		{
			request.setAttribute("matieres", matiereService.getAll());
			request.getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("matiere", matiereService.getById(id));
				request.getRequestDispatcher("/WEB-INF/updateMatiere.jsp").forward(request, response);
			}
			else 
			{
				matiereService.deleteById(id);
				response.sendRedirect("matiere");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MatiereService matiereService = ctx.getBean(MatiereService.class);
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			Matiere matiere = new Matiere(libelle);
			matiereService.create(matiere);
			response.sendRedirect("matiere");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			Matiere matiere = new Matiere(id,libelle);
			matiereService.update(matiere);
			response.sendRedirect("matiere");
		}
	}
}
