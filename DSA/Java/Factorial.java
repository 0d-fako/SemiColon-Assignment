import java.util.Scanner;


public class Factorial {
	
	public static int fact(int number){
		if (number==0) return 1;
		return number*fact(number-1);

	}


	public static void main(String... arg){
	 	Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number to find the factorial: ");
		int n = input.nextInt();
		
		int result = fact(n);


		System.out.println("The factorial of the given value : " +result);	








	}




}