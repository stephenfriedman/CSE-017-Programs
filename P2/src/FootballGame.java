/* 
CSE 17 
Stephen Friedman
815983433
Program #2 DEADLINE: October 17, 2013 
Program Description: Football Box Scores 
*/
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class in my opinion does all the work of the program. It contains the main method which calls readGamesFromFile()
 * so an ArrayList of FootballGame objects is created from football.txt then for every FootballGame in this ArrayList a brief
 * description of the game is printed. Finally a boxscore of each FootballGame in the ArrayList is printed which uses this 
 * class's printBoxScore() which in turn uses 2 more methods from this class getHomeScoreByQuarter() and getvisitorScoreByQuarter.
 * @author Stephen Friedman
 *
 */
public class FootballGame extends Game {
/**
 * Constructor to create a FootballGame, 6 params needed. Simply calls Game class constructor.
 * @param aHomeTeam the home team
 * @param aHomeShort abbreviated name for home team
 * @param aVisitorTeam the visitor team
 * @param aVisitorShort abbreviated name for visitor team
 * @param aDateString the String form of the date the game was played
 * @param someScores the array that contains all the scoring plays from the game
 * @throws Exception if aDateString cannot be parsed correctly in Game
 */
 public FootballGame(String aHomeTeam, String aHomeShort, String aVisitorTeam, String aVisitorShort, String aDateString, Score[] someScores) throws Exception
 {
  super(aHomeTeam,aHomeShort,aVisitorTeam,aVisitorShort,aDateString,someScores);
 }
 /**
  * Calculates the amount of points the home team scored in each quarter, and puts these total into an int[] which is returned.
  * This is done by iterating thorugh the score[] and sorting through which of the elements in score[] are points earned for
  * the home team.
  * @return the int[] containing the amount of points earned in each of the four quarters by the home team
  */
 public int[] getHomeScoreByQuarter()
 {
  int[] scoresByQuarter=new int[4];
  int firstQuarterScore=0;
  int secondQuarterScore=0;
  int thirdQuarterScore=0;
  int fourthQuarterScore=0;
  
  for(int i=0;i<scores.length;i++)
  {

   FootballScore temp = (FootballScore)scores[i];
   if(temp.getTeam().equals(homeShort)&&temp.getQuarter()==1)
   {
     firstQuarterScore+=temp.getPoints();
   } 
   else if(temp.getTeam().equals(homeShort)&&temp.getQuarter()==2)
   {
     secondQuarterScore+=temp.getPoints();
   } 
   
   else if(temp.getTeam().equals(homeShort)&&temp.getQuarter()==3)
   {
     thirdQuarterScore+=temp.getPoints();
   } 
   
   else if(temp.getTeam().equals(homeShort)&&temp.getQuarter()==4)
   {
     fourthQuarterScore+=temp.getPoints();
   } 
  }  
  scoresByQuarter[0]=firstQuarterScore;
  scoresByQuarter[1]=secondQuarterScore;
  scoresByQuarter[2]=thirdQuarterScore;
  scoresByQuarter[3]=fourthQuarterScore;
  return scoresByQuarter;
 }
 /**
  * Calculates the amount of points the visitor team scored in each quarter, and puts these total into an int[] which is returned.
  * This is done by iterating thorugh the score[] and sorting through which of the elements in score[] are points earned for
  * the visitor team.
  * @return the int[] containing the amount of points earned in each of the four quarters by the visitor team
  */
 public int[] getVisitorScoreByQuarter()
 {
	 int[] scoresByQuarter=new int[4];
	  int firstQuarterScore=0;
	  int secondQuarterScore=0;
	  int thirdQuarterScore=0;
	  int fourthQuarterScore=0;

	  for(int i=0;i<scores.length;i++)
	  {
	   FootballScore temp = (FootballScore)scores[i];
	   if(temp.getTeam().equals(visitorShort)&&temp.getQuarter()==1)
	   {
	     firstQuarterScore+=temp.getPoints();
	   } 
	   else if(temp.getTeam().equals(visitorShort)&&temp.getQuarter()==2)
	   {
	     secondQuarterScore+=temp.getPoints();
	   } 
	   
	   else if(temp.getTeam().equals(visitorShort)&&temp.getQuarter()==3)
	   {
	     thirdQuarterScore+=temp.getPoints();
	   } 
	   
	   else if(temp.getTeam().equals(visitorShort)&&temp.getQuarter()==4)
	   {
	     fourthQuarterScore+=temp.getPoints();
	   } 
	  }  
	  scoresByQuarter[0]=firstQuarterScore;
	  scoresByQuarter[1]=secondQuarterScore;
	  scoresByQuarter[2]=thirdQuarterScore;
	  scoresByQuarter[3]=fourthQuarterScore;
	  return scoresByQuarter;
 }
/**
 * This method prints out an elaborate box score of a FootballGame. First the Game printBoxScore() method is used to print out 
 * the 2 teams playing and their scores. Then a breakdown for the scoring by quarter for each team is printed. Then a breakdown
 * of scoring plays by quarter in order of when in the game they were scored. Finally the date, home team, abbreviated name 
 * for the home team, visitor team, abbreviated name for the visitor team, and the number of scoring plays in the game are printed. 
 */
 public void printBoxScore()
 {	
	 int[]homeScores=getHomeScoreByQuarter();
	 int[]visitorScores=getVisitorScoreByQuarter();
	 super.printBoxScore();
	 System.out.println(getHomeTeam()+"          "+homeScores[0]+"  "+homeScores[1]+"  "+homeScores[2]+"  "+homeScores[3]+" -   "+homeScore);
	 System.out.println(getVisitorTeam()+"          "+visitorScores[0]+"  "+visitorScores[1]+"  "+visitorScores[2]+"  "+visitorScores[3]+" -   "+visitorScore);
	 System.out.println("First Quarter");
	 for(int i=0;i<scores.length;i++)
	 {
		FootballScore temp = (FootballScore)scores[i];
		if(temp.getQuarter()==1)
			System.out.println(temp.toString());
	 }
	 System.out.println("Second Quarter");
	 for(int i=0;i<scores.length;i++)
	 {
		FootballScore temp = (FootballScore)scores[i];
		if(temp.getQuarter()==2)
			System.out.println(temp.toString());
	 }
	 System.out.println("Third Quarter");
	 for(int i=0;i<scores.length;i++)
	 {
		FootballScore temp = (FootballScore)scores[i];
		if(temp.getQuarter()==3)
			System.out.println(temp.toString());
	 }
	 System.out.println("Fourth Quarter");
	 for(int i=0;i<scores.length;i++)
	 {
		FootballScore temp = (FootballScore)scores[i];
		if(temp.getQuarter()==4)
			System.out.println(temp.toString());
	 }
	 System.out.println(getDateString()+"      "+getHomeTeam()+"      "+homeShort+"      "+getVisitorTeam()+"      "+visitorShort+"      "+scores.length); 
 }
 /**
  * Reads a file and uses a delimiter to sort through the file and create FootballGame objects. These
  * objects are put into an ArrayList and returned.
  * @param aFile the file to be read and contains all the data for the FootballGame objects
  * @return an ArrayList containing FootballGame objects
  * @throws Exception if the file does not exist
  */
 public static ArrayList readGamesFromFile(String aFile) throws Exception
 {
	 ArrayList allGames= new ArrayList();
	 File y=new File(aFile);
	 Scanner myScanner = new Scanner(y);
	 myScanner.useDelimiter("\\t|[\\n\\r\\f]+");
	 //Keep making FootballGame objects while the file still has text to be read
	 while(myScanner.hasNext())
	 {
		 String theDate= myScanner.next();
		 String theHomeTeam=myScanner.next();
		 String theHomeTeamShort=myScanner.next();
		 String theVisitorTeam=myScanner.next();
		 String theVisitorTeamShort=myScanner.next();
		 int numPlays =Integer.parseInt(myScanner.next());
		 Score[] scoringPlays=new Score[numPlays];
		 //go thorugh all the scoring plays
		 for(int i=0;i<numPlays;i++)
		 {	
			 int aQuarter=Integer.parseInt(myScanner.next());
			 String aTime=myScanner.next();
			 String aTeam=myScanner.next();
			 String aType=myScanner.next();
			 //if the play is a TD then a Pat Description is needed and the amount of Pat Points
			 if(aType.equals("TD"))
			 {
				 String aDescription =myScanner.next();
				 String aPatDescription=myScanner.next();
				 int somePatPoints=Integer.parseInt(myScanner.next());
				 FootballScore aFootballScore=new FootballScore(aTeam,aType,aQuarter,aTime,aDescription,somePatPoints,aPatDescription);
				 scoringPlays[i]=aFootballScore;
			 }
			 else
			 {
				 String aDescription =myScanner.next();
				 FootballScore aFootballScore=new FootballScore(aTeam,aType,aQuarter,aTime,aDescription);
				 scoringPlays[i]=aFootballScore;
			 }
		 }
			 allGames.add(new FootballGame(theHomeTeam,theHomeTeamShort,theVisitorTeam,theVisitorTeamShort,theDate,scoringPlays));
	 }
	 return allGames;
 }
 /**
  * This method uses football.txt and an ArrayList of FootballGames is created out of it,  which is used to print
  * info about all of the FootballGames and then a box score for each game.
  * @param args  none given
  * @throws Exception if the file does not exist
  */
 public static void main (String[]args) throws Exception
 {
	 ArrayList allGames= readGamesFromFile("football.txt");
	 for(int i=0;i<allGames.size();i++)
	 {
		System.out.println(allGames.get(i).toString());
	 }
	 System.out.println("");
	 for(int i=0;i<allGames.size();i++)
	 {
		((FootballGame) allGames.get(i)).printBoxScore();
		System.out.println("");
	 }
	 
 }
 
}



  