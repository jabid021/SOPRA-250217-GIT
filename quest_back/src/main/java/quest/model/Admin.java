package quest.model;

public class Admin extends Utilisateur {

	public Admin(Integer id, String login, String password) {
		super(id, login, password);
	}
	
	public Admin(String login, String password) {
		super(login, password);
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", login=" + login + ", password=" + password + "]";
	}



}