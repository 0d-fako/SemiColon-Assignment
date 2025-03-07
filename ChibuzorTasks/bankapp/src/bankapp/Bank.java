package bankapp.src.bankapp;


import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private String bankName;
    private int accountCounter;


    public Bank( String bankName ) {
        this.bankName = bankName;
        this.accountCounter = 0;
        this.accounts = new ArrayList<>();

    }

    public void createAccount(String firstName, String lastName, String pin) {
        if (firstName == null || lastName == null || pin == null) {
            throw new IllegalArgumentException("First name, last name, and PIN cannot be null");
        }
        if (firstName.isEmpty() || lastName.isEmpty() || pin.isEmpty()) {
            throw new IllegalArgumentException("First name, last name, and PIN cannot be empty");
        }
        accounts.add(new Account(firstName, lastName, generateAccountNumber(), pin));
    }

    public String generateAccountNumber() {
        String number = String.valueOf(accountCounter);
        accountCounter++;
        return number;

    }

    public void transfer(String sender, String recipient, double amount, String pin) {
        Account senderAccount = findAccount(sender);
        Account recipientAccount = findAccount(recipient);
        if (senderAccount == null || recipientAccount == null) throw new IllegalArgumentException("Sender or recipient not found");
        if (senderAccount == recipientAccount ) throw new IllegalArgumentException("Sender and recipient can not be same");
        senderAccount.withdraw(amount, pin);
        recipientAccount.deposit(amount);
    }


    private Account findAccount(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) throw new IllegalArgumentException("Invalid account number");
        if (accounts.isEmpty()) throw new IllegalArgumentException("No account found");
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) return account;
        }
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public String getBankName() {
        return bankName;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account == null) throw new IllegalArgumentException();
        if (amount < 0) throw new IllegalArgumentException();
        account.deposit(amount);
    }

    public double checkBalance(String accountNumber, String pin) {
        if (accountNumber == null) throw new IllegalArgumentException("Account cannot be null");
        if (accounts.isEmpty()) throw new IllegalArgumentException("No account found");
        if (pin == null) throw new IllegalArgumentException("Invalid pin");
        Account account = findAccount(accountNumber);
        if (account == null) throw new IllegalArgumentException("No account found");
        return account.getBalance();
    }
}
