import java.util.Scanner;


public class Fibonacci{
	public static int fib (int number){
		if(number == 0) return 0;
		else if (number == 1) return 1;
		return fib(number-1) + fib(number-2);

	
	}

	public static void main(String... args){
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int n = input.nextInt();

		int result = fib(n);
		System.out.println("Result is : " + result);

	}


}