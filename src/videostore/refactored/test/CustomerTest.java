package videostore.refactored.test;

import junit.framework.TestCase;
import videostore.*;
import videostore.refactored.Customer;
import videostore.refactored.Movie;
import videostore.refactored.Rental;

public class CustomerTest extends TestCase {
	
	Customer client;

	protected void setUp() throws Exception {
		client = new Customer("João");
	}
	
	public void testNameCreation(){
		String result = client.statement();
		assertContain(result,"Rental Record for João");
	}
	
	public void testOneRegularOneDay(){
		rentMovie("Indiana Jones",Movie.REGULAR,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 2.0");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneRegularTreeDays(){
		rentMovie("Indiana Jones",Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneChildrensOneDay(){
		rentMovie("Procurando Nemo",Movie.CHILDREN,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 1.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneChildrensFiveDays(){
		rentMovie("Procurando Nemo",Movie.CHILDREN,5);
		String result = client.statement();
		assertContain(result,"Amount owed is 4.5");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneNewReleaseOneDay(){
		rentMovie("Homem Aranha 2",Movie.NEW_RELEASE,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.0");
		assertContain(result,"You earned 1 frequent renter points");
	}
	
	public void testOneNewReleaseTreeDays(){
		rentMovie("Homem Aranha 2",Movie.NEW_RELEASE,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 9.0");
		assertContain(result,"You earned 2 frequent renter points");
	}
	
	public void testManyRents(){
		rentMovie("Homem Aranha 2",Movie.NEW_RELEASE,2);
		rentMovie("Troia",Movie.NEW_RELEASE,3);
		rentMovie("Procurando Nemo",Movie.CHILDREN,3);
		rentMovie("Indiana Jones",Movie.REGULAR,2);
		rentMovie("Rei Leão",Movie.CHILDREN,4);
		rentMovie("E o vento levou...",Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 25.0");
		assertContain(result,"You earned 8 frequent renter points");
	}
	
	private void rentMovie(String title, int type, int days) {
		Movie movie = Movie.createMovie(title, type);
		Rental rent = new Rental(movie,days);
		client.addRental(rent);
	}

	private void assertContain(String result, String content) {
		assertTrue(result.indexOf(content)>=0);
	}
}
