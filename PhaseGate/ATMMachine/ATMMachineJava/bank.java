import java.util.Scanner;
import java.util.Arrays;

public class Bank{
	private Account[] accounts;
    	private int maxAccounts;
    	private int currentAccountCount;
    	private Scanner input;

    	public Bank(int maxAccounts) {
        	this.maxAccounts = maxAccounts;
        	this.accounts = new Account[maxAccounts];
        	this.currentAccountCount = 0;
        	this.input = new Scanner(System.in);
	}
	
	public void createAccount(){
		if (currentAccountCount >= maxAccounts){
			System.out.println("Maximum Account reached");
			return;	
		}
	
		System.out.print("Please enter your first name");
		String firstName = input.nextLine();

		System.out.print("Please enter your last name");
		String lastName = input.nextLine();

		String accountNumber;
		boolean isUnique;
		do {
			accountNumber = generateAccountNumber();
			isUnique = isAccountNumberUnique(accountNumber);
		}while (!isUnique);

		System.out.print("Set your Pin(4 digits): ");
		String pin = input.nextLine();

		while(!pin.matches("\\d{4}")){
			System.out.println("Pin must be 4 digits, please try again");
			pin = input.nextLine();
		}

		Account newAccount = new Account(accountNumber, pin, firstName, lastName);
		accounts[currentAccountCount++] = newAccount;

		System.out.println("Account created succesffully");
		System.out.println("Your account number is: " + accountNumber);
	
	}

	public boolean isAccountNumberUnique(String accountNumber){
		for (int i = 0; i < currentAccountCount; i++){
			if (accounts[i].getAccountNumber().equals(accountNumber)){
				return false;
			}
		} 
		return true;

	}

	public String generateAccountNumber(){
		return String.format("%08d", (int)(Math.random()*100000000));	
	}
	
	public void transfer(Account sourceAccount){
		System.out.print("Enter recipient Account Number: ");
		String recipientAccountNumber = input.nextLine();

		Account recipientAccount = findAccount(recipientAccountNumber);
		if (recipientAccount == null){
			System.out.println("Recipient not found");
			return;
		}
		System.out.print("Enter transfer amount: ");
		double amount = input.nextDouble();
		input.nextLine();

		if (sourceAccount.withdraw(amount)){
			recipientAccount.deposit(amount);
			System.out.println("Transfer Successsful");

		}
	}

	public Account findAccount(String accountNumber){
		for (int i = 0; i < currentAccountCount; i++){
			if (accounts[i].getAccountNumber().equals(accountNumber)){
				return accounts[i];
			}
		}
		return null;
	}

	public Account login(){
		System.out.print("Please enter your account number");
		String accountNumber = input.nextLine();
			
		Account account = findAccount(accountNumber);
		if (account == null){
			System.out.println("Account not found");
			return null;
		}

		System.out.print("Please enter your PIN: ");
		String pin = input.nextLine();
		
		if(account.validatePin(pin)){
			return account;
		} else {
			System.out.print("Incorrect Pin");
			return null;
		}
	}

	private void closeAccount(Account account){
		if (account.getBalance() > 0){
			System.out.print("Cannot close account. Balance must be zero");
			return;
		}
		System.out.println("Are you sure you want to close this account");
		String response = input.nextLine().toLowerCase();
		
		if (!response.equals("yes")){
			System.out.println("Account closure cancelled");
			return;
		}
		account.deactivate();

		removeAccountFromAccounts(account);

		System.out.println("Account" + account.getAccountNumber() + "closed successfully");
	}

	private void removeAccountFromAccounts (Account accountToRemove){
		for(int i = 0; i < currentAccountCount; i++){
			if(accounts[i] == accountToRemove){
				for (int j = i; j < currentAccountCount - 1; j++){
					accounts[j] = accounts[j+1];
					accounts[currentAccountCount -1] = null;
					currentAccountCount--;
					break;
				}
			}
		}
		
	}
}