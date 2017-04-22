package shoppingcart;

import static org.junit.Assert.*;

public class MockCartObserver implements CartObserver {

	private String nameReceipted;
	private int priceReceipted;
	
	@Override
	public void addedProduct(String name, int price) {
		nameReceipted = name;
		priceReceipted = price;
	}

	@Override
	public void verifyProductReceipt(String expectedName, int expectedPrice) {
		assertEquals(expectedName, nameReceipted);
		assertEquals(expectedPrice, priceReceipted);
	}
}
