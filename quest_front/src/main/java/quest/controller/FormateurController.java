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
import quest.dao.IDAOUtilisateur;
import quest.model.Formateur;
import quest.model.Genre;

@WebServlet("/formateur")
public class FormateurController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException
	 {
	 super.init(config);
	 SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);
		if(request.getParameter("id")==null) 
		{
			request.setAttribute("formateurs", daoUtilisateur.findAllFormateur());
			request.setAttribute("genres", Genre.values());
			request.getRequestDispatcher("/WEB-INF/formateurs.jsp").forward(request, response);
		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) 
			{
				request.setAttribute("formateur", daoUtilisateur.findById(id).get());
				request.setAttribute("genres", Genre.values());
				request.getRequestDispatcher("/WEB-INF/updateFormateur.jsp").forward(request, response);
			}
			else 
			{
				daoUtilisateur.deleteById(id);
				response.sendRedirect("formateur");
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);
		if(request.getParameter("id")==null) 
		{
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Genre civilite = Genre.valueOf(request.getParameter("genre"));
			
			Formateur formateur = new Formateur(login,password,nom,prenom,civilite);
			daoUtilisateur.save(formateur);
		
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
			daoUtilisateur.save(formateur);
		
			response.sendRedirect("formateur");
		}
	}

}
