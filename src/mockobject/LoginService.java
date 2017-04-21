package mockobject;

public class LoginService {

	private UserDAO userDAO;
	
	public void setDAO(UserDAO dao) {
		this.userDAO = dao;
	}
	
	public boolean login(String user, String password) {
		return userDAO.getPassword(user).equals(password);
	}
}
