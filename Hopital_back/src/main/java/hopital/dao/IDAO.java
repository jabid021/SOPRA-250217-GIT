package hopital.dao;import java.util.List;

public interface IDAO<T,K> {

	
	//Pour Windows + Linux
	 String urlBdd = "jdbc:mysql://localhost:3306/hopital";
	 	//Pour Mac
	//static String urlBdd = "jdbc:mysql://localhost:8889/hopital";
	String loginBdd="root";
	String passwordBdd="root";
		
	public List<T> findAll();
	public T findById(K id);
	public void insert(T obj);
	public void update(T obj);
	public void delete(K id);
}
