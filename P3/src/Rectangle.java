/**
 * Recatangle is a sublcass of Shape that implements CharacterGraphic. It has a length and height
 * dimensions and a drawCharacter variable that represents the character used to display the Rectangle
 * on the screen when printed. Other methods include a draw method (how the shape is to be put on the grid)
 * and a setDrawCharacter which allows the drawCharacter to be changed.
 * @author stephen
 *
 */
public class Rectangle extends Shape implements CharacterGraphic{

	private int length;
	private int height;
	private char drawCharacter;
	/**
	 * Constructor for a Rectangle. By defaul drawCharacter is set to '*'
	 * @param aId the ID 
	 * @param loc the location (x,y)
	 * @param aLength the length dimension of the Rectangle
	 * @param aHeight the hieght dimension of the Rectangle
	 */
	public Rectangle(String aId, Coordinate loc,int aLength,int aHeight)
	{
		super(aId,loc);
		height=aHeight;
		length=aLength;
		drawCharacter='#';
	}
	/**
	 * Puts the Rectangle in the grid and eadch spot in the rectangle as well as its
	 * edges is made up of drawCharacter 
	 */
	public void draw(AsciiDisplay dis)
	{
		for(int row =0;row<height;row++)
		{
			for(int col=0;col<length;col++)
			{
				dis.putCharAt(location.getX()+col, location.getY()+row, drawCharacter);
			}
		}
	}
	/**
	 * Changes drawCharacter to a new character c
	 */
	public void setDrawCharacter(char c)
	{
		drawCharacter=c;
	}
	
}
