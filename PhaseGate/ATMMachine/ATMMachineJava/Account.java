public class Account {
	private String firstName;
	private String lastName;
	private String accountNumber;
	private double balance;
	private String pin;
	private boolean isActive;

	public Account(String accountNumber, String pin, String firstName, String lastName) {
        	this.accountNumber = accountNumber;
        	this.pin = pin;
        	this.balance = 0.0;
		this.firstName = firstName;
		this.lastName = lastName;
    	}


	public String getAccountNumber(){
		return accountNumber;
	
	}

	public boolean validatePin(String inputPin){
		return this.pin.equals(inputPin);
	
	}

	public void changePin(String oldPin, String newPin){
		if(validatePin(oldPin)){
			this.pin = newPin;
			System.out.print("PIN changed successfully");
		}else {
			System.out.print("Incorrect current Pin. Pin change unsuccessful");
		}

	}

	public double getBalance(){
		return balance;
	}
	
	public void deposit(double amount){
		if (amount > 0){
			balance += amount;
			System.out.printf("Deposited N%.2f. New Balance: N%.2f, amount, balance");
		} else {
			System.out.println("Invalid deposit amount");
		}
	
	}
	
	public boolean withdraw(double amount){
		if (amount > 0 && amount <= balance){
			balance -= amount;
			System.out.printf("Withdrawn N%.2f, New balance: N%.2f, amount, balance");
			return true;
	
		} else {
			System.out.println ("Insufficient Funds or Invalid Withdrawal amount");
			return false;
		}
		
	}
	
	public void setfirstName (String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
		
	public boolean isActive(){
		return isActive;
	
	}

	public void deactivate(){
		this.isActive = false;
	}
}