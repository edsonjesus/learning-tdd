package shoppingcart;

public interface CartObserver {
	public void addedProduct(String name, int price);

	void verifyProductReceipt(String name, int price);
}
