/**
 * CSE 017
 * Stephen Friedman
 * saf217
 * Program #3
 * Deadline: November 10th, 2013 10:00 PM EST
 * This program allows a text file to be taken in as a command line argument that gives commands
 * that are interpreted by the program to draw Shapes, move shapes, edit shapes, and delete shapes
 * that are printed onto the screen. The 3 shapes that can be made are a Point, a Rectangle, and a 
 * TextBox. Each of these shapes can be moved, their character representations changed, and they can
 * be deleted. The main method handles all of the file input and interpreting of the commands while
 * the other classes handle what to do given certain commands from the text file.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * AsciiDisplay is the object that holds the grid which contains all of the shapes put onto it. It also
 * contains the ArrayList of shapes that are created and then put onto the grid and displayed.
 * @author stephen
 *
 */
public class AsciiDisplay {

	private char[][] grid;
	private ArrayList shapes;
	/**
	 * Constructor for AsciiDisplay by default creates a 30 wide by 15 height grid and initializes the shapes ArrayList
	 */
	public AsciiDisplay()
	{
		grid = new char[30][15];
		shapes = new ArrayList();
	}
	/**
	 * Adds a shape to the shapes ArrayList
	 * @param s the shape to be added
	 */
	public void addShape(Shape s)
	{
		shapes.add(s);
	}
	/**
	 * Finds and returns a shape from the shape ArrayList and finds it by searching for the given parameter id.
	 * If the shape is not found then null is returned.
	 * @param id the ID to search for in the shapes ArrayList
	 * @return the shape with the given id or null if not found
	 */
	public Shape findShape(String id)
	{
		for(int i=0;i<shapes.size();i++)
		{
			if(shapes.get(i) instanceof Shape && ((Shape) shapes.get(i)).getId().equals(id))
			{
				return (Shape)(shapes.get(i));
			}
		}
		return null;
	}
	/**
	 * Moves a shape with the given id to a new location newLoc
	 * @param id the id of the shape to be moved
	 * @param newLoc the new location this shape is to be moved to
	 * @return 0 if the shape was moved, and -1 if the shape was not found
	 */
	public int moveShape(String id,Coordinate newLoc)
	{
		Shape toMove = findShape(id);
		if(toMove==null)
			return -1;
		toMove.move(newLoc);
		return 0;
	}
	
	/**
	 * Changes the drawCharacter of a shape with an id that matches the paramter's id 
	 * @param id the id of the shape to search for 
	 * @param c the new character drawCharacter is to be changed to
	 * @return 0 if the shape's drawCharacter was changed and -1 if the shape was not found
	 */
	public int changeChar(String id,char c)
	{
		Point toChange=(Point) findShape(id);
		if(toChange==null)
			return -1;
		toChange.setDrawCharacter(c);
		return 0;
	}
	/**
	 * Deletes a shape from the shape ArrayList
	 * @param id the id of the shape to be removed from shapes ArrayList
	 * @return 0 if the shape was removed, and -1 if the shape was not found
	 */
	public int deleteShape(String id)
	{
		Shape toDelete = findShape(id);
		if(toDelete==null)
			return -1;
		shapes.remove(toDelete);
		return 0;
	}
	/**
	 * Puts a character c onto the grid at [x][y]
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param c the character to be put at [x][y]
	 */
	public void putCharAt(int x,int y, char c)
	{
		grid[x][y]=c;
	}
	
	/**
	 * Clears the grid by setting all the spots to blank chars and then
	 * goes through every shape in shapes ArrayList and uses each shape's
	 * draw method to put each shape onto the grid
	 */
	public void updateGrid()
	{
		for(int col =0;col<30;col++)
		{
			for(int row=0;row<15;row++)
			{
				grid[col][row]=' ';
			}
		}
		
		for(int i=0;i<shapes.size();i++)
		{
			Shape toPrint =(Shape)(shapes.get(i));
			toPrint.draw(this);
		}
		
	}
	/**
	 * Prints out the grid as well as a border around the grid
	 */
	public void printGrid()
	{
		System.out.println("+------------------------------+");
		for(int row=0;row<15;row++)
		{
			System.out.print("|");
			for(int col=0;col<30;col++)
			{
				System.out.print(grid[col][row]);
			}
			System.out.println("|");
		}
		System.out.println("+------------------------------+");
	}
	/**
	 * The main method takes in 1 command line argument and if its readable the program continues from there. If there are not 1 command 
	 * line argument an error message is printed and the program exits. If there was 1 command line argument but it wasnt readable then 
	 * an error message is printed and the program quits. If the file is read then a Scanner is used to read each line in the text file.
	 * Each line is analyzed starting with the first character on the line which represents a command. If it is a valid command, then the 
	 * next peice of info on the line is read, the ID. The command is performed and the grid is updated as well as the ArrayList updated 
	 * accordingly. If there is an invalid command then the command is ignored and an error message is printed and the program continues
	 * onto the next command. If a command is called where it references a certain shape's ID, and the ID is not found, then it is treated
	 * as an invalid command and an error message is printed.
	 * @param args
	 */
	public static void main(String[] args)
	{
		if(args.length!=1)
		{
			System.out.println("Usage: java AsciiDisplay filename");
			System.exit(0);
		}
		Scanner s = null;
		File f = new File(args[0]);
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Couldn't open file: "+ f.toString());
			System.exit(0);
		}
		//Create the AsciiDisplay which holds the ArrayList of all the Shapes to be created and the grid
		AsciiDisplay a=new AsciiDisplay();
		//Go through every command in the file
		while(s.hasNextLine())
		{
			String line=s.nextLine();
			Scanner forIdOnly=new Scanner(line);
			char aCommand=forIdOnly.next().charAt(0);
			//represents the ID of a shape
			String theID="";
			if(forIdOnly.hasNext())
			{
				theID=forIdOnly.next();
			}
			//Checks for commands that involve creating a new Shape (no ID matching/searching needs to happen)
			if(aCommand=='P' || aCommand=='R' || aCommand=='T' || aCommand=='D')
			{
				//Create a scanner used to read each string on the line
				Scanner input=new Scanner(line);
				//Creates a Point
				if(aCommand=='P')
				{
					String command = input.next();
					theID=input.next();
					int xCoord=Integer.parseInt(input.next());
					int yCoord=Integer.parseInt(input.next());
					Point p =new Point(theID,new Coordinate(xCoord,yCoord));
					a.shapes.add(p);
					a.updateGrid();
				}
				//Creates a Rectangle
				else if(aCommand=='R')
				{
					String command = input.next();
					theID=input.next();
					int xCoord=Integer.parseInt(input.next());
					int yCoord=Integer.parseInt(input.next());
					int theLength=Integer.parseInt(input.next());
					int theHeight=Integer.parseInt(input.next());
					Rectangle r=new Rectangle(theID,new Coordinate(xCoord,yCoord),theLength,theHeight);
					a.shapes.add(r);
					a.updateGrid();

				}
				//Creates a TextBox
				else if(aCommand=='T')
				{
					String command = input.next();
					theID=input.next();
					int xCoord=Integer.parseInt(input.next());
					int yCoord=Integer.parseInt(input.next());
					String theContent="";
					//Keep adding the remaining strings to theContent since theContent is allowed to contain spaces
					while(input.hasNext())
					{
						theContent=theContent+" "+input.next();
					}
					TextBox t=new TextBox(theID,new Coordinate(xCoord,yCoord),theContent);
					a.shapes.add(t);
					a.updateGrid();

				}
				//Draws the grid onto the screen
				else if(aCommand=='D')
				{
					a.printGrid();
				}
			}
			
			//Checks for commands where ID mathcing/searching needs to take place
			else if(aCommand=='M' || aCommand=='C' || aCommand=='E')
			{
				//checks if the ID given matches an ID of an existing shape
				boolean contains=false;
				for(int i=0;i<a.shapes.size();i++)
				{
					Shape test=(Shape)(a.shapes.get(i));
					if(test.getId().equals(theID))
					{
						contains=true;
					}
				} 
				//Scanner used to read each string on the line
				Scanner input=new Scanner(line);
				//Moves a shape
				if(aCommand=='M' && contains)
				{
					String command = input.next();
					theID=input.next();
					int xCoord=Integer.parseInt(input.next());
					int yCoord=Integer.parseInt(input.next());
					Shape toMove=(Shape)(a.findShape(theID));
					toMove.move(new Coordinate(xCoord,yCoord));
					a.updateGrid();

				}
				//changes drawCharacter of a Shape
				else if(aCommand=='C' && contains)
				{
					String command = input.next();
					theID=input.next();
					char changedChar=input.next().charAt(0);
					Point toChange=(Point)(a.findShape(theID));
					toChange.setDrawCharacter(changedChar);
					a.updateGrid();

				}
				//Removes a shape from the grid and ArrayList
				else if(aCommand=='E' && contains)
				{
					String command = input.next();
					theID=input.next();
					Object toDelete=a.findShape(theID);
					a.shapes.remove(toDelete);
					a.updateGrid();
					
				}
				//Prints error message if the ID was invalid
				else
					System.out.println("Invalid argument");
			}
			//Prints error message if an invalid command was given
			else
				System.out.println("Invalid command: "+line.charAt(0));
		}
		
	}
}