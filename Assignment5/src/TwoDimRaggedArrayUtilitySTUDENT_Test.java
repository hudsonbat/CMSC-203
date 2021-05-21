import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = null;
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		inputFile = new File("myDataSet1.txt");
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetTotal() throws FileNotFoundException {
		dataSetSTUDENT = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(5.5,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),0);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetAverage() throws FileNotFoundException {
		dataSetSTUDENT = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(0.6875,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),0);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetRowTotal() throws FileNotFoundException {
		dataSetSTUDENT = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,2),0);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetColumnTotal() throws FileNotFoundException {
		dataSetSTUDENT = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(8.5,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,1),0);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetHighestInArray() throws FileNotFoundException {
		dataSetSTUDENT = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(6,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),0);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] arrayInput = TwoDimRaggedArrayUtility.readFile(inputFile);
		TwoDimRaggedArrayUtility.writeToFile(arrayInput, outputFile);
		double [][] arrayOutput = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertTrue(Arrays.deepEquals(arrayInput, arrayOutput));
	}

}