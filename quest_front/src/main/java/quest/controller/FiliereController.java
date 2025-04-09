package quest.controller;

import java.io.IOException;
import java.time.LocalDate;

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
import quest.model.Filiere;

@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException
	 {
	 super.init(config);
	 SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOFiliere daoFiliere = ctx.getBean(IDAOFiliere.class);
		if(request.getParameter("id")==null) 
		{
			request.setAttribute("filieres", daoFiliere.findAll());
			request.getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("filiere", daoFiliere.findById(id).get());
				request.getRequestDispatcher("/WEB-INF/updateFiliere.jsp").forward(request, response);
			}
			else 
			{
				daoFiliere.deleteById(id);
				response.sendRedirect("filiere");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOFiliere daoFiliere = ctx.getBean(IDAOFiliere.class);
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			LocalDate debut = LocalDate.parse(request.getParameter("debut"));
			LocalDate fin = LocalDate.parse(request.getParameter("fin"));
			
			Filiere filiere = new Filiere(libelle, debut, fin);
			daoFiliere.save(filiere);
			response.sendRedirect("filiere");
		}
		else 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			LocalDate debut = LocalDate.parse(request.getParameter("debut"));
			LocalDate fin = LocalDate.parse(request.getParameter("fin"));
			
			Filiere filiere = new Filiere(id,libelle, debut, fin);
			daoFiliere.save(filiere);
			response.sendRedirect("filiere");
		}
	}

}
