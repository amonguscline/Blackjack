import java.util.*;
class Deck{
  private ArrayList<Card> deck;
  public Deck(){
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] values = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    deck = new ArrayList<Card>();
    for(int i=0;i<suits.length;i++){
      for(int j=0;j<values.length;j++){
        deck.add(new Card(suits[i],values[j]));
      }
    }
  }
  public void shuffle(){
    Collections.shuffle(deck);
  }
  public ArrayList<Card> deal(){
    ArrayList<Card> cards = new ArrayList<Card>();
    cards.add(deck.get(0));
    cards.add(deck.get(1));
    deck.remove(0);
    deck.remove(0);
    return cards;
  }
  public Card hit(){
    Card c = deck.get(0);
    deck.remove(0);
    return c;
  }
  public int handSum(ArrayList<Card> hand){
    int sum=0;
    for(int i=0;i<hand.size();i++){
      sum+=hand.get(i).numberValue();
    }
    if(sum>21){
      for(int i=0;i<hand.size();i++){
        if(hand.get(i).isAce()) sum-=10;
      }
    }
    return sum;
  }
}