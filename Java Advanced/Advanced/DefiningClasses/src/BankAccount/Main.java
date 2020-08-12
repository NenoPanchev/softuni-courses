package BankAccount;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<BankAccount> bankAccountsList = new LinkedList<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount account = new BankAccount();
                    bankAccountsList.add(account);
                    System.out.printf("Account ID%d created%n", account.getID());
                    break;

                case "Deposit":
                    int iD = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);
                    if (iD <= bankAccountsList.size()) {
                        bankAccountsList.get(iD - 1).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, iD);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;

                case "SetInterest":
                    double newRate = Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(newRate);
                    break;

                case "GetInterest":
                    iD = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (iD <= bankAccountsList.size()) {
                        double interest = bankAccountsList.get(iD - 1).getInterest(years);
                        System.out.printf("%.2f%n", interest);
                    } else {
                        System.out.println("Account does not exist");
                    }
            }

            input = scan.nextLine();
        }
    }
}