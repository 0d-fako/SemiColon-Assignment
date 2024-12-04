public class bank{
	private Account[] accounts;
    	private int maxAccounts;
    	private int currentAccountCount;
    	private Scanner scanner;

    	public Bank(int maxAccounts) {
        	this.maxAccounts = maxAccounts;
        	this.accounts = new Account[maxAccounts];
        	this.currentAccountCount = 0;
        	this.scanner = new Scanner(System.in);
	}
	
	



}