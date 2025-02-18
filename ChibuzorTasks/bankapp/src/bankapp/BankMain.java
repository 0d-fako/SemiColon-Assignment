package bankapp.src.bankapp;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to " + bank.getBankName());
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Transfer Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Update PIN");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createAccount(bank, scanner);
                    break;
                case 2:
                    depositMoney(bank, scanner);
                    break;
                case 3:
                    transferMoney(bank, scanner);
                    break;
                case 4:
                    checkBalance(bank, scanner);
                    break;
                case 5:
                    updatePin(bank, scanner);
                    break;
                case 6:
                    running = false;
                    System.out.println("Thank you for using " + bank.getBankName() + ". Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void createAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Set your PIN: ");
        String pin = scanner.nextLine();

        bank.createAccount(firstName, lastName, pin);
        System.out.println("Account created successfully!");
    }

    private static void depositMoney(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        try {
            bank.deposit(accountNumber, amount);
            System.out.println("Deposit successful. New balance: " + bank.checkBalance(accountNumber, "pin"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void transferMoney(Bank bank, Scanner scanner) {
        System.out.print("Enter your account number: ");
        String senderAccount = scanner.nextLine();
        System.out.print("Enter recipient's account number: ");
        String recipientAccount = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        try {
            bank.transfer(senderAccount, recipientAccount, amount, pin);
            System.out.println("Transfer successful.");
            System.out.println("Your new balance: " + bank.checkBalance(senderAccount, pin));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void checkBalance(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        try {
            double balance = bank.checkBalance(accountNumber, pin);
            System.out.println("Your balance: " + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updatePin(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter your current PIN: ");
        String oldPin = scanner.nextLine();
        System.out.print("Enter your new PIN: ");
        String newPin = scanner.nextLine();

        try {
            Account account = bank.getAccounts().stream()
                    .filter(a -> a.getAccountNumber().equals(accountNumber))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Account not found"));

            account.updatePin(oldPin, newPin);
            System.out.println("PIN updated successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
