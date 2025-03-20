package hopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hopital.context.Singleton;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Visite;

public class DAOVisite implements IDAO<Visite,Integer> {

	@Override
	public List<Visite> findAll() {
		List<Visite> visites = new ArrayList();
		Visite visite = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite");

			ResultSet rs =  ps.executeQuery();
			while(rs.next()) 
			{
				Patient patient = Singleton.getInstance().getDaoPatient().findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) Singleton.getInstance().getDaoCompte().findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,rs.getDouble("prix"),rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")));
				visites.add(visite);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return visites;
	}

	@Override
	public Visite findById(Integer id) {
		Visite visite = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where numero=?");
			ps.setInt(1, id);

			ResultSet rs =  ps.executeQuery();
			while(rs.next()) 
			{
				Patient patient = Singleton.getInstance().getDaoPatient().findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) Singleton.getInstance().getDaoCompte().findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("1"),patient,medecin,rs.getDouble("prix"),rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")));
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return visite;
	}

	@Override
	public void insert(Visite visite) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO visite (id_patient,id_medecin,prix,salle,date_visite) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, visite.getPatient().getId());
			ps.setInt(2, visite.getMedecin().getId());
			ps.setDouble(3, visite.getPrix());
			ps.setInt(4, visite.getSalle());
			ps.setString(5, visite.getDateVisite().toString());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) 
			{
				visite.setId(rs.getInt(1));
			}
			
			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(Visite visite) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE visite set id_patient=?,id_medecin=?,prix=?,salle=?,date_visite=? where numero=?");
			ps.setInt(1, visite.getPatient().getId());
			ps.setInt(2, visite.getMedecin().getId());
			ps.setDouble(3, visite.getPrix());
			ps.setInt(4, visite.getSalle());
			ps.setString(5, visite.getDateVisite().toString());
			ps.setInt(6, visite.getId());
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("DELETE FROM visite where numero=?");
			ps.setInt(1,id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	public List<Visite> findByPatient(Integer idPatient)
	{
		List<Visite> visites = new ArrayList();
		Visite visite = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from visite where id_patient=?");
			ps.setInt(1, idPatient);
	
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) 
			{
				Patient patient = Singleton.getInstance().getDaoPatient().findById(rs.getInt("id_patient"));
				Medecin medecin = (Medecin) Singleton.getInstance().getDaoCompte().findById(rs.getInt("id_medecin"));
				visite = new Visite(rs.getInt("numero"),patient,medecin,rs.getDouble("prix"),rs.getInt("salle"),LocalDate.parse(rs.getString("date_visite")));
				visites.add(visite);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return visites;
	}

}
