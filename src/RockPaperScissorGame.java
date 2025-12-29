import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorGame {
    public static void main(String[] args) {
        // var declaration
        String playerSide;
        Scanner input = new Scanner(System.in);
        // set default value "yes" to retain the game loop situation
        String decision = "yes";
        System.out.println("Welcome from Rock,Paper,Scissors game.");

        while ( decision.equals("yes") ) {
            //request game input for the game.
            System.out.print("\nEnter your move (rock,paper,scissors) : ");
            playerSide = input.nextLine().toLowerCase();
            //check the value is correct or not.
            switch (playerSide) {
                case "" -> {
                    System.out.println("\nMust input the value.");
                    continue;
                }
                // transfer the value to custom method and proceed with method.
                case "scissors", "paper", "rock" -> playGame(playerSide);
                default -> {
                    System.out.println("\nThe input value is not correct. Please insert the correct value.");
                    continue;
                }
            }
            // asking user to play the game again.
            System.out.print("\nWould you like to play it again? (Yes, No) : ");
            decision = input.nextLine().toLowerCase();
            while (!decision.equals("yes") && !decision.equals("no")) {
                System.out.print("Please type 'yes' or 'no'.\nWould you like to play again ? (Yes, No) : ");
                decision = input.nextLine().toLowerCase();
            }
        }
        // exit out of the game
        System.out.println("Thanks for your time to play.");
        //shut down the input
        input.close();
    }
    static void playGame( String playerSide){
        // set the random type and set the values for the random data.
        Random computerSide = new Random();
        String [] gameChars = {"rock","paper","scissors"};
        int computerResult = computerSide.nextInt(gameChars.length);
        // final computer choice data ("rock","paper","scissors")
        String computerChoice = gameChars[computerResult];
        System.out.printf("Computer choose %s.\n",computerChoice);
        // check condition the choices between computer and player to determine the winner
        if (computerChoice.equals("scissors")) {
            switch (playerSide) {
                case "rock" -> System.out.println("You Win!");
                case "paper" -> System.out.println("You lose!");
                default -> System.out.println("You draw!");
            }
        } else if (computerChoice.equals("paper")) {
            switch (playerSide) {
                case "scissors" -> System.out.println("You Win!");
                case "rock" -> System.out.println("You lose!");
                default -> System.out.println("You draw!");
            }
        }else{
            switch (playerSide) {
                case "scissors" -> System.out.println("You lose!");
                case "paper" -> System.out.println("You Win!");
                default -> System.out.println("You draw!");
            }
        }
    }
}
