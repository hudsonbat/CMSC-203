/**
 * This class represents a Management Company and its properties. Specifically, it
 * stores owner, name, city, and rent information about no more than five properties 
 * for a Management Company in an array. The class provides methods for getting the 
 * total rent, maximum rent, and the index of the property with maximum rent. It also 
 * provides methods for returning a property given an index, returning a property owner 
 * name, returning a plot, returning a string with the information of properties. And, 
 * most importantly, it provides methods for adding properties to the property array.
 * @author hudson
 */


public class ManagementCompany {
	
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name;
	private Property [] properties;
	private String taxId;
	private Plot plot;
	
	/**
	 * The constructor is a no-argument constructor that does not accept any parameters
	 * and creates a Management Company object using the fields/attributes of this 
	 * class, including the plot field from which it creates a plot object. It also creates a 
	 * new Property array object.
	 */
	
	public ManagementCompany(){
		plot = new Plot();
		this.name = "";
		this.taxId = "";
		plot.setX(0);
		plot.setY(0);
		plot.setWidth(MGMT_WIDTH);
		plot.setDepth(MGMT_DEPTH);
		properties = new Property [MAX_PROPERTY];
		
	}
	
	/**
	 * This constructor creates a Management Company object and
	 * accepts a name, taxId, and mgmFeePer parameter. It sets the 
	 * fields of this class to these parameters and also creates a plot
	 * object. It also creates a new Property array object.
	 * @param name The name of the Management Company
	 * @param taxId The tax ID of the Management Company
	 * @param mgmFeePer The management fee for the Management Company
	 */
	
	public ManagementCompany(String name, String taxId, double mgmFeePer){
		plot = new Plot();
		this.name = name;
		this.taxId = taxId;
		this.mgmFeePer = mgmFeePer;
		plot.setX(0);
		plot.setY(0);
		plot.setWidth(MGMT_WIDTH);
		plot.setDepth(MGMT_DEPTH);
		properties = new Property [MAX_PROPERTY];
		
	}
	
	/**
	 * This constructor creates a Management Company object and
	 * accepts a name, taxId, mgmFeePer, x, y, width, and depth parameter. 
	 * It sets the fields of this class to these parameters. It also creates a 
	 * new Property array object.
	 * @param name The name of the Management Company 
	 * @param taxId The tax ID of the Management Company
	 * @param mgmFeePer The management fee of the Management Company
	 * @param x The x coordinate of the Management Company plot
	 * @param y The y coordinate of the Management Company plot
	 * @param width The width of the Management Company plot
	 * @param depth The depth of the Management Company plot
	 */
	
	public ManagementCompany(String name, String taxId, double mgmFeePer, int x, int y, int width, int depth) {
		
		this.name = name;
		this.taxId = taxId;
		this.mgmFeePer = mgmFeePer;
		plot = new Plot(x,y,width,depth);
		properties = new Property [MAX_PROPERTY];
	}
	
	/**
	 * This copy constructor creates a copy of a Management Company object
	 * by accepting another Management Company object as a parameter and creates
	 * a new Property array object.
	 * @param otherCompany The Management Company object to be copied.
	 */
	
	public ManagementCompany(ManagementCompany otherCompany) {
		
		ManagementCompany mgmComp = new ManagementCompany(otherCompany);
		properties = new Property [MAX_PROPERTY];
		
	}
	
	/**
	 * This method adds a property to the property array and returns an
	 * integer value of -1 if the array is full, a value of -2 if the 
	 * property is null, a value of -3 if the property is not encompassed
	 * by the Management Company plot, a value of -4 if any of the property
	 * plots overlap one another, or a value from 1 to 4 corresponding to 
	 * the index of the property array in which the property is added. This
	 * method accepts a property object as a parameter.
	 * @param property The property object to be added to the properties array.
	 * @return The integer value corresponding either to the index of the array in
	 * which the property was added or one of the 4 scenarios.
	 */
	
	public int addProperty(Property property) {
		ManagementCompany mgmComp = new ManagementCompany();
		int index = 0;
		int i = 0;
		
		for(int j = 0; j < properties.length && properties[j] != null; j++) {
			if(property.getPlot().overlaps(properties[j].getPlot())) {
				return -4;
			}
		}
		
		if(property.equals(null)) {
			return -2;
		}else if (property.getPlot().encompasses(mgmComp.getPlot()) || mgmComp.getPlot().encompasses(property.getPlot()) == false) {
			return -3;
		}else if(properties[i] == null) {
					properties[i] = property;
					index = i;
		}else if(properties[i+1] == null) {
					properties[i+1] = property;
					index = i+1;
		}else if(properties[i+2] == null) {
					properties[i+2] = property;
					index = i+2;
		}else if(properties[i+3] == null) {
					properties[i+3] = property;
					index = i+3;
		} else if(properties[i+4] == null) {
					properties[i+4] = property;
					index = i+4;
		} else {
				return -1;
		}

		return index;
		}

	/**
	 * This method adds a property to the property array and returns an
	 * integer value of -1 if the array is full, a value of -2 if the 
	 * property is null, a value of -3 if the property is not encompassed
	 * by the Management Company plot, a value of -4 if any of the property
	 * plots overlap one another, or a value from 1 to 4 corresponding to 
	 * the index of the property array in which the property is added. This
	 * method accepts the name, city, rent, and owner of the property to be added
	 * to the properties array as its parameters.
	 * @param name The name of the property.
	 * @param city The city in which the property is located.
	 * @param rent The rent amount for the property.
	 * @param owner The owner of the property.
	 * @return The integer value corresponding either to the index of the array in
	 * which the property was added or one of the 4 scenarios.
	 */
	
	public int addProperty(String name, String city, double rent, String owner) {
		Property property = new Property();
		property.setPlot(plot.getX(), plot.getY(), plot.getWidth(), plot.getWidth());
		ManagementCompany mgmComp = new ManagementCompany();
		
		int index = 0;
		int i = 0;
		
		for(int j = 0; properties[j] != null; j++) {
			if(property.getPlot().overlaps(properties[j].getPlot())) {
				return -4;
			}
		}

		 if(property.equals(null)) {
			return -2;
		} else if (property.getPlot().encompasses(mgmComp.getPlot()) || mgmComp.getPlot().encompasses(property.getPlot()) == false) {
			return -3;
		}else if(properties[i] == null) {
			properties[i] = property;
			index = i;
		}else if(properties[i+1] == null) {
			properties[i+1] = property;
			index = i+1;
		}else if(properties[i+2] == null) {
			properties[i+2] = property;
			index = i+2;
		}else if(properties[i+3] == null) {
			properties[i+3] = property;
			index = i+3;
		} else if(properties[i+4] == null) {
			properties[i+4] = property;
			index = i+4;
		} else {
			return -1;
		}

		return index;
	}
	
	/**
	 * This method adds a property to the property array and returns an
	 * integer value of -1 if the array is full, a value of -2 if the 
	 * property is null, a value of -3 if the property is not encompassed
	 * by the Management Company plot, a value of -4 if any of the property
	 * plots overlap one another, or a value from 1 to 4 corresponding to 
	 * the index of the property array in which the property is added. This
	 * method accepts the name, city, rent, owner, and plot fields of the property 
	 * to be added to the properties array as its parameters.
	 * @param name The name of the property owner.
	 * @param city The city in which the property is located.
	 * @param rent The rent amount for the property.
	 * @param owner The owner of the property.
	 * @param x The x-coordinate of the property.
	 * @param y The y-coordinate of the property.
	 * @param width The width of the property.
	 * @param depth The depth of the property.
	 * @return The integer value corresponding either to the index of the array in
	 * which the property was added or one of the 4 scenarios.
	 */
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property property  = new Property();
		property.setPlot(x, y, width, depth);
		ManagementCompany mgmComp = new ManagementCompany();
		
		int index = 0;
		int i = 0;
		
		for(int j = 0; properties[j] != null; j++) {
			if(property.getPlot().overlaps(properties[j].getPlot())) {
				return -4;
			}
		}
		
		if(property.equals(null)) {
			return -2;
		} else if (property.getPlot().encompasses(mgmComp.getPlot()) || mgmComp.getPlot().encompasses(property.getPlot()) == false) {
			return -3;
		}else if(properties[i] == null) {
			properties[i] = property;
			index = i;
		}else if(properties[i+1] == null) {
			properties[i+1] = property;
			index = i+1;
		}else if(properties[i+2] == null) {
			properties[i+2] = property;
			index = i+2;
		}else if(properties[i+3] == null) {
			properties[i+3] = property;
			index = i+3;
		} else if(properties[i+4] == null) {
			properties[i+4] = property;
			index = i+4;
		}else {
				return -1;
		}
		return index;
	}

	/**
	 * This method displays the property information for a property at a
	 * given index, i, which is accepted as a parameter. 
	 * @param i The index of the property to be returned.
	 * @return The information of the property (i.e. owner, name, rent) at the index i.
	 */
	
	public String displayPropertyAtIndex(int i) {
		Property property = new Property();
		property = properties[i];
		return property.toString();
	}
	
	/**
	 * This method returns the maximum number of properties for the property array
	 * and accepts no parameters.
	 * @return The maximum amount of properties allowed in the properties array.
	 */
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	/**
	 * This method finds the property with the highest rent among
	 * the properties in the properties array.
	 * @return The property with the highest rent.
	 */
	
	public double maxRentProp() {
		
		double max = properties[0].getRentAmount();
		for(int i = 1; i< properties.length && properties[i] != null; i++) {
			if(properties[i].getRentAmount()>max) {
				max = properties[i].getRentAmount();
			}
		}
		return max;
	}
	
	/**
	 * This method determines the index of the property with the highest rent
	 * among the properties in the properties array.
	 * @return The index corresponding to the property with the highest rent
	 * among the properties in the properties array.
	 */
	
	public int maxRentPropertyIndex() {
		int maxIndex = 0;
		for(int i = 0; i < properties.length && properties[i] != null;i++) {
			if(properties[i].getRentAmount()==maxRentProp()) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	/**
	 * This method determines the total rent amount of all the properties
	 * in the properties array.
	 * @return The total rent amount of all the properties in the properties array.
	 */
	
	public double totalRent() {
		
		double totalRent = 0;
		double rent;
		for(int i = 0; i < properties.length && properties[i] != null; i++) {
			rent = properties[i].getRentAmount();
			totalRent+=rent;
		}
		return totalRent;
	}
	
	/**
	 * This method returns the information of every property in the 
	 * properties array as a string and accepts no parameters.
	 */
	
	public String toString() {
		String str = new String();
		String prop = new String();
		str = "";
		for(int i = 0; i < properties.length && properties[i] != null; i++) {
		 prop = "Property name: " + properties[i].getPropertyName() + "\nLocated in: "
				+ properties[i].getCity() + "\nBelonging to: " + properties[i].getOwner() +
				"\nRent Amount: " + properties[i].getRentAmount() + "\n";
		 str += prop;
		}
		return str;
	}
	
	/**
	 * This method returns the name of the Management Company and accepts
	 * no parameters.
	 * @return The name of the Management Company.
	 */
	
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method returns the Management Company plot and accepts
	 * no parameters.
	 * @return The Management Company plot.
	 */
	
	public Plot getPlot() {
		
		return plot;
	}
	
	
}
