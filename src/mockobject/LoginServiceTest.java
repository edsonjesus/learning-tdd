package mockobject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoginServiceTest {

	private LoginService serv;
	private MockUserDAO mock;
	
	@Before
	public void initEnvironment() {
		serv = new LoginService();
		mock = new MockUserDAO();
	}
	
	@Test
	public void loginWithSuccess() {
		serv.setDAO(mock);
		mock.userExpected("jesus");
		mock.returnPassword("password");
		assertTrue(serv.login("jesus", "password"));
		mock.checkCalls();
	}

	@Test
	public void loginWithError() {
		serv.setDAO(mock);
		mock.userExpected("jesus");
		mock.returnPassword("password");
		assertFalse(serv.login("jesus", "other_password"));
		mock.checkCalls();
	}
}
