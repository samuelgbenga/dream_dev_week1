package mondayTwentyThreeAssessment.bank;

import mondayTwentyThreeAssessment.bank.exceptions.InvalidNameException;

import java.math.BigDecimal;
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank bank = new Bank("My Bank");

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("\n====== BANK MENU ======");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter option: ");

            int option = input.nextInt();

            try {
                switch (option) {

                    case 1 -> {
                        System.out.print("Enter Name: ");
                        input.nextLine(); // consume leftover newline
                        String name = input.nextLine();

                        System.out.print("Enter PIN: ");
                        String pin = input.nextLine();

                        System.out.print("Enter Account Number: ");
                        int number = input.nextInt();

                        bank.createAccount(name, pin, number);
                        System.out.println("Account created successfully!");
                    }

                    case 2 -> {
                        System.out.print("Enter Account Number: ");
                        int number = input.nextInt();

                        System.out.print("Enter Amount: ");
                        BigDecimal amount = input.nextBigDecimal();

                        bank.deposit(number, amount);
                        System.out.println("Deposit successful!");
                    }

                    case 3 -> {

                        System.out.print("Enter Name: ");
                        input.nextLine(); // consume leftover newline
                        String name = input.nextLine();

                        System.out.print("Enter Account Number: ");
                        int number = input.nextInt();

                        System.out.print("Enter PIN: ");
                        String pin = input.next();

                        System.out.print("Enter Amount: ");
                        BigDecimal amount = input.nextBigDecimal();

                        bank.withdraw(number, amount, name, pin );
                        System.out.println("Withdrawal successful!");
                    }

                    case 4 -> {
                        System.out.print("Enter Source Account Number: ");
                        int src = input.nextInt();

                        System.out.print("Enter Destination Account Number: ");
                        int des = input.nextInt();

                        System.out.print("Enter PIN: ");
                        String pin = input.next();

                        System.out.print("Enter Amount: ");
                        BigDecimal amount = input.nextBigDecimal();

                        bank.transfer(src, des, amount, pin);
                        System.out.println("Transfer successful!");
                    }

                    case 5 -> {
                        System.out.print("Enter Account Number: ");
                        int number = input.nextInt();

                        System.out.print("Enter PIN: ");
                        String pin = input.next();

                        BigDecimal balance = bank.checkBalance(number, pin);
                        System.out.println("Your Balance: " + balance);
                    }

                    case 6 -> {
                        System.out.println("Thank you for using the bank!");
                        isRunning = false;
                    }

                    default -> System.out.println("Invalid option. Try again.");
                }

            } catch (InvalidNameException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Operation failed: " + e.getMessage());
            }
        }

        input.close();
    }
}