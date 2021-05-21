/**
 * This class represents a property and its plot. It provides 
 * methods for both setting and getting a property plot, city, owner, 
 * property name, and rent amount as well as a method for returning
 * the property information.
 * @author hudson
 */


public class Property {
	
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * This no argument constructor creates a property with null values assigned to the city, 
	 * owner, and propertyName String variables as well as the rentAmount double variable and
	 * creates a new plot object. 
	 */
	
	Property(){
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
		
	}
	
	/**
	 * This copy constructor creates a property object based on a plot object, p, which
	 * it accepts as a parameter.
	 * @param p The plot object to be copied.
	 */
	
	Property(Plot p){
		plot = new Plot(p);
		
	}
	
	/**
	 * This constructor creates a property object by accepting parameters for
	 * the property name, city, rent amount, and owner and assigning them to 
	 * the variables propertyName, city, rentAmount and owner respectively.
	 * @param propertyName The name of the property.
	 * @param city The city in which the property is located.
	 * @param rentAmount The amount of rent for the property.
	 * @param owner The owner of the property.
	 */
	
	Property(String propertyName, String city, double rentAmount, String owner){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		
	}
	
	/**
	 * This constructor creates a property object by accepting parameters for
	 * the property name, city, rent amount, owner, as well as the plot fields x, y, 
	 * width, and depth. These parameters are then assigned to the variables propertyName, 
	 * city, rentAmount, owner, x, y, width, and depth respectively.
	 * @param propertyName The name of the property.
	 * @param city The city in which the property is located.
	 * @param rentAmount The amount of rent for the property.
	 * @param owner The owner of the property.
	 * @param x The x-coordinate of the property plot.
	 * @param y The y-coordinate of the property plot.
	 * @param width The width of the property plot.
	 * @param depth The depth of the property plot.
	 */
	
	Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
		
	}

	/**
	 * This method creates a plot for a property by accepting parameters 
	 * for the x-coordinate, y-coordinate, width, and depth of the property
	 * plot and assigning them to the variables x, y, width, and depth.
	 * @param x The x-coordinate of the plot.
	 * @param y The y-coordinate of the plot.
	 * @param width The width of the plot.
	 * @param depth The depth of the plot.
	 */
	
	public void setPlot(int x, int y, int width, int depth) {
		plot = new Plot();
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
	}
	
	/**
	 * This method sets the city of the property by accepting a String parameter
	 * called city and assigning it to the String variable city.
	 * @param city The city in which the property is located.
	 */
	
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * This method sets the owner of the property by accepting a String parameter
	 * called owner and assigning it to the String variable owner.
	 * @param owner The owner of the property.
	 */
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * This method sets the name of the property by accepting a String
	 * parameter called propertyName and assigning it to the String variable
	 * propertyName.
	 * @param propertyName The name of the property.
	 */
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	/**
	 * This method sets the rent amount of the property by accepting a rent amount
	 * parameter and assigning it to the rentAmount variable.
	 * @param rentAmount The rent amount of the property.
	 */
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	/**
	 * This method returns the the city in which the property is located.
	 * @return The city in which the property is located.
	 */
	
	public String getCity() {
		return city;
	}
	
	/**
	 * This method returns the owner of the property.
	 * @return The owner of the property.
	 */
	
	public String getOwner() {
		return owner;
	}
	
	/**
	 * This method returns the name of the property.
	 * @return The property name.
	 */
	
	public String getPropertyName() {
		return propertyName;
	}
	
	/**
	 * This method returns the rent amount of the property.
	 * @return The rent amount of the property.
	 */
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	/**
	 * This method returns the plot of the property.
	 * @return The property plot.
	 */
	
	public Plot getPlot() {
		return plot;
	}
	
	/**
	 * This method returns the name, city, owner, and rent amount of the property
	 * as a String.
	 */
	
	public String toString() {
		
		return "Property Name: " + this.propertyName +"\nLocated in " + this.city +
				"\nBelonging to " + this.owner + "\nRent Amount: " + this.rentAmount;
		
	}
	
	
	
}
