import java.util.Scanner;

public class Usersname {
	public static void main (String[] args){
	
	Scanner input = new Scanner(System.in);
	System.out.print("Enter your name: ");
	String name = input.nextLine();
	
	System.out.printf("Hi %s, Nice to meet you%n", name);
	System.out.println("Hi " + name + ",  Nice to meet you");
	System.out.print("Hi " + name + ",  Nice to meet you");


	}
}