package transport.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import transport.context.Singleton;
import transport.model.Passager;

public class DAOPassager implements IDAO<Passager,Integer> {

	@Override
	public List<Passager> findAll() {
		List<Passager> passagers = new ArrayList();
		EntityManager em = null;
		try 
		{
			em=Singleton.getInstance().getEmf().createEntityManager();
			passagers = em.createQuery("FROM Passager").getResultList();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		return passagers;
	}

	@Override
	public Passager findById(Integer id) {
		Passager passager = null;
		EntityManager em = null;
		try 
		{
			em=Singleton.getInstance().getEmf().createEntityManager();
			passager = em.find(Passager.class, id);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		return passager;
	}

	@Override
	public Passager save(Passager passager) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try 
		{
			em=Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			passager = em.merge(passager);
			
			tx.commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			if(tx!=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		
		return passager;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try 
		{
			em=Singleton.getInstance().getEmf().createEntityManager();
			Passager passager = em.find(Passager.class,id);
			tx = em.getTransaction();
			tx.begin();
			
			em.remove(passager);
			
			tx.commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			if(tx!=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
	}

}
