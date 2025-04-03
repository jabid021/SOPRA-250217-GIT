package hopital.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hopital.context.Singleton;
import hopital.model.Patient;

@WebServlet("/patient")
public class PatientController extends HttpServlet {

	//En mode GET
	/*
		 SI pas d'id => findAll 
		 SI ID => 
		 		Si mot delete => delete
		 		Sinon => findById
	 */

	//En mode POST
	/*SI id ou le mot update 
		  => update
		   Si pas d'id ou le mot insert
		   	=> insert
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")==null) //findAll
		{

		}
		else
		{
			Integer id = Integer.parseInt(request.getParameter("id"));

			if(request.getParameter("delete")==null) //findById
			{
				Patient p = Singleton.getInstance().getDaoPatient().findById(id);
				System.out.println(p);
				request.setAttribute("patient", p);

				request.getRequestDispatcher("/fichePatient.jsp").forward(request, response);
			}
			else //delete
			{
				Singleton.getInstance().getDaoPatient().delete(id);	
			}
		}




	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tache").equals("insert")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id"));
			String prenom = request.getParameter("prenom");
			String nom = request.getParameter("nom");
			
			Patient patient = new Patient(id,nom,prenom);
			Singleton.getInstance().getDaoPatient().save(patient);
		}
		else 
		{
			
		}
	}

}
