package mockobject;

import static org.junit.Assert.*;

public class MockUserDAO implements UserDAO {

	private String user, password, expected;
	
	@Override
	public String getPassword(String user) {
		this.user = user;
		return password;
	}
	
	public void userExpected(String expected) {
		this.expected = expected;
	}

	public void returnPassword(String password) {
		this.password = password;
	}

	public void checkCalls() {
		assertEquals(user, expected);
	}
}
