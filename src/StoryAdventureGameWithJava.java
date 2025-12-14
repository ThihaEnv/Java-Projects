import java.util.Random;
import java.util.Scanner;

public class StoryAdventureGameWithJava {
    public static void main(String[] args) {
        //var declaration
        String name;
        int lane;
        int option;
        Random range = new Random();
        Scanner input = new Scanner(System.in);
        int monsterStrength = range.nextInt(1,11);// monster strength from 1 to 10

        // request traveller name input
        System.out.print("Hello adventurer, What is your name? : ");
        name = input.nextLine().toUpperCase();

        //game intro words to choose lane
        System.out.printf("\nHello,%s. Your journey begins now.\nYou enter a dark forest and reach a split in a path.",name);
        System.out.println("\nDo you :\n1-Go left\n2- Go right");
        System.out.print("Choose option 1 or 2 : ");
        lane = input.nextInt();
        //check condition for choosing the lanes
        //choosing left lane
        if ( lane == 1 ){
            System.out.println("\nYou walk along the left path and find a glowing cave!\nSuddenly, a wild creature appears!\n");
            System.out.printf("The monster has strength of %d.\n",monsterStrength);
            System.out.println("What will you do?\n1-Attack\n2-Run");
            System.out.print("Choose Option 1 or 2 : ");
            option = input.nextInt();
            //check condition to choose to attack the monster
            if ( option == 1 ){
                // will attack continously till monster strength become zero.
                while (monsterStrength > 0){
                    int playerPower = range.nextInt(1,6);
                    monsterStrength -= playerPower;
                    if( monsterStrength > 0) {
                        System.out.printf("\nYou strike the creature for %d damage.\n",playerPower);
                        System.out.printf("The creature remaining strenght : %d\n",monsterStrength);
                        System.out.println("What will you do?\n1-Attack\n2-Run");
                        System.out.print("Choose Option 1 or 2 : ");
                        option = input.nextInt();
                        //50% chance of survival
                        if( option == 2 ){
                            int escapeChance = range.nextInt(2); // 50% chance of survival
                            if ( escapeChance == 0 ) {
                                System.out.println("You escaped successfully.\nYou run out of the forest to safety.");
                                break;
                            }else {
                                System.out.println("\nYou tried to run but the creature blocked your path!");
                                System.out.println("What will you do?\n1-Attack\n2-Run");
                                System.out.print("Choose Option 1 or 2 : ");
                                option = input.nextInt();
                            }
                        }
                    }else{
                        // for victory over the monster
                        System.out.printf("\nThe creature has been defeated!\nCongratulations! %s You survived the adventure.\nYou leave the forest stronger and wiser.",name);
                    }
                }
            }else{
                //directly escaped from the monster without attacking
                System.out.println("You escaped successfully.\nYou run out of the forest to safety.");
            }
        }else{
            System.out.println("You follow the right path and discovered an abandoned village!\nSuddenly, a wild creature appears!");
            System.out.printf("The creature has the strength of : %d\nWhat will you do?\n1-Attack\n2-Run\n",monsterStrength);
            System.out.print("Choose option 1 or 2 : ");
            option = input.nextInt();
            //check condition to choose to attack the monster
            //check condition for start attacking
            if ( option == 1 ){
                while (monsterStrength > 0){
                    int playerPower = range.nextInt(1,6);
                    monsterStrength -=  playerPower;
                    if( monsterStrength > 0) {
                        System.out.printf("You strike the creature for %d\n damage", playerPower);
                        System.out.printf("The creature remaining strenght : %d\n",monsterStrength);
                        System.out.println("You have two options.\n1-Attack\n2-Run");
                        System.out.print("Choose Option 1 or 2 : ");
                        option = input.nextInt();
                        //50 % chance of survival
                        if( option == 2 ){
                            int escapeChance = range.nextInt(2); // 50% chance of survival
                            if ( escapeChance == 0 ) {
                                System.out.println("You escaped successfully.\nYou run out of the forest to safety.");
                                break;
                            }else{
                                System.out.println("\nYou tried to run but the creature blocked your path!\nWhat will you do?\n1-Attack\n2-Run");
                                System.out.print("Choose Option 1 or 2 : ");
                                option = input.nextInt();
                            }
                        }
                    }else{
                        // for victory over the monster
                        System.out.printf("\nThe creature has been defeated!\nCongratulations! %s You survived the adventure.\nYou leave the forest stronger and wiser.",name);
                    }
                }
            }else{
                //directly escaped from the monster
                System.out.println("You escaped successfully.\n You run out of the forest to safety.");
            }
        }
        //shutdown input
        input.close();
    }
}
