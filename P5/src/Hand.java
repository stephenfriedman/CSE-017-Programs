/* 
CSE 17 
Stephen Friedman
saf217
Program #5 DEADLINE: December 6, 2013 
*/
/**
 * Represents a hand of cards. Methods include adding and removing cards to the hand.
 * Other methods return the size of the hand, a string of all the cards in the hand,
 * a method to check if the hand contains a certain card, and a method to get a certain
 * card at a certain index in the hand.
 */
public class Hand {

	private MyLinkedList<Card>cards;
	/**
	 * This method creates a playing Hand
	 */
	public Hand()
	{
		cards=new MyLinkedList<Card>();
	}
	/**
	 * This method adds a Card to the hand
	 * @param c the Card to be added
	 */
	public void addCard(Card c)
	{
		cards.add(c);
	}
	/**
	 * Removes a partuicular Card from the hand
	 * @param c the Card to be removed
	 */
	public void removeCard(Card c)
	{
		if(cards.contains(c))
		{
			cards.remove(c);
		}
	}
	/**
	 * Gets a Card at a certain index in the hand
	 * @param index the index of the card to be retreived
	 * @return the Card at the index
	 */
	public Card getCard(int index)
	{
		if(index>=0 && index<cards.size && cards.size>0)
		{
			return cards.get(index);
		}
		else
			return null;
	}
	/**
	 * Returns whether or not the hand contains a certain card
	 * @param c the card to be searched for
	 * @return true if hand contains the card, false if not
	 */
	public boolean contains(Card c)
	{
		if(cards.contains(c))
			return true;
		else
			return false;
	}
	/**
	 * Returns the size of the hand (number of cards in hand)
	 * @return the number of cards in the hand
	 */
	public int size()
	{
		return cards.size;
	}
	/**
	 * Returns a string representation of every card in the hand
	 */
	public String toString()
	{
		String deck="[";
		for(int i=0;i<cards.size;i++)
		{
			deck=deck.concat(cards.get(i).toString());
			if(!(i==cards.size-1))				
				deck=deck.concat(", ");
			else
				deck=deck.concat("]");
		}
		return deck;
	}
}
