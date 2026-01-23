import java.util.Scanner;

public class BankAccountSystem {
    public static void main(String[] args) {
        //request user inputs
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the account holder name : ");
        String name = input.nextLine();
        System.out.print("Enter the account balance : ");
        double balance = input.nextDouble();

        //give input data and make calculation
        BankAccount myAccount = new SavingsAccount(name, balance);

        //display outputs
        System.out.println("------------");
        System.out.printf("Account Holder: %s%n",myAccount.getAccountHolder());
        System.out.printf("Balance before interest: $ %.2f%n", myAccount.getBalance());
        //use interest calculation method
        myAccount.calculateInterest();
        System.out.printf("Balance after interest: $ %.2f", myAccount.getBalance());
        //input shutdown
        input.close();
    }
}