package bankapp;

public class Account {
    private double balance;

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
        if(pin.equals(this.pin))
    }
}
