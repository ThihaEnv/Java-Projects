abstract class BankAccount {
    //declare variable as private (encapsulation)
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    // Get account owner
    public String getAccountHolder() {
        return accountHolder;
    }
    //get account balance
    public double getBalance() {
        return balance;
    }
    //set account balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
    // abstract method
    public abstract void calculateInterest();
}