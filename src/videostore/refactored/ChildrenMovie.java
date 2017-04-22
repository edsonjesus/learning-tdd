package videostore.refactored;

public class ChildrenMovie extends Movie {
	public ChildrenMovie(String title) {
		super(title, Movie.CHILDREN);
	}

	@Override
	public double getAmount(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3)
			thisAmount += (daysRented - 3) * 1.5;
		return thisAmount;
	}
}
