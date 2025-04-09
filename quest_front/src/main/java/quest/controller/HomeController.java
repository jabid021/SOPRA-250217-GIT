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
import quest.model.Admin;
import quest.model.Formateur;
import quest.model.Stagiaire;
import quest.model.Utilisateur;

@WebServlet("/home")
public class HomeController extends HttpServlet {

	public void init(ServletConfig config) throws ServletException
	 {
	 super.init(config);
	 SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	 }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("deconnecter")!=null) 
		{
			request.getSession().invalidate();
		}
		
		if(request.getSession().getAttribute("connected")==null) 
		{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else
		{
			Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("connected");
			
			if(utilisateur instanceof Admin) 
			{
			request.getRequestDispatcher("/menuAdmin.jsp").forward(request, response);
			}
			else if(utilisateur instanceof Stagiaire) 
			{
			request.getRequestDispatcher("/menuStagiaire.jsp").forward(request, response);
			}
			else if(utilisateur instanceof Formateur) 
			{
			request.getRequestDispatcher("/menuFormateur.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		IDAOUtilisateur daoUtilisateur = ctx.getBean(IDAOUtilisateur.class);
		String login=request.getParameter("login");
		String password = request.getParameter("password");
		Utilisateur utilisateur = daoUtilisateur.findByLoginAndPassword(login, password);
		if(utilisateur == null) 
		{
			request.setAttribute("error", "IDENTIFIANTS INVALIDES");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else 
		{
			request.getSession().setAttribute("connected", utilisateur);
			response.sendRedirect("home");
		}	
	}
	


}
