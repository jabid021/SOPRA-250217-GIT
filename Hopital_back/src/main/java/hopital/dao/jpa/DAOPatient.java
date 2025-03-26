package hopital.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import hopital.context.Singleton;
import hopital.dao.IDAOPatient;
import hopital.model.Patient;

public class DAOPatient implements IDAOPatient {

	@Override
	public List<Patient> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Patient>  patients = em.createQuery("FROM Patient").getResultList();

		em.close();
		return patients;
	}

	@Override
	public Patient findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Patient patient = em.find(Patient.class, id);

		em.close();
		return patient;
	}

	@Override
	public Patient save(Patient patient) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();

		patient = em.merge(patient);

		em.getTransaction().commit();
		em.close();
		return patient;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em=Singleton.getInstance().getEmf().createEntityManager();
		Patient patient = em.find(Patient.class,id);
		em.getTransaction().begin();

		em.remove(patient);

		em.getTransaction().commit();
		em.close();
	}
	

	

	

}
