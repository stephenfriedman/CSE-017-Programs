/* 
CSE 17 
Stephen Friedman
815983433
Program #2 DEADLINE: October 17, 2013 
Program Description: Football Box Scores 
*/
/**
 * This class has 2 constructors to make a FootballScore which is a scoring play. This has many instance 
 * variables to describe everything about this scoring play.
 * @author Stephen Friedman
 *
 */
public class FootballScore extends Score {
  private int quarter;
 private String time;
 private int patPts;
 private String patPlay;
 private String type;
 /**
  * This constructor takes 7 params and creates a FootballScore with a lot of details since it has 7 instance variables it assigns.
  * Used for touchdowns only.
  * @param aTeam the team that scored
  * @param aType the type of play used to score
  * @param aQuarter the quarter that this play occurred in
  * @param aTime the time the play was scored
  * @param aPlay a description of the play
  * @param somePatPts the amount of Pat points scored
  * @param aPatPlay a description of the Pat play
  */
 public FootballScore(String aTeam, String aType, int aQuarter, String aTime, String aPlay, int somePatPts, String aPatPlay)
 {
  super(aTeam,aPlay);
  type = aType;
  quarter = aQuarter;
  patPts = somePatPts;
  patPlay = aPatPlay;
  time=aTime;
  if(type.equals("TD"))
   points=6+patPts;
  else if(type.equals("FG"))
   points=3;
  else
   points=2;  
 }
 /**
  * Creates a FootballScore object for any scoring play other than a touchdown (Field Goal of Safety).
  * @param aTeam the team that scored
  * @param aType the type of play scored
  * @param aQuarter the quarter the play occurred in
  * @param aTime the time in the quarter the play occurred
  * @param aPlay description of the play
  */
 public FootballScore(String aTeam, String aType, int aQuarter, String aTime, String aPlay)
 {
  super(aTeam,aPlay);
  type = aType;
  quarter = aQuarter;
  patPts = 0;
  patPlay=null;
  time=aTime;
  if(type.equals("TD"))
   points = 6;
  else if(type.equals("FG"))
   points = 3;
  else
   points = 2;
 }
 /**
  * Accessor for the quarter the score occurred in
  * @return the quarter the score occurred in
  */
 public int getQuarter()
 {
  return quarter;
 }
/**
 * Accessor for the time in the quarter the score occurred
 * @return the time in the quarter the score occurred
 */
 public String getTime() {
  return time;
 }
/**
 * Accessor for the type of play used to score
 * @return the type of play used to score
 */
 public String getType()
 {
  return type;
 }
 /**
  * A String composed of the team that scored, the play, and the time it occurred.
  * If the play was a touchdown the Pat Play is included in the String.
  */
 public String toString()
 {
  if(patPlay==null)
    return getTeam()+" - "+getPlay()+" "+getTime();
  else
    return getTeam()+" - "+getPlay()+" ("+patPlay+") "+getTime();
 }
}
