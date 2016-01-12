/**
 * Point is a subclass of Shape and implements CharacterGraphic and its simply a one character 
 * point with an ID and location. Methods include a draw method which defines how a point should
 * be created on the grid, and a setDrawCharacter which allows the character representation of
 * the point to be changed to a new one.
 * @author stephen
 *
 */
public class Point extends Shape implements CharacterGraphic{
	
	private char drawCharacter;
	/**
	 * Calls Shapes constructor and by default sets the draw character to '*'
	 * @param aId the ID for the point
	 * @param aLocation the location for the point
	 */
	public Point(String aId, Coordinate aLocation)
	{
		super(aId,aLocation);
		drawCharacter='*';
	}
	/**
	 * Puts the point character into the grid at its location (x,y)
	 */
	public void draw(AsciiDisplay dis)
	{
		dis.putCharAt(location.getX(),location.getY(),drawCharacter);
	}
	/**
	 * Sets drawCharacter to a new character c
	 */
	public void setDrawCharacter(char c)
	{
		drawCharacter=c;
	}
}
