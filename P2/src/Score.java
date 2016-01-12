/* 
CSE 17 
Stephen Friedman
815983433
Program #2 DEADLINE: October 17, 2013 
Program Description: Football Box Scores 
*/
/**
 * This class is a Score object which has a few instance variables about a Score. Here, Score means a play where points were
 * earned by a team. This class has 2 constructors. The toString method is used to return basic info about this Score
 * @author Stephen Friedman
 *
 */
public class Score {
 protected String team;
 protected String play;
 protected int points;
 /**
  * Constructor for a Score object given 3 params
  * @param aTeam the team that scored
  * @param aPlay the play they scored
  * @param somePoints the amount of points earned
  */
 public Score(String aTeam, String aPlay, int somePoints)
 {
  team = aTeam;
  play = aPlay;
  points = somePoints;
 }
 /**
  * Constructor given 2 params
  * @param aTeam the team that scored
  * @param aPlay the play they scored
  */
 public Score(String aTeam, String aPlay)
 {
  team = aTeam;
  play = aPlay;
  points = 1;
 }
 /**
  * Accessor for the team that scored
  * @return the team that scored
  */
 public String getTeam()
 {
  return team;
 }
 /**
  * Accessor for the type of play scored
  * @return the play that was used to score
  */
 public String getPlay()
 {
  return play;
 }
 /**
  * Accessor for the amount of points scored on the play
  * @return the amount of points scored on the play
  */
 public int getPoints()
 {
  return points;
 }

 /**
  * String representation of the team that scored and the play they used
  */
 public String toString()
 {
  return getTeam()+" - "+getPlay();
 }
}

