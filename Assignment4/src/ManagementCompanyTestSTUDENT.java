import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany mgmComp;
	Property p1, p2, p3, p4, p5, p6;
	
	
	@Before
	public void setUp() throws Exception {
		mgmComp = new ManagementCompany("REMAX","3333",5);//student create a management company
		
		p1 = new Property("Glenwood","DC",3400.0,"Peter",1,1,2,2);//student add three properties, with plots, to mgmt co
		p2 = new Property("Monroe","Bethesda",5000.0,"Jake",1,4,2,2);
		p3 = new Property("Kenwood","Rockville",3200.0,"Jessica",4,4,2,2);
		
		mgmComp.addProperty(p1);
		mgmComp.addProperty(p2);
		mgmComp.addProperty(p3);
		
	}

	@After
	public void tearDown() {
		p1 = p2 = p3 = null;
		mgmComp = null;//student set mgmt co to null  
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		p4 = new Property("Lakeview","Baltimore",2300,"Stacy");//student should add property with 4 args & default plot (0,0,1,1)
		p4.setPlot(0, 0, 1, 1);
		p5 = new Property("Shoreline","Ocean City",1400,"Jill",1,7,1,1);//student should add property with 8 args
		p6 = new Property("Bellview","Seattle",3500,"Leah",5,7,2,2);//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		
		assertEquals(mgmComp.addProperty(p4),3,0);
		assertEquals(mgmComp.addProperty(p5),4,0);
		assertEquals(mgmComp.addProperty(p6),-1,0);
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(mgmComp.maxRentProp(),5000.0,0);//student should test if maxRentProp contains the maximum rent of properties
	}

	@Test
	public void testTotalRent() {
		assertEquals(mgmComp.totalRent(),11600.0,0);//student should test if totalRent returns the total rent of properties
	}

 }