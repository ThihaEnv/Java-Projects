class SavingsAccount extends BankAccount {
    //inheritance
    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    // Overriding the abstract method with polymorphism
    //calculating interest
    @Override
    public void calculateInterest() {
        // 5% interest
        double interestRate = 0.05;
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
    }
}