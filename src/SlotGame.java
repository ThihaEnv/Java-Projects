import java.util.Random;
import java.util.Scanner;

public class SlotGame {
    public static void main(String[] args) {
        //var declaration
        Scanner input = new Scanner(System.in);

        //assigned value declaration
        String decision = "yes";
        int initialAmount = 100;

        //intro header for the slot game
        String introStars = "*************************************";
        System.out.printf("%s\nWelcome to the paid slot game!\n%s\n\n",introStars,introStars);
        System.out.println("Symbols : 🍒🍉🍋⭐🔔");

        //game start run as long as player says yes and still have amount to play
        while(decision.equals("yes") && initialAmount > 0) {
          System.out.printf("Current Balance : $%d\n", initialAmount);
          // transfer to methods with required parameters
          initialAmount = playGame(initialAmount,input);
            if(initialAmount <= 0){
                System.out.println("The current amount is insufficient to play.");
                break;
            }
          //ask player to play next round or not
          System.out.print("Would you like to play again ? (Yes, No) : ");
          decision = input.nextLine().toLowerCase();
          //check if the player input yes or no
          while (!decision.equals("yes") && !decision.equals("no")) {
              System.out.print("Please type 'yes' or 'no'.\nWould you like to play again ? (Yes, No) : ");
              decision = input.nextLine().toLowerCase();
          }
      }
        System.out.println("Thanks for your time to play.");
      //input shutdown
        input.close();
    }
    static int playGame(int initialAmount, Scanner input){
        //var declaration
        int betAmount;
        int currentAmount;
        Random gameRandom = new Random();
        String [] selectedChars = new String[3];
        //character value declaration
        String [] gameChars = {"🍒","🍉","🍋","⭐","🔔"};

        //request bet amount
        System.out.print("Place your bet amount : ");
        betAmount = input.nextInt();
        input.nextLine();//convert as string input

        //check condition if bet amount is insufficient to play
        while (betAmount > initialAmount || betAmount <= 0){
            System.out.println("Bet amount is higher than the amount you have.\nPlace your bet amount : ");
            betAmount = input.nextInt();
            input.nextLine();
        }

        System.out.println("Spinning...\n");

        // generate slot chars
        for( int i = 0; i < 3 ; i++) {
            selectedChars[i] = gameChars[gameRandom.nextInt(gameChars.length)];
            String lineSeparator = (i < 2) ? " | " : "\n";
            System.out.print(selectedChars[i]+lineSeparator);
        }
        //check random generated slot chars are same or not
        if(selectedChars[0].equals(selectedChars[1]) && selectedChars[1].equals(selectedChars[2])){
            System.out.print("You got three stripes!! You win!");
            currentAmount = betAmount * 3;
            initialAmount += currentAmount;
        }else if(selectedChars[0].equals(selectedChars[1]) || selectedChars[1].equals(selectedChars[2]) || selectedChars[0].equals(selectedChars[2])){
            System.out.println("You got two same characters!");
            currentAmount = betAmount * 2;
            initialAmount += currentAmount;
        }else{
            System.out.println("You lose!");
            initialAmount -= betAmount;
        }
        System.out.printf("Your current balance : %d\n", initialAmount);
        return initialAmount;
    }
}
