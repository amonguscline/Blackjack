import java.util.*;
class Card{
  private String suit;
  private String value;
  public Card(String suit, String value){
    this.suit = suit;
    this.value = value;
  }
  public String toString(){
    return this.value+" of "+this.suit;
  }
  public void print(){
    System.out.println(this.toString());
  }
  public int numberValue(){
    if(value.equals("Jack")||value.equals("Queen")||value.equals("King")){
      return 10;
    }
    else if(value.equals("Ace")){
      return 11;
    }
    else return Integer.parseInt(value);
  }
  public boolean isAce(){
    return this.value.equals("Ace");
  }
}