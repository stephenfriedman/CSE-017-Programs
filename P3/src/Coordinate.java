/**
 * This class represents a point on the coordinate plane, in this case a point in the display box that is printed
 * @author stephen
 *
 */

public class Coordinate {
	int x;
	int y;
	/**
	 * Constructor for a new Coordinate
	 * @param aX the x coordinate
	 * @param aY the y coordinate
	 */
	public Coordinate(int aX, int aY)
	{
		x=aX;
		y=aY;
	}
	/**
	 * Accessor method for x coordinate
	 * @return
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * Accessor method for y coordinate
	 * @return
	 */
	public int getY()
	{
		return y;
	}
}
