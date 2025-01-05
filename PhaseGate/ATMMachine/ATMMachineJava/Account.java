public class Account {
	private String firstName;
	private String lastName;
	private String accountNumber;
	private double balance;
	private String pin;
	private boolean isActive;

	public Account(String accountNumber, String pin, String firstName, String lastName) {
		if (accountNumber == null || pin == null || firstName == null || lastName == null) {
			throw new IllegalArgumentException("All parameters must be non-null");
		}
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = 0.0;
		this.isActive = true;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public boolean validatePin(String inputPin) {
		return inputPin != null && this.pin.equals(inputPin);
	}

	public void changePin(String oldPin, String newPin) {
		if (newPin == null || newPin.trim().isEmpty()) {
			throw new IllegalArgumentException("New PIN cannot be null or empty");
		}

		if (validatePin(oldPin)) {
			this.pin = newPin;
			System.out.println("PIN changed successfully");
		} else {
			System.out.println("Incorrect current PIN. PIN change unsuccessful");
		}
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.printf("Deposited N%.2f. New Balance: N%.2f%n", amount, balance);
		} else {
			System.out.println("Invalid deposit amount");
		}
	}

	public boolean withdraw(double amount) {
		if (!isActive) {
			System.out.println("Account is not active");
			return false;
		}

		if (amount <= 0) {
			System.out.println("Invalid withdrawal amount");
			return false;
		}

		if (amount > balance) {
			System.out.println("Insufficient funds");
			return false;
		}

		balance -= amount;
		System.out.printf("Withdrawn N%.2f. New balance: N%.2f%n", amount, balance);
		return true;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().isEmpty()) {
			throw new IllegalArgumentException("First name cannot be null or empty");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("Last name cannot be null or empty");
		}
		this.lastName = lastName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void deactivate() {
		this.isActive = false;
	}

	public void activate() {
		this.isActive = true;
	}
}