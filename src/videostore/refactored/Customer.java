package videostore.refactored;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String name;
	private Vector rentals = new Vector();
	private int frequentRenterPoints;
	private double totalAmount;

	public Customer(String name) {
		this.name = name;
	};

	public void addRental(Rental rental) {
		rentals.addElement(rental);
		totalAmount += rental.getAmount();
		frequentRenterPoints += rental.getFrequentRenterPoints();
	}

	public String getName() {
		return name;
	}

	private double getTotalAmount() {
		return totalAmount;
	}

	private int getTotalFrequentRenterPoints() {
		return frequentRenterPoints;
	}
	
	public String statement() {
		Enumeration rentalsEnum = rentals.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (rentalsEnum.hasMoreElements()) {
			Rental each = (Rental) rentalsEnum.nextElement();
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getAmount()) + "\n";
		}
		
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}
}