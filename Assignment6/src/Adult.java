/**
 * This program demonstrates the Adult subclass, which extends the abstract Ticket superclass. 
 * This class represents an Adult ticket class and contains a constructor, a method for 
 * calculating the ticket price for an adult, and a toString method to display the ticket
 * information.
 * @author hudson
 */
public class Adult extends Ticket {
	
	private double ticketPrice;
	
	/**
	 * This constructor sets the name of the movie, the rating of the movie, the date 
	 * the movie was seen, the time the movie was seen, and the feature of the movie by
	 * calling the ticket superclass constructor and passing these parameters to it.
	 * @param movieN The name of the movie.
	 * @param rating The rating of the movie.
	 * @param date The date the movie was seen.
	 * @param time The time the movie was seen.
	 * @param f The feature of the movie.
	 */
	
	public Adult(String movieN, String rating, int date, int time, String f) {
		super(movieN,rating,date,time,f);
	}
	
	/**
	 * This method overrides the calculateTicketPrice method of the abstract Ticket superclass.
	 * It sets the price to 13.50 if the movie was seen during the evening and 10.50 otherwise.
	 * If the feature is an IMAX then the movie price is increased by 3, and if it is a 3D movie,
	 * then it is increased by 2, otherwise it remains the same. Finally, the tax rate is applied
	 * to the ticket price and added to the ticket price and the ticket price is returned.
	 * @return The ticket price.
	 */

	@Override
	public double calculateTicketPrice() {
		
		if(super.getTime() < 18) {
			ticketPrice = 10.50;
		}else {
			ticketPrice = 13.50;
		}
		
		if(super.getFormat() == Ticket.Format.IMAX) {
			ticketPrice += 3.00;
		}else if(super.getFormat() == Ticket.Format.THREE_D) {
			ticketPrice += 2.50;
		}else {
			ticketPrice += 0;
		}
		
		ticketPrice += ticketPrice*super.getTax();
		
		return ticketPrice;
	}
	
	/**
	 * This method overrides the getId method of the abstract Ticket superclass and returns -1
	 * because adults do not have Id's.
	 * @return The id of the adult.
	 */

	@Override
	public int getId() {
		return -1;
	}
	
	/**
	 * This method overrides the toString method of the Ticket superclass and returns a 
	 * string with the information of the movie being seen.
	 * @return A string representing the information of the movie
	 */
	@Override
	public String toString() {
		return 	super.getType().toUpperCase() + " " + super.getFeature() + " Movie: " + super.getMovieName() + " Rating: " +
				super.getRating() + " Day: " + super.getDate() + " Time: " + super.getTime() 
				+ " Price: $" + super.getPrice()+"\n";
	}

}
