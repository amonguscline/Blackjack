import java.util.*;
class Game{
  private Deck d = new Deck();
  private ArrayList<Card> casino = new ArrayList<Card>();
  private ArrayList<Card> playerHand = new ArrayList<Card>();
  public void start(){
    d.shuffle();
    playerHand = d.deal();
    casino = d.deal();
    Scanner sc = new Scanner(System.in);
    String input = "";
    while(!input.equals("n")){
      //clear console so it looks nice
      System.out.print("\033[H\033[2J");  
      System.out.flush();
      
      System.out.println("Your hand: " + playerHand);
      System.out.println("You can see that the dealer has a " + casino.get(0));
      System.out.println("Would you like to hit? (y/n)");
      input = sc.nextLine();
      int pSum=d.handSum(playerHand);
      if(input.equals("y")){
        playerHand.add(d.hit());
        System.out.println("You got a "+playerHand.get(playerHand.size()-1));
        pSum = d.handSum(playerHand);
        if(pSum<21){continue;}
      }
      int dSum = dealerSum();
      if(pSum>21){
        System.out.println("Bust! You lose!");
      }
      else if(dSum>=pSum&&dSum<=21){
        System.out.println("You lose!");
        System.out.println("You had: "+playerHand+" ("+pSum+" points)");
        System.out.println("The dealer had: "+casino + " ("+dSum+" points)");
      }
      else if(dSum<pSum||dSum>21){
        System.out.println("You win!");
        System.out.println("You had: "+playerHand+" ("+pSum+" points)");
        if(dSum>21){System.out.println("The dealer busted!");}
        else System.out.println("The dealer had: "+casino + " ("+dSum+" points)");
      }
      else continue;
      break;
    }
  }
  public int dealerSum(){
    int dSum=0;
    do{
      dSum=d.handSum(casino);
      if(dSum<17){casino.add(d.hit());}
    }
    while(dSum<17);
    return dSum;
  }
}