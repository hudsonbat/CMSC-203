import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) throws FileNotFoundException {
		
	 double [][] array1 = {{-4.0,5.5},
			 				{6.0},
			 				{-2.0,5.0,-3.0},
			 				{0.0, -2.0}};
	 
	 /*System.out.println(TwoDimRaggedArrayUtility.getAverage(array1));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getColumnTotal(array1,1));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getRowTotal(array1,1));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getTotal(array1));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getHighestInColumn(array1,3));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getHighestInRow(array1,2));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getHighestInColumnIndex(array1,3));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getHighestInRowIndex(array1,2));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getLowestInRow(array1,2));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getLowestInRowIndex(array1,2));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getLowestInArray(array1));
	 
	 System.out.println(TwoDimRaggedArrayUtility.getHighestInArray(array1));*/
	 
	/* Scanner input = new Scanner (System.in);
		PrintWriter pw = null;
		
		String age;
		String ageIn5Years;
		int numFriends;
		
		System.out.println("Enter your number of friends");
		numFriends = input.nextInt();
		input.nextLine();
		
		
			pw = new PrintWriter("myText.txt");
			for(int i = 1; i < numFriends; i++) {
				System.out.println("Enter the age of your friend");
				age = input.nextLine();
				pw.print(age + " ");
				System.out.println("Enter the age of your friend in 5 years");
				ageIn5Years = input.nextLine();
				pw.println(ageIn5Years);
			}
			
			pw.close();*/
	 
	File f = new File("D:\\Assignment 5 TXT Files\\myDataSet1.txt");
	 
	System.out.println(f.exists());
		
	System.out.println(new File(".").getAbsoluteFile());
	
	File output = new File("ouput.txt");
	
	TwoDimRaggedArrayUtility.writeToFile(TwoDimRaggedArrayUtility.readFile(f), output);
	
	double [][] outputArray = TwoDimRaggedArrayUtility.readFile(output);
	
	for(int i = 0; i < outputArray.length; i++) {
		System.out.println();
		for(int j = 0; j < outputArray[i].length; j++){
			System.out.print(outputArray[i][j] + " ");
		}
	}
	
		}
	 
	}

