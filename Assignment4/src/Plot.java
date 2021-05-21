import java.util.Properties;

/**
 * This class represents a geographical plot and provides methods for 
 * getting and setting the dimensions of plots as well as determining whether 
 * plots overlap or encompass one another.
 * @author hudson
 */

public class Plot {
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 * This no argument constructor creates a plot with an x value of 0, y value of 0,
	 * width of 1, and depth of 1.
	 */
	
	Plot(){
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
		
	}
	
	/**
	 * This copy constructor creates a plot based on another plot, p, which it accepts
	 * as a parameter.
	 * @param p The plot to be copied.
	 */
	
	Plot(Plot p){
		
		Plot plot = new Plot(p);
		
	}
	
	/**
	 * This constructor creates a plot based on an x coordinate, y coordinate, width,
	 * and depth, all of which are accepted as parameters and assigned to the variables
	 * x, y, width, and depth respectively.
	 * @param x The x-coordinate of the plot.
	 * @param y The y-coordinate of the plot.
	 * @param width The width of the plot.
	 * @param depth The depth of the plot.
	 */
	
	Plot(int x, int y, int width, int depth){
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		
	}
	
	/**
	 * This method determines if a plot overlaps another plot by accepting
	 * a Plot object, plot, and comparing its dimensions to another plot's
	 * and returning a boolean value.
	 * @param plot The plot whose dimensions are to be compared to another plot.
	 * @return True if the plots do overlap one another and false if they do 
	 * not overlap.
	 */
	
	public boolean overlaps(Plot plot) {
		Property p = new Property();
		p.setPlot(x, y, width, depth);
		int pX = p.getPlot().getX();
		int pWidth = p.getPlot().getWidth();
		int pY = p.getPlot().getY();
		int pDepth = p.getPlot().getDepth();
		int plotX = plot.getX();
		int plotY = plot.getY();
		int plotWidth = plot.getWidth();
		int plotDepth = plot.getDepth();
		
		if (pX > plotX && pX < (plotWidth + plotX) && (pY + pDepth) > plotY && plotY > pY) {
			return true;
		}else if (pX > plotX && pX < (plotX + plotWidth) && (plotY + plotDepth) > pY && plotY < pY) {
			return true;	
		} else if(plotX > pX && plotX < (pX + pWidth) && plotY < (pY + pDepth) && plotY > pY){
			return true;	
		}else if (plotX > pX && plotX < (pX + pWidth) && pY < (plotY + plotDepth) && pY > plotY) {
			return true;
		}else if(pX >= plotX && pY >= plotY && (pX + pWidth) <= (plotX + plotWidth) && (pY + pDepth) <= (plotY + plotDepth)) {
			return true;
		}else if(plotX >= pX && plotY >= pY && (plotX + plotWidth) <= (pX + pWidth) && (plotY + plotDepth) <= (pY + pDepth)) {
			return true;
		}else{
			return false;
		}
	
	}
	
	/**
	 * This method determines whether one plot encompasses another by plot by
	 * accepting a Plot object, plot, as a parameter and returning a boolean
	 * value.
	 * @param plot The plot to be compared to another plot.
	 * @return True if the Plot object, plot, is contained by the other plot object 
	 * or false otherwise.
	 */

	public boolean encompasses(Plot plot) {
		Plot p = new Plot();
		p.setX(x);
		p.setY(y);
		p.setDepth(depth);
		p.setWidth(width);
		int mgmWidth = p.getWidth();
		int mgmDepth = p.getDepth();
		int mgmY = p.getY();
		int mgmX = p.getX();
		int plotY = plot.getY();
		int plotX = plot.getX();
		int plotWidth = plot.getWidth();
		int plotDepth = plot.getDepth();
		
		if(plotY >= mgmY && plotX >= mgmX && (plotX + plotWidth) <= (mgmX + mgmWidth) 
				&& (plotY + plotDepth) <= (mgmY + mgmDepth)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * This method sets the x-coordinate of the plot.
	 * @param x The x-coordinate of the plot.
	 */

	public void setX(int x) {
		this.x = x;
		
	}
	
	/**
	 * This method sets the y-coordinate of the plot.
	 * @param y The y-coordinate of the plot.
	 */
	
	public void setY(int y) {
		this.y = y;
		
	}
	
	/**
	 * This method sets the width of the plot.
	 * @param width The width of the plot.
	 */
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * This method sets the depth of the plot.
	 * @param depth The depth of the plot.
	 */
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	/**
	 * This method returns the x-value of the plot.
	 * @return The x-coordinate of the plot.
	 */
	
	public int getX() {
		return x;
	}
	
	/**
	 * This method returns the y-value of the plot.
	 * @return The y-coordinate of the plot.
	 */

	public int getY() {
		return y;
	}
	
	/**
	 * This method returns the width of the plot.
	 * @return The width of the plot.
	 */
	
	public int getWidth() {
		return width;
	}
	
	/**
	 * This method returns the depth of the plot.
	 * @return The depth of the plot.
	 */
	
	public int getDepth() {
		return depth;
	}
	
	/**
	 * This method returns the x-value, y-value, width, and depth of the 
	 * plot as a string. 
	 */
	
	public String toString() {
		
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
		
	}
	
}
