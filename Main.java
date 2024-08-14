import java.util.Scanner;
import java.lang.System;
class Main {
  public static void main(String[] args) {
    Game g = new Game();
    Scanner sc = new Scanner(System.in);
    String input="";
    do{
      g.start();
      System.out.println("Would you like to play again with a new deck? (y/n)");
    }
    while(!sc.nextLine().equals("n"));
    //clear console so it looks nice
    System.out.print("\033[H\033[2J");  
    System.out.flush();
    System.out.println("Thank you for playing!");
    System.exit(0);
  }
}