package shoppingcart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {
	private ShoppingCart cart;

	@Before
	public void initEnvironment() {
		cart = new ShoppingCart();
	}

	@Test
	public void totalCarrinho() {
		cart.addProduct(new Product("T-Shirt", 10));
		cart.addProduct(new Product("Dress", 40));
		cart.addProduct(new Product("Short", 60));
		assertEquals(110, cart.total());
	}

	@Test
	public void observerProductAddition() {
		MockCartObserver mock = new MockCartObserver();
		String name = "Shirt";
		int price = 30;
		cart.addObserver(mock);
		cart.addProduct(new Product("Shirt", 30));
		mock.verifyProductReceipt(name, price);
	}
	
	@Test
	public void addTwoObservers() {
		MockCartObserver mock1 = new MockCartObserver();
		MockCartObserver mock2 = new MockCartObserver();
		
		String name = "Shirt";
		int price = 30;
		
		cart.addObserver(mock1);
		cart.addObserver(mock2);
		
		cart.addProduct(new Product(name, price));
		mock1.verifyProductReceipt(name, price);
		mock2.verifyProductReceipt(name, price);
	}
	
	@Test
	public void continueRunningAfterBugInObserver() {
		MockCartObserver mock1 = new MockCartObserver();
		CartObserver mock2 = new MockCartObserverWithProblem();
		MockCartObserver mock3 = new MockCartObserver();
		
		String name = "Shirt";
		int price = 30;
		
		cart.addObserver(mock1);
		cart.addObserver(mock2);
		cart.addObserver(mock3);
		
		cart.addProduct(new Product(name, price));
		mock1.verifyProductReceipt(name, price);
		mock3.verifyProductReceipt(name, price);
	}
}
