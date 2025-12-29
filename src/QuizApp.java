import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        // var declaration
        String generatedQuestions;
        String playerAnswer;
        Scanner input = new Scanner(System.in);
        int total = 0;

        //set questions values
        String[] questions = {"What is the main function of the router?",
                                "Which part of the computer considered as brain?",
                                "What year was facebook launched?",
                                "Who is known as the father of computers?",
                                "What was the first programming language?"};
        // set choices values
        String[][] choices = {{"1.Storing file.", "2.encrypting data.", "3.Directing internet traffic.", "4.Managing passwords."},
                                {"1.CPU", "2.Hard Drive", "3.RAM", "4.GPU"},
                                {"1.2000", "2.2004", "3.2006", "4.2008"},
                                {"1.Steve Jobs", "2.Bill Gates", "3.Alan Turing", "4.Charles Babbage"},
                                {"1.COBOL", "2.C", "3.Fortran", "4.Assembly"}};
        //set answers values
        String [] answers ={"3", "1", "2", "4", "3"};

        //intro header for the quiz game
        String introStars = "*************************************";
        System.out.printf("%s\nWelcome to the tech quiz game!\n%s\n\n",introStars,introStars);
        for (int i = 0; i < questions.length; i++) {
            //generate questions
            generatedQuestions = questions[i];
            System.out.println(i+1+". " + generatedQuestions);
            //generate choices in the range of 1 to 4.
            for (String answer : choices[i]) {
                System.out.println(answer);
            }
            // request answer from the player
            System.out.print("Enter your guess (1-4) : ");
            playerAnswer = input.nextLine();

            //check conditions for the player's answer input
            switch(playerAnswer){
                // send the info to the built method with parameters
                case "1","2","3","4"->total= checkAnswers(playerAnswer,answers[i],total);
                default->{
                    //repeat the questions if the input is not suitable.
                    System.out.println("Please insert number 1,2,3 or 4.");
                    i--;
                    continue;
                }
            }
        }
        //generate the final score line.
        System.out.printf("Your final score is %d out of %d!",total,questions.length);
    }
    static Integer checkAnswers(String playerAnswers,String answers,int total){
        String resultStars = "********";
        //check the answers are correct or not.
            if (playerAnswers.equals(answers)){
                System.out.printf("%s\nCORRECT!\n%s\n",resultStars,resultStars);
                return total+1;
            }else{
                System.out.printf("%s\nWRONG!\n%s\n",resultStars,resultStars);
                return total;
            }
    }
}
