package bankapp;


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

    public void createAccount(String firstName, String lastName, String pin ) {
        accounts.add(new Account(firstName, lastName, generateAccountNumber(), pin));
    }

    public String generateAccountNumber() {
        String number = String.valueOf(accountCounter);
        accountCounter++;
        return number;

    }

    private Account findAccount(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) throw new IllegalArgumentException("Invalid account number");
        if (accounts.isEmpty()) throw new IllegalArgumentException("No account found");
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) return account;
        }
        return null;
    }
}
