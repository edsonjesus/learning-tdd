package videostore.refactored;

public class NewReleaseMovie extends Movie {
	public NewReleaseMovie(String title) {
		super(title, Movie.NEW_RELEASE);
	}

	@Override
	public double getAmount(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		if (daysRented > 1)
			return 2;
		return 1;
	}
}
