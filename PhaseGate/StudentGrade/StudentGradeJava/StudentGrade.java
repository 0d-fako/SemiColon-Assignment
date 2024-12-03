import java.util.Scanner;
import java.util.Arrays;

public class StudentGrade {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentGrade studentGrade = new StudentGrade();
        


	System.out.println("Welcome to the Student Grade App");
	
        System.out.print("Please enter how many students are in your class: ");
        int numberOfStudents = input.nextInt();
        System.out.print("Please enter how many subjects are taught in your class: ");
        int numberOfSubjects = input.nextInt();
        int[] numbers = studentGrade.getNumberOfStudentsAndSubjects(numberOfStudents, numberOfSubjects);
        int[][] students = studentGrade.collectScoresForEveryStudentAndSubject(numbers);
        int[][] results = studentGrade.askQuestionsForStudents(students, input);
        studentGrade.displaySummary(results);
        
        
        
    }

    public int[] getNumberOfStudentsAndSubjects(int numberOfStudents, int numberOfSubjects) {
        int[] numbers = {numberOfStudents, numberOfSubjects};
        return numbers;
    }
    
    public int[][] collectScoresForEveryStudentAndSubject(int[] numbers) {
        int student = numbers[0];
        int subject = numbers[1];
        int[][] students = new int[student][subject];
        return students;
    }
    
    public int[][] askQuestionsForStudents(int[][] numbers, Scanner input) {
        for (int row = 0; row < numbers.length; row++) {
            System.out.println();
            System.out.println("entering score for student " + (row + 1));
            for (int column = 0; column < numbers[row].length; column++) {
                System.out.print("entering score for subject " + (column + 1) + ": ");
                int answer = input.nextInt();
                if (answer >= 0 && answer <= 100) {
                    numbers[row][column] = answer;
                } else {
                    System.out.println("error, invalid input: number must be zero or above zero. Try again...");
                    column--;
                }
            }
        }
        return numbers;
    }
    
    
    public  void displaySummary(int[][] numbers) {
        
        int position = numbers.length;
        System.out.println("=========================================================================================================");
        displayHeader(numbers);
        System.out.println("=========================================================================================================");
        for (int row = 0; row < numbers.length; row++) {
            int total = 0;
            System.out.print("Student " + (row + 1) + "\t");
            for (int column = 0; column < numbers[row].length; column++) {
                System.out.print(numbers[row][column] + "\t\t");
                total += numbers[row][column];
            }
            int lengths = numbers[row].length;
            double average = total / lengths;
            System.out.println(total + "\t\t" + average + "\t\t  " + (position++));
        }
        System.out.println("==========================================================================================================");
	System.out.println();
	System.out.println();
        subjectSummary(numbers);
    }
    
    public void displayHeader(int[][] numbers) {
        System.out.print("Students\t");
        for (int row = 0; row < numbers.length; row++) {
            for (int column = 0; column < numbers[row].length; column++) {
                System.out.print("Subject " + (column + 1) + "\t");
            }
            System.out.println("TOTAL\t\tAVERAGE\t\tPOSITION");
            break;
        }
    }
    
    public void subjectSummary(int[][] numbers) {
	System.out.println("===========================================================");
        System.out.println("Subject summary");
        for (int row = 0; row < numbers[0].length; row++) {
            decideForEachSubject(row, numbers);
        }
    }
    
    public void decideForEachSubject(int row, int[][] numbers) {
        int largest = numbers[0][row];
        int largestIndex = 0;
        int smallest = 0;
        int smallestIndex = 0;
        int total = 0;
        for (int column = 0; column < numbers.length; column++) {
            if (numbers[column][row] >= largest) {
                largest = numbers[column][row];
                largestIndex = column;
		smallest = largest;
            }
            else if (numbers[column][row] <= smallest) {
                smallest =  numbers[column][row];
                smallestIndex = column;
            }
            total += numbers[column][row];
        }
        System.out.println("Subject " + (row + 1));
        System.out.println("highest scoring is:   student " + (largestIndex + 1) + " scoring: " + largest);
        System.out.println("lowest scoring is:   student " + (smallestIndex + 1) + " scoring: " + smallest + "\nTotal score: " + total + "\nAverage score: " + (total / numbers.length));
        int[] passAndFail = numberOfPasses(row, numbers);
        System.out.println("Number of passes: " + passAndFail[0] + "\nNumber of fails: " + passAndFail[1]);
        System.out.println("===========================================================");
        
    }
    
    public int[] numberOfPasses(int row, int[][] numbers) {
        int pass = 0;
        int fail = 0;
        int subject = row;
        for (int column = 0; column < numbers.length; column++) {
            if (numbers[column][row] >= 50) {
                pass++;
            }
            else fail++;
        }
        int[] value = {pass, fail, subject};
        return value;
    }
    
    
    
    
}