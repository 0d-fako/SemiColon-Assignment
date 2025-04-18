package bankapp.src.bankapp;

public class Account {
    private double balance;
    private String pin;
    private String accountNumber;
    private String firstName;
    private String lastName;

    public Account(String firstName, String lastName, String accountNumber, String pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.pin = pin;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount, String pin) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (balance < amount) throw new IllegalArgumentException("Insufficient balance");
        if(!pin.equals(this.pin)) throw new IllegalArgumentException("Invalid pin");
        this.balance -= amount;

    }

    public void updatePin(String oldPin, String newPin) {
        if(!oldPin.equals(this.pin)) throw new IllegalArgumentException("Invalid pin");
        this.pin = newPin;
    }

    @Override
    public String toString() {
        return "FullName: " +firstName+" "+lastName+ ", accountNumber=" + accountNumber;
    }

}
