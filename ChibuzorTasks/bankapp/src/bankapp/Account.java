package bankapp;

public class Account {
    private double balance;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

}
