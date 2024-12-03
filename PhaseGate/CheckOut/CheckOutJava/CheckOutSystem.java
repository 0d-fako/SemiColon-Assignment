import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class CheckOutSystem {

	static Scanner input = new Scanner(System.in);
	static ArrayList<String> goodsBought = new ArrayList<>();
	static ArrayList<Integer> goodsNo = new ArrayList<>();
	static ArrayList<Double> goodsPrice = new ArrayList<>();
	static Date currentDateAndTime = new Date();
	static String cashierName;
	static String customerName;
        static double amountPaid = 0.0;
	

	public static void main(String[] args) {
	System.out.println("Welcome to the Semicolon Store!");
	

	System.out.print("Please enter your name? ");
	cashierName = input.nextLine();

	System.out.print("Please enter the customer name? ");
	customerName = input.nextLine();
	displayQuestions();

	
 	}


	public static void displayQuestions(){
		System.out.print("What did the user buy? ");
		String productName = input.nextLine();
		goodsBought.add(productName);
		

		System.out.print("How many pieces? ");
		int productQuantity = input.nextInt();
		input.nextLine();
		goodsNo.add(productQuantity);

		System.out.print("How much per unit? ");
		double productPrice = input.nextDouble();
		input.nextLine(); 
		goodsPrice.add(productPrice);

		System.out.print("Do you want to add another item? (yes/no) ");
		String anotherProduct = input.nextLine().toLowerCase();
		if (!anotherProduct.equals("yes") || goodsBought.size() == 100) {
			printInvoice();
		}else {
			displayQuestions();
		}
        }

	public static void printInvoice(){
		double subtotal = 0.0;
		for (int i = 0; i < goodsBought.size(); i++) {
            	subtotal += goodsNo.get(i) * goodsPrice.get(i);
        	}
        
		double vat = subtotal * 0.075;
		double total = subtotal + vat;
        
		System.out.println("SEMICOLON STORE\nMAIN BRANCH\nLOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS");
		System.out.println("TEL: 03293828343");
		System.out.println("Date: " +currentDateAndTime);
		System.out.println("Cashier Name: " +cashierName);
		System.out.println("Customer Name: " +customerName);
		System.out.println("==========================================");
		System.out.println("ITEMS\t\t QTY\t PRICE\t TOTAL(NGN)");

		System.out.println("----------------------------------------");
		for (int i = 0; i < goodsBought.size(); i++) {
    		double lineTotal = goodsNo.get(i) * goodsPrice.get(i);
            	System.out.printf("%-15s %3d x   %6.2f %8.2f\n", goodsBought.get(i), goodsNo.get(i), goodsPrice.get(i), lineTotal);
		}
        
        	System.out.println("-----------------------------------------");
        	System.out.printf("%-20s %10.2f\n", "Subtotal:", subtotal);
        	System.out.printf("%-20s %10.2f\n", "VAT (7.5%):", vat);
        	System.out.printf("%-20s %10.2f\n", "Total:", total);

		System.out.println("-----------------------------------------");
                System.out.print("How much did the customer give you: ");
                amountPaid = input.nextFloat();
                printInvoicePaid();
	}
        

        public static void printInvoicePaid(){
		double subtotal = 0.0;
		for (int i = 0; i < goodsBought.size(); i++) {
            	subtotal += goodsNo.get(i) * goodsPrice.get(i);
        	}
        
		double vat = subtotal * 0.075;
		double total = subtotal + vat;
        
		System.out.println("SEMICOLON STORE\nMAIN BRANCH\nLOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS");
		System.out.println("TEL: 03293828343");
		System.out.println("Date: " +currentDateAndTime);
		System.out.println("Cashier Name: " +cashierName);
		System.out.println("Customer Name: " +customerName);
		System.out.println("==========================================");
		System.out.println("ITEMS\t\t QTY\t PRICE\t TOTAL(NGN)");

		System.out.println("----------------------------------------");
		for (int i = 0; i < goodsBought.size(); i++) {
    		double lineTotal = goodsNo.get(i) * goodsPrice.get(i);
            	System.out.printf("%-15s %3d x   %6.2f %8.2f\n", goodsBought.get(i), goodsNo.get(i), goodsPrice.get(i), lineTotal);
		}
        
        	System.out.println("-----------------------------------------");
        	System.out.printf("%-20s %10.2f\n", "Subtotal:", subtotal);
        	System.out.printf("%-20s %10.2f\n", "VAT (7.5%):", vat);

		System.out.println("=========================================");
        	System.out.printf("%-20s %10.2f\n", "Bill Total:", total);
        	System.out.printf("%-20s %10.2f\n", "Amount paid:", amountPaid);
        	System.out.printf("%-20s %10.2f\n", "Balance:", amountPaid - total);
		System.out.println("=========================================");
		System.out.println("THANK YOU FOR YOUR PATRONAGE");
		System.out.println("-----------------------------------------");

      }
                
}