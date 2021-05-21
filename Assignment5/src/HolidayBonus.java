/**
 * This class represents the holiday bonuses due to stores. It contains a method for calculating the bonuses due to the stores
 * based on the value of the items they sell as well as a method for finding the total value of all bonuses.
 * @author hudson
 */

public class HolidayBonus {
	
	/**
	 * No-arg constructor with no parameters.
	 */

	public HolidayBonus() {
		
	}
	
	/**
	 * This method calculates the bonus due to stores based on the sales revenue they obtain for a particular item. It accepts
	 * a two-dimensional ragged array, data, that represents the sales of each store for each item, as a parameter. It also
	 * accepts three double parameters labeled high, low, and other, which represent the bonus amounts for obtaining the most 
	 * sales for a particular item, the least sales for a particular item, and other sales amounts for a particular item,
	 * respectively. This method returns an array of six or less doubles that represent the bonuses accrued by each store
	 * depending on the amount of sales in the two-dimensional array passed as a parameter.
	 * @param data The two-dimensional ragged array.
	 * @param high The bonus amount for a store with the largest sales amount for a particular item.
	 * @param low The bonus amount for a store with the lowest sales amount for a particular item.
	 * @param other The bonus amount for a store with the largest amount for a particular item.
	 * @return An array of doubles that represent the bonuses accrued by each store.
	 */
	
	public static double [] calculateHolidayBonus(double [][] data, double high, double low, double other) {
		
		double[] bonus = new double[data.length];

		for(int i = 0; i < data.length; i++) {
		for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					bonus[i] += high;
				} else if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j) && TwoDimRaggedArrayUtility.getLowestInColumn(data, j) > 0) {
					bonus[i] += low;
				} else if (data[i][j] < TwoDimRaggedArrayUtility.getHighestInColumn(data, j) && data[i][j] > TwoDimRaggedArrayUtility.getLowestInColumn(data, j)
						&& TwoDimRaggedArrayUtility.getLowestInColumn(data, j) <= 0 && data[i][j] > 0) {
					bonus[i] += low;
				}else if(data[i][j] <= 0) {
					bonus[i] += 0;
				}else
					bonus[i] += other;	
			}
		}
		
		return bonus;
	}
	
	/**
	 * This method calculates the total holiday bonuses accrued by every store represented in the two-dimensional ragged array, 
	 * data, by summing the bonus amounts that each store earned. This method returns the total value of the bonuses accrued by 
	 * each store depending on the amount of sales in the two-dimensional array passed as a parameter.
	 * @param data The two-dimensional ragged array.
	 * @param high The bonus amount for a store with the largest sales amount for a particular item.
	 * @param low The bonus amount for a store with the lowest sales amount for a particular item.
	 * @param other The bonus amount for a store with the largest amount for a particular item.
	 * @return The total value of all holiday bonuses.
	 */
	
	public static double calculateTotalHolidayBonus(double [][] data, double high, double low, double other) {
		
	double totalBonus = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					totalBonus += high;
				} else if(data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j) && TwoDimRaggedArrayUtility.getLowestInColumn(data, j) > 0) {
					totalBonus += low;
				}else if (data[i][j] < TwoDimRaggedArrayUtility.getHighestInColumn(data, j) && data[i][j] > TwoDimRaggedArrayUtility.getLowestInColumn(data, j)
						&& TwoDimRaggedArrayUtility.getLowestInColumn(data, j) <= 0 && data[i][j] > 0) {
					totalBonus += low;	
				} else if(data[i][j] <= 0) {
					totalBonus += 0;
				}else
					totalBonus += other;
			}
		}
		
		return totalBonus;
		
	}
	
	
	
	
	
	
	
	
}
