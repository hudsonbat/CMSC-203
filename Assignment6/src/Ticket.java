/**
 * This program demonstrates the abstract Ticket superclass. This class represents a ticket class 
 * and contains attributes that are necessary to describe a movie and the movie patron, methods that
 * are necessary to set and get the aforementioned attributes, as well as three abstract methods  
 * that must be implemented by subclasses that extend the Ticket class.
 * @author hudson
 */
public abstract class Ticket {
	
	public static enum Format{IMAX,THREE_D,NONE}
	
	private Format f;
	private final double tax = 0.096;
	private int time;
	private String rating;
	private String type;
	private int id;
	private String movieName;
	private int date;
	private int numVisits;
	private String feature;
	private double ticketPrice;
	private int numThisMovie;
	private int numMoviesToday;
	
	/**
	 * This constructor accepts a movieName, rating, date, time, and feature as parameters and assigns 
	 * the parameter variables to the corresponding attributes. It also determines the enumerated format 
	 * based on the string feature variable.
	 * @param movieName The name of the movie.
	 * @param rating The rating of the movie.
	 * @param date The date the movie was seen.
	 * @param time The time the movie was seen.
	 * @param f The feature of the movie.
	 */
	
	public Ticket(String movieName, String rating, int date, int time, String f) {
		this.movieName = movieName;
		this.date = date;
		this.time = time;
		this.rating = rating;
		this.feature = f;
		
		if(f.equals("IMAX")) {
			this.f = Ticket.Format.IMAX;
		}else if (f.equals("3D")) {
			this.f = Ticket.Format.THREE_D;
		}else {
			this.f = Ticket.Format.NONE;
		}
	}
	
	/**
	 * This method accepts a String variable that represents the
	 * feature of the movie as a parameter and assigns its value to the 
	 * feature attribute.
	 * @param feature The feature of the movie.
	 */
	
	public void setFeature(String feature) {
		this.feature = feature;
	}
	
	/**
	 * This method returns the feature of the movie.
	 * @return The feature of the movie.
	 */
	
	public String getFeature() {
		return feature;
	}
	
	/**
	 * This method returns the type of movie patron.
	 * @return The type of movie patron.
	 */
	
	public String getType() {
		return type;
	}
	
	/**
	 * This method accepts a String variable that represents the type
	 * of movie patron as a parameter and assigns its value to the 
	 * type attribute.
	 * @param type The type of movie patron.
	 */

	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * This method accepts an integer variable that represents the id of 
	 * a movie patron as a parameter and assigns its value to the id attribute.
	 * @param id The id of the movie patron.
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * This method returns the tax rate.
	 * @return The tax rate.
	 */
	
	public double getTax() {
		return tax;
	}
	
	/**
	 * This method returns the name of the movie.
	 * @return The name of the movie.
	 */
	
	public String getMovieName() {
		return movieName;
	}
	
	/**
	 * This method accepts a String variable that represents the name
	 * of a movie as a parameter and assigns its value to the movieName 
	 * attribute.
	 * @param movieName The name of the movie.
	 */

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	/**
	 * This method returns the date the movie was seen.
	 * @return The date the movie was seen.
	 */

	public int getDate() {
		return date;
	}
	
	/**
	 * This method accepts an integer variable that represents the date
	 * a movie was seen as a parameter and assigns its value to the date 
	 * attribute.
	 * @param date The date the movie was seen.
	 */

	public void setDate(int date) {
		this.date = date;
	}
	
	/**
	 * This method returns the time the movie was seen.
	 * @return The time the movie was seen.
	 */

	public int getTime() {
		return time;
	}
	
	/**
	 * This method accepts an integer variable that represents the time
	 * a movie was seen and assigns its value to the time attribute.
	 * @param time The time the movie was seen.
	 */

	public void setTime(int time) {
		this.time = time;
	}
	
	/**
	 * This method returns the rating of the movie.
	 * @return The rating of the movie.
	 */

	public String getRating() {
		return rating;
	}
	
	/**
	 * This method accepts a String variable that represents the rating of 
	 * a movie and assigns its value to the rating attribute.
	 * @param rating The rating of the movie.
	 */

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	/**
	 * This method accepts a Format object that represents the format
	 * of a movie as a parameter and assigns the object to the Format attribute.
	 * @param f The Format of the movie. 
	 */
	
	public void setFormat(Format f) {
		this.f = f;
	}
	
	/**
	 * This method returns the Format of the movie.
	 * @return The format of the movie.
	 */
	
	public Format getFormat() {
		return f;
	}
	
	/**
	 * This method accepts an integer variable that represents the number
	 * of visits to the movies in a month by a movie patron and assigns the 
	 * value to the numVisits attribute.
	 * @param numVisits The number of visits in a month by a movie patron.
	 */
	
	public void setNumVisits(int numVisits) {
		this.numVisits = numVisits;
	}
	
	/**
	 * This method returns the number of visits to the movies 
	 * in a month by a movie patron with an id.
	 * @return The number of visits in a month by a movie patron.
	 */
	
	public int getNumVisits() {
		return numVisits;
	}
	
	/**
	 * This method returns the price of a ticket based on the 
	 * type of movie patron that has purchased a ticket.
	 * @return The price of a ticket.
	 */
	
	public abstract double calculateTicketPrice();
	
	/**
	 * This method returns the id of the movie patron.
	 * @return The id of the movie patron. 
	 */
	
	public abstract int getId();
	
	/**
	 * This method returns a string representation of
	 * the information of a movie that a movie patron
	 * has seen.
	 * @return A string representing the information of the movie.
	 */
	
	public abstract String toString();
	
	/**
	 * This method accepts a double variable that represents the price 
	 * of a ticket and assigns its value to the price attribute.
	 * @param price The price of the ticket.
	 */
	
	public void setPrice(double price) {
		ticketPrice = price;
	}
	
	/**
	 * This method returns the price of a ticket.
	 * @return The price of a ticket.
	 */
	
	public double getPrice() {
		return ticketPrice;
	}
	
	/**
	 * This method returns the number of times a movie
	 * patron has seen a movie.
	 * @return The number of times a movie patron has seen a movie.
	 */

	public int getNumThisMovie() {
		return numThisMovie;
	}
	
	/**
	 * This method accepts an integer variable that represents the number
	 * of times a movie patron has seen a movie and assigns its value to the 
	 * numThisMovie variable.
	 * @param numThisMovie The number of times a movie patron has seen a movie.
	 */

	public void setNumThisMovie(int numThisMovie) {
		this.numThisMovie = numThisMovie;
	}
	
	/**
	 * This method returns the number of movies that a movie patron
	 * has seen today.
	 * @return The number of movies the movie patron has seen today.
	 */

	public int getNumMoviesToday() {
		return numMoviesToday;
	}
	
	/**
	 * This method accepts an integer variable that represents
	 * the number of movies that a movie patron has seen today
	 * as a parameter and assigns it value to the numMoviesToday
	 * attribute.
	 * @param numMoviesToday The number of movies a movie patron has seen today.
	 */

	public void setNumMoviesToday(int numMoviesToday) {
		this.numMoviesToday = numMoviesToday;
	}

}
