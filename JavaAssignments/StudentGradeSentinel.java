import java.util.Scanner;

public class StudentGradeSentinel {
	public static void main(String[] args){

	Scanner input = new Scanner(System.in);
	int counter = 1;

	while (counter <=5) {

		System.out.print("Enter the student grade between 0 and 100: ");
		int studentGrade = input.nextInt();
		
		if (studentGrade == -1) {
			break;}
		
		switch (studentGrade/10) {

		case 8 :
		case 9 :
		case 10 :
			System.out.println("You have an A");
			System.out.println("Well Done");
			break;

		case 7 :
		case 6 :
			System.out.println("You have a B");
			break;

		case 5 :
			System.out.println("You have a C");
			break;

		default :
			System.out.println("Please enter a valid grade");
			break;

	
		}
		counter++;
	}
	}
}