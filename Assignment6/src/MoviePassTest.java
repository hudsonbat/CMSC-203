import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoviePassTest {
	MoviePass m1,m2,m3,m4,m5,m6;

	@Before
	public void setUp() throws Exception {
		//only seen 1 movie this month, 1 movie today, and seeing this movie for the first time.
		m1 = new MoviePass("Deadpool", "NR", 5,19,"NONE",12345,1,1,1);
		//seen 2 movies this month, 1 movie today, and seeing this movie for the first time.
		m2 = new MoviePass("Action Point", "NR", 2,12,"NONE",23456,2,1,1);
		//seen 3 movies this month, 1 movie today, and seeing this movie for the first time.
		m3 = new MoviePass("Adrift", "PG13", 3,20,"IMAX",34567,3,1,1);
		//seen 5 movies this month, 1 movie today, and seeing this movie for the second time.
		m4 = new MoviePass("Book Club", "PG13", 1,13,"NONE",45678,5,1,2);
		//seen 1 movies this month, 1 movie today, and seeing this movie for the first time.
		m5 = new MoviePass("Life of the Party", "PG13", 3,21,"3D",56789,1,1,1);
		//seen 20 movies this month and 2 movies today, the second of which is being seen for the first time.
		m6 = new MoviePass("Overboard", "PG13", 2,14,"NONE",67890,20,2,1);	
	}

	@After
	public void tearDown() throws Exception {
		m1=m2=m3=m4=m5=null;
	}

	@Test
	public void test() {
		assertEquals(9.99,m1.calculateTicketPrice(),.01);
		assertEquals(0.0,m2.calculateTicketPrice(),.01);
		assertEquals(18.084,m3.calculateTicketPrice(),.01);
		assertEquals(11.508,m4.calculateTicketPrice(),.01);
		assertEquals(17.536,m5.calculateTicketPrice(),.01);
		assertEquals(11.508,m6.calculateTicketPrice(),.01);
	}

}
