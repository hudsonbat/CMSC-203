/**
 * This program demonstrates the Employee subclass, which extends the abstract Ticket superclass. 
 * This class represents an Employee ticket class and contains two constructors, a method for 
 * calculating the ticket price for an employee, and a toString method to display the ticket
 * information.
 * @author hudson
 */
public class Employee extends Ticket {
	
	int id;
	private double ticketPrice;
	
	/**
	 * This constructor sets the name of the movie, the rating of the movie, the date 
	 * the movie was seen, the time the movie was seen, the feature of the movie, the id of 
	 * the employee movie patron, and the number of visits by the movie patron by calling the ticket 
	 * superclass constructor and passing these parameters to it as well as calling the superclass 
	 * method setNumVisits.
	 * @param movieN The name of the movie.
	 * @param rating The rating of the movie.
	 * @param date The date the movie was seen.
	 * @param time The time the movie was seen.
	 * @param f The feature of the movie.
	 * @param id The id of the employee movie patron.
	 * @param numVisits The number of visits to the movies this month by the employee.
	 */
	
	public Employee(String movieN, String rating, int date, int time, String f, int id, int numVisits) {
		super(movieN,rating,date,time,f);
		super.setNumVisits(numVisits);
		this.id = id;
	}
	
	/**
	 * This constructor sets the name of the movie, the rating of the movie, the date 
	 * the movie was seen, the time the movie was seen, the feature of the movie, and the id 
	 * of the employee movie patron by calling the ticket superclass constructor and passing these 
	 * parameters to it.
	 * @param movieN The name of the movie.
	 * @param rating The rating of the movie.
	 * @param date The date the movie was seen.
	 * @param time The time the movie was seen.
	 * @param f The feature of the movie.
	 * @param id The id of the employee movie patron.
	 */
	
	public Employee(String movieN, String rating, int date, int time, String f, int id) {
		super(movieN,rating,date,time,f);
		this.id = id;
	}
	
	/**
	 * This method overrides the calculateTicketPrice method of the abstract Ticket superclass. 
	 * If the number of visits by a specific employee movie patron is less than 2, the ticket 
	 * price is set to 0. Otherwise, the ticket price is set to 13.50 if the movie was seen during 
	 * the evening and 10.50 otherwise. If the number of visits by a specific employee is greater than
	 * or equal to 2, if the feature is an IMAX then the movie price is increased by 3, and if it is 
	 * a 3D movie, then it is increased by 2, otherwise it remains the same. Finally, the ticket price
	 * is divided by 2 and the tax rate is applied to the new ticket price and added to the ticket price 
	 * and the ticket price is returned.
	 * @return The ticket price.
	 */

	@Override
	public double calculateTicketPrice() {
		
		if(super.getNumVisits() <2) {
			ticketPrice = 0;
		} else if(super.getTime() < 18) {
				ticketPrice = 10.50;
			}else {
				ticketPrice = 13.50;
			}
		
		if(super.getNumVisits() >= 2) {
			if(super.getFormat() == Ticket.Format.IMAX) {
				ticketPrice += 3.00;
			}else if(super.getFormat() == Ticket.Format.THREE_D) {
				ticketPrice += 2.50;
			}else {
				ticketPrice += 0;
			}
			
			ticketPrice/=2;
			
			ticketPrice += ticketPrice*super.getTax();
		}
			
			return ticketPrice;
		}
	
	/**
	 * The method returns the id of the employee movie patron.
	 * @return The id of the employee.
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
