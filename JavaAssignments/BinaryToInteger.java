 import java.util.Scanner;


public class BinaryToInteger {
	public static void main(String[] args){
	Scanner input = new Scanner (System.in);

	System.out.print("Enter a Binary Number: ");
	int binaryToConvert = input.nextInt();
		int convertedInteger = 0;
		int counter = 0;

		while (binaryToConvert != 0){
			int rem = binaryToConvert % 10;
			double remPowered =  rem * Math.pow(2,counter);
			binaryToConvert /=   10;
			convertedInteger  += remPowered ;
			counter++;



		}
	

	System.out.printf("Decimal number is %s", convertedInteger );


	

	}


}
