package bankapp;

public class Account {
    private double balance;
    private String pin;
    private int accountNumber;
    private String firstName;
    private String lastName;

    public Account(String firstName, String lastName, int accountNumber, String pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.pin = pin;



    }

    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(int amount, String pin) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (balance < amount) throw new IllegalArgumentException("Insufficient balance");
        if(!pin.equals(this.pin)) throw new IllegalArgumentException("Invalid pin");
        this.balance -= amount;

    }
}
