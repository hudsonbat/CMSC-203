import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class represents a two-dimensional ragged array. It contains a method for reading string representations 
 * of numerical values from a txt file, converting them to doubles, and storing in a two-dimensional array of 
 * doubles as well as a method for writing an array of doubles to a txt file. The remaining methods return information
 * based on the two-dimensional array, such as the highest value of a particular column or row. 
 * @author hudson
 */

public class TwoDimRaggedArrayUtility {

	/**
	 * No-arg constructor that accepts no parameters/arguments.
	 */
	public TwoDimRaggedArrayUtility(){
		
	}
	
	/**
	 * This method reads string representations of numerical values from a txt file, converts them to double values, and stores
	 * them in a two-dimensional array of doubles by reading each line of the txt file until the txt file has no input left to 
	 * read from.
	 * @param file The txt file from which data is read.
	 * @return The two-dimensional ragged array of doubles created by reading the txt file.
	 * @throws java.io.FileNotFoundException
	 */
	public static double [][] readFile(java.io.File file) throws java.io.FileNotFoundException {
		
		Scanner input = new Scanner(file);
		String [][] myArray = new String [10][10];
		String [] str;
		int numOfRows = 0;
		int numOfCols = 0;
		
		while(input.hasNextLine()) {
			for(int i = 0; i < myArray.length && input.hasNextLine(); i++) {
				str = input.nextLine().split(" ");
				for(int j = 0; j < str.length; j++) {
						myArray[i][j] = str[j];
					}
				}
		}
		
		
		input.close();

			for(int i = 0; i <myArray.length; i++) {
			if(myArray[i][0] != null) {
				numOfRows++;
				}
			}
			
			
			double [][] array = new double [numOfRows][];
			
			for(int k = 0; k < array.length; k++) {
				numOfCols = 0;
				for(int j = 0; j < myArray[k].length && myArray[k][j] != null; j++) {
					numOfCols++;
				}
			array[k] = new double [numOfCols];
			}
			
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array[i].length && myArray[i][j] != null; j++) {
					array[i][j] = Double.parseDouble(myArray[i][j]);
				}
			}
			return array;
		}
	
	/**
	 * This method writes an array of doubles to a txt file by iterating through each row and column of the two-dimensional
	 * array.
	 * @param data The array of doubles to written to the txt file.
	 * @param outputFile The txt file to which the array of doubles should be written.
	 * @throws java.io.FileNotFoundException
	 */
	public static void writeToFile(double[][] data, java.io.File outputFile) throws java.io.FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(outputFile);
		
		for(int i = 0; i < data.length; i++) {
			if(i>=1)
				pw.println();
			for(int j = 0; j < data[i].length; j++) {
				pw.print(data[i][j] + " ");
			}
		}
		pw.close();
	}
	
	/**
	 * This method returns the total of a specific column in a two-dimensional ragged array by accepting a column index, col,
	 * and a two-dimensional array, data, as parameters. If a row in the two-dimensional array doesn't have this column index,
	 * the row is not included in this method.
	 * @param data The two-dimensional ragged array.
	 * @param col The column index of the two-dimensional array whose row values are to be summed.
	 * @return The total of all elements in the column index, col.
	 */
	public static double getColumnTotal(double[][] data, int col) {
		
		double total = 0;
			try {
			for(int i = 0; i < data.length; i++) {
				if(col < data[i].length)
			total += data[i][col];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
	}
			
	return total;
	
	}
	
	/**
	 * This method returns the highest value of a specific column in a two-dimensional ragged array by accepting a column index, 
	 * col, and a two-dimensional array, data, as parameters. If a row in the two-dimensional array doesn't have this column 
	 * index, the row is not included in this method.
	 * @param data The two-dimensional ragged array.
	 * @param col The column index of the two-dimensional array.
	 * @return The largest value in the column index, col.
	 */
	
	public static double getHighestInColumn(double[][] data, int col) {
		
		double highest = 0;
		
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length)
			if(data[i][col] > highest)
				highest = data[i][col];
			}
	return highest;
	}
	
	/**
	 * This method returns the row index of the highest value of a specific column in a two-dimensional ragged array by accepting
	 * a column index, col, and a two-dimensional array, data, as parameters. If a row in the two-dimensional array doesn't have 
	 * this column index, the row is not included in this method.
	 * @param data The two-dimensional ragged array.
	 * @param col The column index of the two-dimensional array.
	 * @return The row index of the largest value in the column index, col.
	 */
	
	public static int getHighestInColumnIndex(double[][] data, int col){
		
		double highest = data[0][col];
		int index = 0;
		
		for(int i = 1; i < data.length; i++) {
			if(col < data[i].length)
			if(data[i][col] > highest) {
				highest = data[i][col];
				index = i;
			}
		}
		
		return index;
		
	}
	
	/**
	 * This method returns the lowest value of a specific column in a two-dimensional ragged array by accepting a column index, 
	 * col, and a two-dimensional array, data, as parameters. If a row in the two-dimensional array doesn't have this column 
	 * index, the row is not included in this method.
	 * @param data The two-dimensional ragged array.
	 * @param col The column index of the two-dimensional array.
	 * @return The smallest value in the column index, col.
	 */
	
	public static double getLowestInColumn(double[][] data, int col) {
		
		double lowest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
		
				for(int i = 0; i < data.length; i++) {
					if(col < data[i].length)
					if(data[i][col] < lowest) {
						lowest = data[i][col];
					}
				}
			
			return lowest;
				
			}
	
	/**
	 * This method returns the row index of the smallest value of a specific column in a two-dimensional ragged array by 
	 * accepting a column index, col, and a two-dimensional array, data, as parameters. If a row in the two-dimensional array 
	 * doesn't have this column index, the row is not included in this method.
	 * @param data The two-dimensional ragged array.
	 * @param col The column index of the two-dimensional array.
	 * @return The row index of the smallest value in the column index, col.
	 */
			
	public static int getLowestInColumnIndex(double[][] data, int col) {
		
		double lowest = data[0][col];
		int index = 0;
		
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length)
			if(data[i][col] < lowest) {
				lowest = data[i][col];
				index = i;
			}
		}
	
	return index;
				
			}
	/**
	 * This method returns the highest value of a specific row in a two-dimensional ragged array by accepting a row index, 
	 * row, and a two-dimensional array, data, as parameters. 
	 * @param data The two-dimensional ragged array.
	 * @param row The row index of the two-dimensional array.
	 * @return The largest value in the row index, row.
	 */
	
	public static double getHighestInRow(double[][] data, int row){
		
		double highest = data[row][0];
		
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] > highest) {
				highest = data[row][i];
			}
		}
	
	return highest;
		
	}
	
	/**
	 * This method returns the column index of the highest value of a specific row in a two-dimensional ragged array by 
	 * accepting a row index, row, and a two-dimensional array, data, as parameters. 
	 * @param data The two-dimensional ragged array.
	 * @param row The row index of the two-dimensional array.
	 * @return The column index of the largest value in the row index, row.
	 */
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		
		double highest = data[row][0];
		int index = 0;
		
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] > highest) {
				highest = data[row][i];
				index = i;
			}
		}
	
	return index;
		
	}
	
	/**
	 * This method returns the smallest value of a specific row in a two-dimensional ragged array by accepting a row index, 
	 * row, and a two-dimensional array, data, as parameters. 
	 * @param data The two-dimensional ragged array.
	 * @param row The row index of the two-dimensional array.
	 * @return The smallest value in the row index, row. 
	 */
	
	public static double getLowestInRow(double[][] data, int row) {
		
		double lowest = data[row][0];
		
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
	
	return lowest;
		
	}
	
	/**
	 * This method returns the column index of the smallest value of a specific row in a two-dimensional ragged array by 
	 * accepting a row index, row, and a two-dimensional array, data, as parameters. 
	 * @param data The two-dimensional ragged array.
	 * @param row The row index of the two-dimensional array.
	 * @return The column index of the smallest value in the row index, row.
	 */
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		
		double lowest = data[row][0];
		int index = 0;
		
		for(int i = 1; i < data[row].length; i++) {
			if(data[row][i] < lowest) {
				lowest = data[row][i];
				index = i;
			}
		}
	
	return index;
		
	}
	
	/**
	 * This method returns the total of a specific row in a two-dimensional ragged array by accepting a row index, row,
	 * and a two-dimensional array, data, as parameters. 
	 * @param data The two-dimensional ragged array.
	 * @param row The row index of the two-dimensional array.
	 * @return The sum of all the elements in the row index, row.
	 */
	
	public static double getRowTotal(double[][] data, int row) {
		
		double total = 0;
		
		for(int i = 0; i < data[row].length; i++) {
		total += data[row][i];
		}
	
	return total;
		
	}
	
	/**
	 * This method returns the largest value in a two-dimensional ragged array, data, passed as a parameter.
	 * @param data The two-dimensional ragged array.
	 * @return The largest value in the two-dimensional ragged array, data.
	 */
	
	public static double getHighestInArray(double[][] data){
		
		double highest = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
	
		return highest;
	}
	
	/**
	 * This method returns the smallest value in a two-dimensional ragged array, data, passed as a parameter.
	 * @param data The two-dimensional ragged array.
	 * @return The smallest value in the two-dimensional ragged array, data.
	 */
	
	public static double getLowestInArray(double[][] data) {
		
	double lowest = data[0][0];
		
		for(int i = 1; i < data.length; i++) {
			for(int j = 1; j < data[i].length; j++) {
				if(data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
	
		return lowest;
	}
	
	/**
	 * This method returns the sum of all elements in a two-dimensional ragged array, data, passed as a parameter.
	 * @param data The two-dimensional ragged array.
	 * @return The sum of all elements in the two-dimensional ragged array, data.
	 */
	
	public static double getTotal(double[][] data) {
		
		double total = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j <data[i].length; j++) {
				total += data[i][j];
			}
		}
		
		return total;
		
	}
	
	/**
	 * This method returns the average value of a two-dimensional ragged array, data, passed as a parameter.
	 * @param data The two-dimensional ragged array.
	 * @return The total value of all elements divided by the number of elements in the two-dimensional ragged array, data.
	 */
	
public static double getAverage(double[][] data) {
		
		double total = 0;
		int number = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j <data[i].length; j++) {
				total += data[i][j];
				number++;
			}
		}
		
		return total/number;
	}
	
	


	
}
