package shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Product> listProducts = new ArrayList<>();
	List<CartObserver> listObservers = new ArrayList<>();

	public void addProduct(Product product) {
		listProducts.add(product);

		for (CartObserver observer : listObservers) {
			try {
				observer.addedProduct(product.getName(), product.getPrice());
			} catch (Exception e) {}
		}
	}

	public int total() {
		int total = 0;
		for (Product product : listProducts)
			total += product.getPrice();
		return total;
	}

	public void addObserver(CartObserver observer) {
		listObservers.add(observer);
	}

}
