import java.util.Scanner;
import java.util.Arrays;

public class ATMMachineApp {
    private static Bank bank;
    private static Scanner scanner;

    public static void main(String[] args) {
        bank = new Bank(1000);
        scanner = new Scanner(System.in);
        
        while (true) {
            mainMenu();
        }
    }

    public static void mainMenu() {
        System.out.println("------ATM MENU-----");
        System.out.println("1. Create Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        
        int response = scanner.nextInt();
        scanner.nextLine();
        
        switch (response) {
            case 1:
                bank.createAccount();
                break;
            case 2: 
                Account loggedInAccount = bank.login();
                if (loggedInAccount != null) {
                    handleLoggedInMenu(loggedInAccount, bank);
                }
                break;
            case 3: 
                System.out.println("Thank you for using our ATM");
                System.exit(0);
            default:
                System.out.println("Invalid Option, Try again");
        }
    }

    public static void handleLoggedInMenu(Account account, Bank bank) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- ACCOUNT MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Change PIN");
            System.out.println("6. Close Account");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.printf("Current Balance: $%.2f%n", account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    bank.transfer(account);
                    break;
                case 5:
                    System.out.print("Enter current PIN: ");
                    String oldPin = scanner.nextLine();
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.nextLine();
                    account.changePin(oldPin, newPin);
                    break;
                case 6:
                    bank.closeAccount(account);
                    return;
                case 7:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }