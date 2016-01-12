/* 
CSE 17 
Stephen Friedman
815983433
Program #2 DEADLINE: October 17, 2013 
Program Description: Football Box Scores 
*/
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class is the parent of FootballGame and holds many instance variables about a game. This class also has the score[] which is the
 * array that holds all of the scoring plays in the game. This class only has 1 constructor.
 * @author Stephen Friedman
 *
 */
public class Game {
 protected String homeTeam;
 protected String homeShort;
 protected String visitorTeam;
 protected String visitorShort;
 protected int  homeScore;
 protected int visitorScore;
 protected Date date;
 protected Score[] scores;

 /**
  * Constructor a game object given 6 parameters
  * @param aHomeTeam the name of the home team
  * @param aHomeShort the abbreviated name for the home team
  * @param aVisitorTeam the name of the visiting team
  * @param aVisitorShort the abbreviated name for the visiting team
  * @param aDateString the date of the game (MM/dd/yy)
  * @param someScores the array that contains all the scoring plays (Score objects) in a game
  * @throws Exception thrown if there is an error in parsing aDateString
  */
 public Game(String aHomeTeam, String aHomeShort, String aVisitorTeam, String aVisitorShort, String aDateString, Score[] someScores) throws Exception
 {
 homeTeam = aHomeTeam;
 homeShort=aHomeShort;
 visitorTeam=aVisitorTeam;
 visitorShort=aVisitorShort;
 //allows the date to be formatted so that date can be a Date object
 SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
 date=stdDate.parse(aDateString);
 scores=someScores;
 homeScore=0;
 visitorScore=0;
 sumScores();
 }
 
 /**
  * Accessor for homeTeam
  * @return the home team
  */
 public String getHomeTeam()
 {
  return homeTeam;
 }
 /**
  * Accessor for visitorTeam
  * @return the visiting Team
  */
 public String getVisitorTeam()
 {
  return visitorTeam;
 }
 /**
  * Converts date into a string and returns it
  * @return string representation of date
  */
 public String getDateString()
 {
	 SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
	 return stdDate.format(date);
 }
 /**
  * Prints the game matchup and the teams' scores in the game
  */
 public void printBoxScore()
 {
  System.out.println(getVisitorTeam()+" at " + getHomeTeam()+": "+visitorScore+"-"+homeScore);
 }
 /**
  * Prints the date of the game and which teams played
  */
 public String toString()
 {
  return getDateString()+": "+getVisitorTeam()+" at " + getHomeTeam();
 }
 /**
  * Compares if the given Object parameter is a game with the same home team, visitor team, and date
  */
 public boolean equals(Object o)
 {
  if(o instanceof Game && ((Game) o).getHomeTeam().equals(this.getHomeTeam())&&((Game) o).getVisitorTeam().equals(this.getVisitorTeam())&&((Game) o).getDateString().equals(this.getDateString()))
   return true;
  return false;
 }
 /**
  * Totals the score for the home team and visitor team by iterating through score[] and determining which team scored and gets the points for each score
  */
 public void sumScores()
 {
	 for(int i=0;i<scores.length;i++)
	 {
		 //System.out.println("The team that scored is: "+scores[i].getTeam());
		 if(scores[i].getTeam().equals(homeShort))
		 {
			 homeScore+=scores[i].getPoints(); 
		 }
			
		 else
		 {
			 visitorScore+=scores[i].getPoints();
		 }
		 
	 }
 }
}
