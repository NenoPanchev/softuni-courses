package BankAccount;

public class BankAccount {
    private int iD;
    private double balance;
    private static int bankAccountCount = 1;
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    BankAccount() {
        this.iD = bankAccountCount++;
    }

    public int getID() {
        return iD;
    }
}
