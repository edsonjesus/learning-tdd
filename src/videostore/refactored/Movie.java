package videostore.refactored;

public abstract class Movie {
	
	public static final int CHILDREN = 2;

	public static final int REGULAR = 0;

	public static final int NEW_RELEASE = 1;

	private String _title;

	private int _priceCode;

	public static Movie createMovie(String title, int priceCode) {
		if(priceCode == Movie.REGULAR)
			return new RegularMovie(title);
		
		if(priceCode == Movie.CHILDREN)
			return new ChildrenMovie(title);
		
		if(priceCode == Movie.NEW_RELEASE)
			return new NewReleaseMovie(title);
		
		throw new RuntimeException("There isn't movies for this type.");
	}
	
	protected Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int priceCode) {
		_priceCode = priceCode;
	}

	public String getTitle() {
		return _title;
	}

	public abstract double getAmount(int daysRented);
	
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
}