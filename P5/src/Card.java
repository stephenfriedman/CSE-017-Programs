/* 
CSE 17 
Stephen Friedman
saf217
Program #5 DEADLINE: December 6, 2013 
*/
/**
 * This class represents 1 Card. A card a has a suit (C, D, H, S) and rank (1-13).
 * Methods include a toString method to represent the card and a equals method to comapre
 * this card with a given object.
 */
public class Card {

	private char suit;
	private int rank;
	/**
	 * This constructor creates a Card with a given suit and rank, given valid input.
	 * With invalid input an IllegalArgumentException is thrown.
	 * @param aSuit the suit of the card
	 * @param aRank the number value of the card (1-13)
	 */
	public Card(char aSuit, int aRank)
	{
		if((aSuit=='C'||aSuit=='D'||aSuit=='H'||aSuit=='S')&&aRank>0 &&aRank<14)
		{
			suit=aSuit;
			rank=aRank;	
		}
		else
			throw new IllegalArgumentException();
	}	
	/**
	 * Getter method for the suit
	 * @return the suit of the card
	 */
	public char getSuit()
	{
		return suit;
	}
	/**
	 * Getter method for the rank
	 * @return the rank of the card
	 */
	public int getRank()
	{
		return rank;
	}
	/**
	 * Returns the string representation of the rank of the card followed
	 * by the suit of the card. 
	 */
	public String toString()
	{
		String finalRank="";
		if(getRank()==1)
			finalRank=finalRank.concat("A");
		if(getRank()==13)
			finalRank=finalRank.concat("K");
		if(getRank()==12)
			finalRank=finalRank.concat("Q");
		if(getRank()==11)
			finalRank=finalRank.concat("J");
		if(getRank() > 1 && getRank()<11)
			finalRank=finalRank.concat(Integer.toString(getRank()));
		String combo=finalRank+Character.toString(getSuit());
		return combo;
	}
	/**
	 * Determines and returns if the given parameter matches this Card
	 */
	public boolean equals(Object o)
	{
		Card c = (Card)(o);
		if(c.getRank()==getRank() && c.getSuit()==getSuit())
			return true;
		else
			return false;
	}
	
}
