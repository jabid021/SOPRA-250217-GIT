package hopital.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Secretaire;

public class DAOCompte implements IDAO<Compte,Integer> {

	@Override
	public List<Compte> findAll() {
		List<Compte> comptes = new ArrayList();
		Compte compte = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");
	
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin")) {
					compte = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else 
				{
					compte = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				
				comptes.add(compte);
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return comptes;
	}

	@Override
	public Compte findById(Integer id) {
		Compte compte = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1,id);
	
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin")) {
					compte = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else 
				{
					compte = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return compte;
	}

	@Override
	public void insert(Compte compte) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,type_compte) VALUES (?,?,?)");
			ps.setString(1, compte.getLogin());
			ps.setString(2, compte.getPassword());
			ps.setString(3, compte.getClass().getSimpleName());

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
	public void update(Compte compte) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("UPDATE compte set login=?,password=?,type_compte=? where id=?");
			ps.setString(1, compte.getLogin());
			ps.setString(2, compte.getPassword());
			ps.setString(3, compte.getClass().getSimpleName());
			ps.setInt(4, compte.getId());
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
			PreparedStatement ps = conn.prepareStatement("DELETE FROM compte where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public Compte findByLoginAndPassword(String login,String password) 
	{
		Compte compte = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(urlBdd,loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1,login);
			ps.setString(2, password);
	
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Medecin")) {
					compte = new Medecin(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
				else 
				{
					compte = new Secretaire(rs.getInt("id"),rs.getString("login"),rs.getString("password"));
				}
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return compte;
	}

}
