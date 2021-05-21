import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerSTUDENT_Test {
	private MovieTicketManager ticketList;
	

	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		
		ticketList.addTicket("Knocked Up", "R", 2, 15, "3D", "Adult", 0);
		ticketList.addTicket("Solo", "PG", 2, 13, "NONE", "Adult", 0);
		ticketList.addTicket("Ghostbusters", "PG13", 3, 19, "IMAX", "Adult", 0);
		
		ticketList.addTicket("Shrek", "PG", 1, 15, "3D", "Child", 0);
		ticketList.addTicket("The Little Mermaid", "G", 2, 13, "NONE", "Child", 0);
		ticketList.addTicket("Aladdin", "PG", 3, 18, "IMAX", "Child", 0);
		
		ticketList.addTicket("Scream", "R", 1, 15, "3D", "Employee", 1111);
		ticketList.addTicket("Black Swan", "R", 2, 13, "NONE", "Employee", 2222);
		ticketList.addTicket("Black Swan", "PG13", 3, 18, "IMAX", "Employee", 2222);
		
		ticketList.addTicket("Scream", "R", 1, 15, "3D", "MoviePass", 3333);
		ticketList.addTicket("Black Swan", "R", 2, 13, "NONE", "MoviePass", 4444);
		ticketList.addTicket("Scream", "R", 3, 18, "IMAX", "MoviePass", 3333);

	}

	@After
	public void tearDown() throws Exception {
		ticketList = null;
	}

	/**
	 * Student Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		//Student test Employees' number of visits
		assertEquals(2,ticketList.numVisits(2222));
		assertEquals(1,ticketList.numVisits(1111));
	
		//Student test MoviePass members' number of visits
		assertEquals(2,ticketList.numVisits(3333));
		assertEquals(1,ticketList.numVisits(4444));
	
	}

	/**
	 * Student Test the number of times this movie has been viewed
	 * This only applied to those who have id numbers - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		//Student test Employees' number of views
		assertEquals(2,ticketList.numThisMovie(2222,"Black Swan"));
		assertEquals(1,ticketList.numThisMovie(1111,"Scream"));

		//Student test MoviePass members' number of views
		assertEquals(2,ticketList.numThisMovie(3333,"Scream"));
		assertEquals(1,ticketList.numThisMovie(4444,"Black Swan"));
	}

}