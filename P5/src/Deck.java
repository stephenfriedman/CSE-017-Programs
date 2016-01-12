/* 
CSE 17 
Stephen Friedman
saf217
Program #5 DEADLINE: December 6, 2013 
Program Description: This program simulates a deck of cards and hands of cards. It 
allows for cards to be moved to and from hands which can vary in  number and size.
By default the deck is set to a standard 4 suit 52 card deck (no jokers). The deck
is in the form of a linkedlist which allows it to be managed exactly how a real
deck of cards is managed. The deck of cards contains 52 individual Cards, each which
has their own suit and rank. The main method runs through scenarios of playing
with the cards by shuffling the cards and dealing the cards to various hands and
exchanging the cards to and from a hand.
*/
/**
 * This class represents a deck of cards. The included methods give capabilities 
 * to shuffle the deck, give a string representation of the deck, draw cards
 * from the deck, exchange cards in the deck, and deal hands.
 */
public class Deck {
	
	private MyLinkedList<Card>cards;	
	/**
	 * This constructor creates a deck of all 52 playing cards
	 */
	public Deck()
	{
		cards=new MyLinkedList<Card>();
		int spot=0;
		for(int i=1;i<=13;i++)
		{
			cards.add(spot,new Card('C',i));
			spot++;
		}
		for(int i=1;i<=13;i++)
		{
			cards.add(spot,new Card('D',i));
			spot++;
		}
		for(int i=1;i<=13;i++)
		{
			cards.add(spot,new Card('H',i));
			spot++;
		}
		for(int i=1;i<=13;i++)
		{
			cards.add(spot,new Card('S',i));
			spot++;
		}
	}
	/**
	 * This method shuffles the deck. It does this by
	 * removing a random sized set of cards from a random
	 * spot in the deck and adds that set to the front of the
	 * deck. This process is repeated 30 times.
	 */
	public void shuffle()
	{
		int start=0;
		int end=0;
		for(int i=0;i<30;i++)
		{
			start=0;
			end=0;
			while(start==end || start>end)
			{
				start=(int) (Math.random()*52);
				end=(int)(Math.random()*52);
			}
			MyLinkedList<Card> takenOut=cards.extractSublist(start, end);
			cards.prepend(takenOut);
		}
	}
	/**
	 * This method pulls one card off the deck
	 * and returns this Card
	 * @return the Card being drawn from the deck
	 */
	public Card draw()
	{
		if(cards.size==0)
			return null;
		else
			return cards.remove(0);
	}
	/**
	 * This method removes a certain card from a certain hand
	 * and then the hand receives a card from the top of the deck.
	 * The card that was originally taken away from the hand is put on
	 * the bottom of the deck.
	 * @param h the hand to make the exchange
	 * @param c the card to be removed from the hand
	 */
	public void exchangeCard(Hand h, Card c)
	{
		if(h.contains(c)&&cards.size>0)
		{
			h.removeCard(c);
			cards.add(c);
			Card toAdd =cards.remove(0);
			h.addCard(toAdd);
		}
	}
	/**
	 * This method deals out a certain number of hands with
	 * a certain number of cards for each hand. It will work
	 * to fill all these hands until it has done so or the deck
	 * has been depleted of cards.
	 * @param numHands the number of hands to be dealt
	 * @param handSize the number of cards per hand
	 * @return an array of all the hands dealt
	 */
	public Hand[] deal(int numHands,int handSize)
	{
		Hand[] hands =new Hand[numHands];
		int numToDeal=numHands*handSize;
		int whichHand=0;
		for(int i=0;i<numHands;i++)
		{
			hands[i]=new Hand();
		}
		while(cards.size>0&&numToDeal>0)
		{
			if(whichHand==numHands)
				whichHand=0;
			hands[whichHand].addCard(cards.remove(0));
			numToDeal--;
			whichHand++;
		}
		return hands;
	}
	/**
	 * This method returns a string of all of the 
	 * cards in the deck.
	 */
	public String toString()
	{
		
		String deck="[";
		for(int i=0;i<cards.size;i++)
		{
			Card c=cards.get(i);
			deck=deck.concat(c.toString());
			if(!(i==cards.size-1))				
				deck=deck.concat(", ");
			else
				deck=deck.concat("]");
		}
		return deck;
	}
	/**
	 * The main method creates a deck, prints the deck contents,
	 * shuffles the deck, prints the shuffled deck, deals
	 * 4 hands each with 5 cards per hand, prints each hand,
	 * prints the deck after the deal, exchanges a card from 
	 * the first hand, prints out the new hand after the 
	 * exchange, and finally prints the deck out after the
	 * exchange.
	 * @param args none given
	 */
	public static void main (String[]args)
	{
		Deck myDeck = new Deck(); 
		System.out.println("Initial Deck:"); 
		System.out.println(myDeck.toString()); 
		myDeck.shuffle(); 
		System.out.println("Deck after shuffle:"); 
		System.out.println(myDeck.toString()); 
	    System.out.println("Dealing..."); 
	    Hand[] myHands = myDeck.deal(4,5);
	    for (int i=0; i < myHands.length; i++) 
	    {
	    	 System.out.println("Hand " + i + ": " + myHands[i]); 
	    }
	    System.out.println("Deck after deal:"); 
	    System.out.println(myDeck.toString()); 
	    System.out.println("Hand 0 exchanging first card:"); 
	    myDeck.exchangeCard(myHands[0], myHands[0].getCard(0)); 
	    System.out.println("New Hand 0: " + myHands[0]); 
	    System.out.println("Deck after exchange:"); 
	    System.out.println(myDeck.toString()); 
	 



	}

}
