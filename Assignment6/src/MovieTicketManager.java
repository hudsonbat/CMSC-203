import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.text.NumberFormat;

/**
 * This program demonstrates the MovieTicketManager class, which implements the MovieTicketManagerInterface interface. 
 * This class represents a movie manager that adds, tracks, and displays the information of movie ticket buyers that are 
 * children, adults, employees, and moviepass holders. It contains methods for adding, displaying, and analyzing the 
 * information of movie patrons.
 * @author hudson
 */

public class MovieTicketManager extends java.lang.Object implements MovieTicketManagerInterface{
	
	private NumberFormat currencyFormat = NumberFormat.getNumberInstance();
	
	private int numVisits;
	private int numThisMovie;
	private int numMovieToday;
	
	
	ArrayList <Ticket> ticketList = new ArrayList<Ticket>();
	
	/**
	 * No-arg constructor 
	 */
	
	public MovieTicketManager() {
		
	}

/**
 * This method accepts an integer variable that represents
 * the id a movie patron as a parameter and, based on that 
 * id, determines the number of visits by a movie patron in 
 * a month.
 * @param id The id of the movie patron.
 * @return The number of visits by the movie patron.
 */
	@Override
	public int numVisits(int id) {
		numVisits = 0;
	for(int i = 0; i < ticketList.size(); i++) {
		if(ticketList.get(i).getId() == id) {
			numVisits++;
			ticketList.get(i).setNumVisits(numVisits);
		}
	}
	return numVisits;
	}
	
	/**
	 * This method accepts an integer variable that represents the id of a 
	 * movie patron and a string variable that represents the name of a movie as 
	 * parameters and determines the the number of a times that the movie 
	 * patron has seen this movie.
	 * @param id The id of the movie patron.
	 * @param movie The name of the movie.
	 * @return The number of times this movie has been seen by the movie patron.
	 */
	
	@Override
	public int numThisMovie(int id, String movie) {
		numThisMovie = 0;
		for(int i = 0; i <ticketList.size(); i++) {
			if(ticketList.get(i).getMovieName() == movie && ticketList.get(i).getId() == id) {
				numThisMovie++;
				ticketList.get(i).setNumThisMovie(numThisMovie);
			}
		}
		
		return numThisMovie;
	}
	
	/**
	 * This method accepts an integer variable that represents the id of a 
	 * movie patron and an integer variable that represents the date a movie or
	 * number of movies were seen as parameters and determines the the number of 
	 * movies that a movie patron has seen today.
	 * @param id The id of the movie patron.
	 * @param date The date.
	 */

	@Override
	public int numMoviesToday(int id, int date) {
		numMovieToday = 0;
		for(int i = 0; i <ticketList.size();i++) {
			if(ticketList.get(i).getDate() == date && ticketList.get(i).getId() == id) {
				numMovieToday++;
				ticketList.get(i).setNumMoviesToday(numMovieToday);
			}
		}
		
		return numMovieToday;
	}
	
	/**
	 * This method accepts four String variables that represent the name of the movie, 
	 * the rating of the movie, the feature of the movie, and the type of movie patron, 
	 * as well as three integer variables that represent the date and time the movie was seen 
	 * and the id of the movie patron as parameters. The method determines the ticket price for 
	 * each type of movie patron by passing the parameter variables to each movie patron constructor
	 * and calling each movie patron types overriden calculateTicketPrice method. The method also
	 * adds each successive movie ticket type to the arraylist of Ticket objects. 
	 * @param movieN The name of the movie.
	 * @param rating The rating of the movie.
	 * @param d The date the movie was seen.
	 * @param t The time the movie was seen.
	 * @param f The feature of the movie.
	 * @param type The type of movie patron. 
	 * @param id The id of the movie patron.
	 * @return The ticket price.
	 */

	@Override
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id) {
			
		double price;
		
		if(type.equals("Child")) {
			Child c = new Child(movieN, rating, d,t,f);
			ticketList.add(c);
			price = c.calculateTicketPrice();
			c.setPrice(price);
			c.setType(type);
		}else if(type.equals("Adult")) {
			Adult a  = new Adult(movieN, rating, d,t,f);
			ticketList.add(a);
			price = a.calculateTicketPrice();
			a.setPrice(price);
			a.setType(type);
		}else if(type.equals("Employee")) {
			Employee e  = new Employee(movieN, rating, d,t,f,id);
			ticketList.add(e);
			e.setType(type);
			price = e.calculateTicketPrice();
			e.setPrice(price);
		} else if(type.equals("MoviePass")) {
			MoviePass mP = new MoviePass(movieN, rating, d,t,f,id);
			ticketList.add(mP);
			mP.setType(type);
			numVisits(id);
			numMoviesToday(id,d);
			numThisMovie(id,movieN);
			price = mP.calculateTicketPrice();
			mP.setPrice(price);
		}else {
			return -1;
		}
		
		return price;
	}
	
	/**
	 * This method returns the total monthly sales for the movie ticket manager
	 * by adding the total value of the ticket prices from every type of movie patron.
	 * @return The total sales for the month. 
	 */

	@Override
	public double totalSalesMonth() {
		double total = 0;
		for(int i = 0; i < ticketList.size();i++) {
			total+= ticketList.get(i).getPrice();
		}
		return total;
	}
	
	/**
	 * This method returns a string representation of the monthly sales by 
	 * movie patron type.
	 * @return The monthly sales for each type of movie patron. 
	 */

	@Override
	public String monthlySalesReport() {
		
		currencyFormat.setMaximumFractionDigits(2);
		currencyFormat.setMinimumFractionDigits(2);
		
		int adultCount = 0;
		int childCount = 0;
		int employeeCount = 0;
		int moviePassCount = 0;
		
		double adultSales = 0.00;
		double childSales = 0.00;
		double employeeSales = 0.00;
		double moviePassSales = 0.00;
		
		for(int i = 0; i < ticketList.size();i++) {
			if(ticketList.get(i).getType().equals("Child")) {
				childSales += ticketList.get(i).getPrice();
				childCount++;
			} else if(ticketList.get(i).getType().equals("Adult")) {
				adultSales += ticketList.get(i).getPrice();
				adultCount++;
			} else if(ticketList.get(i).getType().equals("Employee")) {
				employeeSales += ticketList.get(i).getPrice();
				employeeCount++;
			} else if(ticketList.get(i).getType().equals("MoviePass")) {
				moviePassSales += ticketList.get(i).getPrice();
				moviePassCount++;
			}else {
				
			}
		}
		
		String adSales = currencyFormat.format(adultSales);
		String chSales = currencyFormat.format(childSales);
		String empSales = currencyFormat.format(employeeSales);
		String mpSales = currencyFormat.format(moviePassSales);
		String totalSales = currencyFormat.format(totalSalesMonth());
		
	
		return "\t\tMonthly Sales Report\n\n" + "\t\tSales\tNumber\n" +
		"ADULT\t\t $" + adSales + "\t" + adultCount +"\n" + "CHILD\t\t $" + chSales + "\t" + childCount +"\n"
		+ "EMPLOYEE\t $" + empSales + "\t" + employeeCount +"\n" + "MOVIEPASS\t $" + mpSales + "\t" + moviePassCount +"\n\n"+
		"Total Monthly Sales: $" + totalSales;
	}
	
	/**
	 * This method returns a string arraylist containing the movie information
	 * of all 3D movies seen by movie patrons.
	 * @return An arraylist containing the movie information of all 3D movies seen.  
	 */

	@Override
	public ArrayList<String> get3DTickets() {
		ArrayList <Ticket> threeDTickets = new ArrayList<Ticket>();
		for(int i = 0; i<ticketList.size(); i++) {
			if(ticketList.get(i).getFormat() == Ticket.Format.THREE_D) {
				threeDTickets.add(ticketList.get(i));
			}
		}
		
		Collections.sort(threeDTickets,sortByDay);
		
		ArrayList<String> threeD = new ArrayList<String>();
		for(int i = 0; i < threeDTickets.size();i++) {
			threeD.add(threeDTickets.get(i).toString());
		}
	 
	return threeD;
	}
	
	/**
	 * This method returns the information of every movie seen by all movie patrons. 
	 * @return An arraylist containing the information of all movies seen. 
	 */

	@Override
	public ArrayList<String> getAllTickets() {
		ArrayList <Ticket> tickets = new ArrayList<Ticket>();
		for(int i = 0; i<ticketList.size(); i++) {
				tickets.add(ticketList.get(i));
			}
		
		Collections.sort(tickets,sortByDay);
		
		ArrayList<String> allTix = new ArrayList<String>();
		for(int i = 0; i < tickets.size();i++) {
			allTix.add(tickets.get(i).toString());
		}
		
		return allTix;
	}
	
	/**
	 * This method returns an arraylist containing the information of all 
	 * movies seen by moviepass member movie patrons.
	 * @return An arraylist containing the information of all movies seen by moviepass members. 
	 */

	@Override
	public ArrayList<String> getMoviePassTickets() {
		
		ArrayList <Ticket> moviePassTickets = new ArrayList<Ticket>();
		for(int i = 0; i<ticketList.size(); i++) {
			if(ticketList.get(i).getType().equals("MoviePass")) {
				moviePassTickets.add(ticketList.get(i));
			}
		}
		
		Collections.sort(moviePassTickets,sortById);
		
		ArrayList<String> moviePass = new ArrayList<String>();
			for(int i = 0; i < moviePassTickets.size();i++) {
				moviePass.add(moviePassTickets.get(i).toString());
			}
		 
		return moviePass;
	}
	
	/**
	 * This method accepts a File object as a parameter and reads input from this file 
	 * into a string array until the file has been entirely read. 
	 * @param file The File object to be read from.
	 */

	@Override
	public void readFile(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		String [] str;

		while(input.hasNextLine()) {
				str = input.nextLine().split(":");
				addTicket(str[0],str[1],Integer.parseInt(str[2]),Integer.parseInt(str[3]),str[4],
						str[5],Integer.parseInt(str[6]));
					}
		input.close();
	}
	
	/**
	 * This method returns a comparator for objects of the ticket superclass
	 * that compares ticket objects by id. 
	 */
	
	private Comparator<Ticket> sortById = new Comparator<Ticket>() {
			@Override
			public int compare(Ticket o1, Ticket o2) {
				String id1 = Integer.toString(o1.getId());
				String id2 = Integer.toString(o2.getId());
				return id1.compareTo(id2);
			}
		};
		
		/**
		 * This method returns a comparator for objects of the ticket superclass
		 * that compares ticket objects by day.
		 */
	
	private Comparator<Ticket> sortByDay = new Comparator<Ticket>(){
			@Override
			public int compare(Ticket o1, Ticket o2) {
				String day1 = Integer.toString(o1.getDate());
				String day2 = Integer.toString(o2.getDate());
				return day1.compareTo(day2);
			}
	};

}
	


