/**
 * This abstract class is the "template" for all the different types of shapes that can be created in this program.
 * A shape has both an ID and a location  (x and y coordinates). This abstract class also includes methods to move
 * a shape to new coordinates and a method to check if two shapes are exactly the same ones.
 * @author stephen
 *
 */
public abstract class Shape {

	protected String id;
	protected Coordinate location;
	/**
	 * Constructor for a shape. A shape has an ID and a location
	 * @param aId the ID for the shape
	 * @param aLocation the X,Y location of the shape
	 */
	public Shape(String aId, Coordinate aLocation)
	{
		id=aId;
		location=aLocation;
	}
	/**
	 * Accessor for the id
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * Abstract method for how a shape is to be drawn
	 * @param dis the AsciiDisplay to be drawn on
	 */
	public abstract void draw(AsciiDisplay dis);
	
	/**
	 * Move a shpae to a new location
	 * @param newLoc the new location to move the shape to
	 */
	public void move(Coordinate newLoc)
	{
		location=newLoc;
	}
	/**
	 * Checks if two shapes are the exact same ones by referencing ID's
	 */
	public boolean equals(Object obj)
	{
		if(obj instanceof Shape && ((Shape) obj).getId().equals(this.getId()))
			return true;
		else
			return false;
	}
}
