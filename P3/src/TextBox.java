/**
 * TextBox is a subclass of Shape that is just text that can be put into grid (one char per coordinate in grid)
 * @author stephen
 *
 */
public class TextBox extends Shape{

	private String content;
	/**
	 * Consterucotr for a TextBox
	 * @param aId the ID
	 * @param aLoc the location (x,y)
	 * @param someContent the text in the TextBox to be put into the grid
	 */
	public TextBox(String aId,Coordinate aLoc,String someContent)
	{
		super(aId,aLoc);
		content=someContent;
	}
	/**
	 * Puts each char from content into one coordiante on grid, going from left to right (increasing x value)
	 */
	public void draw(AsciiDisplay dis)
	{
		for(int i=0;i<content.length();i++)
		{
			dis.putCharAt(location.getX()+i, location.getY(), content.charAt(i));
		}
	}
}