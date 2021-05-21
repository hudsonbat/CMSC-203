/**
 * This program demonstrates the MoviePass subclass, which extends the abstract Ticket superclass. 
 * This class represents a MoviePass ticket class and contains two constructors, a method for 
 * calculating the ticket price for a MoviePass member, and a toString method to display the ticket
 * information.
 * @author hudson
 */
public class MoviePass extends Ticket {
	
	int id;
	double ticketPrice;
	
	/**
	 * This constructor sets the name of the movie, the rating of the movie, the date 
	 * the movie was seen, the time the movie was seen, the feature of the movie, the id of 
	 * the moviepass movie patron, and the number of visits by the movie patron by calling the ticket 
	 * superclass constructor and passing these parameters to it.
	 * @param movieN The name of the movie.
	 * @param rating The rating of the movie.
	 * @param date The date the movie was seen.
	 * @param time The time the movie was seen.
	 * @param f The feature of the movie.
	 * @param id The id of the moviepass member movie patron.
	 */
	
	public MoviePass(String movieN, String rating, int date, int time, String f, int id) {
		super(movieN,rating,date,time,f);
		this.id = id;
	}
	
	/**
	 * This constructor sets the name of the movie, the rating of the movie, the date 
	 * the movie was seen, the time the movie was seen, the feature of the movie, the id of 
	 * the moviepass movie patron, and the number of visits by the movie patron by calling the ticket 
	 * superclass constructor and passing these parameters to it as well as calling the superclass 
	 * method setNumVisits, the superclass method setNumMovieToday, and the superclass method 
	 * setNumThisMovie.
	 * @param movieN The name of the movie.
	 * @param rating The rating of the movie.
	 * @param date The date the movie was seen.
	 * @param time The time the movie was seen.
	 * @param f The feature of the movie.
	 * @param id The id of the moviepass member movie patron.
	 * @param numVisits The number of visits to the movies by the moviepass member this month.
	 * @param numMovieToday The number of movies seen by the moviepass member today.
	 * @param numThisMovie The number of times a movie has been seen by a moviepass member.
	 */
	
	public MoviePass(String movieN, String rating, int date, int time, String f, int id,int numVisits, int numMovieToday, int numThisMovie) {
		super(movieN,rating,date,time,f);
		super.setNumVisits(numVisits);
		super.setNumMoviesToday(numMovieToday);
		super.setNumThisMovie(numThisMovie);
		this.id = id;
	}
	
	/**
	 * This method overrides the calculateTicketPrice method of the abstract Ticket superclass. 
	 * If the number of visits by a specific moviepass member movie patron is 1 and the format
	 * of the movie is NONE, the ticket price is set to 9.99. Otherwise, if the number of visits
	 * is greater than 1 and the number of movies today is 1 and the number of times seeing this
	 * movie is 1 and the format of the movie is NONE, then the price is set to 0. Otherwise, the 
	 * ticket price is set to 13.50 if the movie was seen during the evening and 10.50 otherwise. 
	 * If the number of visits by a specific employee is greater than or equal to 2, if the feature is 
	 * an IMAX then the movie price is increased by 3, and if it is a 3D movie, then it is increased by 2, 
	 * otherwise it remains the same. Finally, the  tax rate is applied to the new ticket price and added 
	 * to the ticket price and the ticket price is returned.
	 * @return The ticket price.
	 */

	@Override
	public double calculateTicketPrice() {
		
		if(super.getNumVisits() == 1 && super.getFormat() == Ticket.Format.NONE) {
			ticketPrice = 9.99;
		}else if(super.getNumVisits() > 1 && super.getNumMoviesToday() == 1 && super.getNumThisMovie() == 1 
				&& super.getFormat() == Ticket.Format.NONE) {
			ticketPrice = 0;
		}else {
	
		 if(super.getTime() < 18) {
			ticketPrice = 10.50;
		}
			else {
				ticketPrice = 13.50;
			}
			
		if(super.getFormat() == Ticket.Format.IMAX) {
			ticketPrice += 3.00;
		}else if(super.getFormat() == Ticket.Format.THREE_D) {
			ticketPrice += 2.50;
		}
		
			ticketPrice += ticketPrice*super.getTax();
		}
			
			return ticketPrice;
	}
	
	/**
	 * This method returns the id of the moviepass member movie patron.
	 * @return The id of the moviepass member.
	 */
	
	@Override
	public int getId() {
		return id;
	}
	
	/**
	 * This method overrides the toString method of the Ticket superclass and returns a 
	 * string with the information of the movie being seen.
	 * @return A string representing the information of the movie
	 */

	@Override
	public String toString() {
		return 	super.getType().toUpperCase() + "-" + this.getId() + " " +
				super.getFeature() + " Movie: " + super.getMovieName() + " Rating: " +
				super.getRating() + " Day: " + super.getDate() + " Time: " + super.getTime() 
				+ " Price: $" + super.getPrice() + "\n";
	}
	

}
