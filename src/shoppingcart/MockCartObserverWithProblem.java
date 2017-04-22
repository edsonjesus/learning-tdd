package shoppingcart;

public class MockCartObserverWithProblem implements CartObserver {

	@Override
	public void addedProduct(String name, int price) {
		throw new RuntimeException("Error simulated at mock.");
	}

	@Override
	public void verifyProductReceipt(String name, int price) {
	}
}
